package app;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import data.Candidate;

@WebServlet("/ShowCan")
public class ShowCan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	public void init() {
		dao=new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Password1");
	}
    
    public ShowCan() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Candidate c = null;
		
		if(dao.getConnection()) {
			c = dao.getCandidate(id);
		}
		
		request.setAttribute("profile", c);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/profile.jsp");
		rd.forward(request, response);
	}

}
