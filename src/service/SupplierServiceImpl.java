package service;

import java.util.List;

import dao.SupplierDAOImpl;
import domain.SupplierDTO;

public class SupplierServiceImpl implements SupplierService{
	private static SupplierServiceImpl instance = new SupplierServiceImpl();
	private SupplierServiceImpl() {dao = SupplierDAOImpl.getInstance();}
	public static SupplierServiceImpl getInstance() {return instance;}
	SupplierDAOImpl dao;
	@Override
	public void registSupplier(SupplierDTO sup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<SupplierDTO> bringSupplierList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SupplierDTO> retrieveSuppliers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SupplierDTO retrieveSupplier(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countSupplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifySupplier(SupplierDTO sup) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeSupplier(SupplierDTO sup) {
		// TODO Auto-generated method stub
		
	}

}
