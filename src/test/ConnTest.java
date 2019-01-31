package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnTest {
	public static void main(String[] args) {
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 try { //오라클( DB ) 안쪽
			 Class.forName("oracle.jdbc.OracleDriver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "oracle", "password");
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery("SELECT COUNT(*) AS COUNT FROM EMPLOYEES");
			 String count = "";
			 while(rs.next()) {
				 count = rs.getString("COUNT");
			 }
			 System.out.println("회원의 수 "+count);
		 }catch(Exception e) {
			 e.printStackTrace();   //로그를 찍어
		 }finally {
			 try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		 }
	}
}
