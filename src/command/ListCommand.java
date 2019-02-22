package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import domain.CategoryDTO;
import domain.CustomerDTO;
import domain.ProductDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;

public class ListCommand extends Command{
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		Proxy paging = new Pagination();
		paging.carryOut(request);
		Proxy pagePxy = new PageProxy();
		pagePxy.carryOut(paging);
		List<?> list = new ArrayList<>();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUS_LIST:
			list = CustomerServiceImpl.getInstance().bringCustomerList(pagePxy);
			
			break;
		case PRO_LIST: 
			list = ProductServiceImpl.getInstance().bringProductList(pagePxy);
			break;
		case CATE_LIST:
			list = CategoryServiceImpl.getInstance().bringCategoryList(pagePxy);
			break;
		default:
			break;
		}
		request.setAttribute("list", list);
		request.setAttribute("pagination", paging);
	}
}
