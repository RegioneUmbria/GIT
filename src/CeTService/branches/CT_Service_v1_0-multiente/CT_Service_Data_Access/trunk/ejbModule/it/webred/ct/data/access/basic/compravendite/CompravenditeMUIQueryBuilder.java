package it.webred.ct.data.access.basic.compravendite;

public class CompravenditeMUIQueryBuilder {
	private final String SQL_SOGGETTI_NOTA = 
		"SELECT DISTINCT SOGG.TIPO_SOGGETTO,SOGG.COGNOME, SOGG.NOME, SOGG.CODICE_FISCALE, SOGG.DENOMINAZIONE,  SOGG.CODICE_FISCALE_G, TITO.SC_FLAG_TIPO_TITOL_NOTA , TITO.SF_FLAG_TIPO_TITOL_NOTA "+
	    "FROM MUI_NOTA_TRAS NOTA, MUI_SOGGETTI SOGG, MUI_TITOLARITA TITO " +
		"WHERE TITO.IID_NOTA = SOGG.IID_NOTA  " +
		  "AND TITO.IID_FORNITURA = SOGG.IID_FORNITURA " +
		  "AND TITO.ID_SOGGETTO_NOTA = SOGG.ID_SOGGETTO_NOTA " +
		  "AND SOGG.IID_NOTA = NOTA.IID " + 
		  "AND SOGG.IID_FORNITURA = NOTA.IID_FORNITURA " + 
		  "AND NOTA.IID= ? " +
		  "ORDER BY SF_FLAG_TIPO_TITOL_NOTA, SC_FLAG_TIPO_TITOL_NOTA, COGNOME,NOME, DENOMINAZIONE ";

	public String getSQL_SOGGETTI_NOTA() {
		return SQL_SOGGETTI_NOTA;
	}
	
}