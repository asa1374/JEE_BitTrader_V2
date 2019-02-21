package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.ImageProxy;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CustomerDAOImpl implements CustomerDAO{
	private static CustomerDAOImpl instance = new CustomerDAOImpl();
	Connection conn;
	private CustomerDAOImpl() {
		conn = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();
	}
	public static CustomerDAOImpl getInstance() {return instance;}
	@Override
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
			ps.setString(8, cus.getPhone());
			int rs = ps.executeUpdate();
			System.out.println((rs==1)? "성공" : "실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public boolean existCustomerID(CustomerDTO cus) {
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
			e.printStackTrace();
		}
		return ok;
	}
	@Override
	public List<CustomerDTO> bringCustomerList(Proxy pxy) {
		List<CustomerDTO> list = new ArrayList<>();
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
									.getConnection().prepareStatement(CustomerSQL.LIST.toString());
			ps.setString(1, String.valueOf(page.getStartRow()));
			ps.setString(2, String.valueOf(page.getEndRow()));
			ResultSet rs = ps.executeQuery();
			CustomerDTO cus = null;
			while(rs.next()) {
				cus = new CustomerDTO();
					cus.setCount(rs.getString("RNUM"));
					cus.setAddress(rs.getString("ADDRESS"));
					cus.setCity(rs.getString("CITY"));
					cus.setCustomerID(rs.getString("CUSTOMER_ID"));
					cus.setCustomerName(rs.getString("CUSTOMER_NAME"));
					cus.setPhone(rs.getString("PHONE"));
					cus.setPostalCode(rs.getString("POSTAL_CODE"));
					cus.setSsn(rs.getString("SSN"));
					list.add(cus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CustomerDTO> selectCategoris(Proxy pxy) {
		return null;
	}

	@Override
	public CustomerDTO selectCustomer(CustomerDTO cus) {
		CustomerDTO cust = null;
		try {
			String pass = cus.getPassword();
			if(pass!=null) {
				PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
						.prepareStatement(CustomerSQL.SIGNIN.toString());
				ps.setString(1, cus.getCustomerID());
				ps.setString(2, cus.getPassword());
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					cust = new CustomerDTO();
					cust.setCustomerID(rs.getString("CUSTOMER_ID"));
					cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
					cust.setPassword(rs.getString("PASSWORD"));
					cust.setAddress(rs.getString("ADDRESS"));
					cust.setCity(rs.getString("CITY"));
					cust.setPostalCode(rs.getString("POSTAL_CODE"));
					cust.setSsn(rs.getString("SSN"));
					cust.setPhone(rs.getString("PHONE"));
					cust.setPhoto(rs.getString("PHOTO"));
				}
			}else {
				PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
						.prepareStatement(CustomerSQL.RETRIEVE.toString());
				ps.setString(1, cus.getCustomerID());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					cust = new CustomerDTO();
					cust.setCustomerID(rs.getString("CUSTOMER_ID"));
					cust.setCustomerName(rs.getString("CUSTOMER_NAME"));
					cust.setAddress(rs.getString("ADDRESS"));
					cust.setCity(rs.getString("CITY"));
					cust.setPostalCode(rs.getString("POSTAL_CODE"));
					cust.setSsn(rs.getString("SSN"));
					cust.setPhone(rs.getString("PHONE"));
					cust.setPhoto(rs.getString("PHOTO"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cust;
	}

	@Override
	public int countCustomer(Proxy pxy) {
		int res = 0;
		try {
			String count = CustomerSQL.COUNT.toString();
			PreparedStatement ps;
			ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(count);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				res = Integer.parseInt(rs.getString("COUNT"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		try {//1 password 2 phone 3 addr 4 city 5 postal_code 6 customerid
			String sql = CustomerSQL.UPDATE.toString();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ps.setString(1, cus.getPassword());
			ps.setString(2, cus.getPhone());
			ps.setString(3, cus.getAddress());
			ps.setString(4, cus.getCity());
			ps.setString(5, cus.getPostalCode());
			ps.setString(6, cus.getCustomerID());
			int a = ps.executeUpdate();
			if(a==1) {
				System.out.println("입력성공");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		
		try {
			String sql = "delete from customers where customer_id like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, cus.getCustomerID());
			int i = ps.executeUpdate();
			if(i==1) {
				System.out.println("삭제 성공");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Map<String, Object> selectPhone(Proxy pxy) {
		Map<String,Object> map = new HashMap<String, Object>();
		try {
			String sql = CustomerSQL.TEST.toString();
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			CustomerDTO cus = null;
			while(rs.next()) {
				cus = new CustomerDTO();
				String entry = rs.getString("customer_id");
				cus.setCustomerID(rs.getString("customer_id"));
				cus.setCustomerName(rs.getString("customer_name"));
				cus.setPhone(rs.getString("phone"));
				map.put(entry, cus);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
	public Map<String,Object> selectProfile(Proxy pxy) {
		Map<String,Object> map = new HashMap<String, Object>();
		CustomerDTO cus = new CustomerDTO();
		ImageDTO img = new ImageDTO();
		try {
			ImageProxy ipxy = (ImageProxy)pxy;
			ImageDAOImpl.getInstance().createImage((ipxy).getImg());
			String imgSeq = ImageDAOImpl.getInstance().lastImageSeq();
			
			String sql = "UPDATE CUSTOMERS SET PHOTO = ? WHERE CUSTOMER_ID LIKE ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, imgSeq);
			ps.setString(2, ipxy.getImg().getOwner());
			ps.executeUpdate();
			
			cus.setCustomerID(ipxy.getImg().getOwner());
			cus = selectCustomer(cus);
			map.put("cus", cus);
			String seq = cus.getPhoto();
			
			img.setImgseq(seq);
			img = ImageDAOImpl.getInstance().selectImage(img);
			map.put("img", img);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}
}
