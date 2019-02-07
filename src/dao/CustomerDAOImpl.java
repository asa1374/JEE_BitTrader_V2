package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.CustomerDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class CustomerDAOImpl implements CustomerDAO{
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	private CustomerDAOImpl() {}
	public static CustomerDAOImpl getInstance() {return instance;}
	@Override
	//customerID,customerName,password,address,city,postalCode,ssn
	public void resistCustomer(CustomerDTO cus) {
		try {
			String sql = CustomerSQL.SIGNUP.toString();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, cus.getCustomerID());
			ps.setString(2, cus.getCustomerName());
			ps.setString(3, cus.getPassword());
			ps.setString(4, cus.getAddress());
			ps.setString(5, cus.getCity());
			ps.setString(6, cus.getPostalCode());
			ps.setString(7, cus.getSsn());
			int rs = ps.executeUpdate();
			System.out.println((rs==1)? "성공" : "실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public boolean existCustomer(CustomerDTO cus) {
		boolean ok = false;
		try {
			String sql = CustomerSQL.SIGNIN.toString();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
							.getConnection().prepareStatement(sql);
			System.out.println("실행할 쿼리:" + sql);
			ps.setString(1,cus.getCustomerID());
			ps.setString(2, cus.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ok = true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ok;
	}
	@Override
	public List<CustomerDTO> bringCustomerList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomerDTO> retrieveCategoris(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retrieveCustomer(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}


}
