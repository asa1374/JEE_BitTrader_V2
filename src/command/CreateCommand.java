package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomerDTO;
import domain.EmployeeDTO;
import enums.Action;
import service.CustomerServiceImpl;
import service.EmployeeServiceImpl;

public class CreateCommand extends Command{
	public CreateCommand(HttpServletRequest request,HttpServletResponse response) {
		super(request, response);
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
			cus.setCustomerID(request.getParameter("cusid"));
			cus.setCustomerName(request.getParameter("name"));
			cus.setPostalCode(request.getParameter("post"));
			CustomerServiceImpl.getInstance().resistCustomer(cus);
			break;
		default:
			break;
		}
		
	}
}