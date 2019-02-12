package service;

import java.util.List;

import domain.CustomerDTO;
import proxy.Pagination;

public interface CustomerService {
	public void resistCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList(Pagination page);
	public List<CustomerDTO> retrieveCategoris(String searchWord);
	public CustomerDTO retrieveCustomer(CustomerDTO cus);
	public int countCustomer();
	public boolean existCustomerID(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
