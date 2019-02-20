package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import dao.ImageDAOImpl;
import domain.CustomerDTO;
import domain.ImageDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class RetrieveCommand extends Command{
	public RetrieveCommand(Map<String,Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		CustomerDTO cust = new CustomerDTO();
		ImageDTO img = new ImageDTO();
		cust.setCustomerID(request.getParameter("customerID"));
		cust = CustomerServiceImpl.getInstance().retrieveCustomer(cust);
		img.setImgseq(cust.getPhoto());
		img = ImageDAOImpl.getInstance().selectImage(img);
		request.setAttribute("cust", cust);
		request.setAttribute("image", img);
	}
}
