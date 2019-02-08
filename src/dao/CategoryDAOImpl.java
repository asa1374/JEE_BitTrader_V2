package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryDTO;
import enums.Vendor;
import factory.DatabaseFactory;

public class CategoryDAOImpl implements CategoryDAO{
	private static CategoryDAOImpl instance = new CategoryDAOImpl();
	private CategoryDAOImpl() {}
	public static CategoryDAOImpl getInstance() {return instance;}
	
	@Override
	public void insertCategory(CategoryDTO cat) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
					.prepareStatement(sql);
			int rs = ps.executeUpdate();
			System.out.println((rs==1)?"입력성공" : "입력실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<CategoryDTO> selectCategoryList() {
		List<CategoryDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement ps =
					DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				list.add(null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CategoryDTO> selectCategoris(String searchWord) {
		List<CategoryDTO> list = null;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection().prepareStatement(sql);
			ps.setString(1, "");
			while(ps.executeQuery().next()) {
				list = new ArrayList<>();
				list.add(null);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public CategoryDTO selectCategory(String searchWord) {
		CategoryDTO cus = null;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
					.getConnection().prepareStatement(sql);
			ps.setString(1,"");
			while(ps.executeQuery().next()) {
				cus = new CategoryDTO();
				cus.setCategoryID("");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cus;
	}
	
	@Override
	public int countCategory() {
		int count = 0;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection().prepareStatement(sql);
			ps.setString(1,"");
			
			while(ps.executeQuery().next()) {
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public void updateCategory(CategoryDTO cat) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory.createDatabase(Vendor.ORACLE)
			.getConnection().prepareStatement(sql);
			ps.setString(1, "");
			 ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCategory(CategoryDTO cat) {
		
	}


}
