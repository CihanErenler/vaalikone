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

@WebServlet(
	    name = "updateCan",
	    urlPatterns = {"/updateCan"}
	)
public class UpdateCan extends HttpServlet 
{
	private Dao dao;

	public void init() 
	{
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Password1");
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.sendRedirect("index.html");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		String id=request.getParameter("id");
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String city=request.getParameter("city");
		String age=request.getParameter("age");
		String profession=request.getParameter("profession");
		String political_party=request.getParameter("political_party");
		String why_candidate=request.getParameter("why_candidate");
		String about=request.getParameter("about");
		String profile_pic=request.getParameter("profile_pic");
		
		
		Candidate c =new Candidate(id, fname, lname, city, age, profession, political_party, why_candidate, about, profile_pic);
		
		ArrayList<Candidate> list = new ArrayList<>();
		if(dao.getConnection()) 
		{
			list = dao.updateCandidate(c, dao);
		}
		
		request.setAttribute("candidatelist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/admin-candidate.jsp");
		rd.forward(request, response);
	}

}
