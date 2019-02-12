package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander {
	public static Command order(HttpServletRequest request,HttpServletResponse response) {
		Command cmd = null;
		System.out.println("====3.커멘더 진입====");
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case MOVE: 
			cmd = new Command(request,response);
			break;
		case REGISTER : case SIGNUP :
			System.out.println("커멘더에서 등록하는곳$$$$$$$$$$");
			cmd = new CreateCommand(request, response);
			break;
		case ACCESS : case SIGNIN :
			cmd = new ExistCommand(request, response);
			break;
		case CUS_LIST :
			cmd = new ListCommand(request, response);
			break;
		default:
			break;
		}
		return cmd;
	}
}
