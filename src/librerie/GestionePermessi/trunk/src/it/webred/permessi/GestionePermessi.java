package it.webred.permessi;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * TODO Classe per che si occupa di controllare i permessi di un utente.
 * @author Petracca Marco - Alessaandro Feriani
 * @version $Revision: 1.4 $ $Date: 2010/07/07 08:48:37 $
 */
public final class GestionePermessi
{
	public static final String PLACEHOLDER_READ_ENTITY_RIGHT="Lettura {0} ({1})";
	public static final String PLACEHOLDER_WRITE_ENTITY_RIGHT="Scrittura {0} ({1})";
	public static final String PLACEHOLDER_DELETE_ENTITY_RIGHT="Eliminazione {0} ({1})";
	public static final String PLACEHOLDER_ENTITY_NAME="{0} ({1})";
	public static final String PLACEHOLDER_APPLICATION_NAME="Diritti sui Dati ({1})";
	public static final String PLACEHOLDER_APPLICATION_TYPE="Diritti sui Dati";
	public static final String PLACEHOLDER_ENTE_NAME="{1}";
	public static final String PLACEHOLDER_USER_NAME="{2}";
	public static final String READ_ENTITY="READ_ENTITY";
	public static final String WRITE_ENTITY="WRITE_ENTITY";
	public static final String DELETE_ENTITY="DELETE_ENTITY";
	public  static final long CATEGORIA_AMAPPLICATION_INDEFINITA = 99;

	private static final String ENTE_PREDEFINITO = "";
	
	/**
	 * Mappa che contiene tutti i permessi degli utenti<br>
	 * La chiave è il nome utente<br>
	 * Il valore è il bean PermessirBean  
	 */
	private static Map<String,PermessirBean> mappa = Collections.synchronizedMap(new HashMap<String,PermessirBean>());
	
	private GestionePermessi()
	{
	}

	private synchronized static NameValuePair[] getProperties(AuthContext authContext)
	{
		LinkedList<NameValuePair> listaProperties = new LinkedList<NameValuePair>();

		try
		{
			if( authContext != null )
			{				
				String sql = "";
				
				sql += "SELECT DISTINCT 'permission@-@'|| ai.FK_AM_APPLICATION||'@-@'|| it.NAME||'@-@'||p.NAME NAME, '*' as VALUE ";
				sql += "FROM AM_PERMISSION p, AM_PERMISSION_AIR pair, AM_AI_ROLE air, AM_APPLICATION_ITEM ai, AM_ITEM it, AM_USER u, AM_USER_AIR uair ";
				sql += "WHERE uair.FK_AM_USER = u.NAME ";
				sql += "AND uair.FK_AM_AI_ROLE = air.ID ";
				sql += "AND air.FK_AM_application_ITEM = Ai.ID ";
				sql += "AND AI.FK_AM_ITEM = it.NAME ";
				sql += "AND p.FK_AM_ITEM = it.NAME ";
				sql += "AND air.id = pair.FK_AM_AI_ROLE ";
				sql += "AND p.NAME = pair.FK_AM_PERMISSION ";
				sql += "AND u.NAME = '" + authContext.getUser().getName() + "' ";
				sql += "AND U.DISABLE_CAUSE IS NULL ";
	
				sql += "UNION ";
	
				sql += "SELECT DISTINCT 'permission@-@'|| ai.FK_AM_APPLICATION||'@-@'|| it.NAME||'@-@'||p.NAME Value, '*' "; 
				sql += "FROM AM_PERMISSION p, AM_PERMISSION_AIR pair, AM_AI_ROLE air, AM_APPLICATION_ITEM ai, AM_ITEM it, AM_GROUP_AIR gair, AM_GROUP g, AM_USER_GROUP ug, AM_USER u ";
				sql += "WHERE ug.FK_AM_USER = u.NAME  ";
				sql += "AND g.NAME = UG.FK_AM_GROUP  ";
				sql += "AND gair.FK_AM_AI_ROLE = air.ID "; 
				sql += "AND air.FK_AM_application_ITEM = Ai.ID "; 
				sql += "AND AI.FK_AM_ITEM = it.NAME  ";
				sql += "AND p.FK_AM_ITEM = it.NAME  ";
				sql += "AND air.id = pair.FK_AM_AI_ROLE "; 
				sql += "AND p.NAME = pair.FK_AM_PERMISSION "; 
				sql += "AND u.NAME = '" + authContext.getUser().getName() + "' "; 
	
				sql += "UNION ";
	
				sql += "SELECT DISTINCT 'property@-@ente' || '@-@' || app.NAME VALUE, ic.fk_am_comune "; 
				sql += "FROM am_item it, am_user u, am_user_air uair, am_ai_role air, am_application app, am_instance i, am_instance_comune ic, am_application_item ai "; 
				sql += "WHERE uair.FK_AM_USER = u.NAME  "; 
				sql += "AND uair.fk_am_ai_role = air.ID  "; 
				sql += "AND air.fk_am_application_item = ai.ID "; 
				sql += "AND APP.NAME = I.FK_AM_APPLICATION ";  
				sql += "AND I.NAME = IC.FK_AM_INSTANCE ";  
				sql += "AND ai.fk_am_item = it.NAME ";  
				sql += "AND app.NAME = ai.fk_am_application ";  
				sql += "AND app.NAME NOT IN ('Diritti sui Dati (' || ic.fk_am_comune || ')') ";  
				sql += "AND u.NAME = '" + authContext.getUser().getName() + "' "; 
				sql += "AND U.DISABLE_CAUSE IS NULL "; 		
	
				PreparedStatement pstmt = authContext.getConnection().prepareStatement(sql);
				
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					String name = rs.getString("NAME");
					String value = rs.getString("VALUE"); 
					
					NameValuePair nv = new NameValuePair(name, value);
					listaProperties.add(nv);
				}
			}
			
		}
		catch(Exception ex)
		{
			
		}
		
		NameValuePair[] array = new NameValuePair[listaProperties.size()];
		listaProperties.toArray(array);

		return array; 
	}
	/**
	 * @param principalUser
	 * @return
	 */
	private synchronized static PermessirBean riempiMappa(AuthContext authContext)
	{
		PermessirBean perm = new PermessirBean();
		perm.setUser(authContext.getUser().getName());

		NameValuePair[] listaProperties = getProperties(authContext);
		perm.setListaProperties(listaProperties);
		for (NameValuePair property : listaProperties) {
			// Formato del permesso
			// appl. item permission
			// permission@-@rulengine@-@Motore Regole@-@Assegna Permessi

			String p = property.getName();
			if(p.indexOf("permission@-@")==0)
			{
				String[] tok = p.replace("permission@-@", "").split("@-@");
				String application = tok[0];
				String item = tok[1];
				String permesso = tok[2];
				perm.setPermissions(application, item, permesso);

			}
		}
		
		mappa.put(authContext.getUser().getName(), perm);

		return perm;
	}

	/**
	 * Questo metodo si occupa di controllare se un utente è autorizzato <br>
	 * ad eseguire una determinata operazione sulla entità passata.<br>
	 * Per prima cosa controlla se sono già stati caricati i permessi per l'utente;<br>
	 * in caso affermativo controlla se è autorizzato, altrimenti prima richiama il metodo riempiMappa(principalUser)<br>
	 * che si occupa del recupero dei permessi per poi memorizzarli. 
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @param nome Il nome dell'entità della quale sto controllando i diritti
	 * @param application Il nome dell'applicazione 
	 * @param permesso Il permesso che descrive l'operazione che si vuole compiere(READ,WRITE,DELETE)
	 * @return true se è autorizzato, altrimenti false
	 */
	public synchronized static boolean operazioneSuEntita(AuthContext authContext, String nome, String permesso)
	{
		// se almeno uno dei paramentri non è valorizzato allora il diritto non c'è
		if(authContext == null || authContext.getUser()==null || authContext.getApplication()==null ) return false;
		if( nome==null || permesso==null ) return false;

		String ente= getEnteFromContext( authContext);

		Object[] dati={nome,ente};
		String dirittiApplication = MessageFormat.format(PLACEHOLDER_APPLICATION_NAME,dati);
		String entityName = MessageFormat.format(PLACEHOLDER_ENTITY_NAME,dati);

		String permessoEntity="";
		if(permesso.toUpperCase().equals(READ_ENTITY)){
			permessoEntity = MessageFormat.format(PLACEHOLDER_READ_ENTITY_RIGHT,dati);
		}else if(permesso.toUpperCase().equals(WRITE_ENTITY)){
			permessoEntity = MessageFormat.format(PLACEHOLDER_WRITE_ENTITY_RIGHT,dati);
		}else if(permesso.toUpperCase().equals(DELETE_ENTITY)){
			permessoEntity = MessageFormat.format(PLACEHOLDER_DELETE_ENTITY_RIGHT,dati);
		}
		
		AuthContext newContext = new AuthContext(authContext);
		newContext.setItem(entityName);
		newContext.setApplication(dirittiApplication);
		return autorizzato(newContext, permessoEntity);
	}
	
	/**
	 * Questo metodo si occupa di controllare se un utente è autorizzato <br>
	 * ad eseguire una determinata operazione.<br>
	 * Per prima cosa controlla se sono già stati caricati i permessi per l'utente;<br>
	 * in caso affermativo controlla se è autorizzato, altrimenti prima richiama il metodo riempiMappa(principalUser)<br>
	 * che si occupa del recupero dei permessi per poi memorizzarli. 
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @param application Il nome dell'applicazione 
	 * @param item L'oggetto dell'applicazione
	 * @param permesso Il permesso che descrive l'operazione che si vuole compiere
	 * @return true se è autorizzato, altrimenti false
	 */
	public synchronized static boolean autorizzato(AuthContext authContext, String permesso)
	{
		return autorizzato(authContext, permesso, false);

	}
	
	/**
	 * Questo metodo si occupa di controllare se un utente è autorizzato <br>
	 * ad eseguire una determinata operazione.<br>
	 * Per prima cosa controlla se sono già stati caricati i permessi per l'utente;<br>
	 * in caso affermativo controlla se è autorizzato, altrimenti prima richiama il metodo riempiMappa(principalUser)<br>
	 * che si occupa del recupero dei permessi per poi memorizzarli. 
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @param application Il nome dell'applicazione 
	 * @param item L'oggetto dell'applicazione
	 * @param permesso Il permesso che descrive l'operazione che si vuole compiere
	 * @param refresh ricarica i diritti dal DB se impostato a true.
	 * @return true se è autorizzato, altrimenti false
	 */
	public synchronized static boolean autorizzato(AuthContext authContext, String permesso, boolean refresh)
	{
		String userName = authContext.getUser().getName();
		PermessirBean perBean = mappa.get(userName);
		if (perBean == null || refresh)
		{
			perBean = riempiMappa(authContext);
		}
		return perBean.getPermissions(authContext.getApplication(), authContext.getItem(), permesso);

	}
	
	/** 
	 * Metodo che verifica la validità della password dell'utente che si connette ad un applicativo.
	 * @param conn La connessione allo schema AM dove effettuare il controllo
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @param numGiorni Il numero dei giorni di validità della password dell'utente
	 * @return un array di due oggetti:<br>
	 * 1) String: il nome dell'utente loggato<br>
	 * 2) boolean: true se la password dell'utente è valida (non è scaduta), altrimenti false
	 */
	public synchronized static Object[] pwdValida(AuthContext authContext, int numGiorni)
	{
		Object[] retVal = new Object[2];

		try {
			String userName = authContext.getUser().getName();
			retVal[0] = userName;
			PreparedStatement pstmt = authContext.getConnection().prepareStatement("SELECT TRUNC(DT_UPD_PWD) AS DT_UPD_PWD FROM AM_USER WHERE NAME = ?");
			pstmt.setString(1, userName);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				if (rs.getObject("DT_UPD_PWD") == null) {
					retVal[1] = new Boolean(false);
					return retVal;
				}					
				Date dtUpdPwd = rs.getDate("DT_UPD_PWD");
				GregorianCalendar calUpdPwd = new GregorianCalendar();
				calUpdPwd.setTime(dtUpdPwd);
				calUpdPwd.add(Calendar.DAY_OF_YEAR, numGiorni);
				GregorianCalendar calOggi = new GregorianCalendar();
				calOggi.set(Calendar.HOUR_OF_DAY, 0);
				calOggi.set(Calendar.MINUTE, 0);
				calOggi.set(Calendar.SECOND, 0);
				calOggi.set(Calendar.MILLISECOND, 0);
				retVal[1] = new Boolean(calOggi.getTime().getTime() <= calUpdPwd.getTime().getTime());
			}
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			return retVal;
		} catch (Exception e) {
			retVal[0] = null;
			retVal[1] = new Boolean(false);
			return retVal;
		}

	}
	
	/**
	 * Carica tutti i permessi assegnati ad un certo utente<br>
	 * senza distinzione tra applicazioni
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @param application nome dell'applicazione da cui richeidere i permessi
	 * @param item nome dell'item da cui richeidere i permessi
	 * @return Una lista di stringhe contenente i nomi dei permessi
	 */
	public synchronized static ArrayList<String> getPermissionsList(AuthContext authContext)
	{
		return getPermissionsList(authContext, false);
	}	
	
	/**
	 * Carica tutti i permessi assegnati ad un certo utente<br>
	 * senza distinzione tra applicazioni
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @param application nome dell'applicazione da cui richeidere i permessi
	 * @param item nome dell'item da cui richeidere i permessi
	 * @param refresh ricarica i diritti dal DB se impostato a true.
	 * @return Una lista di stringhe contenente i nomi dei permessi
	 */
	public synchronized static ArrayList<String> getPermissionsList(AuthContext authContext, boolean refresh)
	{
		String userName = authContext.getUser().getName();
		PermessirBean perBean = mappa.get(userName);
		if (perBean == null || refresh)
		{
			perBean = riempiMappa(authContext);
		}
		return perBean.getPermissionsList();

	}	

	/**
	 * Recupera l'ente nelle proprietà dell'utente loggato nella sua proprietà ="property@-@ente@-@<context>"
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal().
	 * @param context Il context del quale vogliamo recuperare l'ente. 
	 * @return L'ente se trovato altrimenti stringa vuota "".
	 */
	public synchronized static String getEnteFromContext(AuthContext authContext)
	{
		String ente=ENTE_PREDEFINITO;
		
		String entePropertyString="property@-@ente@-@"+authContext.getApplication();
		ArrayList<String> lista = getListaPropertiesValues(authContext, entePropertyString);
		
		if(lista.size()>0)ente=lista.get(0);

		return ente;
	}


	/**
	 * Ricava una lista di valori relativi ad una certa proprietà
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @param nomeProperties Il nome della proprietà 
	 * @return La lista dei valori trovati, può essere vuota
	 */
	public synchronized static ArrayList<String> getListaPropertiesValues(AuthContext authContext, String nomeProperties)
	{
		
		return getListaPropertiesValues(authContext, nomeProperties, false);
	}

	/**
	 * Ricava una lista di valori relativi ad una certa proprietà
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @param nomeProperties Il nome della proprietà 
	 * @return La lista dei valori trovati, può essere vuota
	 */
	public synchronized static ArrayList<String> getListaPropertiesValues(AuthContext authContext, String nomeProperties, boolean refresh)
	{
		String userName = authContext.getUser().getName();
		PermessirBean perBean = mappa.get(userName);
		if (perBean == null || refresh)
		{
			perBean = riempiMappa(authContext);
		}
		
		return perBean.getListaPropertiesValues(nomeProperties);
	}
	
	public synchronized static void clearCache(String username)
	{
		if(username != null)
			mappa.remove(username);
	}
	
	
	/**
	 * Carica tuttele applicazioni alle quali può accedere un utente
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @return Una lista di stringhe contenente i nomi delle applicazioni
	 */
	public synchronized static ArrayList<String> getApplications(AuthContext authContext)
	{
		return getApplications( authContext, false);
	}		
	/**
	 * Carica tuttele applicazioni alle quali può accedere un utente
	 * @param user L'oggetto recuperato dalla request mediante il metodo getUserPrincipal()
	 * @param refresh ricarica i diritti dal DB se impostato a true.
	 * @return Una lista di stringhe contenente i nomi delle applicazioni
	 */
	public synchronized static ArrayList<String> getApplications(AuthContext authContext, boolean refresh)
	{
		String userName = authContext.getUser().getName();
		PermessirBean perBean = mappa.get(userName);
		if (perBean == null || refresh)
		{
			perBean = riempiMappa(authContext);
		}
		return perBean.getApplications();

	}	
}
