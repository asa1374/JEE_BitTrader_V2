package service;

import java.util.List;

import dao.OrderDAOImpl;
import domain.OrderDTO;

public class OrderServiceimpl implements OrderService{
	private static OrderServiceimpl instance = new OrderServiceimpl();
	private OrderServiceimpl() {dao = OrderDAOImpl.getInstance();}
	public static OrderServiceimpl getInstance() {return instance;}
	OrderDAOImpl dao;
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
	public void modifyOrder(OrderDTO or) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(OrderDTO or) {
		// TODO Auto-generated method stub
		
	}

}
