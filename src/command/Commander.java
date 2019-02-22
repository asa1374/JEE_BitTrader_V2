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
		case REGISTER : case SIGNUP : case PRO_REGIST :
			cmd = new CreateCommand(pxy);
			break;
		case ACCESS : case SIGNIN :
			cmd = new ExistCommand(pxy);
			break;
		case CUS_LIST : case PRO_LIST : case CATE_LIST:
			cmd = new ListCommand(pxy);
			break;
		case CUST_RETRIEVE :
			cmd = new RetrieveCommand(pxy);
			break;
		case CUS_UPDATE : case PRO_UPDATE:
			cmd = new UpdateCommand(pxy);
			break;
		case CUS_FILE_UPLOAD :
			cmd = new FileCommand(pxy);
			break;
		case CUST_DELETE :
			cmd = new DeleteCommand(pxy);
			break;
		default:
			break;
		}
		return cmd;
	}
}
