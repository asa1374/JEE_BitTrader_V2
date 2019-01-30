package service;

import java.util.List;

import domain.ShipperDTO;

public interface ShipperService {
	public void registShipper(ShipperDTO ship);
	public List<ShipperDTO> bringShipperList();
	public List<ShipperDTO> retrieveShippers(String searchWord);
	public ShipperDTO retrieveShipper(String searchWord);
	public int countShipper();
	public void modifyShipper(ShipperDTO ship);
	public void removeShipper(ShipperDTO ship);
	
}
