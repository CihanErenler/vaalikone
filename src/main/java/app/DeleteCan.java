package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.Response;

import model.Candidate;

/**
 * Servlet implementation class DeleteCan
 */
@WebServlet("/deleteCan")
public class DeleteCan extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public DeleteCan() 
	{
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Candidate c = new Candidate();
		
		HttpSession session = request.getSession(false);

		boolean isLoggedIn = false;
		if (session == null) {
		} else {
			if (session.getAttribute("isLoggedIn") == null) {

			} else {
				isLoggedIn = (boolean) session.getAttribute("isLoggedIn");
			}
		}

		if (!isLoggedIn) {
			response.sendRedirect("/index.jsp");
		}

		else {
			String id = request.getParameter("id");
			c.setId(Integer.parseInt(id));
			if(deleteCandidate(c)) 
			{
				response.sendRedirect("/readallcandidates");
			}
		}
	}
	
	private boolean deleteCandidate(Candidate c) 
	{
		String url = "http://localhost:8080/rest/candidateservice/delete";
		Client cl = ClientBuilder.newClient();
		WebTarget wt = cl.target(url).path(String.valueOf(c.getId()));
		Builder b = wt.request();
		Response res = b.delete();

		if (res.getStatus() == 200) 
		{
			return true;
		} else 
		{
			return false;
		}
	}
	
	
	

}
