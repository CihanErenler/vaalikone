package app;

import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.Dao;
import model.Question;

@WebServlet("/jsp/updateque")
public class UpdateQue extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateQue() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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
		} else {
			String id = request.getParameter("id");
			String text = request.getParameter("question");

			if (request.getParameter("addNew") != null) {
				Question q = new Question();
				q.setQuestion(text);
				q.setQuestionRef(String.valueOf(new Timestamp(System.currentTimeMillis()).getTime()));
				
				if (addQuestion(q)) {
					String qid = q.getQuestionRef();
					response.sendRedirect("/randomAnswers?qid="+qid);
				}
			} else {
				Question q = new Question();
				q.setId(Integer.parseInt(id));
				q.setQuestion(text);

				if (updateQuestion(q)) {
					response.sendRedirect("/jsp/admin-questions");
				}
			}
		}

	}

	private boolean updateQuestion(Question q) {
		String url = "http://localhost:8080/rest/questionservice/update";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();

		Response res = b.put(Entity.entity(q, MediaType.APPLICATION_JSON));
		if (res.getStatus() == 200) {
			return true;
		} else {
			return false;
		}
	}
	private boolean addQuestion(Question q) {
		String url = "http://localhost:8080/rest/questionservice/add";
		Client c = ClientBuilder.newClient();
		WebTarget wt = c.target(url);
		Builder b = wt.request();
		Entity e = Entity.entity(q, MediaType.APPLICATION_JSON);
		Response res = b.post(e);
		
		if (res.getStatus() == 200) {
			return true;
		}
		else {
			return false;
		}
	}
}
