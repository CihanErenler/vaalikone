package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DaoC;
import model.Answer;
import model.Candidate;
import model.Question;

/**
 * 
 * Servlet responsible for calculating a match between voters and candidates answers
 * Sends result to top 3 page which displays result to a voter
 */
@WebServlet("/calculate")
public class calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private DaoC dao = null;

	@Override
	// connection
	public void init() {
		dao = new DaoC();
	}

	public calculate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Users answers collected from the js (questions.js) seprated by a % sign
		// splits the answers using the % sign and creates an array storing them
		String[] voterAnswers = request.getParameter("answersArr").split("%");

		// array storing all candidates as objects (it has all the candidates info
		// including picture, collection of answers etc
		ArrayList<Candidate> candidates = dao.readAllCandidate();

		ArrayList<HashMap<String, Integer>> forSorting = new ArrayList<HashMap<String,Integer>>();
		ArrayList<Question> questions = dao.readAllQuestion();
		ArrayList<Integer> qIds = new ArrayList<Integer>();
		questions.forEach((q) -> qIds.add(q.getId()));
		
		for (Candidate c : candidates) {
			HashMap<String, Integer> answerComparison = new HashMap<String, Integer>();
			List<Answer> answers = c.getAnswers();
			ArrayList<Integer> percentage = new ArrayList<Integer>();
			for (int i=0; i<qIds.size(); i++) {
				for (Answer a:answers) {
					if(a.getQuestion().getId() == qIds.get(i)) {
						percentage.add(calculatePer(a.getAnswer(), String.valueOf(voterAnswers[i])));
						break;
					}
				}
				i++;
			}
			answerComparison.put("candidateId", c.getId());
			answerComparison.put("answerPercentage", getResult(percentage));
			forSorting.add(answerComparison);
		}
		
		System.out.println("456 : "+customSort(forSorting));
		System.out.println("456 size : "+customSort(forSorting).size());
		request.setAttribute("top", customSort(forSorting).subList(0, 3));
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/top-3.jsp");
		rd.forward(request, response);
	}

	// function returns an array of arrays that stores list of answers per each
	// candidate
	// returns a % value of a match between voter's answer and each candidate's
	// answer

	
	// method that calculates the average of a percent values of a match
	protected int getResult(ArrayList<Integer> x) {
		int sum = 0;

		for (int i : x) {
			sum += i;
		}

		// rounding down doubles to integers with math.floor (5.2 = 5)
		return (int) Math.floor(sum / x.size());
	}

	// calculating point system of match for each voter answer vs. candidate answer
	protected int calculatePer(String a, String s) {
		int num = 0;
		int i = Integer.parseInt(a);
		int j = Integer.parseInt(s);

		if (i == j) {
			num = 100;
		} else {
			// based on difference between answers we are giving the points
			int val = Math.max(i, j) - Math.min(i, j);

			if (val == 1) {
				num = 75;
			} else if (val == 2) {
				num = 50;
			} else if (val == 3) {
				num = 25;
			} else if (val == 4) {
				num = 0;
			}
		}

		return num;
	}
	
	// sorting the percentage average values in order
	public ArrayList<HashMap<String, Integer>> customSort(ArrayList<HashMap<String, Integer>> a) {
		boolean sorted = false;
		HashMap<String, Integer> temp;
		while (!sorted) {
			sorted = true;
			for (int i = 0; i < a.size() - 1; i++) {
				if (a.get(i).get("answerPercentage") < a.get(i + 1).get("answerPercentage")) {
					temp = a.get(i);
					a.set(i, a.get(i + 1));
					a.set(i + 1, temp);
					sorted = false;
				}
			}
		}
		return a;
	}

}
