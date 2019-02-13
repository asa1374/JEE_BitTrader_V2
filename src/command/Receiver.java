package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.Proxy;
import proxy.RequestProxy;
import proxy.ResponeseProxy;

public class Receiver {
	public static Command cmd = new Command();
	
	public static void init(HttpServletRequest request,HttpServletResponse response) {
		System.out.println("====2.리시버 진입====");
		RequestProxy req = new RequestProxy();
		ResponeseProxy resp = new ResponeseProxy();
		Map<String,Proxy> pxy = new HashMap<>();
		req.carryOut(request);
		resp.carryOut(response);
		pxy.put("req", req);
		pxy.put("resp", resp);
		cmd = Commander.order(pxy);
	}
}
