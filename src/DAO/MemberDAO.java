package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnect.DBConnection;

public class MemberDAO { // DB Query 수행 Class
	Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	boolean result1;
	int result2;
	
	public MemberDAO() throws ClassNotFoundException, SQLException {
		con = new DBConnection().getConnection();
	}
	
	public String login(String id, String pw) throws SQLException { // 로그인
		String sql = "SELECT * FROM member WHERE id = ? AND pw = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(id.equals(rs.getString("id")) && pw.equals(rs.getString("pw"))) {
					System.out.println("로그인 성공!");
					
					result1 = true;
				} else {
					System.out.println("로그인 실패!");
					
					result1 = false;
				}
			}
		} catch(SQLException e) {
			System.out.println("Login Error!");
		}
		String id1 = rs.getString("id");
		
		return id1;
	}
	
	public boolean register(String id, String pw, String name, String age, String gender, String tel, String address) { // 회원가입
		String sql = "INSERT INTO member VALUES(?, ?, ?, to_number(?), ?, ?, ?)";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, age);
			pstmt.setString(5, gender);
			pstmt.setString(6, tel);
			pstmt.setString(7, address);
			
			pstmt.executeUpdate();
			
			System.out.println("INSERT SUCCESS!");
		} catch(SQLException e) {
			System.out.println("INSERT ERROR!");
			
			return false;
		}
		
		return true;
	}
}