package dao;

import java.util.List;

import domain.ShipperDTO;

public class ShipperDAOImpl implements ShipperDAO{
	private static ShipperDAOImpl instance = new ShipperDAOImpl();
	private ShipperDAOImpl() {}
	public static ShipperDAOImpl getInstance() {return instance;}
	
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
	public void modifyShipper(String searchWord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeShipper(String searchWord) {
		// TODO Auto-generated method stub
		
	}

}
