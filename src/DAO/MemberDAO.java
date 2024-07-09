package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DBConnect.DBConnection;
import VO.MemberVO;

public class MemberDAO { // DB Query 수행 Class
	Connection con;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
		
	public MemberDAO() throws ClassNotFoundException, SQLException {
		con = new DBConnection().getConnection();
	}
	
	public ArrayList<MemberVO> login(String id, String pw) throws SQLException { // 로그인
		ArrayList<MemberVO> list = new ArrayList<MemberVO>();
		
		String sql = "SELECT * FROM member WHERE id = ? AND pw = ?";
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String id1 = rs.getString("id");
				String pw1 = rs.getString("pw");
				
				MemberVO vo = new MemberVO(id1, pw1);
				
				list.add(vo);
			}
		} catch(SQLException e) {
			System.out.println("Login Error!");
		}
		
		return list;
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