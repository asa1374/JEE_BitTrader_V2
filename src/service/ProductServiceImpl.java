package service;

import java.util.List;

import dao.ProductDAOImpl;
import domain.ProductDTO;
import proxy.Proxy;

public class ProductServiceImpl implements ProductService{
	private static ProductServiceImpl instance = new ProductServiceImpl();
	private ProductServiceImpl() {dao = ProductDAOImpl.getInstance();}
	public static ProductServiceImpl getInstance() {return instance;}
	ProductDAOImpl dao;
	@Override
	public void registProduct(ProductDTO pro) {
		dao.registProduct(pro); 
	}

	@Override
	public List<ProductDTO> bringProductList(Proxy pxy) {
		return dao.bringProductList(pxy);
	}

	@Override
	public List<ProductDTO> retrieveProducts(Proxy pxy) {
		return null;
	}

	@Override
	public ProductDTO retrieveProduct(ProductDTO pro) {
		return dao.retrieveProduct(pro);
	}

	@Override
	public int countProduct(Proxy pxy) {
		return dao.countProduct(pxy);
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
