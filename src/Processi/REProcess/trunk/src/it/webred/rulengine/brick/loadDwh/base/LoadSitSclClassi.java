package it.webred.rulengine.brick.loadDwh.base;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Timestamp;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.Properties;


import org.apache.log4j.Logger;

import it.webred.rulengine.Context;
import it.webred.rulengine.Rule;
import it.webred.rulengine.brick.bean.ApplicationAck;
import it.webred.rulengine.brick.bean.CommandAck;
import it.webred.rulengine.brick.bean.ErrorAck;
import it.webred.rulengine.brick.bean.RejectAck;
import it.webred.rulengine.db.model.RRuleParamIn;
import it.webred.rulengine.dwh.DwhUtils;
import it.webred.rulengine.dwh.Dao.DaoException;
import it.webred.rulengine.dwh.Dao.DaoFactory;
import it.webred.rulengine.dwh.Dao.SitSclClassiDao;
import it.webred.rulengine.dwh.def.ChiaveOriginale;
import it.webred.rulengine.dwh.def.DtExpDato;
import it.webred.rulengine.dwh.def.DtFineDato;
import it.webred.rulengine.dwh.def.DtIniDato;
import it.webred.rulengine.dwh.table.SitSclClassi;
import it.webred.rulengine.exception.CommandException;
import it.webred.rulengine.impl.bean.BeanCommand;

public class LoadSitSclClassi extends AbstractLoaderCommand implements Rule
{
	
	public LoadSitSclClassi(BeanCommand bc, Properties jrulecfg) {
		super(bc, jrulecfg);
		// TODO Auto-generated constructor stub
	}


	private static final Logger log = Logger.getLogger(LoadSitSclClassi.class.getName());
	
	//	blocco di inizializzazione della variabile tabellaDwhClass (specifica di quale classe è la TabellaDwh di questo load)
	{
		tabellaDwhClass = SitSclClassi.class;
	}


	@Override
	public CommandAck runWithConnectionSpec(Context ctx, Connection conn)
		throws CommandException
	{
		try {
			List parametriIn = this.getParametersIn(_jrulecfg);
			String id_orig = (String) ctx.get(((RRuleParamIn) parametriIn.get(0)).getDescr());
			Integer fk_ente_sorgente = (Integer) ctx.get(((RRuleParamIn) parametriIn.get(1)).getDescr());
			
			String codClasse = (String) ctx.get(((RRuleParamIn) parametriIn.get(2)).getDescr());
			String codIstituto = (String) ctx.get(((RRuleParamIn) parametriIn.get(3)).getDescr());
			String nrSezione = (String) ctx.get(((RRuleParamIn) parametriIn.get(4)).getDescr());
			String sezioneClasse = (String) ctx.get(((RRuleParamIn) parametriIn.get(5)).getDescr());
			String tipoClasse = (String) ctx.get(((RRuleParamIn) parametriIn.get(6)).getDescr());
			String mensaLun = (String) ctx.get(((RRuleParamIn) parametriIn.get(7)).getDescr());
			String mensaMar = (String) ctx.get(((RRuleParamIn) parametriIn.get(8)).getDescr());
			String mensaMer = (String) ctx.get(((RRuleParamIn) parametriIn.get(9)).getDescr());
			String mensaGio = (String) ctx.get(((RRuleParamIn) parametriIn.get(10)).getDescr());
			String mensaVen = (String) ctx.get(((RRuleParamIn) parametriIn.get(11)).getDescr());
			String mensaSab = (String) ctx.get(((RRuleParamIn) parametriIn.get(12)).getDescr());

			Timestamp dt_exp_dato = (Timestamp) ctx.get(((RRuleParamIn) parametriIn.get(13)).getDescr());
			Timestamp dt_ini_val_dato = (Timestamp) ctx.get(((RRuleParamIn) parametriIn.get(14)).getDescr());
			Timestamp dt_fine_val_dato = (Timestamp) ctx.get(((RRuleParamIn) parametriIn.get(15)).getDescr());
			Integer flag_dt_val_dato = (Integer) ctx.get(((RRuleParamIn) parametriIn.get(16)).getDescr());
			
			
			if(codClasse==null || codIstituto==null || nrSezione==null)
				return new RejectAck("SIT_SCL_CLASSI - Dati obbligatori non forniti");
			if(flag_dt_val_dato.intValue() != 0 && flag_dt_val_dato.intValue() != 1)
				return new RejectAck("SIT_SCL_CLASSI - flag_dt_val_dato non valido");
			SitSclClassi tab = (SitSclClassi)getTabellaDwhInstance(ctx);
			ChiaveOriginale chiaveOriginale =  new ChiaveOriginale();
			chiaveOriginale.setValore(id_orig);
			
			NumberFormat n = NumberFormat.getNumberInstance(Locale.ITALY);
			
			tab.setIdOrig(chiaveOriginale);
			tab.setDtExpDato((DtExpDato)DwhUtils.getDataDwh(new DtExpDato(),dt_exp_dato));
			tab.setDtInizioDato((DtIniDato)DwhUtils.getDataDwh(new DtIniDato(),dt_ini_val_dato));
			tab.setDtFineDato((DtFineDato)DwhUtils.getDataDwh(new DtFineDato(),dt_fine_val_dato));
			tab.setFlagDtValDato(new BigDecimal(flag_dt_val_dato));
			tab.setFkEnteSorgente(DwhUtils.getIdentificativo(fk_ente_sorgente), ctx.getBelfiore());
			
			
			tab.setCodClasse(codClasse);
			tab.setCodIstituto(codIstituto);
			tab.setNrSezione(new BigDecimal(nrSezione));
			tab.setSezioneClasse(sezioneClasse);
			tab.setTipoClasse(tipoClasse);
			tab.setMensaLun(mensaLun);
			tab.setMensaMar(mensaMar);
			tab.setMensaMer(mensaMer);
			tab.setMensaGio(mensaGio);
			tab.setMensaVen(mensaVen);
			tab.setMensaSab(mensaSab);
			
			SitSclClassiDao dao = (SitSclClassiDao) DaoFactory.createDao(conn,tab, ctx.getEnteSorgenteById(fk_ente_sorgente)); 
			
			
			boolean salvato = dao.save(ctx.getBelfiore());			
			
		} catch (DaoException e)
		{
			log.error("Errore di inserimento nella classe Dao",e);
			ErrorAck ea = new ErrorAck(e.getMessage());
			return (ea);
		} catch (Exception e)
		{
			log.error("LoadSitSclClassi",e);
			ErrorAck ea = new ErrorAck(e.getMessage());
			return (ea);
		}

		String msg = "Record SIT_SCL_CLASSI inserito";
		return(new ApplicationAck(msg));

	}

}
