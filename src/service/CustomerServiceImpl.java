package service;

import java.util.List;
import java.util.Map;

import dao.CustomerDAOImpl;
import domain.CustomerDTO;
import proxy.Proxy;

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
	public List<CustomerDTO> bringCustomerList(Proxy pxy) {
		return dao.bringCustomerList(pxy);
	}

	@Override
	public List<CustomerDTO> retrieveCategoris(Proxy pxy) {
		return dao.selectCategoris(pxy);
	}

	@Override
	public CustomerDTO retrieveCustomer(CustomerDTO cus) {
		return dao.selectCustomer(cus);
	}

	@Override
	public int countCustomer(Proxy pxy) {
		return dao.countCustomer(pxy);
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
	@Override
	public Map<String, Object> retreivePhone(Proxy pxy) {
		
		return dao.selectPhone(pxy);
	}

}
