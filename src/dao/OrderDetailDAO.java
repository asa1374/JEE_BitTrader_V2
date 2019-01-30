package dao;

import java.util.List;

import domain.OrderDetailDTO;

public interface OrderDetailDAO {
	public void registOrderDetail(OrderDetailDTO ord);
	public List<OrderDetailDTO> bringOrderDetailList();
	public List<OrderDetailDTO> retrieveOrderDetails(String searchWord);
	public OrderDetailDTO retrieveOrderDetail(String searchWord);
	public int countOrderDetail();
	public void modifyOrderDetail(String searchWord);
	public void removeOrderDetail(String searchWord);
}
