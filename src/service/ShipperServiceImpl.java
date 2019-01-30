package service;

import java.util.List;

import dao.ShipperDAO;
import dao.ShipperDAOImpl;
import domain.ShipperDTO;

public class ShipperServiceImpl implements ShipperService{
	private static ShipperServiceImpl instance = new ShipperServiceImpl();
	private ShipperServiceImpl() {dao = ShipperDAOImpl.getInstance();}
	public static ShipperServiceImpl getInstance() {return instance;}
	
	ShipperDAO dao;
	
	@Override
	public void registShipper(ShipperDTO ship) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShipperDTO> bringShipperList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShipperDTO> retrieveShippers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShipperDTO retrieveShipper(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countShipper() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyShipper(ShipperDTO ship) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeShipper(ShipperDTO ship) {
		// TODO Auto-generated method stub
		
	}

}
