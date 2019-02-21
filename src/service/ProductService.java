package service;

import java.util.List;
import domain.ProductDTO;

public interface ProductService {
	public void registProduct(ProductDTO pro);
	public List<ProductDTO> bringProductList();
	public List<ProductDTO> retrieveProducts(String searchWord);
	public ProductDTO retrieveProduct(ProductDTO pro);
	public int countProduct();
	public void modifyProduct(ProductDTO pro);
	public void removeProduct(ProductDTO pro);
}
