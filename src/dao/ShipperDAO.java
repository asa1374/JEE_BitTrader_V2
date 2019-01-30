package dao;

import java.util.List;

import domain.ShipperDTO;

public interface ShipperDAO {
	public void registShipper(ShipperDTO ship);
	public List<ShipperDTO> bringShipperList();
	public List<ShipperDTO> retrieveShippers(String searchWord);
	public ShipperDTO retrieveShipper(String searchWord);
	public int countShipper();
	public void modifyShipper(String searchWord);
	public void removeShipper(String searchWord);
}
