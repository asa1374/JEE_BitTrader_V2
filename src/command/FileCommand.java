package command;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
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
			/* 1.파일업로드한 이미지를 insert 해야한다.
			 * 2.커스토머안에 photo에 대표이미지를 방금 인설트한 이미지로 바꿔야한다. 단 default_photo.jpg 로
			 * 되어있는 것을 이미지의 seq 값으로 바꾼다.
			 * 3. 이후 고객의 정보
			 * 4. 이미지에서 seq에 따른 이미지 정보 두개를 가져온다. 
			 * */
			Map<String,Object> map = CustomerServiceImpl.getInstance().fileUpload(ipxy);
			
			request.setAttribute("cust", map.get("cus"));
			request.setAttribute("image", map.get("img"));
			
			break;
		default:
			break;
		}
	}
}
