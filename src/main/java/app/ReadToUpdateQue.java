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

import model.Question;

/**
 * Servlet implementation class ReadToUpdateQue
 * Displays question for the admin, possible edition
 */
@WebServlet("/jsp/ReadToUpdateQue")
public class ReadToUpdateQue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadToUpdateQue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id=request.getParameter("id");
		
		if(request.getParameter("addNew") != null) {
			request.setAttribute("addNew", "1");
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/add-question.jsp");
			rd.forward(request, response);
		}
		else {
			Question q= null;
			q=getQuestion(id);
			
			request.setAttribute("question", q);
			
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/add-question.jsp");
			rd.forward(request, response);
		}	
	}
	
	
	private Question getQuestion(String id) {
		String url = "http://localhost:8080/rest/questionservice/read";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url).path(id);
		Builder b = wt.request();
		
		Question q = b.get(Question.class);
		
		return q;
	}
	
}
