package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Admin;
import data.Candidate;
import data.Question;
import data.Voter;

import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	                System.out.println("Connected");
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	     
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	public ArrayList<Candidate> readAllCandidate() {
		ArrayList<Candidate> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from candidate");
			while (RS.next()){
				Candidate c=new Candidate();
				c.setId(RS.getInt("id"));
				c.setFname(RS.getString("fname"));
				c.setLname(RS.getString("lname"));
				c.setCity(RS.getString("city"));
				c.setAge(RS.getString("age"));
				c.setProfession(RS.getString("profession"));
				c.setPoliticalParty(RS.getString("political_party"));
				c.setWhyCandidate(RS.getString("why_candidate"));
				c.setAbout(RS.getString("about"));
				c.setProfilePic(RS.getString("profile_pic"));
				list.add(c);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Candidate> updateCandidate(Candidate c) 
	{
		try 
		{
			String sql="update candidate set fname=? lname=? city=? age=? profession=? political_party=? why_candidate=?"
					+ "about=? profile_pic=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, c.getFname());
			pstmt.setString(2, c.getLname());
			pstmt.setString(3, c.getCity());
			pstmt.setString(4, c.getAge());
			pstmt.setString(5, c.getProfession());
			pstmt.setString(6, c.getPoliticalParty());
			pstmt.setString(7, c.getWhyCandidate());
			pstmt.setString(8, c.getAbout());
			pstmt.setString(9, c.getProfilePic());
			pstmt.setInt(10, c.getId());
			pstmt.executeUpdate();
			return readAllCandidate();
		}
		catch(SQLException e) 
		{
			return null;
		}
	}
	
/*	
	public ArrayList<Fish> deleteFish(String id) {
		try {
			String sql="delete from fish where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllFish();
		}
		catch(SQLException e) {
			return null;
		}
	}

	public Fish readFish(String id) {
		Fish f=null;
		try {
			String sql="select * from fish where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Fish();
				f.setId(RS.getInt("id"));
				f.setBreed(RS.getString("breed"));
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}*/
}