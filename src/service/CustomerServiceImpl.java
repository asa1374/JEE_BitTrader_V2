package service;

import java.util.List;

import dao.CustomerDAOImpl;
import domain.CustomerDTO;

public class CustomerServiceImpl implements CustomerService{
	private static CustomerServiceImpl instance = new CustomerServiceImpl();
	private CustomerServiceImpl() {dao = CustomerDAOImpl.getInstance();}
	public static CustomerServiceImpl getInstance() {return instance;}
	
	CustomerDAOImpl dao;
	@Override
	public void resistCustomer(CustomerDTO cus) {
		dao.resistCustomer(cus);	
	}

	@Override
	public List<CustomerDTO> bringCustomerList() {
		return dao.bringCustomerList();
	}

	@Override
	public List<CustomerDTO> retrieveCategoris(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cus) {
		return dao.selectCustomer(cus);
	}

	@Override
	public int countCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void modifyCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCustomer(CustomerDTO cus) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean existCustomerID(CustomerDTO cus) {
		boolean res = false;
		res = dao.existCustomerID(cus);
		if(res) {
			res = true;
		}
		return res;
	}

}
