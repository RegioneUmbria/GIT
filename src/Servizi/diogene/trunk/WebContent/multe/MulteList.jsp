<%@ page language="java" %>
<!DOCTYPE HTML PUBLIC "-//w3c//dtd html 4.0 transitional//en">
<% HttpSession sessione = request.getSession(true);  %> 
<% java.util.Vector vlista=(java.util.Vector)sessione.getAttribute(MulteLogic.LISTA_MULTE); %>
<% it.escsolution.escwebgis.multe.bean.MulteFinder finder = (it.escsolution.escwebgis.multe.bean.MulteFinder)sessione.getAttribute(MulteLogic.FINDER); %>
<% int js_back = 1;
	if (sessione.getAttribute("BACK_JS_COUNT")!= null)
		js_back = ((Integer)sessione.getAttribute("BACK_JS_COUNT")).intValue();%>
	<% java.lang.String funzionalita=(java.lang.String)sessione.getAttribute("FUNZIONALITA"); %>	
<%@page import="it.escsolution.escwebgis.multe.logic.MulteLogic"%>
<%@page import="it.escsolution.escwebgis.multe.bean.Multe"%>
<html>
	<head>
		<title>Multe - Lista</title>
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
	
	
		function vai(chiave, record_cliccato){
			wait();
			document.mainform.OGGETTO_SEL.value=chiave;
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
					popUpAperte[index] = window.open("", "MulteDetail" + index, "width=640,height=480,status=yes,resizable=yes");
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
				popUpAperte[index] = window.open("", "MulteDetail" + index, "width=640,height=480,status=yes,resizable=yes");
				return popUpAperte[index].name;
			}
		}
	
		<%if (vlista.size() > 0){
			Multe con = (Multe)vlista.get(0);%>
			function vaiPrimo(){
			 	document.mainform.OGGETTO_SEL.value='<%=con.getChiave()%>';
				document.mainform.RECORD_SEL.value=1;
				document.mainform.ST.value = 3;
				document.mainform.submit();
			}
		<%}%>	
	
	</script>

	<body onload="mettiST()">

		<form name="mainform" action="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/Multe" target="_parent" >

		<div align="center" class="extWinTDTitle"><span class="extWinTXTTitle">
			&nbsp;<%=funzionalita%>:&nbsp;Lista Multe</span>
		</div>
		
		&nbsp;
               
   		<table width="100%" class="extWinTable" cellpadding="0" cellspacing="0">
			
			<tr>
				<td class="extWinTDTitle" colspan="8"><span class="extWinTXTTitle">DATI MULTA</span></td>
				<td class="extWinTDTitle" colspan="3"><span class="extWinTXTTitle">SOGGETTI COLLEGATI</span></td>
			<tr>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">TIPO</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">NUMERO</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">DATA</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">IMPORTO</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">DATA SCAD. PAGAM.</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">PAGATO</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">LUOGO</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">TARGA</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">COGNOME</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">NOME</span></td>
				<td class="extWinTDTitle"><span class="extWinTXTTitle">CODICE FISCALE</span></td>
			
			</tr>
	
			<% Multe t = new Multe(); %>
			<% java.util.Enumeration en = vlista.elements(); %>
			<% int contatore = 1; %>
			<% long progressivoRecord = (finder.getPaginaAttuale()-1)*finder.getRighePerPagina()+1; %>
			<% while (en.hasMoreElements()) {
		        t = (Multe)en.nextElement();
		       System.out.println("Chiave, Progressivo: " + t.getChiave() + ", " + progressivoRecord);   
		        %>

	    		<tr id="r<%=contatore%>">
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
						<span class="extWinTXTData"><%=t.getTipoVerbale()!=null ? t.getTipoVerbale() : "-" %></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;' >
						<span class="extWinTXTData"><%=t.getNrVerbale()!=null ? t.getNrVerbale() : "-" %></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;' >
						<span class="extWinTXTData"><%=t.getDataMulta()!=null ? t.getDataMulta() : "-"%></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
						<span class="extWinTXTData"><%=t.getImportoMulta()!=null ? t.getImportoMulta() : "-" %></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
						<span class="extWinTXTData"><%=t.getDtScadenzaPagamento()!=null ? t.getDtScadenzaPagamento() : "-" %></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
						<span class="extWinTXTData"><%=t.getFlagPagamento()!=null ? t.getFlagPagamento() : "-" %></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
						<span class="extWinTXTData"><%=t.getLuogoInfrazione()!=null ? t.getLuogoInfrazione() : "-" %></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
						<span class="extWinTXTData"><%=t.getTarga()!=null ? t.getTarga() : "-" %></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
						<span class="extWinTXTData"><%=t.getCognome()!=null ? t.getCognome() : "-" %></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
						<span class="extWinTXTData"><%=t.getNome()!=null ? t.getNome() : "-" %></span>
					</td>
					<td onclick="vai('<%=t.getId()%>', '<%=progressivoRecord%>', true)" class="extWinTDData" onmouseover='chgtr(<%=contatore%>,1)' onmouseout='chgtr(<%=contatore%>,0)' style='cursor: pointer;'>
						<span class="extWinTXTData"><%=t.getCodFisc()!=null ? t.getCodFisc() : "-" %></span>
					</td>	
				</tr>
	
				<% 
				contatore++; progressivoRecord ++;
			  	} 
			  	%>

				<input type='hidden' name="ST" value="">
				<input type='hidden' name="OGGETTO_SEL" value="">
				<input type='hidden' name="RECORD_SEL" value="">
				<input type='hidden' name="ACT_PAGE" value="<%=finder.getPaginaAttuale()%>">
				<input type='hidden' name="AZIONE" value="">
				<input type='hidden' name="UC" value="120">
				<input type='hidden' name="BACK" value="">
				<input type="hidden" name="BACK_JS_COUNT" value="<%=js_back%>">

		</table>
		</form>

		<div id="wait" class="cursorWait" />
	</body>
</html>