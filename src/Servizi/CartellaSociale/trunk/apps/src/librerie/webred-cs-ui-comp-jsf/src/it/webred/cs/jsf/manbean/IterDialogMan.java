package it.webred.cs.jsf.manbean;

import it.webred.cs.data.DataModelCostanti.PermessiIterDialog;
import it.webred.cs.data.model.CsOOperatoreSettore;
import it.webred.cs.jsf.bean.IterBaseBean;
import it.webred.cs.jsf.bean.IterDialogCambioStatoBean;
import it.webred.cs.jsf.bean.IterDialogCasoBean;
import it.webred.cs.jsf.bean.IterDialogHistoryBean;
import it.webred.cs.jsf.interfaces.IIterDialog;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AbortProcessingException;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.naming.NamingException;

@ManagedBean
@ViewScoped
public class IterDialogMan extends IterBaseBean implements IIterDialog {
	
	private static final long serialVersionUID = 1L;
	
	private IterDialogCasoBean caso = new IterDialogCasoBean();
	private IterDialogHistoryBean history = new IterDialogHistoryBean();
	private IterDialogCambioStatoBean cambioStato = new IterDialogCambioStatoBean();
	
	private long idCaso;
	private String opUsername;
	private String opRuolo;
	private long idSettore;
	private String alertUrl;
	private boolean notificaSettoreSegnalante;
	private boolean visibile = false;
	private Long idStatoSuccessivo = 0L;
	
	public void initialize(long idCaso) throws NamingException {
    	this.idCaso = idCaso;
   	
        alertUrl = getRequest().getRequestURL().toString() + "?IDCASO=" + idCaso;

        opUsername = getUser().getUsername();
        CsOOperatoreSettore opSettore = (CsOOperatoreSettore) getSession().getAttribute("operatoresettore");
    	idSettore = opSettore.getCsOSettore().getId();
    	opRuolo = "OPERATORE"; 
        notificaSettoreSegnalante = true;
        
        if( getSession().getAttribute("ITER_DIALOG_USERNAME") != null )
        	opUsername = (String)getSession().getAttribute("ITER_DIALOG_USERNAME"); 
        
        if( getSession().getAttribute("ITER_DIALOG_RUOLO") != null )
        	opRuolo = (String)getSession().getAttribute("ITER_DIALOG_RUOLO"); 
        
        if( getSession().getAttribute(PermessiIterDialog.ITER_DIALOG_PERMESSO_NOTIFICA_SETTORE_SEGNALANTE) != null )
        	notificaSettoreSegnalante = (Boolean)getSession().getAttribute(PermessiIterDialog.ITER_DIALOG_PERMESSO_NOTIFICA_SETTORE_SEGNALANTE); 

        this.caso.initialize(idCaso);
		this.history.initialize(idCaso, opUsername, opRuolo);
		this.cambioStato.initialize(idCaso, opUsername, idSettore, opRuolo, alertUrl, notificaSettoreSegnalante );
	}

	protected void refreshDialog() throws NamingException {
		this.caso.initialize(idCaso);
		this.history.initialize(idCaso, opUsername, opRuolo);
		this.cambioStato.initialize(idCaso, opUsername,idSettore, opRuolo, alertUrl, notificaSettoreSegnalante);
	}
	
	@Override
	public void openDialog(Long idCaso) throws NamingException {
		initialize(idCaso);
		visibile = true;
    }
	
	@Override
	public ActionListener getCloseDialog() {
	    return new ActionListener() {
	        @Override
	        public void processAction(ActionEvent event) throws AbortProcessingException {
	        	visibile = false;
	        }
	    };
	}
	
	@Override
	public void saveDialog(Long idStatoSuccessivo) throws NamingException {
		
		this.idStatoSuccessivo = idStatoSuccessivo; 
		boolean hasAttr = false;
		
		//Open dati panel and attribute panel or open dati panel
		if(this.cambioStato.hasAttributi(idStatoSuccessivo))
			hasAttr = true;			
				
		if (this.cambioStato.checkRenderOperatore(idStatoSuccessivo))
			hasAttr = true;
		
		if(hasAttr)
			return;
		
		if( !this.cambioStato.salvaStato(idStatoSuccessivo) )
			return;
					
		refreshDialog();

		addInfo( "Info",  "Operazione avvenuta con successo." );
	}
 
	@Override
	public void saveDialogWithAttributes() throws NamingException {
		
		if( !validaForm( ) )
			return;
		
		if( !this.cambioStato.salvaStato(idStatoSuccessivo) )
			return;
		
		refreshDialog();

		addInfo( "Info",  "Operazione avvenuta con successo." );
	}

	protected boolean validaForm() throws NamingException {
		
		boolean isValid = true;
		
		isValid &= this.cambioStato.validaTransizione( idStatoSuccessivo );
		
		isValid &= this.cambioStato.validaAttributi( idStatoSuccessivo );
		
		return isValid;
	}
	
	@Override
	public IterDialogCasoBean getCaso() {
		return caso;
	}

	@Override
	public IterDialogHistoryBean getHistory() {
		return history;
	}

	@Override
	public IterDialogCambioStatoBean getCambioStato() {
		return cambioStato;
	}

	@Override
	public boolean isVisibile() {
		return visibile;
	}
}
