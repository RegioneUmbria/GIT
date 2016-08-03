<%@ page language="java" import="it.escsolution.escwebgis.successioni.bean.*" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<%   HttpSession sessione = request.getSession(true);  %> 
<%  
	
	java.util.Vector vlista=(java.util.Vector)sessione.getAttribute("LISTA_OGGETTI_EREDITA"); 
	Oggetto det = (Oggetto)sessione.getAttribute("OGGETTO");
	
	OggettoFinder finder = null;
	if (sessione.getAttribute("FINDER19")!= null){
		finder = (OggettoFinder)sessione.getAttribute("FINDER19"); 
	}else 
		finder = new OggettoFinder();
	java.lang.String ST = (java.lang.String)sessione.getAttribute("ST");
%>
<%   it.escsolution.escwebgis.common.PulsantiNavigazione pulsanti = (it.escsolution.escwebgis.common.PulsantiNavigazione)sessione.getAttribute("PULSANTI");%>

<%int js_back = 1;
	if (sessione.getAttribute("BACK_JS_COUNT")!= null)
		js_back = ((Integer)sessione.getAttribute("BACK_JS_COUNT")).intValue();%>

<html>
<head>
<title>Successioni Oggetti - Particolare Dettaglio</title>
<LINK rel="stylesheet" href="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/styles/style.css" type="text/css">
<script src="../ewg/Scripts/dynamic.js" language="JavaScript"></script>
</head>

<script>

function chgtr(row,flg)
		{
		if (flg==1)
			{
			document.all("r"+row).style.backgroundColor = "#d7d7d7";
			}
		else
			{
			document.all("r"+row).style.backgroundColor = "";
			}
		}

function vaiDefunto(indice, record_cliccato){
	document.mainform.action="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/SuccessioniDefunti";
	
	ufficio = document.all("UFFICIO_"+indice).value;
	anno = document.all("ANNO_"+indice).value;
	volume = document.all("VOLUME_"+indice).value;
	numero = document.all("NUMERO_"+indice).value;
	sottonumero = document.all("SOTTONUMERO_"+indice).value;
	comune = document.all("COMUNE_"+indice).value;
	progressivo = document.all("DEF_"+indice).value;
	
	document.mainform.OGGETTO_SEL.value=""+ufficio+"|"+anno+"|"+volume+"|"+numero+"|"+sottonumero+"|"+comune+"|"+progressivo;
	document.mainform.RECORD_SEL.value=record_cliccato;
	document.mainform.ST.value = 3;
	document.mainform.UC.value = 15;
	document.mainform.EXT.value = 1;
	document.mainform.submit();
	wait();
}

function vaiErede(indice, record_cliccato) {
	document.mainform.action="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/SuccessioniEredi";
	
	ufficio = document.all("UFFICIO_"+indice).value;
	anno = document.all("ANNO_"+indice).value;
	volume = document.all("VOLUME_"+indice).value;
	numero = document.all("NUMERO_"+indice).value;
	sottonumero = document.all("SOTTONUMERO_"+indice).value;
	comune = document.all("COMUNE_"+indice).value;
	progressivo = document.all("PROGRESSIVO_"+indice).value;
	progressivoErede = document.all("EREDE_"+indice).value;
	
	document.mainform.OGGETTO_SEL.value=""+ufficio+"|"+anno+"|"+volume+"|"+numero+"|"+sottonumero+"|"+comune+"|"+progressivo+"|"+progressivoErede;
	document.mainform.RECORD_SEL.value=record_cliccato;
	document.mainform.ST.value = 3;
	document.mainform.UC.value = 18;
	document.mainform.EXT.value = 1;
	document.mainform.submit();
	wait();
}

function mettiST(){
	document.mainform.ST.value = 2;
}
</script>
<body onload="mettiST()">

<form name="mainform" target="_parent" action="">

<div align="center" class="extWinTDTitle"><span class="extWinTXTTitle">
	FOGLIO:<%=det.getFoglio()%> PARTICELLA:<%=det.getParticella()%> SUBALTERNO:<%=det.getSubalterno()%></span>
</div>

&nbsp;
<input type="Image" ID="UserCommand8"  align="MIDDLE" src="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/images/print.gif"  border="0" vspace="0" hspace="0"  alt = "Stampa"  
						onMouseOver="setbutton('UserCommand8','<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/images/print_Over.gif')" 
						onMouseOut="setbutton('UserCommand8','<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/images/print.gif')" 
						onMouseDown="setbutton('UserCommand8','<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/images/print_Down.gif')" 
						onMouseUp="setbutton('UserCommand8','<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/images/print.gif')" onClick="Stampa()">
	<br/>
<table width="100%">
<tr>
	<td valign="top" style="background-color: #FFFFFF;">
	<table width="100%" class="extWinTable" cellpadding="0" cellspacing="0">
	<tr> 
		<td colspan=6 class="extWinTDTitle"><span class="extWinTXTTitle">Eredita'</span></td> 
	</tr>
	<tr> 
		<td colspan=3 class="extWinTDTitle"><span class="extWinTXTTitle">Dati Defunto</span></td>
		<td colspan=3 class="extWinTDTitle"><span class="extWinTXTTitle">Dati Erede</span></td> 
	</tr>
	<tr>
		<td class="extWinTDTitle"><span class="extWinTXTTitle">CF Defunto</span></td>
		<td class="extWinTDTitle"><span class="extWinTXTTitle">Nominativo</span></td>
		<td class="extWinTDTitle"><span class="extWinTXTTitle">Quota Possesso</span></td>		
		<td class="extWinTDTitle"><span class="extWinTXTTitle">CF Erede</span></td>
		<td class="extWinTDTitle"><span class="extWinTXTTitle">Denominazione</span></td>
		<td class="extWinTDTitle"><span class="extWinTXTTitle">Quota Erede</span></td>
	</tr>
	
	<% if (vlista.size() == 0){%>
 	 <tr>
	 	<td colspan='6' class="extWinTDData">
		<span class="extWinTXTData">Non � presente alcun record associato</span>
		</td>
	</tr>
	<%}%>
		
	<%Eredita ere = new Eredita(); %>
  	<%java.util.Enumeration en = vlista.elements(); int contatore = 1; %>
  	<% long progressivoRecord = 1; %>
  	<%while (en.hasMoreElements()) {
    	ere = (Eredita)en.nextElement();
    	%>
    	<tr id="r<%=contatore%>" >
		<td class="extWinTDData" onclick="vaiDefunto('<%=contatore%>','<%=progressivoRecord%>')" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)'  style='cursor: pointer;'>
		<span class="extWinTXTData"><%=ere.getCfDefunto()%></span></td>
		<td class="extWinTDData" onclick="vaiDefunto('<%=contatore%>','<%=progressivoRecord%>')" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)'  style='cursor: pointer;'>
		<span class="extWinTXTData"><%=ere.getCognome()%> <%=ere.getNome()%></span></td>		
		<td class="extWinTDData" onclick="vaiDefunto('<%=contatore%>','<%=progressivoRecord%>')" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)'  style='cursor: pointer;border-right:1Px Solid #000000;'>
		<span class="extWinTXTData"  ><%=ere.getNumeratoreQuotaDef()%>/<%=ere.getDenominatoreQuotaDef()%> </span></td>
		
		<td class="extWinTDData" onclick="vaiErede('<%=contatore%>','<%=progressivoRecord%>')" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)'  style='cursor: pointer;'>
		<span class="extWinTXTData"><%=ere.getCfErede()%></span></td>
		<td class="extWinTDData" onclick="vaiErede('<%=contatore%>','<%=progressivoRecord%>')" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)'  style='cursor: pointer;'>
		<span class="extWinTXTData"><%=ere.getDenominazione()%></span></td>				
		<td class="extWinTDData" onclick="vaiErede('<%=contatore%>','<%=progressivoRecord%>')" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)'  style='cursor: pointer;'>
		<span class="extWinTXTData"><%=ere.getNumeratoreQuotaEre()%>/<%=ere.getDenominatoreQuotaEre()%> </span></td>
		
		<input type='hidden' name='UFFICIO_<%=contatore%>' value='<%=ere.getUfficio()%>'>
		<input type='hidden' name='ANNO_<%=contatore%>' value='<%=ere.getAnno()%>'>
		<input type='hidden' name='VOLUME_<%=contatore%>' value='<%=ere.getVolume()%>'>
		<input type='hidden' name='NUMERO_<%=contatore%>' value='<%=ere.getNumero()%>'>
		<input type='hidden' name='SOTTONUMERO_<%=contatore%>' value='<%=ere.getSottonumero()%>'>
		<input type='hidden' name='COMUNE_<%=contatore%>' value='<%=ere.getComune()%>'>
		<input type='hidden' name='PROGRESSIVO_<%=contatore%>' value='<%=ere.getProgressivo()%>'>
		<input type='hidden' name='IMMOBILE_<%=contatore%>' value='<%=ere.getProgressivoImmobile()%>'>
		<input type='hidden' name='EREDE_<%=contatore%>' value='<%=ere.getProgressivoErede()%>'>
		<input type='hidden' name='DEF_<%=contatore%>' value='<%=ere.getProgressivoDef()%>'>
		</tr>
		<% contatore++;progressivoRecord ++;
	 }%>
	</table>
	</td>
</tr>
	
<input type='hidden' name="ST" value="">
<input type='hidden' name="OGGETTO_SEL" value="">
<input type='hidden' name="RECORD_SEL" value="">
<input type='hidden' name="AZIONE" value="">
<input type='hidden' name="UC" value="19">
<input type='hidden' name="EXT" value="">
<input type='hidden' name="BACK" value="">
<input type="hidden" name="BACK_JS_COUNT" value="<%=js_back%>">
</table>
</form>
<div id="wait" class="cursorWait" />
</body>
</html>