/*
 * Created on 2-lug-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package it.escsolution.escwebgis.condomini.servlet;

import it.escsolution.escwebgis.common.EscElementoFiltro;
import it.escsolution.escwebgis.common.EscFinder;
import it.escsolution.escwebgis.common.EscOperatoreFiltro;
import it.escsolution.escwebgis.common.EscService;
import it.escsolution.escwebgis.common.EscServlet;
import it.escsolution.escwebgis.common.PulsantiNavigazione;
import it.escsolution.escwebgis.common.Tema;
import it.escsolution.escwebgis.condomini.bean.Condomini;
import it.escsolution.escwebgis.condomini.bean.CondominiFinder;
import it.escsolution.escwebgis.condomini.logic.CondominiCondominiLogic;

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
public class CondominiCondominiServlet extends EscServlet implements EscService {

	PulsantiNavigazione nav = new PulsantiNavigazione();
	private String recordScelto;
	private CondominiCondominiLogic logic = null;
	private final String NOMEFINDER = "FINDER17";
	private CondominiFinder finder = null;

	public void EseguiServizio(
		HttpServletRequest request,HttpServletResponse response)
				throws ServletException, IOException {
				/*
				 * ad ogni uc corrisponde una funzionalità diversa
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
					this.leggiCrossLink(request);
					break;
				 case 33:
					 // ho cliccato su un elemento --> visualizzo il dettaglio
					 mCaricareDettaglio(request,response);
					this.leggiCrossLink(request);
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
					CondominiCondominiLogic logic = new CondominiCondominiLogic(this.getEnvUtente(request));
					HttpSession sessione = request.getSession();

					Vector listaElementiFiltro = new Vector();
					Vector operatoriStringa = new Vector();
					operatoriStringa.add(new EscOperatoreFiltro("=","uguale"));
					operatoriStringa.add(new EscOperatoreFiltro("like","contiene"));

					// costruisce il vettore di elementi per la pagina di ricerca

					EscElementoFiltro elementoFiltro = new EscElementoFiltro();

					elementoFiltro = new EscElementoFiltro();
					elementoFiltro.setLabel("Denominazione");
					elementoFiltro.setAttributeName("DENOMINAZIONE");
					elementoFiltro.setTipo("S");
					elementoFiltro.setCampoJS("");
					elementoFiltro.setListaOperatori(operatoriStringa);
					elementoFiltro.setCampoFiltrato("DENOMINAZIONE");
					listaElementiFiltro.add(elementoFiltro);

					elementoFiltro = new EscElementoFiltro();
					elementoFiltro.setLabel("Codice Via");
					elementoFiltro.setAttributeName("CODVIA");
					elementoFiltro.setTipo("S");
					elementoFiltro.setCampoJS("");
					elementoFiltro.setListaOperatori(operatoriStringa);
					elementoFiltro.setCampoFiltrato("CODVIA");
					listaElementiFiltro.add(elementoFiltro);

					elementoFiltro = new EscElementoFiltro();
					elementoFiltro.setLabel("Indirizzo");
					elementoFiltro.setAttributeName("INDIRIZZO");
					elementoFiltro.setTipo("S");
					elementoFiltro.setCampoJS("");
					elementoFiltro.setListaOperatori(operatoriStringa);
					elementoFiltro.setCampoFiltrato("INDIRIZZO");
					listaElementiFiltro.add(elementoFiltro);

					elementoFiltro = new EscElementoFiltro();
					elementoFiltro.setLabel("Civico");
					elementoFiltro.setAttributeName("CIVICO");
					elementoFiltro.setTipo("S");
					elementoFiltro.setCampoJS("numeroIntero");
					elementoFiltro.setListaOperatori(operatoriStringa);
					elementoFiltro.setCampoFiltrato("CIVICO");
					listaElementiFiltro.add(elementoFiltro);

					sessione.setAttribute("LISTA_RICERCA",listaElementiFiltro);
					sessione.setAttribute("TITOLO",Tema.getNomeFiltro(uc));
					
					//chiamare la pagina di ricerca
					nav.chiamataRicerca();
					this.chiamaPagina(request,response,"condomini/condFrame.jsp", nav);

				}

	private void mCaricareLista(HttpServletRequest request,HttpServletResponse response,boolean notListaPrincipale)throws Exception{
			// prendere dalla request i parametri di ricerca impostati dall'utente
			HttpSession sessione = request.getSession();

			if (sessione.getAttribute(NOMEFINDER)!= null){
				if (((Object)sessione.getAttribute(NOMEFINDER)).getClass() == new CondominiFinder().getClass()){
					finder = (CondominiFinder)sessione.getAttribute(NOMEFINDER);
				}
				else
					finder = null;
			}


			finder = (CondominiFinder)gestireMultiPagina(finder,request);

			CondominiCondominiLogic logic = new CondominiCondominiLogic(this.getEnvUtente(request));
			Hashtable ht = logic.mCaricareListaCondomini(vettoreRicerca,finder);

			// eseguire la query e caricare il vettore con i risultati
			// chiamare la pagina di lista


			Vector vct_lista_condomini= (Vector)ht.get("LISTA_CONDOMINI");
			finder = (CondominiFinder)ht.get("FINDER");

			sessione.setAttribute("LISTA_CONDOMINI",vct_lista_condomini);

			if (!notListaPrincipale){
				finder = (CondominiFinder)ht.get("FINDER");
				sessione.setAttribute(NOMEFINDER,finder);
			}


			if(chiamataEsterna)
				nav.chiamataEsternaLista();
			else
				nav.chiamataInternaLista();

			this.chiamaPagina(request,response,"condomini/condFrame.jsp", nav);
		}

	private void mCaricareDettaglio(HttpServletRequest request,HttpServletResponse response)throws Exception{
				// prendere dalla request il parametrio identificativo dell'oggetto cliccato
				// eseguire la query per caricare l'oggetto selezionato dal db
				// chiamare la pagina di dettaglio

				String azione = "";
				HttpSession sessione = request.getSession();
				CondominiFinder finder = null;
				//boolean chiamataEsterna = false;
				if (sessione.getAttribute(NOMEFINDER) !=null){
					if (((Object)sessione.getAttribute(NOMEFINDER)).getClass() == new CondominiFinder().getClass()){
						finder = (CondominiFinder)sessione.getAttribute(NOMEFINDER);
					}
				}
				if (request.getParameter("AZIONE")!= null)
					azione = request.getParameter("AZIONE");
				gestioneMultiRecord(request,response,azione,finder,sessione,"LISTA_CONDOMINI",(Vector)sessione.getAttribute("LISTA_CONDOMINI"),NOMEFINDER);
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
				CondominiCondominiLogic logic = new CondominiCondominiLogic(this.getEnvUtente(request));
				Hashtable ht = logic.mCaricareDettaglioCondominio(oggettoSel);

				Condomini cond = (Condomini)ht.get("CONDOMINIO");
				sessione.setAttribute("CONDOMINIO",cond);
				Vector vct = (Vector )ht.get("LISTA_CONDOMINI_MULTIPLI");
				sessione.setAttribute("LISTA_CONDOMINI_MULTIPLI",vct);

				if(chiamataEsterna)
					nav.chiamataEsternaDettaglio();
				else
					nav.chiamataInternaDettaglio();


				this.chiamaPagina(request,response,"condomini/condFrame.jsp", nav);

				//EscFinder escf = (EscFinder)sessione.getAttribute(NOMEFINDER);


			}

	public String getChiaveOggetto(EscFinder finder, Vector listaOggetti,int recordSuccessivo){

		Condomini def = (Condomini)listaOggetti.get(recordSuccessivo);
		String key =def.getCodctb().equals("-")?"-1":def.getCodctb();
 			   key+="@"+def.getDenominazione()+"@"+def.getCodvia()+"@"+def.getIndirizzo()+"@";
 			   key+=def.getCivico().equals("-")?"-1":def.getCivico();
 		return key;


	}

			/*public Hashtable executeLogic(EscFinder finder2) throws Exception{
				finder = (CondominiFinder)finder2;
				CondominiCondominiLogic logic = new CondominiCondominiLogic(this.getEnvUtente());
				return logic.mCaricareListaCondomini(this.vettoreRicerca,finder);
				}*/

			public EscFinder getNewFinder(){
						return new CondominiFinder();
					}

			public String getTema() {
				return "Condomini";
			}

		public String getTabellaPerCrossLink() {
				return "SIT_MI_CODICE_VIA_COND";
			}
}

