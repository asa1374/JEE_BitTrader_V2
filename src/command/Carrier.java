package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.RequestProxy;
import proxy.ResponeseProxy;

public class Carrier {
	public static void forward(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		System.out.println("====6.케리어 진입====");
		RequestProxy req = new RequestProxy();
		ResponeseProxy resp = new ResponeseProxy();
		req.carryOut(request);
		resp.carryOut(response);
		System.out.println("Receiver의 뷰 정보"+ Receiver.cmd.getView());
		System.out.println("req.getRequest()   "+req.getRequest());
		System.out.println("resp.getResponse()  "+resp.getResponse());
		request.getRequestDispatcher(Receiver.cmd.getView()).forward(request, response);
	}
}
