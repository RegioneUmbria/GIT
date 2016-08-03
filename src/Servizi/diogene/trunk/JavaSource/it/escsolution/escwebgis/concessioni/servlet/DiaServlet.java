/*
 * Created on 3-mag-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package it.escsolution.escwebgis.concessioni.servlet;


import it.escsolution.escwebgis.common.EscElementoFiltro;
import it.escsolution.escwebgis.common.EscFinder;
import it.escsolution.escwebgis.common.EscOperatoreFiltro;
import it.escsolution.escwebgis.common.EscService;
import it.escsolution.escwebgis.common.EscServlet;
import it.escsolution.escwebgis.common.PulsantiNavigazione;
import it.escsolution.escwebgis.common.Tema;
import it.escsolution.escwebgis.concessioni.bean.Dia;
import it.escsolution.escwebgis.concessioni.bean.DiaFinder;
import it.escsolution.escwebgis.concessioni.logic.DiaLogic;

import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class DiaServlet extends EscServlet implements EscService
{

	private String recordScelto;

	private DiaLogic logic = null;

	// private AnagrafeFinder finder = null;
	public static final String NOMEFINDER = "FINDER40";

	private DiaFinder finder = null;

	PulsantiNavigazione nav;

	public void EseguiServizio(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		/*
		 * ad ogni uc corrisponde una funzionalità diversa
		 */
		// super.init(getServletConfig());
		// String aaa = getServletConfig().getServletName();
		HttpSession sessione = request.getSession();		
		sessione.setAttribute("FUNZIONALITA", Tema.getNomeFunzionalita(uc));
		
		super.EseguiServizio(request, response);
		try
		{
			switch (st)
			{
			case 1:
				// carico la form di ricerca
				pulireSessione(request);
				mCaricareFormRicerca(request, response);
				break;
			case 2:
				// vengo dalla pagina di ricerca --> predispongo la lista e la
				// passo alla pagina di lista
				// pulireSessione(request);
				mCaricareLista(request, response);
				break;
			case 3:
				// ho cliccato su un elemento --> visualizzo il dettaglio
				mCaricareDettaglio(request, response);
				this.leggiCrossLink(request);
				break;
			case 33:
				 // ho cliccato su un elemento --> visualizzo il dettaglio						 
					 mCaricareDettaglio(request,response);
					 this.leggiCrossLink(request);						 
				 	 break;
			}
		}
		catch (it.escsolution.escwebgis.common.DiogeneException de)
		{
			throw de;
		}
		catch (Exception ex)
		{
			log.error(ex.getMessage(),ex);
		}

	}

	private void mCaricareFormRicerca(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		// caricare dati che servono nella pagina di ricerca
		HttpSession sessione = request.getSession();

		Vector listaElementiFiltro = new Vector();
		Vector operatoriStringa = new Vector();
		operatoriStringa.add(new EscOperatoreFiltro("=", "uguale"));
		operatoriStringa.add(new EscOperatoreFiltro("like", "contiene"));

		Vector operatoriStringaRid = new Vector();
		operatoriStringaRid.add(new EscOperatoreFiltro("=", "uguale"));

		// costruisce il vettore di elementi per la pagina di ricerca
		//costruisce il vettore di elementi per la pagina di ricerca
		EscElementoFiltro elementoFiltro = new EscElementoFiltro();
		elementoFiltro.setLabel("Anno");
		elementoFiltro.setAttributeName("Anno");
		elementoFiltro.setTipo("S");
		elementoFiltro.setCampoJS("");
		elementoFiltro.setListaOperatori(operatoriStringaRid);
		elementoFiltro.setCampoFiltrato("TRIM(ANNOPG)");
		listaElementiFiltro.add(elementoFiltro);

		elementoFiltro = new EscElementoFiltro();
		elementoFiltro.setLabel("Numero Protocollo");
		elementoFiltro.setAttributeName("NUMERO");
		elementoFiltro.setTipo("S");
		elementoFiltro.setCampoJS("");
		elementoFiltro.setListaOperatori(operatoriStringaRid);
		elementoFiltro.setCampoFiltrato("TRIM(NUMEROPG)");
		listaElementiFiltro.add(elementoFiltro);

		elementoFiltro = new EscElementoFiltro();
		elementoFiltro.setLabel("Denominazione");
		elementoFiltro.setAttributeName("Denominazione");
		elementoFiltro.setTipo("S");
		elementoFiltro.setCampoJS("");
		elementoFiltro.setListaOperatori(operatoriStringa);
		elementoFiltro.setCampoFiltrato("DENOMINAZIONE");
		listaElementiFiltro.add(elementoFiltro);

		elementoFiltro = new EscElementoFiltro();
		elementoFiltro.setLabel("Oggetto");
		elementoFiltro.setAttributeName("oggetto");
		elementoFiltro.setTipo("S");
		elementoFiltro.setCampoJS("");//todo
		elementoFiltro.setListaOperatori(operatoriStringa);
		elementoFiltro.setCampoFiltrato("OGGETTO");
		listaElementiFiltro.add(elementoFiltro);


		sessione.setAttribute("LISTA_RICERCA", listaElementiFiltro);
		sessione.setAttribute("TITOLO", Tema.getNomeFiltro(uc));
		

		// chiamare la pagina di ricerca
		nav = new PulsantiNavigazione();
		nav.chiamataRicerca();
		this.chiamaPagina(request, response, "concessioni/diaFrame.jsp", nav);

	}

	private void mCaricareLista(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// prendere dalla request i parametri di ricerca impostati dall'utente
		HttpSession sessione = request.getSession();

		if (sessione.getAttribute(NOMEFINDER) != null)
		{
			if (((Object) sessione.getAttribute(NOMEFINDER)).getClass() == new DiaFinder().getClass())
			{
				finder = (DiaFinder) sessione.getAttribute(NOMEFINDER);
			}
			else
				finder = null;
		}

		finder = (DiaFinder) gestireMultiPagina(finder, request);

		DiaLogic logic = new DiaLogic(this.getEnvUtente(request));
		Hashtable ht = logic.mCaricareLista(vettoreRicerca, finder);

		// eseguire la query e caricare il vettore con i risultati
		// chiamare la pagina di lista

		Vector vct_lista = (Vector) ht.get(DiaLogic.LISTA);
		finder = (DiaFinder) ht.get("FINDER");
		sessione.setAttribute(DiaLogic.LISTA, vct_lista);
		sessione.setAttribute(NOMEFINDER, finder);

		nav = new PulsantiNavigazione();
		if (chiamataEsterna)
		{

			nav.chiamataEsternaLista();
			nav.setExt("1");
			nav.setPrimo(true);
		}
		else
			nav.chiamataInternaLista();
		this.chiamaPagina(request, response, "concessioni/diaFrame.jsp", nav);
	}

	private void mCaricareDettaglio(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		// prendere dalla request il parametrio identificativo dell'oggetto
		// cliccato
		// eseguire la query per caricare l'oggetto selezionato dal db
		// chiamare la pagina di dettaglio

		String azione = "";
		HttpSession sessione = request.getSession();
		
		removeOggettiIndiceDaSessione(sessione);
		
		DiaFinder finder = null;
		// boolean chiamataEsterna = false;
		if (sessione.getAttribute(NOMEFINDER) != null)
		{
			if (((Object) sessione.getAttribute(NOMEFINDER)).getClass() == new DiaFinder().getClass())
			{
				finder = (DiaFinder) sessione.getAttribute(NOMEFINDER);
			}
		}

		if (request.getParameter("AZIONE") != null)
			azione = request.getParameter("AZIONE");
		gestioneMultiRecord(request, response, azione, finder, sessione, DiaLogic.LISTA, (Vector) sessione.getAttribute(DiaLogic.LISTA), NOMEFINDER);
		if (azione.equals(""))
		{
			oggettoSel = "";
			recordScelto = "";
			sessione.removeAttribute("BACK_JS_COUNT");
			sessione.removeAttribute("BACK_RECORD_ENABLE");

			if (request.getParameter("OGGETTO_SEL") != null)
			{
				oggettoSel = request.getParameter("OGGETTO_SEL");
			}
			if (request.getParameter("RECORD_SEL") != null)
			{
				recordScelto = request.getParameter("RECORD_SEL");
				if (finder != null)
					finder.setRecordAttuale(new Long(recordScelto).longValue());
			}
		}

		/*
		 * carica il dettaglio
		 */
		DiaLogic logic = new DiaLogic(this.getEnvUtente(request));
		Hashtable ht = logic.mCaricareDettaglio(oggettoSel);
		Dia dia = (Dia) ht.get(DiaLogic.DIA);
		sessione.setAttribute(DiaLogic.DIA, dia);
		nav = new PulsantiNavigazione();
		if (chiamataEsterna)
			nav.chiamataEsternaDettaglio();
		else
			nav.chiamataInternaDettaglio();

		this.chiamaPagina(request, response, "concessioni/diaFrame.jsp", nav);

	}


	public Hashtable executeLogic(EscFinder finder2, HttpServletRequest request) throws Exception
	{
		finder = (DiaFinder) finder2;
		DiaLogic logic = new DiaLogic(this.getEnvUtente(request));
		return logic.mCaricareLista(this.vettoreRicerca, finder);
	}

	public EscFinder getNewFinder()
	{
		return new DiaFinder();
	}

	public String getChiaveOggetto(EscFinder finder, Vector listaOggetti, int recordSuccessivo)
	{
		return ((Dia) listaOggetti.get(recordSuccessivo)).getChiave();
	}

	public String getTema()
	{
		return "Concessioni Edilizie";
	}

	public String getTabellaPerCrossLink()
	{
		return "MILANO.MI_DIA";
	}

}
