
<%
	boolean isLoggedIn = false;
	if (session.getAttribute("isLoggedIn") != null) {
		isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
	}
	
	if (isLoggedIn) {
	%>
	<%@ include file="../html/admin-nav.html"%>
	<%
		} else {
	%>
	<%@ include file="../html/navbar.html"%>
	<%
		}
%>

