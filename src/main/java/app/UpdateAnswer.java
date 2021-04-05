package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Answer;

@WebServlet("/jsp/UpdateAnswer")
public class UpdateAnswer extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao = null;
	
	public void init() 
	{
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Password1");
	}      
 
    public UpdateAnswer() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String ref = request.getParameter("ref");
		int size = Integer.parseInt(request.getParameter("size"));
		String id = "";
		ArrayList<Answer> answer = new ArrayList<Answer>();
		

		if (dao.getConnection()) {
			id = String.valueOf(dao.getIdByRef(ref));
			for (int i=0; i<size; i++) {
				Answer ans = new Answer(id, request.getParameter("questionID".concat(String.valueOf(i))), request.getParameter(String.valueOf(i)));
				answer.add(ans);
			}
			dao.addAnswerCandidate(answer);
			response.sendRedirect("admin-candidate");
		}

	}

}
