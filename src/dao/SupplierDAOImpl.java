package dao;

import java.util.List;

import domain.SupplierDTO;

public class SupplierDAOImpl implements SupplierDAO{
	private static SupplierDAOImpl instance = new SupplierDAOImpl();
	private SupplierDAOImpl() {}
	public static SupplierDAOImpl getInstance() {return instance;}
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
