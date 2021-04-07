
<%
	boolean isLoggedIn = false;
	if (session.getAttribute("isLoggedIn") != null) {
		isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
	}
	
	if (isLoggedIn) {
		out.print("admin-nav.html");
	} else {
		out.print("navbar.html");
	}
%>