<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<%   HttpSession sessione = request.getSession(true);  %> 
<% java.util.Vector vlistaCond=(java.util.Vector)sessione.getAttribute("LISTA_CONDOMINI"); %>
<% it.escsolution.escwebgis.condomini.bean.CondominiFinder finder = (it.escsolution.escwebgis.condomini.bean.CondominiFinder)sessione.getAttribute("FINDER17"); %>
<%int js_back = 1;
	if (sessione.getAttribute("BACK_JS_COUNT")!= null)
		js_back = ((Integer)sessione.getAttribute("BACK_JS_COUNT")).intValue();%>  
<% java.lang.String funzionalita=(java.lang.String)sessione.getAttribute("FUNZIONALITA"); %>
<html>
<head>
<title>Condomini Condomini - Lista</title>
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


function vai(codice, record_cliccato){
	wait();
	document.mainform.OGGETTO_SEL.value=codice;
	document.mainform.RECORD_SEL.value=record_cliccato;
	document.mainform.ST.value = 3;
	document.mainform.submit();
	}

function mettiST(){
	document.mainform.ST.value = 2;
}

function vai(codice, record_cliccato, isPopUp)
{
	try
	{
		document.mainform.OGGETTO_SEL.value = codice;
		document.mainform.RECORD_SEL.value = record_cliccato;
		if (isPopUp)
		{
			targ = apriPopUp(record_cliccato);
			
			if (targ)
			{
				document.mainform.ST.value = 33;
				document.mainform.target = targ;
				document.mainform.submit();
				document.mainform.ST.value = 2;
				document.mainform.target = "_parent";
			}
		}
		else
		{
			wait();
			document.mainform.ST.value = 3;
			document.mainform.target = "_parent";
			document.mainform.submit();
		}
	}
	catch (e)
	{
		//alert(e);
	}
}

var popUpAperte = new Array();
function apriPopUp(index)
{
	if (popUpAperte[index])
	{
		if (popUpAperte[index].closed)
		{
			popUpAperte[index] = window.open("", "PopUpCondDetail" + index, "width=640,height=480,status=yes,resizable=yes");
			popUpAperte[index].focus();
			return popUpAperte[index].name;
		}
		else
		{
			popUpAperte[index].focus();
			return false;
		}
	}
	else
	{
		popUpAperte[index] = window.open("", "PopUpCondDetail" + index, "width=640,height=480,status=yes,resizable=yes");
		return popUpAperte[index].name;
	}
}


<% if (vlistaCond.size() > 0){
it.escsolution.escwebgis.condomini.bean.Condomini pCond=(it.escsolution.escwebgis.condomini.bean.Condomini)vlistaCond.get(0);%>
function vaiPrimo(){
 	document.mainform.OGGETTO_SEL.value='<%=pCond.getCodctb()%>@<%=pCond.getDenominazione()%>@<%=pCond.getCodvia()%>@<%=pCond.getIndirizzo()%>@<%=pCond.getCivico()%>';
	document.mainform.RECORD_SEL.value=1;
	document.mainform.ST.value = 3;
	document.mainform.submit();
	}
<%}%>

</script>
<body onload="mettiST()">

<form name="mainform" action="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/CondominiCondomini" target="_parent" >
 
<div align="center" class="extWinTDTitle"><span class="extWinTXTTitle">
	&nbsp;<%=funzionalita%>:&nbsp;Lista Condomini</span>
</div>
		
&nbsp;
               
   <table width="100%" class="extWinTable" cellpadding="0" cellspacing="0">
	
	<tr>
		<td class="extWinTDTitle"><span class="extWinTXTTitle">Denominazione</span></td>
		<td class="extWinTDTitle"><span class="extWinTXTTitle">Codice Via</span></td>
		<td class="extWinTDTitle"><span class="extWinTXTTitle">Indirizzo</span></td>
		<td class="extWinTDTitle"><span class="extWinTXTTitle">Civico</span></td>

	</tr>
	
	<% it.escsolution.escwebgis.condomini.bean.Condomini cond = new it.escsolution.escwebgis.condomini.bean.Condomini(); %>
  <% java.util.Enumeration en = vlistaCond.elements(); int contatore = 1; %>
  <% long progressivoRecord = (finder.getPaginaAttuale()-1)*finder.getRighePerPagina()+1; %>
  <% while (en.hasMoreElements()) {
        cond = (it.escsolution.escwebgis.condomini.bean.Condomini)en.nextElement();%>



    <tr id="r<%=contatore%>" onclick="vai('<%=cond.getCodctb()%>@<%=cond.getDenominazione()%>@<%=cond.getCodvia()%>@<%=cond.getIndirizzo()%>@<%=cond.getCivico()%>', '<%=progressivoRecord%>', true)">
		
		<td class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
		<span class="extWinTXTData"><%=cond.getDenominazione()%></span></td>
		<td class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
		<span class="extWinTXTData"><%=cond.getCodvia()%></span></td>
		<td class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
		<span class="extWinTXTData"><%=cond.getIndirizzo()%></span></td>
		<td class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
		<span class="extWinTXTData"><%=cond.getCivico()%></span></td>	
	</tr>
	
<% contatore++;progressivoRecord ++;} %>

<input type='hidden' name="ST" value="">
<input type='hidden' name="OGGETTO_SEL" value="">
<input type='hidden' name="RECORD_SEL" value="">
<input type='hidden' name="ACT_PAGE" value="<%=finder.getPaginaAttuale()%>">
<input type='hidden' name="AZIONE" value="">
<input type='hidden' name="UC" value="17">
<input type='hidden' name="BACK" value="">
<input type="hidden" name="BACK_JS_COUNT" value="<%=js_back%>">

</table>
</form>
<div id="wait" class="cursorWait" />
</body>
</html>