package it.webred.ct.data.access.basic.indice.via;

import it.webred.ct.data.access.basic.indice.IndiceDataIn;
import it.webred.ct.data.access.basic.indice.IndiceService;
import it.webred.ct.data.access.basic.indice.civico.dto.SitCivicoDTO;
import it.webred.ct.data.access.basic.indice.dto.SitNuovoDTO;
import it.webred.ct.data.model.indice.SitViaUnico;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ViaService extends IndiceService{
	
	//public void creaNuovaVia(SitViaUnico nuovo);
	public void creaNuovaVia(IndiceDataIn indDataIn);
}
