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

@WebServlet("/update-candidate")
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
		String politicalParty=request.getParameter("politicalParty");
		String whyCandidate=request.getParameter("whyCandidate");
		String about=request.getParameter("about");
		String profilePic=request.getParameter("profilePic");
		
		
		Candidate c =new Candidate(id, fname, lname, city, age, profession, politicalParty, whyCandidate, about, profilePic);
		
		ArrayList<Candidate> list = null;
		if(dao.getConnection()) 
		{
			list = dao.updateCandidate(c);
		}
		
		request.setAttribute("candidatelist", list);
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/.jsp");
		rd.forward(request, response);
	}

}
