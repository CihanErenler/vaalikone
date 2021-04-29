package app;

import java.io.IOException;
import java.util.ArrayList;
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

import model.Question;

/**
 * Servlet implementation class ShowQue
 */
@WebServlet("/jsp/admin-questions")
public class ShowQue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()	
     */
    public ShowQue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "http://localhost:8080/rest/questionservice/readall";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();
		
		List<Question> listQuestion = b.get(new GenericType<List<Question>>() {});
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin-questions.jsp");
		request.setAttribute("listQuestion", listQuestion);
		rd.forward(request, response);
	}

}
