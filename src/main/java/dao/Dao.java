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
	
	public Question getQuestion(String id) throws SQLException {
        Question q = null;
        String sql = "SELECT * FROM question WHERE id = ?";
         
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, id);
         
        ResultSet resultSet = statement.executeQuery();
         
        if (resultSet.next()) {
            String text = resultSet.getString("question");
            q = new Question(id, text);
        }
         
        resultSet.close();
        statement.close();
         
        return q;
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
			pstmt.executeUpdate();
			return readAllQuestions();
		}
		catch(SQLException e) {
			return null;
		}
	}
}
