package controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import domain.EmployeeDTO;
import enums.Action;
import service.EmployeeService;
import service.EmployeeServiceImpl;

@WebServlet("/employee.do")
public class EmployeeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	EmployeeService service = EmployeeServiceImpl.getInstance();
	
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("====1.컨트롤러====");
		Receiver.init(request, response);
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE:
			System.out.println("====무브====");
			Carrier.forward(request, response);
			break;
		case REGISTER :
			System.out.println("*******2.레지스터");
			EmployeeDTO emp = new EmployeeDTO();
			emp.setName(request.getParameter("name"));
			emp.setManager(request.getParameter("manager"));
			emp.setBirthDate(request.getParameter("birthday"));
			emp.setPhoto(request.getParameter("photo"));
			emp.setNote(request.getParameter("desc"));
			service.registEmployee(emp);
			Carrier.forward(request, response);
			break;

		default:
			break;
			
		}
	}
	
}