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
	
	// Connection method
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
	
	// Candidate - related 
	public ArrayList<Candidate> readAllCandidate() {
		ArrayList<Candidate> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from candidate");
			while (RS.next()){
				Candidate c=new Candidate();
				c.setId(RS.getString("id"));
				c.setFname(RS.getString("fname"));
				c.setLname(RS.getString("lname"));
				c.setCity(RS.getString("city"));
				c.setAge(RS.getString("age"));
				c.setProfession(RS.getString("profession"));
				c.setPolitical_party(RS.getString("political_party"));
				c.setWhy_candidate(RS.getString("why_candidate"));
				c.setAbout(RS.getString("about"));
				c.setProfile_pic(RS.getString("profile_pic"));
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
			pstmt.setString(6, c.getPolitical_party());
			pstmt.setString(7, c.getWhy_candidate());
			pstmt.setString(8, c.getAbout());
			pstmt.setString(9, c.getProfile_pic());
			pstmt.setString(10, c.getId());
			pstmt.executeUpdate();
			return readAllCandidate();
		}
		catch(SQLException e)
		{
			return null;
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
						getQuestions(rs.getString("question_id")).getText()));
			}

			return list;

		}catch(SQLException e) {
			return null;
		}
	}
	
	// Questions related
	
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

	public ArrayList<Question> readAllQuestions() {
		ArrayList<Question> listQuestion = new ArrayList<>();
		try {
			String sql = "SELECT * FROM question";
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery(sql);

			while (RS.next()){
				Question q = new Question();
				q.setId(RS.getInt("id"));
				q.setText(RS.getString("question"));
				listQuestion.add(q);
			}
			return listQuestion;
		}
		catch(SQLException e) {
			return null;
		}
	}


	public boolean addQuestion(Question q) {
		String sql = "INSERT INTO question (question) VALUES (?)";
		try {

			PreparedStatement statement=conn.prepareStatement(sql);
			statement.setString(1, q.getText());

			boolean rowInserted = statement.executeUpdate() > 0;
			statement.close();
			return rowInserted;

		} catch (Exception e) {
			return false;
		}

	}
	
	public ArrayList<Question> updateQuestion(Question q) {
		try {
			String sql="update question set question=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, q.getText());
			pstmt.setInt(2, q.getId());
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	// Login/admin related
	public boolean adminLogin(Admin adm) {
		try {
			int c = 0;
			String sql="select * from admin where email=? and pwd=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, adm.getEmail());
			pstmt.setString(2, adm.getPass());
			ResultSet RS = pstmt.executeQuery();
			while (RS.next()) {
				c++;
			}
			if (c>0) {
				return true;
			}
			else {
				return false;
			}
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}

	public ArrayList<Admin> matchedAdmin(Admin adm) {
		ArrayList<Admin> list=new ArrayList<>();
		try {
			String sql="select * from admin where email=? and pwd=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, adm.getEmail());
			pstmt.setString(2, adm.getPass());
			ResultSet RS = pstmt.executeQuery();
			while (RS.next()){
				Admin ad=new Admin();
				ad.setId(RS.getString("id"));
				ad.setEmail(RS.getString("email"));
				list.add(ad);
			}
			System.out.println(RS.getFetchSize());
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}

	public int matchedAdminInt(Admin adm) {
		try {
			int c=0;
			String sql="select * from admin where email=? and pwd=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, adm.getEmail());
			pstmt.setString(2, adm.getPass());
			ResultSet RS = pstmt.executeQuery();
			while (RS.next()) {
				c++;

			}
			return c;
		}
		catch(SQLException e) {
			return 100;
		}
	}

}