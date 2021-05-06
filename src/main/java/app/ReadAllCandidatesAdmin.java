package app;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.GenericType;

import model.Candidate;

@WebServlet("/readallcandidatesadmin")
public class ReadAllCandidatesAdmin extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public ReadAllCandidatesAdmin() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String url = "http://localhost:8080/rest/candidateservice/readalladmin";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();
		
		List<Candidate> candidateList = b.get(new GenericType<List<Candidate>>() {});
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin-candidate.jsp");
		request.setAttribute("candidateList", candidateList);
		rd.forward(request, response);	

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{

	}

}