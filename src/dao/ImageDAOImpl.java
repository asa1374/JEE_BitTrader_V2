package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			String sql = "insert into image(IMG_SEQ,IMGNAME,IMGEXTENTION,OWNER)" + 
									"values(IMG_SEQ.NEXTVAL,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, img.getImgName());
			ps.setString(2, img.getImgExtention());
			ps.setString(3, img.getOwner());
			int a = ps.executeUpdate();
			if(a==1) {
				System.out.println("@@@@@이미지 등록 성공");
			}
		} catch (Exception e) {
			
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
		ImageDTO resimg = new ImageDTO();
		try {
			String sql = "select * from image where img_seq like ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, img.getImgseq());
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				resimg.setImgExtention(rs.getString("IMGEXTENTION"));
				resimg.setImgName(rs.getString("IMGNAME"));
				resimg.setImgseq(rs.getString("IMG_SEq"));
				resimg.setOwner(rs.getString("OWNER"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resimg;
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
		String seq = "";
		try {
			String sql = "select max(img_seq) maximage from image";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				seq = rs.getString("MAXIMAGE");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return seq;
	}

}
