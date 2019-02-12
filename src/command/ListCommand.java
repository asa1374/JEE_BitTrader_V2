package command;


import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import enums.Action;
import proxy.Proxy;
import service.CustomerServiceImpl;

public class ListCommand extends Command{
	public ListCommand(HttpServletRequest request,HttpServletResponse response) {
		super(request, response);
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUS_LIST:
			System.out.println("$$$$$$$$$$$$$LIST에서 page값"+request.getParameter("page"));
			System.out.println("$$$$$$$$$$$$$LIST에서 page_num값"+request.getParameter("page_num"));
			System.out.println("$$$$$$$$$$$$$LIST에서 page_size값"+request.getParameter("page_size"));
			List<CustomerDTO> list = CustomerServiceImpl.getInstance()
					.bringCustomerList(new Proxy().getPage());
			request.setAttribute("list", list);
			break;
			
		default:
			break;
		}
	}
}
