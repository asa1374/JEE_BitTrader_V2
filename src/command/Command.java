package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Data;

@Data
public class Command implements Order{
	protected HttpServletRequest request;
	protected String action,domain,page,view;
	public Command() {}
	
	public Command(HttpServletRequest request,HttpServletResponse response) {
		setRequest(request);
		execute();	
	}
	
	@Override
	public void execute() {
		this.setAction(request.getParameter("cmd"));
		this.setDomain(request.getServletPath().split("/")[1].replace(".do", ""));
		this.setPage(request.getParameter("page"));
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
	}
}
