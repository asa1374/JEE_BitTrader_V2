package service;

import java.util.List;

import domain.CustomerDTO;
import proxy.Proxy;

public interface CustomerService {
	public void resistCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList(Proxy pxy);
	public List<CustomerDTO> retrieveCategoris(Proxy pxy);
	public CustomerDTO retrieveCustomer(CustomerDTO cus);
	public int countCustomer(Proxy pxy);
	public boolean existCustomerID(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
