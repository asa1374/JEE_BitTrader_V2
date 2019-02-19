package dao;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageDAO {
	public void createImage(ImageDTO img);
	public List<ImageDTO> selectimageList(Proxy pxy);
	public List<ImageDTO> selectImages(Proxy pxy);
	public ImageDTO selectImage(ImageDTO img);
	public String lastImageSeq();
	public int countImage(Proxy pxy);
	public void updateImage(Proxy pxy);
	public void deleteImage(Proxy pxy);
}
