package dao;

import java.util.List;

import domain.CustomerDTO;

public interface CustomerDAO {
	public void resistCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList();
	public List<CustomerDTO> selectCategoris(String searchWord);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public int countCustomer();
	public boolean existCustomerID(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
