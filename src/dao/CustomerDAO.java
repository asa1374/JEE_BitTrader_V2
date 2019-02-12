package dao;

import java.util.List;

import domain.CustomerDTO;
import proxy.Pagination;

public interface CustomerDAO {
	public void resistCustomer(CustomerDTO cus);
	public List<CustomerDTO> bringCustomerList(Pagination page);
	public List<CustomerDTO> selectCategoris(String searchWord);
	public CustomerDTO selectCustomer(CustomerDTO cus);
	public int countCustomer();
	public boolean existCustomerID(CustomerDTO cus);
	public void modifyCustomer(CustomerDTO cus);
	public void removeCustomer(CustomerDTO cus);
}
