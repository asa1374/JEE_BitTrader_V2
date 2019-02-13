package dao;

import java.util.List;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerDAO {
	public void resistCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList(Proxy pxy);
	public List<CustomerDTO> selectCategoris(Proxy pxy);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public int countCustomer(Proxy pxy);
	public boolean existCustomerID(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
