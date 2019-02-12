package proxy;

import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Capable{
	private String pageNum, pageSize, blockSize,
				startRow,endRow,startPage,endPage,prevBlock,nextBlock;
	private int totalCount;
	private boolean existPrev, existnext;
	@Override
	public void carryOut() {
		HttpServletRequest request = Receiver.cmd.getRequest();
		System.out.println("request " + request.getParameter("page_size"));
		this.pageSize = (request.getParameter("page_size")==null)?"5":request.getParameter("page_size");
		this.pageNum = (request.getParameter("page_num")==null)?"1":request.getParameter("page_num");
		this.totalCount = CustomerServiceImpl.getInstance().countCustomer();
		this.startRow = String.valueOf(totalCount - (Integer.parseInt(pageSize)*(Integer.parseInt(pageNum)-1)));
		this.endRow = String.valueOf(totalCount - (Integer.parseInt(pageSize)*Integer.parseInt(pageNum))+1);
	}
}
