<%
	double val = Math.random();
	String url = "jsp/protected/welcome.faces?" + val;
	String es = request.getParameter("es");
	response.sendRedirect(url + (es!=null?("&es="+es):""));
%>