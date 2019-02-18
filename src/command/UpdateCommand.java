package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		CustomerDTO cus = new CustomerDTO();
		cus.setCustomerID(request.getParameter("customer_ID"));
		cus = CustomerServiceImpl.getInstance().retrieveCustomer(cus);
		System.out.println("수정전에 회원의 정보"+cus.toString());
		cus.setPhone((request.getParameter("phone").equals(""))? cus.getPhone() : request.getParameter("phone"));
		cus.setPostalCode((request.getParameter("postalCode").equals(""))?cus.getPostalCode():request.getParameter("postalCode"));
		cus.setCity((request.getParameter("city").equals(""))?cus.getCity():request.getParameter("city"));
		cus.setAddress((request.getParameter("address").equals(""))?cus.getAddress():request.getParameter("address"));
		cus.setPassword((request.getParameter("password").equals(""))?cus.getPassword():request.getParameter("password"));
		System.out.println("수정하려는 회원의 정보"+cus.toString());
		CustomerServiceImpl.getInstance().modifyCustomer(cus);
		cus = CustomerServiceImpl.getInstance().retrieveCustomer(cus);
		request.setAttribute("cust", cus);
	}
}
