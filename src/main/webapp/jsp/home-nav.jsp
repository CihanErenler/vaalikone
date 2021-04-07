<%
			boolean isLoggedIn = false;
		if (session.getAttribute("isLoggedIn") != null) {
			isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
		}

		if (isLoggedIn) {
		%>
		<nav class="main-nav">
			<a href="/index.jsp">Home</a>
			<a href="/jsp/admin-dashboard.jsp">Dashboard</a>
			<a href="/logout">Log Out</a>
		</nav>
		<%
			} else {
		%>
		<nav class="main-nav">
			<a href="/index.jsp">Home</a>
			<a href="/login">Admin Login</a>
		</nav>
		<%
			}
%>