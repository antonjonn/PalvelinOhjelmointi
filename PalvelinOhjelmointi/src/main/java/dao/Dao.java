package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Answer;
import data.Candidate;
import data.Question;

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
	public ArrayList<Candidate> readAllCandidates() {
		ArrayList<Candidate> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from ehdokkaat");
			while (RS.next()){
				Candidate f=new Candidate();
				f.setId(RS.getString("ehdokas_id"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setPuolue(RS.getString("puolue"));
				f.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				f.setIka(RS.getString("ika"));
				f.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				f.setMita_edistaa(RS.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
				f.setAmmatti(RS.getString("ammatti"));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Candidate> updateCandidate(Candidate f) {
		try {
			String sql="update ehdokkaat set ika=? where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getIka());
			pstmt.setInt(2, f.getId());
			pstmt.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			return null;
		}
	}
	public ArrayList<Candidate> deleteCandidate(String id) {
		try {
			String sql="delete from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			return null;
		}
	}

	public Candidate readCandidate(int id) {
		Candidate f=null;
		try {
			String sql="select * from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Candidate();
				f.setId(RS.getString("ehdokas_id"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setPuolue(RS.getString("puolue"));
				f.setKotipaikkakunta(RS.getString("kotipaikkakunta"));
				f.setIka(RS.getString("ika"));
				f.setMiksi_eduskuntaan(RS.getString("miksi_eduskuntaan"));
				f.setMita_edistaa(RS.getString("MITA_ASIOITA_HALUAT_EDISTAA"));
				f.setAmmatti(RS.getString("ammatti"));
		
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public ArrayList<Question> readAllQuestions() {
		ArrayList<Question> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from kysymykset order by kys_jar");
			while (RS.next()){
				Question f=new Question();
				f.setKysymys_id(RS.getInt("kysymys_id"));
				f.setKysymys(RS.getString("kysymys"));
				f.setKysjar(RS.getInt("kys_jar"));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public void updateQuestion(int kysymys_id, String kysymys, int kysjar) {
		try {
			String sql="update kysymykset set kysymys=?, kys_jar=? where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, kysymys);
			pstmt.setInt(2, kysjar);
			pstmt.setInt(3, kysymys_id);
			pstmt.executeUpdate();
			
		}
		catch(SQLException e) {
			System.out.println("shit pant");
		}
	}
	
	public ArrayList<Question> createQuestion(Question f) {
		try {
			String sql = "";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kysymys);
			pstmt.executeUpdate();
			return readAllQuestions();
		} catch (SQLException e) {
			return null;
		}
	}
	
	public void deleteQuestion(int id) {
		try {
			String sql="delete from kysymykset where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			
		}
		catch(SQLException e) {
		System.out.println("something gone wronge");
		}
	}
	
	public Question readQuestion(int id) {
		Question f=null;
		try {
			String sql="select * from kysymykset where kysymys_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Question();
				f.setKysymys_id(RS.getInt("kysymys_id"));
				f.setKysymys(RS.getString("kysymys"));
				f.setKysjar(RS.getInt("kys_jar"));
		
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
	

	public Answer readAnswer(int candidate_id) {
		Answer f=null;
		try {
			String sql="select * from vastaukset where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, candidate_id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Answer();
				f.setKysymys_id(RS.getInt("kysymys_id"));
				f.setKommentti(RS.getString("kommentti"));
				f.setEhdokas_id(RS.getInt("ehdokas_id"));
				f.setVastaus(RS.getInt("vastaus"));
		
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}


}
