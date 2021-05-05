package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DaoC;
import model.Question;
import model.Answer;
import model.Candidate;

/**
 * 
 * Servlet allowing a logged admin to change candidates answers
 *
 */
@WebServlet("/jsp/UpdateAnswer")
public class UpdateAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoC dao = new DaoC();  
 
    public UpdateAnswer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			String ref = request.getParameter("ref");
			int size = Integer.parseInt(request.getParameter("size"));
			
			List<Answer> answer = new ArrayList<Answer>();
			
			Candidate c = dao.readCandidateByRef(ref);
			
			for (int i=0; i<size; i++) {
				Answer ans = new Answer();
				Question q = dao.readQuestion(Integer.parseInt(request.getParameter("questionID".concat(String.valueOf(i)))));
				
				ans.setAnswer(request.getParameter(String.valueOf(i)));
				ans.setQuestion(q);
				answer.add(ans);
			}
			c.setAnswers(answer);
			
			dao.updateCandidate(c);
			
			response.sendRedirect("/readallcandidatesadmin");
			
		}
	}

}
