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
				//c.setId(RS.getInt("id"));
				//c.setBreed(RS.getString("breed"));
				list.add(c);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	/*public ArrayList<Candidate> updateFish(Candidate c) {
		try {
			String sql="update fish set breed=? where id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getBreed());
			pstmt.setInt(2, f.getId());
			pstmt.executeUpdate();
			return readAllFish();
		}
		catch(SQLException e) {
			return null;
		}
	}
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