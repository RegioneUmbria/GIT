package it.webred.indice.fastsearch;

import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.escsolution.escwebgis.common.EscElementoFiltro;
import it.escsolution.escwebgis.common.EscFinder;
import it.escsolution.escwebgis.common.EscOperatoreFiltro;
import it.escsolution.escwebgis.common.EscService;
import it.escsolution.escwebgis.common.EscServlet;
import it.escsolution.escwebgis.common.PulsantiNavigazione;
import it.escsolution.escwebgis.common.Tema;
import it.webred.GlobalParameters;
import it.webred.indice.Fonte;
import it.webred.indice.fastsearch.bean.IndiceBean;
import it.webred.indice.fastsearch.bean.TipoRicercaBean;
import it.webred.indice.fastsearch.fabbricato.bean.FabbricatoTotaleBean;
import it.webred.indice.fastsearch.fabbricato.bean.FastSearchFabbricatoFinder;
import it.webred.indice.fastsearch.fabbricato.logic.FastSearchFabbricatoLogic;
import it.webred.indice.fastsearch.oggetto.bean.FastSearchOggettoFinder;
import it.webred.indice.fastsearch.oggetto.bean.OggettoTotaleBean;
import it.webred.indice.fastsearch.oggetto.logic.FastSearchOggettoLogic;

public class FastSearchFabbricatoServlet extends GenericFastSearchServlet
{
	
	private	PulsantiNavigazione nav;

   public void init(ServletConfig config) throws ServletException {
	        super.init(config);
    }



	public void EseguiServizio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
			super.EseguiServizio(request, response);
			
			request.getSession().setAttribute("FUNZIONALITA", Tema.getNomeFunzionalita(uc));
			 try{
				 switch (st){
					 case 1:
						 // carico la form di ricerca
						 pulireSessione(request);
						 mCaricareFormRicerca(request,response);
						 break;
					 case 2:
						 // carico la form di ricerca
						 mCaricareLista(request,response);
						 break;
					 case 3:
						 // carico la form di ricerca
						 mCaricareDettaglio(request,response);
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
		
		private void mCaricareFormRicerca(HttpServletRequest request, HttpServletResponse response) throws Exception
		{
			// caricare dati che servono nella pagina di ricerca
			HttpSession sessione = request.getSession();

			Vector listaElementiFiltro = new Vector();
			
			Vector operatoriStringa = new Vector();
			operatoriStringa.add(new EscOperatoreFiltro("=","uguale"));
			operatoriStringa.add(new EscOperatoreFiltro("like","contiene"));
			Vector operatoriLike = new Vector();
			operatoriLike.add(new EscOperatoreFiltro("like","contiene"));

			Vector operatoriNumerici = new Vector();
			operatoriNumerici.add(new EscOperatoreFiltro("=","="));
			operatoriNumerici.add(new EscOperatoreFiltro("<>","<>"));
			operatoriNumerici.add(new EscOperatoreFiltro(">",">"));
			operatoriNumerici.add(new EscOperatoreFiltro("<","<"));
			
			// Aggiungo i campi di ricerca
			
			listaElementiFiltro.add(getFiltroTipoRicerca());   //Tipo Ricerca
			
			EscElementoFiltro elementoFiltro = new EscElementoFiltro();
			elementoFiltro.setLabel("Sezione");
			elementoFiltro.setAttributeName("SEZIONE");
			elementoFiltro.setTipo("S");
			elementoFiltro.setListaOperatori(operatoriStringa);
			elementoFiltro.setCampoFiltrato("SEZIONE");
			listaElementiFiltro.add(elementoFiltro);
			
			elementoFiltro = new EscElementoFiltro();
			elementoFiltro.setLabel("Foglio");
			elementoFiltro.setAttributeName("FOGLIO");
			elementoFiltro.setTipo("S");
			elementoFiltro.setCampoJS("lpad4_0");
			elementoFiltro.setListaOperatori(operatoriStringa);
			elementoFiltro.setCampoFiltrato("FOGLIO");
			listaElementiFiltro.add(elementoFiltro);
			
			elementoFiltro = new EscElementoFiltro();
			elementoFiltro.setLabel("Particella");
			elementoFiltro.setAttributeName("PARTICELLA");
			elementoFiltro.setTipo("S");
			elementoFiltro.setCampoJS("lpad5_0");
			elementoFiltro.setListaOperatori(operatoriStringa);
			elementoFiltro.setCampoFiltrato("PARTICELLA");
			listaElementiFiltro.add(elementoFiltro);

			sessione.setAttribute("LISTA_RICERCA",listaElementiFiltro);
			sessione.setAttribute("TITOLO",Tema.getNomeFiltro(uc));

			nav = new PulsantiNavigazione();
			nav.chiamataRicerca();

			this.chiamaPagina(request,response,"fastsearch/fabbricato/fastSearchFabbricatoFrame.jsp", nav);

		}

		private void mCaricareLista(HttpServletRequest request,HttpServletResponse response)throws Exception{
			// prendere dalla request i parametri di ricerca impostati dall'utente
			HttpSession sessione = request.getSession();

			/*
			 * Questo parametro passato dalla InfoCivico.jsp serve a capire se la richiesta
			 * arriva dalla mappa (=dopo che si è cliccato sul civico) o dal filtro 
			 * della popolazione
			 */
			String keystr= request.getParameter("KEYSTR");
			String queryForKeyStr= request.getParameter("queryForKeyStr");
			String origine = request.getParameter("origine");
			String lastColor = request.getParameter("LAST_COLOR");
			String lastFamily = request.getParameter("LAST_FAMILY");
			
			FastSearchFabbricatoFinder finder = null;
			
			if (origine != null && !origine.trim().equalsIgnoreCase("")){
				if (vettoreRicerca == null)
					vettoreRicerca = new Vector();
				vettoreRicerca.add(origine);
			}
			if (sessione.getAttribute("FINDER504")!= null) {
				if (((Object)sessione.getAttribute("FINDER504")).getClass() == new FastSearchFabbricatoFinder().getClass()){
					finder = (FastSearchFabbricatoFinder) sessione.getAttribute("FINDER504");
				}
				else
					finder = null;
			}
			

			finder = (FastSearchFabbricatoFinder) gestireMultiPagina(finder,request);

			FastSearchFabbricatoLogic logic = new FastSearchFabbricatoLogic(this.getEnvUtente(request));
			Hashtable ht = null;
			
			boolean unico = verificaSearchSoloUnico();
			
			if(unico)
				ht = logic.mCaricareListaSoloUnico(vettoreRicerca,finder);
			else
				ht = logic.mCaricareLista(vettoreRicerca,finder);


			// eseguire la query e caricare il vettore con i risultati
			// chiamare la pagina di lista


		    Vector vct_lista_fabbricati = (Vector)ht.get("lista_fabbricati_tot");
			finder = (FastSearchFabbricatoFinder)ht.get("FINDER504");

			sessione.setAttribute("indice.lista_fabbricati", vct_lista_fabbricati);
			sessione.setAttribute("FINDER504", finder);

			sessione.setAttribute("KEYSTR", null);
			sessione.setAttribute("queryForKeyStr", null);

		
			nav = new PulsantiNavigazione();
			nav.chiamataInternaLista();
			
			this.chiamaPagina(request,response,"fastsearch/fabbricato/fastSearchFabbricatoFrame.jsp",nav);
			
		}
		
		
		private void mCaricareDettaglio(HttpServletRequest request,HttpServletResponse response)throws Exception{
			FastSearchFabbricatoLogic logic = new FastSearchFabbricatoLogic(this.getEnvUtente(request));
			HashMap<String, Fonte> fonteDescr = logic.getFonti();
			
			HashMap<String, IndiceBean> oggettiMap = logic.getFabbricatoFonti(request.getParameter("OGGETTO_SEL"), fonteDescr);

			FabbricatoTotaleBean ogg = logic.getFabbricato(request.getParameter("OGGETTO_SEL"));
			request.getSession().setAttribute("fabbricatiMap", oggettiMap);
			request.getSession().setAttribute("fonteDescr", fonteDescr);
			request.getSession().setAttribute("fabbIndiceUnico", ogg);
			
			
			nav = new PulsantiNavigazione();
			this.chiamaPagina(request,response,"fastsearch/fabbricato/fastSearchFabbricatoFrame.jsp",nav);

		}
		
		public EscFinder getNewFinder(){
			return new FastSearchFabbricatoFinder();
		}
		
		public String getTema() {
			return "Ricerca veloce Fabbricati";
		}
		

		public String getLocalDataSource() {
			return "jdbc/Diogene_DS";
		}
		
		
}
