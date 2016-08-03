CREATE OR REPLACE VIEW vw_siticonduz_imm_all
(
    cod_nazionale
  , foglio
  , particella
  , sub
  , unimm
  , tipo_titolo
  , perc_poss
  , tipo_documento
  , tit_no_cod
  , valido_inizio
  , valido_fine
  , atto_inizio
  , atto_fine
  , pk_cuaa
  , cuaa
  , data_inizio
  , data_fine
)
AS
(
SELECT "COD_NAZIONALE","FOGLIO","PARTICELLA","SUB","UNIMM",1 as "TIPO_TITOLO",1000 as "PERC_POSS",'T' as "TIPO_DOCUMENTO",'' as "TIT_NO_COD",DATA_INIZIO_VAL as "VALIDO_INIZIO",DATA_FINE_VAL as "VALIDO_FINE",DATA_INIZIO_VAL as "ATTO_INIZIO",DATA_FINE_VAL as "ATTO_FINE",2510666 as "PK_CUAA",'BLLGPP66B09F205A' as"CUAA", DATA_INIZIO_VAL  as "DATA_INIZIO",DATA_FINE_VAL as "DATA_FINE" FROM SITI.SITIUIU
);





CREATE OR REPLACE VIEW VW_CONTRIBUENTI
(PK_SEQU_CONTRIBUENTI, UK_CODI_CONTRIBUENTE, CODENTE, CODICE_CONTRIBUENTE, CODICE_FISCALE, 
 PARTITA_IVA, DENOMINAZIONE, COGNOME, NOME, SESSO, 
 DATA_NASCITA, DESCR_COMUNE_NASCITA, DESCR_INDIRIZZO, INTERNO, COMUNE_RESIDENZA, 
 FK_CIVICI, FK_ANAGRAFE, FK_COMUNI, DATA_VALIDITA, PROVENIENZA)
AS 
(
SELECT PK_id_CONTRIBUENTI as "PK_SEQU_CONTRIBUENTI",sogd as "UK_CODI_CONTRIBUENTE",CODENT as "CODENTE",codfisc as "CODICE_CONTRIBUENTE",codfisc as "CODICE_FISCALE",codfisc as "PARTITA_IVA","DENOMINAZIONE","COGNOME","NOME","SESSO",to_date ('17-05-1970','dd-MM-yyyy') as "DATA_NASCITA", 'PERUGIA' "DESCR_COMUNE_NASCITA",'VIA LE MANI DAL CULO 26' as "DESCR_INDIRIZZO",1 as "INTERNO",'MILANO' as "COMUNE_RESIDENZA",1 as "FK_CIVICI",1 as "FK_ANAGRAFE",1 as "FK_COMUNI","DATA_VALIDITA","PROVENIENZA" FROM DBTOTALE.SIT_T_CONTRIBUENTI
         WHERE PROVENIENZA = 'T'
);

CREATE OR REPLACE VIEW VW_ANAGRAFE
(TIPO_SOGGETTO, CODICE_FISCALE, COGNOME, NOME, SESSO, 
 DATA_NASCITA, DESCR_COMUNE_NASCITA, DESCR_INDIRIZZO)
AS 
(
SELECT 'T' ,codfisc as "CODICE_FISCALE","COGNOME","NOME","SESSO",to_date ('17-05-1970','dd-MM-yyyy') as "DATA_NASCITA", 'PERUGIA' "DESCR_COMUNE_NASCITA",'VIA LE MANI DAL CULO 26' as "DESCR_INDIRIZZO"  FROM DBTOTALE.SIT_T_CONTRIBUENTI
         WHERE PROVENIENZA = 'T'
);

