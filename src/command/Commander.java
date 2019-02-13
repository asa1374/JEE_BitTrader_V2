package command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;

public class Commander {
	public static Command order(Map<String,Proxy> pxy) {
		System.out.println("---Commander--5------------");
		Command cmd = null;
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case MOVE: 
			cmd = new Command(pxy);
			break;
		case REGISTER : case SIGNUP :
			System.out.println("커멘더에서 등록하는곳$$$$$$$$$$");
			cmd = new CreateCommand(pxy);
			break;
		case ACCESS : case SIGNIN :
			cmd = new ExistCommand(pxy);
			break;
		case CUS_LIST :
			cmd = new ListCommand(pxy);
			break;
		default:
			break;
		}
		return cmd;
	}
}
