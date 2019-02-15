package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import domain.EmployeeDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class EmployeeDAOImpl implements EmployeeDAO{
	private static EmployeeDAOImpl instance = new EmployeeDAOImpl();
	private EmployeeDAOImpl() {}
	public static EmployeeDAOImpl getInstance() {return instance;}

	@Override
	public void insertEmployee(EmployeeDTO emp) {
		try {
			//MANAGER,NAME,BIRTHDATE,PHOTO,NOTES
			String sql = String.format(EmployeeSQL.REGISTER.toString());
			System.out.println("실행할 쿼리:" + sql);
			Connection conn = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();
			System.out.println("DAOImpl에 들어와서 sql 작업시작");
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, emp.getManager());
			psmt.setString(2, emp.getName());
			psmt.setString(3, emp.getBirthDate());
			psmt.setString(4, emp.getPhoto());
			psmt.setString(5, emp.getNote());
			int rs = psmt.executeUpdate();
			System.out.println((rs==1) ? "입력성공" : "입력실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Override
	public List<EmployeeDTO> selectEmployeeList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDTO> selectEmployees(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDTO selectEmployee(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existsEmployee(EmployeeDTO emp) {
		boolean res = false;
		try {
			String sql = String.format(EmployeeSQL.ACCESS.toString());
			PreparedStatement psmt = DatabaseFactory.createDatabase(Vendor.ORACLE)
										.getConnection().prepareStatement(sql);
			psmt.setString(1, emp.getEmployeeID());
			psmt.setString(2, emp.getName());
			ResultSet rs = psmt.executeQuery();
			if(rs.next()) {
				res = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void updateEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(EmployeeDTO emp) {
		// TODO Auto-generated method stub
		
	}

}
