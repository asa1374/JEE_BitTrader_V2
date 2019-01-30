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
			cmd = new MoveCommand(request,response);
			break;
		case LOGIN :
			cmd = new LoginCommand(request,response);
			break;
		default:
			break;
		}
		return cmd;
	}
}
