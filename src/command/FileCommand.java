package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ImageDTO;
import enums.Action;
import proxy.ImageProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomerServiceImpl;

public class FileCommand extends Command {

	public FileCommand(Map<String, Proxy> pxy) {
		super(pxy);
		RequestProxy req = (RequestProxy) pxy.get("req");
		HttpServletRequest request = req.getRequest();
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUS_FILE_UPLOAD:
			System.out.println("파일커멘드 진입");
			ImageProxy ipxy = new ImageProxy();
			ipxy.carryOut(request);
			/*ImageServiceImpl.getInstance().addImage(img);*/
			ImageDTO image = ipxy.getImg();
			CustomerDTO cus = new CustomerDTO();
			cus.setCustomerID(ipxy.getImg().getOwner());
			cus = CustomerServiceImpl.getInstance().retrieveCustomer(cus);
			//cus = CustomerServiceImpl.getInstance().fileUpload(ipxy);
			request.setAttribute("cust", cus);
			request.setAttribute("image", image);
			break;
		default:
			break;
		}
	}
}
