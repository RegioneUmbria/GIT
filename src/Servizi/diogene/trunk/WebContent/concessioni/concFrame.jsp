<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<% HttpSession sessione = request.getSession(true); %>
<% java.lang.String ST = (java.lang.String)sessione.getAttribute("ST"); %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CONCESSIONE</title>
<script>
<!--
function goBack(numeroBack){
	history.go(numeroBack);
}
function ricarica(){
	document.location.reload();
}
//-->
</script>
</head>
<%if(ST.equals("33")){%>
<frameset rows="*" border="0">
	<frame name="bodyPage" src="<%= request.getContextPath() %>/concessioni/concDetail.jsp" noresize class="frame">
	<%
	} 
else 
{	
if(ST.equals("1")){%>
<frameset rows="0,30,*" border="0">
<%}else{%>
<frameset rows="0,30,*,30" border="0">
<%}%>
	<frame name="hidden" src="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/common/hidden.jsp" noresize scrolling="NO" class="frame">
	<frame name="barraTool" src="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/frame/barraTool.jsp" noresize scrolling="NO" class="frame">
	<!--frame name="barraLink" src="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/frame/barraLink.jsp" noresize scrolling="NO" class="frame"-->
	<%if(ST.equals("1")){%>
	<frame name="bodyPage" src="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/common/search.jsp" noresize class="frame">
	<%}else if(ST.equals("2")){%>
	<frame name="bodyPage" src="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/concessioni/concList.jsp" noresize class="frame">
	<%}else if(ST.equals("3")){%>
	<frame name="bodyPage" src="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/concessioni/concDetail.jsp" noresize class="frame">
	<%}%>
	<%if((ST.equals("2"))||(ST.equals("3"))){%>
	<frame name="barraMoveRecord" src="<%= it.escsolution.escwebgis.common.EscServlet.URL_PATH %>/frame/barraMoveRecord.jsp" noresize scrolling="NO" class="frame">
<%}
}%>
</frameset>
</html>