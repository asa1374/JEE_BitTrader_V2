package proxy;

import javax.servlet.http.HttpServletResponse;

import lombok.Data;

@Data
public class ResponeseProxy implements Proxy{
	private HttpServletResponse response;
	@Override
	public void carryOut(Object o) {
		System.out.println("====4.respon 진입====");
		setResponse((HttpServletResponse) o);
	}
	
}
