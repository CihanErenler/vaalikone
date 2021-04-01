package app;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Question;

/**
 * Servlet implementation class UpdateQue
 */
@WebServlet("/jsp/updateque")
public class UpdateQue extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao = null;
	
	@Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Password1");
	}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateQue() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//    	response.sendRedirect("admin-questions");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
        String text = request.getParameter("question");    
        
        if (request.getParameter("addNew") != null ) {
        	System.out.println("new question");
        	Question q = new Question();
        	q.setText(text);
        	
        	ArrayList<Question> list=null;
     		if (dao.getConnection()) {
     			list=dao.addQuestion(q);
     		}
     		
     		request.setAttribute("listQuestion", list);
     		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin-questions.jsp");
     		rd.forward(request, response);
        }
        else {
        	Question q = new Question(id, text);
     		
     		ArrayList<Question> list=null;
     		if (dao.getConnection()) {
     			list=dao.updateQuestion(q);
     		}
     		
     		request.setAttribute("listQuestion", list);
     		RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin-questions.jsp");
     		rd.forward(request, response);
        }
       
        
        
	}
}
