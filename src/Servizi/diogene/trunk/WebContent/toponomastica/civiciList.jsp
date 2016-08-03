<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">

<% HttpSession sessione = request.getSession(true);  %> 
<% java.util.Vector vlistaCivici=(java.util.Vector)sessione.getAttribute(it.escsolution.escwebgis.toponomastica.logic.ToponomasticaCiviciLogic.LISTA_CIVICI); %>
<% it.escsolution.escwebgis.toponomastica.bean.CivicoFinder finder = (it.escsolution.escwebgis.toponomastica.bean.CivicoFinder)sessione.getAttribute("FINDER11"); %>

<%int js_back = 1;
	if (sessione.getAttribute("BACK_JS_COUNT")!= null)
		js_back = ((Integer)sessione.getAttribute("BACK_JS_COUNT")).intValue();%>
<% java.lang.String funzionalita=(java.lang.String)sessione.getAttribute("FUNZIONALITA"); %>
		
<html>
<head>
<title>Toponomastica Civici - Lista</title>
<LINK rel="stylesheet" href="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/styles/style.jsp" type="text/css">
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



function vai(Particella, record_cliccato){
	wait();
	document.mainform.OGGETTO_SEL.value=Particella;
	document.mainform.RECORD_SEL.value=record_cliccato;
	<%java.lang.String ST = (java.lang.String)sessione.getAttribute("ST");%>

	<%if (ST.equals("2")){%>
		document.mainform.ST.value = 3;
	<%}else{%>
		document.mainform.ST.value = 5;
	<%}%>
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
			popUpAperte[index] = window.open("", "PopUpCiviciDetail" + index, "width=700,height=480,status=yes,resizable=yes");
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
		popUpAperte[index] = window.open("", "PopUpCiviciDetail" + index, "width=700,height=480,status=yes,resizable=yes");
		return popUpAperte[index].name;
	}
}

<% if (vlistaCivici.size() > 0){
	it.escsolution.escwebgis.toponomastica.bean.Civico pCivico=(it.escsolution.escwebgis.toponomastica.bean.Civico)vlistaCivici.get(0);%>
function vaiPrimo(){
 	document.mainform.OGGETTO_SEL.value='<%=pCivico.getChiave().replaceAll("'","\\\\'")%>';
	document.mainform.RECORD_SEL.value=1;
	document.mainform.ST.value = 3;
	document.mainform.submit();
	}
<%}%>
</script>

<body onload="mettiST()">

<form name="mainform" action="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/ToponomasticaCivici" target="_parent" >
 
<div align="center" class="extWinTDTitle"><span class="extWinTXTTitle">
	&nbsp;<%=funzionalita%>:&nbsp;Elenco Particelle Civici</span>
</div>
		
&nbsp;
               
   <table width="100%" class="extWinTable" cellpadding="0" cellspacing="0">
	
	<tr>
		<td class="extWinTDTitle" style="width: 10%;"><span class="extWinTXTTitle">Sedime<span class="extWinTXTTitle"></td>
		<td class="extWinTDTitle" style="width: 60%;"><span class="extWinTXTTitle">Nome Via<span class="extWinTXTTitle"></td>
		<td class="extWinTDTitle" style="width: 10%;"><span class="extWinTXTTitle">Civico</span></td>
		<td class="extWinTDTitle" style="width: 5%;"><span class="extWinTXTTitle">Mappa</span></td>
	</tr>
        
        

  <% it.escsolution.escwebgis.toponomastica.bean.Civico civico = new it.escsolution.escwebgis.toponomastica.bean.Civico(); %>
  <% java.util.Enumeration en = vlistaCivici.elements(); int contatore = 1; %>
  <% long progressivoRecord = (finder.getPaginaAttuale()-1)*finder.getRighePerPagina()+1; %>
  <% while (en.hasMoreElements()) {
        civico = (it.escsolution.escwebgis.toponomastica.bean.Civico)en.nextElement();%>



    <tr id="r<%=contatore%>" >

		<td onclick="vai('<%=civico.getChiave().replaceAll("'","\\\\'")%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)'  style='cursor: pointer;'>
		<span class="extWinTXTData"><%=civico.getSedime()%></span></td>
		<td onclick="vai('<%=civico.getChiave().replaceAll("'","\\\\'")%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
		<span class="extWinTXTData"><%=civico.getStrada()%></span></td>
		<td onclick="vai('<%=civico.getChiave().replaceAll("'","\\\\'")%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
		<span class="extWinTXTData"><%=civico.getDescrCivico()%></span></td>
		<td onclick="zoomInMappaCivici('<%= civico.getCod_nazionale() %>','<%=civico.getPk_sequ_civico()%>')" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
		<span class="extWinTXTData"><img src="../ewg/images/Localizza.gif"/></span></td>
		
	</tr>
		
  <% contatore++;progressivoRecord ++;} %>
  
<input type='hidden' name="ST" value="">
<input type='hidden' name="OGGETTO_SEL" value="">
<input type='hidden' name="RECORD_SEL" value="">
<input type='hidden' name="ACT_PAGE" value="<%=finder.getPaginaAttuale()%>">
<input type='hidden' name="AZIONE" value="">
<input type='hidden' name="UC" value="11">
<input type='hidden' name="BACK" value="">
<input type="hidden" name="BACK_JS_COUNT" value="<%=js_back%>">

</table>
</form>
<div id="wait" class="cursorWait" />
</body>
</html>