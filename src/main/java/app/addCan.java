package app;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import java.io.*;  

import dao.Dao;
import data.Candidate;


@WebServlet(name = "AddCandidate", urlPatterns = { "/jsp/addCan" })
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)


public class addCan extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Dao dao;
    
    public addCan() {
        super();
        
    }
    
    @Override
	public void init() {
		dao = new Dao("jdbc:mysql://localhost:3306/vaalikone", "root", "Password1");
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//get the file chosen by the user
		Part filePart = request.getPart("profile_pic");
		
		//get the InputStream to store the file somewhere
	    InputStream fileInputStream = filePart.getInputStream();
	    
	    //for example, you can copy the uploaded file to the server
	    //note that you probably don't want to do this in real life!
	    //upload it to a file host like S3 or GCS instead
	    File fileToSave = new File("C:\\Users\\Connor\\git\\vaalikone\\src\\main\\webapp\\img\\" + filePart.getSubmittedFileName());
		Files.copy(fileInputStream, fileToSave.toPath(), StandardCopyOption.REPLACE_EXISTING);
		
		System.out.println(request.getParameter("profile_pic"));
		
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String city=request.getParameter("city");
		String age=request.getParameter("age");
		String profession=request.getParameter("profession");
		String political_party=request.getParameter("political_party");
		String why_candidate=request.getParameter("why_candidate");
		String about=request.getParameter("about");
		String profile_pic=request.getParameter("profile_pic");
		
		Candidate c =new Candidate(fname, lname, city, age, profession, political_party, why_candidate, about, profile_pic);
		
		if (dao.getConnection()) {
 			if(dao.addCandidate(c)) {
 				response.sendRedirect("/jsp/admin-candidate");
 			}
 		}
		
		
	}
}
