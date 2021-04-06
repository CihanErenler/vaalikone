package app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.Dao;
import data.Answer;
import data.Candidate;
import data.Question;

@WebServlet("/calculate")
public class calculate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Dao dao = null;

	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Password1");
	}

	public calculate() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] str = new String[request.getParameter("answersArr").length()];
		str = request.getParameter("answersArr").split("%");

		ArrayList<Candidate> c = new ArrayList<>();
		ArrayList<ArrayList<Answer>> list = new ArrayList<>();
		ArrayList<Answer> candi = new ArrayList<>();

		if (dao.getConnection()) {
			for (Candidate i : dao.readAllCandidate()) {
				c.add(dao.getCandidate(i.getId()));
			}
		}

		list = getPer(c, str);

		for (int i = 0; i < list.size(); i++) {
			ArrayList<Integer> nums = new ArrayList<>();
			for (int j = 0; j < list.get(i).size(); j++) {
				nums.add(Integer.parseInt(list.get(i).get(j).getAnswer()));
			}
			
			candi.add(new Answer(list.get(i).get(1).getCan_id(), String.valueOf(getResult(nums))));
		}
		
		
		for(Answer x : candi) {
			System.out.println("Id : "+ x.getCan_id()+" / "+ "Percentage : "+x.getAnswer()+"%");
		}
	}
	
	
	protected ArrayList<ArrayList<Answer>> getPer(ArrayList<Candidate> x, String[] y) {

		ArrayList<ArrayList<Answer>> list = new ArrayList<>();
		int count = 0;

		for (int i = 0; i < x.size(); i++) {
			ArrayList<Answer> per = new ArrayList<>();
			for (int j = 0; j < x.get(i).getAnswers().size(); j++) {

				per.add(new Answer(x.get(i).getAnswers().get(j).getCan_id(),
						x.get(i).getAnswers().get(j).getQuestion_id(),
						String.valueOf(calculatePer(x.get(i).getAnswers().get(j).getAnswer(), y[j]))));

			}

			list.add(per);
		}
		return list;
	}

	protected int getResult(ArrayList<Integer> x) {
		int sum = 0;
		
		for(int i : x ) {
			sum += i;
		}
		
		return (int)Math.floor(sum / x.size()) ;
	}

	protected int calculatePer(String a, String s) {
		int num = 0;
		int i = Integer.parseInt(a);
		int j = Integer.parseInt(s);

		if (i == j) {
			num = 100;
		} else {
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

}
