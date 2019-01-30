package service;

import java.util.List;

import dao.OrderDetailDAOImpl;
import domain.OrderDetailDTO;

public class OrderDetailServiceImpl implements OrderDetailService{
	private static OrderDetailServiceImpl instance = new OrderDetailServiceImpl();
	private OrderDetailServiceImpl() {dao = OrderDetailDAOImpl.getInstance();}
	public static OrderDetailServiceImpl getInstance() {return instance;}
	OrderDetailDAOImpl dao ;
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
	public void modifyOrderDetail(OrderDetailDTO ord) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrderDetail(OrderDetailDTO ord) {
		// TODO Auto-generated method stub
		
	}

}
