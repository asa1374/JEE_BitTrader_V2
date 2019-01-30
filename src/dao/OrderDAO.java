package dao;

import java.util.List;

import domain.OrderDTO;

public interface OrderDAO {
	public void registOrder(OrderDTO or);
	public List<OrderDTO> bringOrderList();
	public List<OrderDTO> retrieveOrders(String searchWord);
	public OrderDTO retrieveOrder(String searchWord);
	public int countOrder();
	public void modifyOrder(String searchWord);
	public void removeOrder(String searchWord);
}
