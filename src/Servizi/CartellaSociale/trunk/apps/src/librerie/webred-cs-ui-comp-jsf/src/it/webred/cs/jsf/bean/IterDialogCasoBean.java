package it.webred.cs.jsf.bean;

import it.webred.amprofiler.ejb.anagrafica.AnagraficaService;
import it.webred.amprofiler.model.AmAnagrafica;
import it.webred.cs.csa.ejb.client.AccessTableCasoSessionBeanRemote;
import it.webred.cs.csa.ejb.client.AccessTableOperatoreSessionBeanRemote;
import it.webred.cs.csa.ejb.dto.BaseDTO;
import it.webred.cs.csa.ejb.dto.IterDTO;
import it.webred.cs.csa.ejb.dto.OperatoreDTO;
import it.webred.cs.data.model.CsACaso;
import it.webred.cs.data.model.CsACasoOpeTipoOpe;
import it.webred.cs.data.model.CsOOperatore;
import it.webred.cs.jsf.manbean.superc.CsUiCompBaseBean;
import it.webred.ejb.utility.ClientUtility;
import it.webred.utilities.DateTimeUtils;

import java.io.Serializable;

public class IterDialogCasoBean extends IterBaseBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	protected long idCaso;
	
	public String nomeCaso;
	public String dataInserimento;
	public String utenteInserimento;
	public String dataModifica;
	public String utenteModifica; 
	public String responsabile;
	
	public void initialize(long idCaso ){
		try {
			
			this.idCaso = idCaso;
			
			AccessTableCasoSessionBeanRemote casoSessionBean = getCasoSessioBean();
			AccessTableOperatoreSessionBeanRemote operatoreSessionBean = getOperatoreSessioBean();
			AnagraficaService anagraficaService = (AnagraficaService) ClientUtility.getEjbInterface("AmProfiler", "AmProfilerEjb", "AnagraficaServiceBean");
			
			IterDTO itDto = new IterDTO();
			fillEnte(itDto);
			itDto.setIdCaso(idCaso);
			CsACaso caso = casoSessionBean.findCasoById(itDto);
			
			String soggetto_Cf = caso.getCsASoggetto().getCsAAnagrafica().getCf();
			String soggetto_Nome = caso.getCsASoggetto().getCsAAnagrafica().getNome();
			String soggetto_Cognome = caso.getCsASoggetto().getCsAAnagrafica().getCognome();
			
			OperatoreDTO opDto = new OperatoreDTO();
			fillEnte(opDto);
			opDto.setUsername(caso.getUserIns());
			CsOOperatore operatoreInserimento = operatoreSessionBean.findOperatoreByUsername(opDto);
			
			opDto.setUsername(caso.getUsrMod());
			CsOOperatore operatoreModifica = operatoreSessionBean.findOperatoreByUsername(opDto);
			
			BaseDTO bDto = new BaseDTO();
			CsUiCompBaseBean.fillEnte(bDto);
			bDto.setObj(caso.getId());
			CsACasoOpeTipoOpe casoOpTipoOp = casoSessionBean.findResponsabile(bDto);
			if( casoOpTipoOp != null ) {
				CsOOperatore operatore = casoOpTipoOp.getCsOOperatoreTipoOperatore().getCsOOperatoreSettore().getCsOOperatore();
				AmAnagrafica amAna = anagraficaService.findAnagraficaByUserName(operatore.getUsername());
				this.responsabile = amAna.getCognome() + " " + amAna.getNome();
			}
			
			this.nomeCaso = soggetto_Nome + "  " + soggetto_Cognome + "  (" + soggetto_Cf +")";
			
			this.dataInserimento = DateTimeUtils.dateToString(caso.getDtIns(), "dd/MM/yy HH:mm:ss");
			AmAnagrafica amAna = anagraficaService.findAnagraficaByUserName(operatoreInserimento.getUsername());
			this.utenteInserimento = amAna.getCognome() + " " + amAna.getNome();
			
			if(caso.getDtMod() != null)
			this.dataModifica = DateTimeUtils.dateToString(caso.getDtMod(), "dd/MM/yy HH:mm:ss");
			
			if(operatoreModifica != null) {
				amAna = anagraficaService.findAnagraficaByUserName(operatoreModifica.getUsername());
				this.utenteModifica = amAna.getCognome() + " " + amAna.getNome();
			}
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
			addError("Errore nell'inizializzazione del caso!", "Inizializzazione caso non riuscita!");
		}
	}	
	
	public String getNomeCaso() {
		return nomeCaso;
	}

	public String getDataInserimento() {
		return dataInserimento;
	}

	public String getUtenteInserimento() {
		return utenteInserimento;
	}

	public String getDataModifica() {
		return dataModifica;
	}

	public String getUtenteModifica() {
		return utenteModifica;
	}

	public String getResponsabile() {
		return responsabile;
	}

	public boolean isDataInserimentoRendered() {
		return dataInserimento != null;
	}

	public boolean isUtenteInserimentoRendered() {
		return utenteInserimento != null;
	}

	public boolean isDataModificaRendered() {
		return dataModifica != null;
	}

	public boolean isUtenteModificaRendered() {
		return utenteModifica != null;
	}

	public boolean isResponsabileRendered() {
		return responsabile != null;
	}

	public long getIdCaso() {
		return idCaso;
	}
	
}
