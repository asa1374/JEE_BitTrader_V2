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
import enums.Vendor;
import factory.DatabaseFactory;

public class ProductDAOImpl implements ProductDAO{
	private static ProductDAOImpl instance = new ProductDAOImpl();
	Connection conn;
	private ProductDAOImpl() {conn = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();}
	public static ProductDAOImpl getInstance() {return instance;}
	@Override
	public void registProduct(ProductDTO pro) {
		try {
			String sql = "insert into Products(PRODUCT_ID,PRODUCT_NAME,SUPPLIER_ID,CATEGORY_ID,UNIT,PRICE)\n" + 
					"values(PRODUCT_ID.NEXTVAL,?,?,?,?,?)";
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
	public List<ProductDTO> bringProductList() {
		List<ProductDTO> list = new ArrayList<>();
		ProductDTO pro = null;
		try {
			String sql = "select * from products";
			PreparedStatement ps = conn.prepareStatement(sql);
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
	public List<ProductDTO> retrieveProducts(String searchWord) {
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
	public int countProduct() {
		// TODO Auto-generated method stub
		return 0;
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
