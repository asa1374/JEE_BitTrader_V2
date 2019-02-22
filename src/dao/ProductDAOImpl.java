package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.ProductDTO;
import enums.ProductSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class ProductDAOImpl implements ProductDAO{
	private static ProductDAOImpl instance = new ProductDAOImpl();
	Connection conn;
	private ProductDAOImpl() {conn = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();}
	public static ProductDAOImpl getInstance() {return instance;}
	
	@Override
	public void registProduct(ProductDTO pro) {
		try {
			String sql = ProductSQL.REGISTER.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getProductName());
			ps.setString(2, pro.getSupplierID());
			ps.setString(3, pro.getCategoryID());
			ps.setString(4, pro.getUnit());
			ps.setString(5, pro.getPrice());
			int i= ps.executeUpdate();
			if(i==1) {
				System.out.println("상품등록 성공");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ProductDTO> bringProductList(Proxy pxy) {
		List<ProductDTO> list = new ArrayList<>();
		ProductDTO pro = null;
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			String sql = ProductSQL.LIST.toString();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, String.valueOf(page.getStartRow()));
			ps.setString(2, String.valueOf(page.getEndRow()));
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				pro = new ProductDTO();
				pro.setCategoryID(rs.getString("CATEGORY_ID"));
				pro.setPrice(rs.getString("PRICE"));
				pro.setProductID(rs.getString("PRODUCT_ID"));
				pro.setProductName(rs.getString("PRODUCT_NAME"));
				pro.setSupplierID(rs.getString("SUPPLIER_ID"));
				pro.setUnit(rs.getString("UNIT"));
				list.add(pro);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductDTO> retrieveProducts(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDTO retrieveProduct(ProductDTO pro) {
		ProductDTO respro = null;
		try {
			String sql = "select * from products where PRODUCT_ID like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, pro.getProductID());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				respro = new ProductDTO();
				respro.setCategoryID(rs.getString("CATEGORY_ID"));
				respro.setPrice(rs.getString("PRICE"));
				respro.setProductID(rs.getString("PRODUCT_ID"));
				respro.setProductName(rs.getString("PRODUCT_NAME"));
				respro.setSupplierID(rs.getString("SUPPLIER_ID"));
				respro.setUnit(rs.getString("UNIT"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respro;
	}

	@Override
	public int countProduct(Proxy pxy) {
		int count = 0;
		try {
			String sql = "select count(*) count from products";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public void modifyProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeProduct(ProductDTO pro) {
		// TODO Auto-generated method stub
		
	}

}
