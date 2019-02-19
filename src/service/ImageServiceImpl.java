package service;

import java.util.List;

import dao.ImageDAO;
import dao.ImageDAOImpl;
import domain.ImageDTO;
import proxy.Proxy;

public class ImageServiceImpl implements ImageService{
	private static ImageServiceImpl instance = new ImageServiceImpl();
	ImageDAO dao;
	private ImageServiceImpl() { dao=ImageDAOImpl.getInstance();}
	public static ImageServiceImpl getInstance() {return instance;}

	@Override
	public void addImage(ImageDTO img) {
		dao.createImage(img);
	}

	@Override
	public List<ImageDTO> imageList(Proxy pxy) {
		return dao.selectimageList(pxy);
	}

	@Override
	public List<ImageDTO> searchImage(Proxy pxy) {
		return dao.selectImages(pxy);
	}

	@Override
	public ImageDTO oneImage(ImageDTO img) {
		return dao.selectImage(img);
	}

	@Override
	public int countImage(Proxy pxy) {
		return dao.countImage(pxy);
	}

	@Override
	public void modifiedImage(Proxy pxy) {
		dao.updateImage(pxy);
	}

	@Override
	public void removeImage(Proxy pxy) {
		dao.deleteImage(pxy);
	}

}
