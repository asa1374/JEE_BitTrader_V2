package service;

import java.util.List;

import domain.ImageDTO;
import proxy.Proxy;

public interface ImageService {
	public void addImage(ImageDTO img);
	public List<ImageDTO> imageList(Proxy pxy);
	public List<ImageDTO> searchImage(Proxy pxy);
	public ImageDTO oneImage(ImageDTO img);
	public int countImage(Proxy pxy);
	public void modifiedImage(Proxy pxy);
	public void removeImage(Proxy pxy);
}
