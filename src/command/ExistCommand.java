package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class ExistCommand extends Command{
	public ExistCommand(HttpServletRequest request,HttpServletResponse response) {
		super(request, response);
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeeDTO emp = new EmployeeDTO();
			emp.setEmployeeID(request.getParameter("empno"));
			emp.setName(request.getParameter("name"));
			boolean exitst = EmployeeServiceImpl.getInstance().existsEmployee(emp);
			if(exitst) {
				System.out.println("접속 허용");
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
			exitst = CustomerServiceImpl.getInstance().existCustomer(cus);
			if(exitst) {
				System.out.println("접속허용");
			}else {
				System.out.println("접속불가");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			break;
		default:
			break;
		}
	}
}
