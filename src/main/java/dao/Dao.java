package dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Admin;
import data.Answer;
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
	
	public Candidate getCandidate(String id) {
		Candidate c = null;
		try {
			
			ArrayList<Answer> list = getCanAnswerList(id);
			
			String sql = "select * from candidate where id=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				c=new Candidate(String.valueOf(rs.getInt("id")), rs.getString("fname"), 
						rs.getString("lname"), rs.getString("city"), rs.getString("age"), 
						rs.getString("profession"), rs.getString("political_party"), 
						rs.getString("why_candidate"), rs.getString("about"), 
						rs.getString("profile_pic"), list);
			}
			
			return c;
			
		}catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Answer> getCanAnswerList(String id){
		ArrayList<Answer> list = new ArrayList<>();

		try {	
			String sql = "select * from answer where can_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				
				
				
				list.add(new Answer(String.valueOf(rs.getInt("id")), 
						rs.getString("can_id"),
						rs.getString("question_id"),
						rs.getString("answer"),
						getQuestions(rs.getString("question_id")).getQuestion()));
			}
			
			return list;
			
		}catch(SQLException e) {
			return null;
		}
	}
	
	public Question getQuestions(String id) {
		Question q = null;
		
		try{
			String sql = "select * from question where id=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				q = new Question(String.valueOf(rs.getInt("id")), rs.getString("question"));
			}
			
			return q;
			
		}catch(SQLException e) {
			return null;
		}
	}

}