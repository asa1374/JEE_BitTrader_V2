package dao;

import java.util.List;

import domain.ProductDTO;

public interface ProductDAO {
	public void registProduct(ProductDTO pro);
	public List<ProductDTO> bringProductList();
	public List<ProductDTO> retrieveProducts(String searchWord);
	public ProductDTO retrieveProduct(String searchWord);
	public int countProduct();
	public void modifyProduct(ProductDTO pro);
	public void removeProduct(ProductDTO pro);
}
