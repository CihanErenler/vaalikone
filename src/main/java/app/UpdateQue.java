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
@WebServlet("/jsp/admin-questions1")
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
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getServletPath();
		try {
            switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertQuestion(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
            	System.out.println("This is edit");
                break;
            case "/update":
                updateQuestion(request, response);
                break;
            default:
                listQuestion(request, response);
                break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
	}
	
		
	private void listQuestion(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException, ServletException {
		 		ArrayList<Question> listQuestion = null;
			if (dao.getConnection()) {
				listQuestion = dao.readAllQuestions();
			}
			else {
				System.out.println("No connection to database");
			}
			request.setAttribute("listQuestion", listQuestion);
			
			RequestDispatcher rd=request.getRequestDispatcher("/jsp/admin-questions.jsp");
			rd.forward(request, response);
		}
	 
	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/add-question.jsp");
	        dispatcher.forward(request, response);
	    }
	 
	    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, ServletException, IOException {
	        String id = request.getParameter("id");
	        Question existingQuestion = dao.getQuestions(id);
	        RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/add-question.jsp");
	        request.setAttribute("existingquestion", existingQuestion);
	        dispatcher.forward(request, response);
	 
	    }
	 
	    private void insertQuestion(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException {
	    	String id = "";
	        String text = request.getParameter("text");
	        Question newQuestion = new Question(id, text);
	        dao.addQuestion(newQuestion);
	        response.sendRedirect("admin-questions1");
	    }
	 
	    private void updateQuestion(HttpServletRequest request, HttpServletResponse response)
	        throws SQLException, IOException {
	        String id = request.getParameter("id");
	        String text = request.getParameter("text");
	        Question q = new Question(id, text);
	        dao.updateQuestion(q);
	        response.sendRedirect("admin-questions1");
	    }
}
