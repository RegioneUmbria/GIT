/*
 * Created on 2-lug-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package it.escsolution.escwebgis.agenziaEntrate.servlet;

import it.escsolution.escwebgis.agenziaEntrate.bean.AgenziaEntrateContribuente;
import it.escsolution.escwebgis.agenziaEntrate.bean.AgenziaEntrateContribuentiFinder;
import it.escsolution.escwebgis.agenziaEntrate.logic.AgenziaEntrateContribuentiLogic;
import it.escsolution.escwebgis.common.EscElementoFiltro;
import it.escsolution.escwebgis.common.EscFinder;
import it.escsolution.escwebgis.common.EscOperatoreFiltro;
import it.escsolution.escwebgis.common.EscService;
import it.escsolution.escwebgis.common.EscServlet;
import it.escsolution.escwebgis.common.PulsantiNavigazione;
import it.escsolution.escwebgis.common.Tema;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Administrator
 *
 * To change the template for this generated type comment go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
public class AgenziaEntrateContribuentiServlet extends EscServlet implements EscService {

	PulsantiNavigazione nav = new PulsantiNavigazione();
	private String recordScelto;
	private AgenziaEntrateContribuentiLogic logic = null;
	private final String NOMEFINDER = "FINDER21";
	private AgenziaEntrateContribuentiFinder finder = null;

	public void EseguiServizio(
		HttpServletRequest request,HttpServletResponse response)
				throws ServletException, IOException {
				/*
				 * ad ogni uc corrisponde una funzionalit diversa
				 *
				 */
		HttpSession sessione = request.getSession();		
		sessione.setAttribute("FUNZIONALITA", Tema.getNomeFunzionalita(uc));
		
		super.EseguiServizio(request,response);
		 try{
			 switch (st){
				 case 1:
					 // carico la form di ricerca
					 pulireSessione(request);
					 mCaricareFormRicerca(request,response);
					 break;
				 case 2:
					 // vengo dalla pagina di ricerca --> predispongo la lista e la passo alla pagina di lista
					 //pulireSessione(request);
					 mCaricareLista(request,response,false);
					 break;
				 case 3:
					 // ho cliccato su un elemento --> visualizzo il dettaglio
					 mCaricareDettaglio(request,response);
					//this.leggiCrossLink(request);
					 break;
				 case 33:
					 // ho cliccato su un elemento --> visualizzo il dettaglio
					 mCaricareDettaglio(request,response);
					//this.leggiCrossLink(request);
					 break;

			 }
		 }
		 catch(it.escsolution.escwebgis.common.DiogeneException de)
		 {
		 	throw de;
		 }
		catch(Exception ex){
			log.error(ex.getMessage(),ex);
		}


			}

	private void mCaricareFormRicerca(HttpServletRequest request, HttpServletResponse response) throws Exception{

					//caricare dati che servono nella pagina di ricerca
					AgenziaEntrateContribuentiLogic logic = new AgenziaEntrateContribuentiLogic(this.getEnvUtente(request));
					HttpSession sessione = request.getSession();


					Vector listaElementiFiltro = new Vector();
					Vector operatoriStringa = new Vector();
					operatoriStringa.add(new EscOperatoreFiltro("=","uguale"));
					operatoriStringa.add(new EscOperatoreFiltro("like","contiene"));



					Vector operatoriNumerici = new Vector();
					operatoriNumerici.add(new EscOperatoreFiltro("=","="));
					operatoriNumerici.add(new EscOperatoreFiltro("<>","<>"));
					operatoriNumerici.add(new EscOperatoreFiltro(">",">"));
					operatoriNumerici.add(new EscOperatoreFiltro("<","<"));

					Vector operatoriStringaRid = new Vector();
					operatoriStringaRid.add(new EscOperatoreFiltro("=","uguale"));

					// costruisce il vettore di elementi per la pagina di ricerca

					EscElementoFiltro elementoFiltro = new EscElementoFiltro();
					elementoFiltro.setLabel("Codice Fiscale");
					elementoFiltro.setAttributeName("COD_FISC_PERSONA");
					elementoFiltro.setTipo("S");
					elementoFiltro.setCampoJS("");
					elementoFiltro.setListaOperatori(operatoriStringaRid);
					elementoFiltro.setCampoFiltrato("COD_FISC_PERSONA");
					listaElementiFiltro.add(elementoFiltro);


					elementoFiltro = new EscElementoFiltro();
					elementoFiltro.setLabel("Cognome");
					elementoFiltro.setAttributeName("COGNOME");
					elementoFiltro.setTipo("S");
					elementoFiltro.setCampoJS("");
					elementoFiltro.setListaOperatori(operatoriStringa);
					elementoFiltro.setCampoFiltrato("COGNOME");
					listaElementiFiltro.add(elementoFiltro);


					elementoFiltro = new EscElementoFiltro();
					elementoFiltro.setLabel("Nome");
					elementoFiltro.setAttributeName("NOME");
					elementoFiltro.setTipo("S");
					elementoFiltro.setCampoJS("");
					elementoFiltro.setListaOperatori(operatoriStringa);
					elementoFiltro.setCampoFiltrato("NOME");
					listaElementiFiltro.add(elementoFiltro);

					elementoFiltro = new EscElementoFiltro();
					elementoFiltro.setLabel("Data di nascita");
					elementoFiltro.setAttributeName("DATA_NASCITA");
					elementoFiltro.setTipo("S");
					elementoFiltro.setCampoJS("controllaData");
					elementoFiltro.setListaOperatori(operatoriNumerici);
					elementoFiltro.setCampoFiltrato("DATA_NASCITA");
					listaElementiFiltro.add(elementoFiltro);



					sessione.setAttribute("LISTA_RICERCA",listaElementiFiltro);
					sessione.setAttribute("TITOLO",Tema.getNomeFiltro(uc));
					
					//chiamare la pagina di ricerca
					nav.chiamataRicerca();
					this.chiamaPagina(request,response,"agenziaEntrate/contrFrame.jsp", nav);

				}

	private void mCaricareLista(HttpServletRequest request,HttpServletResponse response,boolean notListaPrincipale)throws Exception{
			// prendere dalla request i parametri di ricerca impostati dall'utente
			HttpSession sessione = request.getSession();

			if (sessione.getAttribute(NOMEFINDER)!= null){
				if (((Object)sessione.getAttribute(NOMEFINDER)).getClass() == new AgenziaEntrateContribuentiFinder().getClass()){
					finder = (AgenziaEntrateContribuentiFinder)sessione.getAttribute(NOMEFINDER);
				}
				else
					finder = null;
			}


			finder = (AgenziaEntrateContribuentiFinder)gestireMultiPagina(finder,request);

			AgenziaEntrateContribuentiLogic logic = new AgenziaEntrateContribuentiLogic(this.getEnvUtente(request));
			Hashtable ht = logic.mCaricareListacContribuente(vettoreRicerca,finder);

			// eseguire la query e caricare il vettore con i risultati
			// chiamare la pagina di lista


			Vector vct_lista_contribuenti= (Vector)ht.get("LISTA_CONTRIBUENTI");
			finder = (AgenziaEntrateContribuentiFinder)ht.get("FINDER");

			sessione.setAttribute("LISTA_CONTRIBUENTI",vct_lista_contribuenti);

			if (!notListaPrincipale){
				finder = (AgenziaEntrateContribuentiFinder)ht.get("FINDER");
				sessione.setAttribute(NOMEFINDER,finder);
			}


			if(chiamataEsterna)
				nav.chiamataEsternaLista();
			else
				nav.chiamataInternaLista();

			this.chiamaPagina(request,response,"agenziaEntrate/contrFrame.jsp", nav);
		}

	private void mCaricareDettaglio(HttpServletRequest request,HttpServletResponse response)throws Exception{
				// prendere dalla request il parametrio identificativo dell'oggetto cliccato
				// eseguire la query per caricare l'oggetto selezionato dal db
				// chiamare la pagina di dettaglio

				String azione = "";
				HttpSession sessione = request.getSession();
				AgenziaEntrateContribuentiFinder finder = null;
				//boolean chiamataEsterna = false;
				if (sessione.getAttribute(NOMEFINDER) !=null){
					if (((Object)sessione.getAttribute(NOMEFINDER)).getClass() == new AgenziaEntrateContribuentiFinder().getClass()){
						finder = (AgenziaEntrateContribuentiFinder)sessione.getAttribute(NOMEFINDER);
					}
				}
				if (request.getParameter("AZIONE")!= null)
					azione = request.getParameter("AZIONE");
				gestioneMultiRecord(request,response,azione,finder,sessione,"LISTA_CONTRIBUENTI",(Vector)sessione.getAttribute("LISTA_CONTRIBUENTI"),NOMEFINDER);
				if (azione.equals("")){
					oggettoSel="";recordScelto="";
					sessione.removeAttribute("BACK_JS_COUNT");
					sessione.removeAttribute("BACK_RECORD_ENABLE");

					if (request.getParameter("OGGETTO_SEL")!= null){
						oggettoSel = request.getParameter("OGGETTO_SEL");
					}
					if (request.getParameter("RECORD_SEL")!= null){
						recordScelto = request.getParameter("RECORD_SEL");
						if (finder!=null)
							finder.setRecordAttuale(new Long(recordScelto).longValue());
						}
					}

				/*
				 * carica il dettaglio
				 */
				AgenziaEntrateContribuentiLogic logic = new AgenziaEntrateContribuentiLogic(this.getEnvUtente(request));
				Hashtable ht = logic.mCaricareDettaglioContribuente(oggettoSel);

				AgenziaEntrateContribuente contribuente = (AgenziaEntrateContribuente)ht.get("CONTRIBUENTE");
				sessione.setAttribute("CONTRIBUENTE",contribuente);

				if(chiamataEsterna)
					nav.chiamataEsternaDettaglio();
				else
					nav.chiamataInternaDettaglio();


				this.chiamaPagina(request,response,"agenziaEntrate/contrFrame.jsp", nav);

				//EscFinder escf = (EscFinder)sessione.getAttribute(NOMEFINDER);


			}

	public String getChiaveOggetto(EscFinder finder, Vector listaOggetti,int recordSuccessivo){
				return ((AgenziaEntrateContribuente)listaOggetti.get(recordSuccessivo)).getidContribuente();
				}

			/*public Hashtable executeLogic(EscFinder finder2) throws Exception{
				finder = (SoggettoFinder)finder2;
				SoggettoSoggettoLogic logic = new SoggettoSoggettoLogic(this.getEnvUtente());
				return logic.mCaricareListaSoggetto(this.vettoreRicerca,finder);
				}*/

			public EscFinder getNewFinder(){
						return new AgenziaEntrateContribuentiFinder();
					}

			public String getTema() {
				return "SIATEL";
			}

		public String getTabellaPerCrossLink() {
				return "MI_SIATEL_P_FIS";
			}
}
