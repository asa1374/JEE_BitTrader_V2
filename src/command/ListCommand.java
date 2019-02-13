package command;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import domain.CustomerDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class ListCommand extends Command{
	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUS_LIST:
			Proxy paging = new Pagination();
			paging.carryOut(request);
			Proxy pagePxy = new PageProxy();
			pagePxy.carryOut(paging);
			List<CustomerDTO> list = CustomerServiceImpl.getInstance()
					.bringCustomerList(pagePxy);
			request.setAttribute("list", list);
			break;
			
		default:
			break;
		}
	}
}
