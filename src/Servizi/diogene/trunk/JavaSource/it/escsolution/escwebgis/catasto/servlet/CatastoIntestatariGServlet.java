/*
 * Created on 19-apr-2004
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package it.escsolution.escwebgis.catasto.servlet;

import it.escsolution.escwebgis.catasto.bean.IntestatarioF;
import it.escsolution.escwebgis.catasto.bean.IntestatarioG;
import it.escsolution.escwebgis.catasto.bean.IntestatarioGFinder;
import it.escsolution.escwebgis.catasto.logic.CatastoImmobiliLogic;
import it.escsolution.escwebgis.catasto.logic.CatastoIntestatariFLogic;
import it.escsolution.escwebgis.catasto.logic.CatastoIntestatariGLogic;
import it.escsolution.escwebgis.catasto.logic.CatastoTerreniLogic;
import it.escsolution.escwebgis.common.ComuniLogic;
import it.escsolution.escwebgis.common.EscElementoFiltro;
import it.escsolution.escwebgis.common.EscFinder;
import it.escsolution.escwebgis.common.EscOperatoreFiltro;
import it.escsolution.escwebgis.common.EscService;
import it.escsolution.escwebgis.common.EscServlet;
import it.escsolution.escwebgis.common.PulsantiNavigazione;
import it.escsolution.escwebgis.common.Tema;
import it.webred.GlobalParameters;
import it.webred.indice.OggettoIndice;

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
public class CatastoIntestatariGServlet extends EscServlet implements EscService{

		private String recordScelto;
		private CatastoIntestatariGLogic logic = null;
		private IntestatarioGFinder finder = null;
		private final String NOMEFINDER = "FINDER4";
		PulsantiNavigazione nav = new PulsantiNavigazione();

	private void mCaricareParticelle(HttpServletRequest request,HttpServletResponse response)throws Exception{
		/*
		 * carica la lista di terreni e fabbricati dell'intestatario
		 */
		HttpSession sessione = request.getSession();
		 // immobili
		 CatastoImmobiliLogic logic = new CatastoImmobiliLogic(this.getEnvUtente(request));
		 IntestatarioG intG = (IntestatarioG)sessione.getAttribute("INTESTATARIOG");
		 Hashtable ht = logic.mCaricareListaImmobiliPerTitolarita(intG.getCodIntestatario());
		 Vector listaImmobili = (Vector)ht.get("LISTA_IMMOBILI");


		// terreni
		CatastoTerreniLogic logic2 = new CatastoTerreniLogic(this.getEnvUtente(request));
		Hashtable ht2 = logic2.mCaricareListaTerreniPerTitolarita(intG.getCodIntestatario());
		Vector listaTerreni = (Vector)ht2.get("LISTA_TERRENI");

		sessione.setAttribute("LISTA_IMMOBILI2",listaImmobili);
		sessione.setAttribute("LISTA_TERRENI2",listaTerreni);

		nav.chiamataPart();
		this.chiamaPagina(request,response,"catasto/intGiuFrame.jsp",nav);

	}

	private void mCaricareDetParticelle(HttpServletRequest request,HttpServletResponse response)throws Exception{
		/*
		 * carica la lista di terreni e fabbricati dell'intestatario
		 */
		HttpSession sessione = request.getSession();
		 // immobili
		 CatastoImmobiliLogic logic = new CatastoImmobiliLogic(this.getEnvUtente(request));
		 IntestatarioG intG = (IntestatarioG)sessione.getAttribute("INTESTATARIOG");
		 Hashtable ht = logic.mCaricareListaImmobiliPerTitolarita(intG.getCodIntestatario());
		 Vector listaImmobili = (Vector)ht.get("LISTA_IMMOBILI");


		// terreni
		CatastoTerreniLogic logic2 = new CatastoTerreniLogic(this.getEnvUtente(request));
		Hashtable ht2 = logic2.mCaricareListaTerreniPerTitolarita(intG.getCodIntestatario());
		Vector listaTerreni = (Vector)ht2.get("LISTA_TERRENI");

		sessione.setAttribute("LISTA_IMMOBILI2",listaImmobili);
		sessione.setAttribute("LISTA_TERRENI2",listaTerreni);

	}
	
	private void mCaricareDetParticellePopup(HttpServletRequest request,HttpServletResponse response)throws Exception{
		/*
		 * carica la lista di terreni e fabbricati dell'intestatario
		 */
		
		 // immobili
		 CatastoImmobiliLogic logic = new CatastoImmobiliLogic(this.getEnvUtente(request));
		 IntestatarioG intG = (IntestatarioG)request.getAttribute("INTESTATARIOG");
		 Hashtable ht = logic.mCaricareListaImmobiliPerTitolarita(intG.getCodIntestatario());
		 Vector listaImmobili = (Vector)ht.get("LISTA_IMMOBILI");


		// terreni
		CatastoTerreniLogic logic2 = new CatastoTerreniLogic(this.getEnvUtente(request));
		Hashtable ht2 = logic2.mCaricareListaTerreniPerTitolarita(intG.getCodIntestatario());
		Vector listaTerreni = (Vector)ht2.get("LISTA_TERRENI");

		request.setAttribute("LISTA_IMMOBILI2",listaImmobili);
		request.setAttribute("LISTA_TERRENI2",listaTerreni);

	}
	
	public void EseguiServizio(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		
		HttpSession sessione = request.getSession();		
		sessione.setAttribute("FUNZIONALITA", Tema.getNomeFunzionalita(uc));
		
		super.EseguiServizio(request,response);
		
		String ext= request.getParameter("IND_EXT");
		
		if (ext!= null && ext.equals("1"))
			_EseguiServizioExt(request,response);
		else
			_EseguiServizio(request,response);
		
	}

	public void _EseguiServizio(
		HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, IOException {

		/*
		 * ad ogni uc corrisponde una funzionalit diversa
		 *
		 */
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
				mCaricareLista(request,response);
				break;
			case 3:
				// ho cliccato su un elemento --> visualizzo il dettaglio
				mCaricareDettaglio(request,response,false,3);
				//this.leggiCrossLink(request);
				break;
			case 4:
				// ho cliccato su un elemento --> visualizzo il dettaglio
				mCaricareParticelle(request,response);
				break;
			case 5:
				mCaricarePopupTitolarita(request,response,false);
				break;
			case 33:
				// ho cliccato su un elemento --> visualizzo il dettaglio
				mCaricareDettaglio(request,response,false,33);
				//this.leggiCrossLink(request);
				break;
			}
		}
		 catch(it.escsolution.escwebgis.common.DiogeneException de)
		 {
		 	throw de;
		 }
		catch(Exception exx){
			log.error(exx.getMessage(),exx);
		}


	}
	
	public void _EseguiServizioExt(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException
	{
		super.EseguiServizio(request,response);
		try
		{
			
				switch (st){
					case 101:
						mCaricareDettaglio(request,response,false,101);			
						break;
					
				}
				
		}
		catch(it.escsolution.escwebgis.common.DiogeneException de)
		{
			throw de;
		}
		catch(Exception ex)
		{
			throw new it.escsolution.escwebgis.common.DiogeneException(ex);
		}
	}
	private void mCaricareDettaglio(HttpServletRequest request,HttpServletResponse response,boolean tipo, int st)throws Exception{
		// prendere dalla request il parametro identificativo dell'oggetto cliccato
		// eseguire la query per caricare l'oggetto selezionato dal db
		// chiamare la pagina di dettaglio


		String azione = "";
		HttpSession sessione = request.getSession();
		removeOggettiIndiceDaSessione(sessione);
		 		
		IntestatarioGFinder finder = null;

		if (sessione.getAttribute(NOMEFINDER) !=null){
			if (((Object)sessione.getAttribute(NOMEFINDER)).getClass() == new IntestatarioGFinder().getClass()){
				finder = (IntestatarioGFinder)sessione.getAttribute(NOMEFINDER);
			}
			else{
				// il finder non corrisponde -->

				finder = null;

			}
		}


		if (request.getParameter("AZIONE")!= null)
				azione = request.getParameter("AZIONE");
		gestioneMultiRecord(request,response,azione,finder,sessione,"LISTA_INTESTATARIG",(Vector)sessione.getAttribute("LISTA_INTESTATARIG"),NOMEFINDER);
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
		 * carica il dettaglio dell'intestatario
		 */
		CatastoIntestatariGLogic logic = new CatastoIntestatariGLogic(this.getEnvUtente(request));
		Hashtable ht =null;
		
		if (st == 101)
			 ht = logic.mCaricareDettaglioFromSoggetto(oggettoSel);
		else
			ht = logic.mCaricareDettaglioIntestatarioG(oggettoSel);
		

		IntestatarioG intG = (IntestatarioG)ht.get("INTESTATARIOG");

		// LEGGE E METTE IN SESSIONE I SOGGETTI SCARTATI
		super.leggiScarti(request.getSession(), intG, "CONS_SOGG_TAB", null, "SOGGETTI CATASTO", request);

		sessione.setAttribute("INTESTATARIOG",intG);

//		TEST MB
		mCaricareDetParticelle(request,response);
//FINE TEST MB

		if(chiamataEsterna)
			nav.chiamataEsternaDettaglio();
		else
			nav.chiamataInternaDettaglio();
		
		// Aggiungo i valori per l'indice di correlazione
		Vector<OggettoIndice> sOggettiInd = new Vector<OggettoIndice>();
		
		OggettoIndice oi = new OggettoIndice();
		
		oi.setIdOrig(intG.getPkId());
		oi.setFonte("4");
		oi.setProgr("3");
		
		if (intG.getDenominazione()!= null && ! intG.getDenominazione().equals(""))
			oi.setDescrizione(intG.getDenominazione());
		
		sOggettiInd.add(oi);
		
		sessione.setAttribute("indice_soggetti", sOggettiInd);

		this.chiamaPagina(request,response,"catasto/intGiuFrame.jsp",nav);
	}
	
	private void mCaricareDettaglioFromSoggetto(HttpServletRequest request,HttpServletResponse response) throws Exception
	{
		
		String idSoggetto= request.getParameter("OGGETTO_SEL");
		HttpSession sessione = request.getSession();
		
		removeOggettiIndiceDaSessione(sessione);
		
		CatastoIntestatariGLogic logic = new CatastoIntestatariGLogic(this.getEnvUtente(request));
		Hashtable ht = logic.mCaricareDettaglioFromSoggetto(idSoggetto);
		

			IntestatarioG intG = (IntestatarioG)ht.get("INTESTATARIOG");

			// LEGGE E METTE IN SESSIONE I SOGGETTI SCARTATI
			super.leggiScarti(request.getSession(), intG, "CONS_SOGG_TAB", null, "SOGGETTI CATASTO", request);

			sessione.setAttribute("INTESTATARIOG",intG);
			sessione.setAttribute("TIPO",new Boolean(false));

			mCaricareDetParticelle(request,response);

			if(chiamataEsterna)
				nav.chiamataEsternaDettaglio();
			else
				nav.chiamataInternaDettaglio();

		//	st = 3;
			
			
			// Aggiungo i valori per l'indice di correlazione
			Vector<OggettoIndice> sOggettiInd = new Vector<OggettoIndice>();
			
			OggettoIndice oi = new OggettoIndice();
			
			oi.setIdOrig(intG.getPkId());
			oi.setFonte("4");
			oi.setProgr("3");
			
			if (intG.getDenominazione()!= null && ! intG.getDenominazione().equals(""))
				oi.setDescrizione(intG.getDenominazione());
			
			sOggettiInd.add(oi);
			
			sessione.setAttribute("indice_soggetti", sOggettiInd);

			this.chiamaPagina(request,response,"catasto/intGiuFrame.jsp", nav);

			

		
	}


	private void mCaricareFormRicerca(HttpServletRequest request,HttpServletResponse response) throws Exception{
		// caricare dati che servono nella pagina di ricerca --> eventuali combo

		HttpSession sessione = request.getSession();
		/** Comune */
		Vector vctComuni = new ComuniLogic(this.getEnvUtente(request)).getListaComuniUtente(request.getUserPrincipal().getName());
		/***/


		Vector listaElementiFiltro = new Vector();
		Vector operatoriStringa = new Vector();
		operatoriStringa.add(new EscOperatoreFiltro("=","uguale"));
		operatoriStringa.add(new EscOperatoreFiltro("like","contiene"));


		Vector operatoriStringaRid = new Vector();
		operatoriStringaRid.add(new EscOperatoreFiltro("=","uguale"));

		Vector operatoriNumerici = new Vector();
		operatoriNumerici.add(new EscOperatoreFiltro("=","="));
		operatoriNumerici.add(new EscOperatoreFiltro("<>","<>"));
		operatoriNumerici.add(new EscOperatoreFiltro(">",">"));
		operatoriNumerici.add(new EscOperatoreFiltro("<","<"));


		// costruisce il vettore di elementi per la pagina di ricerca
		EscElementoFiltro elementoFiltro = new EscElementoFiltro();
		elementoFiltro.setLabel("Comune");
		elementoFiltro.setAttributeName("COMUNE");
		elementoFiltro.setTipo("S");
		elementoFiltro.setCampoJS("");
		elementoFiltro.setListaOperatori(operatoriStringa);
		elementoFiltro.setListaValori(vctComuni);
		elementoFiltro.setCampoFiltrato("siticomu.CODI_FISC_LUNA (+)");
		listaElementiFiltro.add(elementoFiltro);

		elementoFiltro = new EscElementoFiltro();
		elementoFiltro.setLabel("Denominazione");
		elementoFiltro.setAttributeName("DENOMINAZIONE");
		elementoFiltro.setTipo("S");
		elementoFiltro.setCampoJS("");
		elementoFiltro.setListaOperatori(operatoriStringa);
		elementoFiltro.setCampoFiltrato("cons_sogg_tab.RAGI_SOCI");
		listaElementiFiltro.add(elementoFiltro);

		elementoFiltro = new EscElementoFiltro();
		elementoFiltro.setLabel("Partita IVA");
		elementoFiltro.setAttributeName("PARTITA_IVA");
		elementoFiltro.setTipo("S");
		elementoFiltro.setCampoJS("");
		elementoFiltro.setListaOperatori(operatoriStringa);
		elementoFiltro.setCampoFiltrato("cons_sogg_tab.CODI_PIVA");
		listaElementiFiltro.add(elementoFiltro);



		sessione.setAttribute("LISTA_RICERCA",listaElementiFiltro);
		sessione.setAttribute("TITOLO",Tema.getNomeFiltro(uc));
		

		// chiamare la pagina di ricerca
		nav.chiamataRicerca();
		this.chiamaPagina(request,response,"catasto/intGiuFrame.jsp",nav);
	}
	private void mCaricareLista(HttpServletRequest request,HttpServletResponse response)throws Exception{
		// prendere dalla request i parametri di ricerca impostati dall'utente
		// eseguire la query e caricare il vettore con i risultati
		// chiamare la pagina di lista
		// prendere dalla request i parametri di ricerca impostati dall'utente
		HttpSession sessione = request.getSession();

		if (sessione.getAttribute(NOMEFINDER)!= null){
				finder = (IntestatarioGFinder)sessione.getAttribute(NOMEFINDER);
		}
		else{
			finder = null;// IntestatarioGFinder();
		}

		finder = (IntestatarioGFinder)gestireMultiPagina(finder,request);

		CatastoIntestatariGLogic logic = new CatastoIntestatariGLogic(this.getEnvUtente(request));
		Hashtable ht = logic.mCaricareListaIntestatariG2(vettoreRicerca,finder);

		// eseguire la query e caricare il vettore con i risultati
		// chiamare la pagina di lista
		Vector vct_lista_intestatari = (Vector)ht.get("LISTA_INTESTATARIG");
		finder = (IntestatarioGFinder)ht.get("FINDER");

//		TEST MB
		boolean saltaListaConUno = GlobalParameters.SALTA_LISTA_CON_UNO.get(this.getEnvUtente(request).getEnte()) == null ? GlobalParameters.SALTA_LISTA_CON_UNO_DEF : GlobalParameters.SALTA_LISTA_CON_UNO.get(this.getEnvUtente(request).getEnte()).booleanValue();
		if (saltaListaConUno && vct_lista_intestatari.size() == 1){
			/*
			 * carica il dettaglio dell'intestatario
			 */
			logic = new CatastoIntestatariGLogic(this.getEnvUtente(request));
			Hashtable htd = logic.mCaricareDettaglioIntestatarioG(((IntestatarioG)vct_lista_intestatari.get(0)).getCodIntestatario());

			IntestatarioG intG = (IntestatarioG)htd.get("INTESTATARIOG");

			// LEGGE E METTE IN SESSIONE I SOGGETTI SCARTATI
			super.leggiScarti(request.getSession(), intG, "CONS_SOGG_TAB", null, "SOGGETTI CATASTO", request);

			sessione.setAttribute("INTESTATARIOG",intG);

			mCaricareDetParticelle(request,response);

			if(chiamataEsterna)
				nav.chiamataEsternaDettaglio();
			else
				nav.chiamataInternaDettaglio();

			st=33;

			this.chiamaPagina(request,response,"catasto/intGiuFrame.jsp",nav);

			//cross link
			//this.leggiCrossLink(request);


		}else {
//FINE TEST MB

		request.setAttribute("LISTA_INTESTATARIG",vct_lista_intestatari);
		sessione.setAttribute("LISTA_INTESTATARIG",vct_lista_intestatari);
		sessione.setAttribute(NOMEFINDER,finder);

		if(chiamataEsterna)
			nav.chiamataEsternaLista();
		else
			nav.chiamataInternaLista();
		this.chiamaPagina(request,response,"catasto/intGiuFrame.jsp",nav);

//		TEST MB
		}
//		FINE TEST MB

	}
	public String getChiaveOggetto(EscFinder finder, Vector listaOggetti,int recordSuccessivo){
		return ((IntestatarioG)listaOggetti.get(recordSuccessivo)).getCodIntestatario();
	}
	public Hashtable executeLogic(EscFinder finder2, HttpServletRequest request) throws Exception{
		finder = (IntestatarioGFinder)finder2;
		CatastoIntestatariGLogic logic = new CatastoIntestatariGLogic(this.getEnvUtente(request));
		return logic.mCaricareListaIntestatariG2(this.vettoreRicerca,finder);
	}

	public EscFinder getNewFinder(){
			return new IntestatarioGFinder();
		}
	public String getTema() {
		return "Catasto";
	}
	public String getTabellaPerCrossLink() {
		return "CONS_SOGG_TAB/*G*/";
	}
	
	private void mCaricarePopupTitolarita(HttpServletRequest request,HttpServletResponse response, boolean tipo)throws Exception{
		
		String pIva= request.getParameter("PARTITA_IVA");
		
		CatastoIntestatariGLogic logic = new CatastoIntestatariGLogic(this.getEnvUtente(request));
		
		//ricavo l'id dell'intestatario in base ai dati
		
		String oggettoSel= logic.mTrovaIntestatario(pIva);
		
		/*
		 * carica il dettaglio dell'intestatario
		 */
		
		
		Hashtable ht = logic.mCaricareDettaglioIntestatarioG(oggettoSel);

		IntestatarioG intG = (IntestatarioG)ht.get("INTESTATARIOG");

		// LEGGE E METTE IN SESSIONE I SOGGETTI SCARTATI
		super.leggiScarti(request.getSession(), intG, "CONS_SOGG_TAB", null, "SOGGETTI CATASTO", request);

		request.setAttribute("INTESTATARIOG",intG);

//		TEST MB
		mCaricareDetParticellePopup(request,response);
//FINE TEST MB

		

		this.chiamaPagina(request,response,"tributi/popupTitolaritaG.jsp",nav);
			
		}
}
