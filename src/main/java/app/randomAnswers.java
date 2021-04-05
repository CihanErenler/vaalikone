package app;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Question;
import data.Candidate;
import data.RandomAnswer;


@WebServlet("/randomAnswers")
public class randomAnswers extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao = null;
	
	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Password1");
	}
   
    public randomAnswers() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("qid");
		ArrayList<Candidate> candidates = new ArrayList<>();
		ArrayList<RandomAnswer> randoms = new ArrayList<>();
		
		Question q = null;
		
		if(dao.getConnection()) {
			q = dao.getQuestions(id);
			candidates = dao.readAllCandidate();
			randoms = assignAnswers(candidates, id);
			dao.addAnswersForNewQuestion(randoms);
		}
		
		request.setAttribute("question", q);
		request.setAttribute("cans", randoms);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/askToCandidates.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	protected ArrayList<RandomAnswer> assignAnswers(ArrayList<Candidate> c, String qid) {
		ArrayList<RandomAnswer> answers = new ArrayList<>();
		
		for(Candidate can : c) {
			String randomAnswer = String.valueOf((int)Math.floor(Math.random() * 5 + 1));
			System.out.println(can.getProfile_pic());
			answers.add(new RandomAnswer(can.getId(), qid, randomAnswer, can.getProfile_pic()));
		}
		
		return answers;
	}

}
