package test;

import java.sql.ResultSet;
import enums.Vendor;
import factory.DatabaseFactory;

public class ConnTest2 {
	public static void main(String[] args) {
		ResultSet rs = null;
		 try { //오라클( DB ) 안쪽
			 String sql = "SELECT COUNT(*) AS COUNT FROM EMPLOYEES";
			 
			 rs = DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql).executeQuery();
			 String count = "";
			 while(rs.next()) {
				 count = rs.getString("COUNT");
			 }
			 System.out.println("회원의 수 "+count);
		 }catch(Exception e) {
			 e.printStackTrace();   //로그를 찍어
		 }
	}
}
