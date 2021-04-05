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
import data.Candidate;
import data.Question;

/**
 * Servlet implementation class DeleteCan
 */
@WebServlet("/deleteCan")
public class DeleteCan extends HttpServlet {
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Password1");
	}
	private static final long serialVersionUID = 1L;
       
    
    public DeleteCan() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		ArrayList<Candidate> list = new ArrayList<>();
		
		String id = request.getParameter("id");
    	
    	if (dao.getConnection()) {
 			if(dao.deleteCandidate(id)) {
 				response.sendRedirect("/jsp/admin-candidate");
 			}
    	}
    	
//    	request.setAttribute("candidatelist", list);
//		RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin-candidate.jsp");
//		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
