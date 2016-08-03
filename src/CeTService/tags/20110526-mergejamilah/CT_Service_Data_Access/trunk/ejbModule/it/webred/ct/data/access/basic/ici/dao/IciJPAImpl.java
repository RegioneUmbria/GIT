package it.webred.ct.data.access.basic.ici.dao;

import it.webred.ct.data.access.basic.anagrafe.AnagGenQueryBuilder;
import it.webred.ct.data.access.basic.anagrafe.dto.SoggettoAnagrafeDTO;
import it.webred.ct.data.access.basic.catasto.CatastoServiceException;
import it.webred.ct.data.access.basic.common.dto.RicercaOggettoDTO;
import it.webred.ct.data.access.basic.ici.IciQueryBuilder;
import it.webred.ct.data.access.basic.ici.IciServiceException;
import it.webred.ct.data.access.basic.ici.dto.OggettoIciDTO;
import it.webred.ct.data.access.basic.ici.dto.RicercaOggettoIciDTO;
import it.webred.ct.data.access.basic.ici.dto.RicercaSoggettoIciDTO;
import it.webred.ct.data.access.basic.ici.dto.RicercaViaIciDTO;
import it.webred.ct.data.access.basic.ici.dto.VersamentoIciAnnoDTO;
import it.webred.ct.data.access.basic.tarsu.TarsuOggQueryBuilder;
import it.webred.ct.data.access.basic.tarsu.TarsuServiceException;
import it.webred.ct.data.model.ici.SitTIciOggetto;
import it.webred.ct.data.model.ici.SitTIciSogg;
import it.webred.ct.data.model.ici.SitTIciVia;
import it.webred.ct.data.model.ici.VTIciSoggAll;
import it.webred.ct.data.model.tarsu.SitTTarOggetto;
import it.webred.ct.data.model.tarsu.SitTTarVia;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

public class IciJPAImpl extends IciBaseDAO implements IciDAO{
 
	@Override
	public List<OggettoIciDTO> getListaOggettiByIdSogg(RicercaSoggettoIciDTO rs) throws IciServiceException {
		String idSogg = rs.getIdSoggIci();
		List<OggettoIciDTO> oggettiIci = new ArrayList<OggettoIciDTO>();
		OggettoIciDTO	ogg;  
		logger.debug("LISTA OGGETTI ICI - ID SOGGETTO["+idSogg+"]");
			
		try{
			Query q = manager_diogene.createNamedQuery("SitTIciOggetto.getOggettiByIdSogg");
			q.setParameter("idSogg", idSogg);
			List<Object[]> res = q.getResultList();
			logger.debug("Result size ["+res.size()+"]");
			
			for(Object[] eleRes: res){
				ogg = new OggettoIciDTO(eleRes[1].toString(), (SitTIciOggetto)eleRes[0]);
				String str = ogg.getOggettoIci().getSez();
				if (str==null )
					ogg.getOggettoIci().setSez("");
				else
					ogg.getOggettoIci().setSez(str.trim());
				str = ogg.getOggettoIci().getFoglio();
				if (str==null || str.equals("") || Integer.parseInt(str) == 0 )
					ogg.getOggettoIci().setFoglio("");
				else
					ogg.getOggettoIci().setFoglio(str.trim());
				str = ogg.getOggettoIci().getNumero();
				if (str==null || str.equals("") || Integer.parseInt(str) == 0 )
					ogg.getOggettoIci().setNumero("");
				else
					ogg.getOggettoIci().setNumero(str.trim());
				str = ogg.getOggettoIci().getSub();
				if (str==null || str.equals("") || Integer.parseInt(str) == 0 )
					ogg.getOggettoIci().setSub("");
				else
					ogg.getOggettoIci().setSub(str.trim());
				str = ogg.getOggettoIci().getYeaDen();
				if (str==null || str.equals("") || Integer.parseInt(str) == 0 )
					ogg.getOggettoIci().setYeaDen("");
				else
					ogg.getOggettoIci().setYeaDen(str.trim());
				str = ogg.getOggettoIci().getYeaPro();
				if (str==null || str.equals("") || Integer.parseInt(str) == 0 )
					ogg.getOggettoIci().setYeaPro("");
				else
					ogg.getOggettoIci().setYeaPro(str.trim());
				str = ogg.getOggettoIci().getYeaRif();
				if (str==null || str.equals("") || Integer.parseInt(str) == 0 )
					ogg.getOggettoIci().setYeaRif("");
				else
					ogg.getOggettoIci().setYeaRif(str.trim());
				oggettiIci.add(ogg);
			}
				
		}catch (NoResultException nre) {
			logger.warn("getListaOggettiByIdSogg - No Result " + nre.getMessage());
		}catch(Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return oggettiIci;
	}

	@Override
	public List<SitTIciSogg> getListaSoggByCF(RicercaSoggettoIciDTO rs) throws IciServiceException  {
		String codFis = rs.getCodFis();
		List<SitTIciSogg> result = new ArrayList<SitTIciSogg>();
		codFis = codFis.trim().toUpperCase();
		
		logger.debug("getListaSoggByCF ->LISTA SOGGETTI ICI - CF["+codFis+"]");
			
		try {
			Query q = manager_diogene.createNamedQuery("SitTIciSogg.getListaSoggIciByCF");
			q.setParameter("codFisc", codFis);
			result = q.getResultList();
			logger.debug("Result size ["+result.size()+"]");
			
		}catch (NoResultException nre) {
			logger.warn("getListaSoggByCF - No Result " + nre.getMessage());
		} catch (Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return result;
	}

	@Override
	public List<VTIciSoggAll> getListaSoggettiByOgg(RicercaOggettoIciDTO ro) throws IciServiceException {
		String idExt = ro.getIdExt();
		List<VTIciSoggAll> listaSogg= new ArrayList<VTIciSoggAll>();
		logger.debug("LISTA SOGGETTI ICI PER OGGETTO- ID_EXT_OGG["+idExt+"]");
		try{
			Query q = manager_diogene.createNamedQuery("VTIciSoggAll.getSoggettiByOgg");
			q.setParameter("idOgg", idExt);
			listaSogg =(List<VTIciSoggAll>)q.getResultList();
			logger.debug("Result size ["+listaSogg.size()+"]");
		}catch (NoResultException nre) {
			logger.warn("getListaSoggettiByOgg - No Result " + nre.getMessage());
		}catch(Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return listaSogg;
	}

	@Override
	public List<SitTIciSogg> searchSoggetto(RicercaSoggettoIciDTO rs) throws IciServiceException  {
		List<SitTIciSogg> lista=null;
		try{
			String sql = (new IciQueryBuilder(rs)).createQuery(false);
			logger.debug("searchSoggettoIci. SQL: " + sql);
			Query q = manager_diogene.createQuery(sql);
			if (rs.getTipoRicerca() != null && rs.getTipoRicerca().equals("all")) {
				lista = (List<SitTIciSogg> )q.getResultList();
				logger.debug("Result size ["+lista.size()+"]");
			}
			else {
				List<Object[]> res = q.getResultList();
				logger.debug("Result size ["+res.size()+"]");
				lista = new ArrayList<SitTIciSogg>();
				for (Object[] ele : res) {
					SitTIciSogg sogg = new SitTIciSogg();
					sogg.setTipSogg(rs.getTipoSogg());
					if (rs.getTipoSogg().equals("F"))  {
						if (ele[0] != null)
							sogg.setCogDenom(ele[0].toString().trim());
						if (ele[1] != null)
							sogg.setNome(ele[1].toString().trim());
						if (ele[2] != null)
							sogg.setDtNsc((Date)ele[2]);
						if (ele[3] != null)
							sogg.setCodFisc(ele[3].toString().trim());
						if (ele[4] != null)
							sogg.setCodCmnNsc(ele[4].toString().trim());
						if (ele[5] != null)
							sogg.setDesComNsc(ele[5].toString().trim());
					}else {
						if (ele[0] != null) 	
							sogg.setCogDenom(ele[0].toString().trim());
						if (ele[1] != null)
							sogg.setPartIva(ele[1].toString().trim());
					}
					lista.add(sogg);
				}
			}
		}catch (NoResultException nre) {
			logger.warn("getListaSoggettiByOgg - No Result " + nre.getMessage());
		}catch(Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return lista;
	}

	public List<VersamentoIciAnnoDTO> getSommaVersamenti(RicercaSoggettoIciDTO rs) throws IciServiceException  {
		List<VersamentoIciAnnoDTO> lista=null;
		logger.debug("IciJPAImpl.getSommaVersamenti(). Id sogg: " + rs.getIdSoggIci());
		try{
			Query q = manager_diogene.createNamedQuery("SitTIciVersamenti.getSommaVersamenti");
			q.setParameter("id", rs.getIdSoggIci());
			List<Object[]> res = q.getResultList();
			logger.debug("Result size ["+res.size()+"]");
			lista = new ArrayList<VersamentoIciAnnoDTO>();
			VersamentoIciAnnoDTO vers=null;
			for (Object[] ele : res) {
				vers=new VersamentoIciAnnoDTO();
				if (ele[0] != null)
					vers.setYeaRif(ele[0].toString());
				if (ele[1] != null)
					vers.setImpPagEu((BigDecimal)ele[1]);
				lista.add(vers);
				
			}
		}catch (NoResultException nre) {
			logger.warn("getSommaVersamenti - No Result " + nre.getMessage());
		}catch(Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return lista;
	}

	@Override
	public SitTIciSogg getSoggettoById(RicercaSoggettoIciDTO rs) throws IciServiceException {
		SitTIciSogg sogg= null;
		logger.debug("IciJPAImpl.getSoggettoById. Id sogg: " + rs.getIdSoggIci());
		try{
			Query q = manager_diogene.createNamedQuery("SitTIciSogg.getSoggettoById");
			q.setParameter("id", rs.getIdSoggIci());
			sogg = (SitTIciSogg)q.getSingleResult();
		}catch (NoResultException nre) {
			logger.warn("IciJPAImpl.getSoggettoById - No Result " + nre.getMessage());
		}catch(Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return sogg;
	}

	@Override
	public SitTIciVia getViaByIdExt(RicercaViaIciDTO rv) throws IciServiceException  {
		SitTIciVia via =null;
		try {
			System.out.println("IciJPAImpl.getViaByIdExt - IdExt:  ["+rv.getDatiVia().getIdExt()+"]");
			Query q = manager_diogene.createNamedQuery("SitTIciVia.getViaByIdExt");
			q.setParameter("idExt", rv.getDatiVia().getIdExt());	
			via = (SitTIciVia) q.getSingleResult();
		}catch (NoResultException nre) {
			logger.warn("IciJPAImpl.getViaByIdExt - No Result " + nre.getMessage());
		}catch(Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return via;
	}

	@Override
	public List<SitTIciOggetto> getOggettiByFabbricato(RicercaOggettoDTO ro)			throws IciServiceException {
		List<SitTIciOggetto> lista= new ArrayList<SitTIciOggetto>();
		logger.debug("LISTA OGGETTI ICI PER FABBRICATO - SEZ["+ro.getSezione()+"];FOGLIO[" + ro.getFoglio()+ "];PARTICELLA["+ ro.getParticella()+"]");
		String sez = ro.getSezione();
		Query q =null;
		try{
			if (sez!=null && !sez.equals("")) {
				q = manager_diogene.createNamedQuery("SitTIciOggetto.getOggettiBySezFabbricato");
				q.setParameter("sezione", sez);
			}
			else
				q = manager_diogene.createNamedQuery("SitTIciOggetto.getOggettiByFabbricato");
			q.setParameter("provenienza", ro.getProvenienza().trim());
			q.setParameter("foglio", ro.getFoglio().trim());
			q.setParameter("particella", ro.getParticella().trim());
			lista =(List<SitTIciOggetto>)q.getResultList();
			logger.debug("Result size ["+lista.size()+"]");
		}catch (NoResultException nre) {
			logger.warn("getListaSoggettiByOgg - No Result " + nre.getMessage());
		}catch(Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return lista;
	}
	
	@Override
	public List<SitTIciOggetto> getOggettiByUI(RicercaOggettoDTO ro)	throws IciServiceException {
		List<SitTIciOggetto> lista= new ArrayList<SitTIciOggetto>();
		logger.debug("LISTA OGGETTI ICI PER UI - SEZ["+ro.getSezione()+"];FOGLIO[" + ro.getFoglio()+ "];PARTICELLA["+ ro.getParticella()+"];SUB["+ ro.getSub()+"]");
		String sez = ro.getSezione();
		Query q =null;
		try{
			if (sez!=null && !sez.equals("")) {
				q = manager_diogene.createNamedQuery("SitTIciOggetto.getOggettiBySezFPS");
				q.setParameter("sezione", sez);
			}
			else
				q = manager_diogene.createNamedQuery("SitTIciOggetto.getOggettiByFPS");
			q.setParameter("provenienza", ro.getProvenienza().trim());
			q.setParameter("foglio", ro.getFoglio().trim());
			q.setParameter("particella", ro.getParticella().trim());
			q.setParameter("sub", ro.getSub().trim());
			lista =(List<SitTIciOggetto>)q.getResultList();
			logger.debug("Result size ["+lista.size()+"]");
		}catch (NoResultException nre) {
			logger.warn("getListaSoggettiByOgg - No Result " + nre.getMessage());
		}catch(Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return lista;
	}

	@Override
	public List<SitTIciOggetto> getListaOggettiAiCiviciIci(RicercaOggettoIciDTO ro) 	throws IciServiceException {
		List<SitTIciOggetto> lista = new ArrayList<SitTIciOggetto>();
		logger.debug("getListaOggettiAiCiviciIci -  LISTA OGGETTI ICI PER CIVICI ICI");
		Query q =null;
		try{
			if (ro==null)
				System.out.println("getListaOggettiAiCiviciIci ro NULLO");
			else
				System.out.println("getListaOggettiAiCiviciIci ro NOT NULLO");
			
			String sql = (new IciQueryBuilder(ro)).createQueryOggettoVia();
			logger.debug("getListaOggettiAiCiviciIci - SQL: " + sql);
			q = manager_diogene.createQuery(sql);
			lista =(List<SitTIciOggetto>)q.getResultList();
			logger.debug("Result size ["+lista.size()+"]");
		}catch (NoResultException nre) {
			logger.warn("getListaOggettiAiCiviciIci - No Result " + nre.getMessage());
		}catch(Throwable t) {
			logger.error("", t);
			throw new IciServiceException(t);
		}
		return lista;
	}

}
