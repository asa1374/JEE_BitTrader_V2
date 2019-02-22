package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import domain.ProductDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;
import service.ProductServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case REGISTER :
			EmployeeDTO emp = new EmployeeDTO();
			emp.setName(request.getParameter("name"));
			emp.setManager(request.getParameter("manager"));
			emp.setBirthDate(request.getParameter("birthday"));
			emp.setPhoto(request.getParameter("photo"));
			emp.setNote(request.getParameter("desc"));
			EmployeeServiceImpl.getInstance().registEmployee(emp);
			break;
		case SIGNUP :
			System.out.println("SIGNUP 등록중");
			CustomerDTO cus = new CustomerDTO();
			cus.setAddress(request.getParameter("addr"));
			cus.setCity(request.getParameter("city"));
			cus.setPassword(request.getParameter("password"));
			cus.setSsn(request.getParameter("ssn"));
			cus.setPhone(request.getParameter("phone"));
			cus.setCustomerID(request.getParameter("cusid"));
			cus.setCustomerName(request.getParameter("name"));
			cus.setPostalCode(request.getParameter("post"));
			CustomerServiceImpl.getInstance().resistCustomer(cus);
			break;
		case PRO_REGIST :
			ProductDTO pro = new ProductDTO();
			pro.setCategoryID(request.getParameter("categoryID"));
			pro.setPrice(request.getParameter("price"));
			pro.setProductName(request.getParameter("productName"));
			pro.setSupplierID(request.getParameter("supplierID"));
			pro.setUnit(request.getParameter("unit"));
			System.out.println(pro);
			ProductServiceImpl.getInstance().registProduct(pro);
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