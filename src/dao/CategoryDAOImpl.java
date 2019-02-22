package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CategoryDTO;
import enums.CategorySQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CategoryDAOImpl implements CategoryDAO{
	private static CategoryDAOImpl instance = new CategoryDAOImpl();
	Connection conn ;
	private CategoryDAOImpl() {conn = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();}
	public static CategoryDAOImpl getInstance() {return instance;}
	
	@Override
	public void insertCategory(CategoryDTO cat) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
			int rs = ps.executeUpdate();
			System.out.println((rs==1)?"입력성공" : "입력실패");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<?> selectCategoryList(Proxy pxy) {
		List<CategoryDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement ps =conn.prepareStatement(sql);
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
	public List<?> selectCategoris(Proxy pxy) {
		List<CategoryDTO> list = new ArrayList<>();
		CategoryDTO cate = null;
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			String sql = CategorySQL.LIST.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(page.getStartRow()));
			ps.setString(2, String.valueOf(page.getEndRow()));
			System.out.println("스타트 페이지"+page.getStartRow());
			System.out.println("엔드 페이지"+page.getEndRow());
			System.out.println("SQL실행문"+sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				cate = new CategoryDTO();
				cate.setCategoryID(rs.getString("CATEGORY_ID"));
				cate.setCategoryName(rs.getString("CATEGORY_NAME"));
				cate.setDescription(rs.getString("DESCRIPTION"));
				list.add(cate);
			}
		} catch (Exception e) {
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
	public int countCategory(Proxy pxy) {
		int count = 0;
		try {
			String sql = CategorySQL.COUNT.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				count = rs.getInt("COUNT");
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
