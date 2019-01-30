package dao;

import java.util.List;

import domain.OrderDetailDTO;

public class OrderDetailDAOImpl implements OrderDetailDAO{
	private static OrderDetailDAOImpl instance = new OrderDetailDAOImpl();
	private OrderDetailDAOImpl() {}
	public static OrderDetailDAOImpl getInstance() {return instance;}

	@Override
	public void registOrderDetail(OrderDetailDTO ord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrderDetailDTO> bringOrderDetailList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderDetailDTO> retrieveOrderDetails(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderDetailDTO retrieveOrderDetail(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrderDetail() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyOrderDetail(String searchWord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrderDetail(String searchWord) {
		// TODO Auto-generated method stub
		
	}

}
