package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {
	public void resistCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList();
	public List<CustomerDTO> retrieveCategoris(String searchWord);
	public CustomerDTO retrieveCustomer(String searchWord);
	public int countCustomer();
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
