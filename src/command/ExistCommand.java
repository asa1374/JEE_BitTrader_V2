package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import proxy.Pagination;
import proxy.Proxy;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command{
	public ExistCommand(HttpServletRequest request,HttpServletResponse response) {
		super(request, response);
		HttpSession session = request.getSession();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeID(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exitst = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if(exitst) {
				System.out.println("접속 허용");
				List<CustomerDTO> list = CustomerServiceImpl.getInstance().bringCustomerList(new Proxy().getPage());
				System.out.println("총 고객의 수 :" + list.size());
				System.out.println("가장 최근에 가입한 고객명 : " + list.get(0).getCustomerName());
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
