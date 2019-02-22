package dao;

import java.util.List;

import domain.CustomerDTO;
import domain.ProductDTO;
import proxy.Proxy;

public interface ProductDAO {
	public void registProduct(ProductDTO pro);
	public List<ProductDTO> bringProductList(Proxy pxy);
	public List<ProductDTO> retrieveProducts(Proxy pxy);
	public ProductDTO retrieveProduct(ProductDTO pro);
	public int countProduct(Proxy pxy);
	public void modifyProduct(ProductDTO pro);
	public void removeProduct(ProductDTO pro);
}
