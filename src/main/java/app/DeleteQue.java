package app;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import model.Question;

/**
 * Servlet implementation class DeleteQue
 */
@WebServlet("/DeleteQue")
public class DeleteQue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeleteQue() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Question q = new Question();

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
			q.setId(Integer.parseInt(id));
			if (deleteQuestion(q)) {
				response.sendRedirect("/jsp/admin-questions");
			}
		}
	}

	private boolean deleteQuestion(Question q) {
		String url = "http://localhost:8080/rest/questionservice/delete";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url).path(String.valueOf(q.getId()));
		System.out.println("Out thingy" + wt);
		Builder b = wt.request();
		Response res = b.delete();

		if (res.getStatus() == 200) {
			return true;
		} else {
			return false;
		}
	}
}
