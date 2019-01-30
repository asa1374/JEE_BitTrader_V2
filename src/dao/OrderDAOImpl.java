package dao;

import java.util.List;

import domain.OrderDTO;

public class OrderDAOImpl implements OrderDAO{
	private static OrderDAOImpl instance = new OrderDAOImpl();
	private OrderDAOImpl() {}
	public static OrderDAOImpl getInstance() {return instance;}
	@Override
	public void registOrder(OrderDTO or) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDTO> bringOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDTO> retrieveOrders(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDTO retrieveOrder(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyOrder(String searchWord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(String searchWord) {
		// TODO Auto-generated method stub
		
	}

}
