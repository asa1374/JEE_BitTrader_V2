package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import proxy.Proxy;
import proxy.RequestProxy;

@Data
public class Command implements Order{
	protected HttpServletRequest request;
	protected String action,domain,page,view;
	public Command() {}
	public Command(Map<String,Proxy> pxy) {
		System.out.println("-----Command-----6------------");
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		setAction((request.getParameter("cmd")==null)?"move":request.getParameter("cmd"));
		if(request.getParameter("dir")==null) {
			setDomain(request.getServletPath().split("/")[1].replace(".do", ""));
		}else {
			setDomain(request.getParameter("dir"));
		}
		setPage(request.getParameter("page"));
		execute();	
	}
	
	@Override
	public void execute() {
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
	}
}
