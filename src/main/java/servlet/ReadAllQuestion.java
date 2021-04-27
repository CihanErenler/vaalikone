package servlet;

import java.util.List;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.client.Invocation.Builder;
import model.Question;

/**
 * Servlet implementation class ReadAllQuestion
 */
@WebServlet("/readallquestion")
public class ReadAllQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReadAllQuestion() {
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/testing.jsp");
		request.setAttribute("listQuestion", listQuestion);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
