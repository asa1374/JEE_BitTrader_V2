package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import domain.ImageDTO;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO{

	private static ImageDAOImpl instance = new ImageDAOImpl();
	Connection conn;
	public ImageDAOImpl() {
		conn = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection();
	}
	public static ImageDAOImpl getInstance() {return instance;}

	@Override
	public void createImage(ImageDTO img) {
		try {
			String sql = "";
			PreparedStatement ps = conn.prepareStatement(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ImageDTO> selectimageList(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ImageDTO> selectImages(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ImageDTO selectImage(ImageDTO img) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countImage(Proxy pxy) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateImage(Proxy pxy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteImage(Proxy pxy) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public String lastImageSeq() {
		// TODO Auto-generated method stub
		return null;
	}

}
