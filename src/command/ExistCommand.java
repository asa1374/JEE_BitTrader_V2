package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import proxy.PageProxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command{
	public ExistCommand(Map<String,Proxy> pxy) {
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		HttpSession session = request.getSession();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeID(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exitst = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if(exitst) {
				List<CustomerDTO> list = CustomerServiceImpl.getInstance().bringCustomerList(new PageProxy().getPage());
				request.setAttribute("list", list);
			}else {
				System.out.println("접속 불가");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			break;
		case SIGNIN :
			CustomerDTO cus = new CustomerDTO();
			cus.setCustomerID(request.getParameter("cusid"));
			cus.setPassword(request.getParameter("password"));
			cus = CustomerServiceImpl.getInstance().retrieveCustomer(cus);
			if(cus!=null) {
				System.out.println("로그인허용");
				session.setAttribute("customer", cus);
			}else {
				System.out.println("로그인불가");
				super.setDomain("customer");
				super.setPage("signin");
				super.execute();
			}
			break;
		default:
			break;
		}
	}
}
