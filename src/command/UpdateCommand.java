package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ProductDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;

public class UpdateCommand extends Command{
	public UpdateCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUS_UPDATE:
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
			break;
		case PRO_UPDATE :
			ProductDTO pro = new ProductDTO();
			pro.setProductID(request.getParameter("productID"));
			pro = ProductServiceImpl.getInstance().retrieveProduct(pro);
			request.setAttribute("prolist", pro);
			
			Proxy paging = new Pagination();
			paging.carryOut(request);
			Proxy pagePxy = new PageProxy();
			pagePxy.carryOut(paging);
			List<?> prolist = ProductServiceImpl.getInstance().bringProductList(pagePxy);
			request.setAttribute("list", prolist);
			request.setAttribute("pagination", paging);
			break;
		default:
			break;
		}
		
	}
}
