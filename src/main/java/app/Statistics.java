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


@WebServlet("/Statistics")
public class Statistics extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Dao dao = null;
	
	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Password1");
	}
       

    public Statistics() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Question> q = new ArrayList<>();
		ArrayList<Integer> s = new ArrayList<>();
		ArrayList<String> sta = new ArrayList<>();
		
		if(dao.getConnection()) {
			q = dao.readAllQuestions();
			for(int i = 0; i < q.size(); i++) {
				s.add(q.get(i).getId());
			}
			sta = dao.getStatistics(s);
		}
		
		request.setAttribute("statistics", sta);
		request.setAttribute("questions", q);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/statistics.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
