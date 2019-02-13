package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Proxy{
	private int pageNum, pageSize, blockSize,totalCount,
				startRow,endRow,startPage,endPage,prevBlock,nextBlock,pageCount;
	private boolean existPrev, existnext;
	@Override
	public void carryOut(Object o) {
		HttpServletRequest request = (HttpServletRequest)o;
		System.out.println("request " + request.getParameter("page_size"));
		pageSize = (request.getParameter("page_size")==null)?5:Integer.parseInt(request.getParameter("page_size"));
		pageNum = (request.getParameter("page_num")==null)?1:Integer.parseInt(request.getParameter("page_num"));
		blockSize = (request.getParameter("block_size")==null)?5:Integer.parseInt(request.getParameter("block_size"));
		totalCount = CustomerServiceImpl.getInstance().countCustomer(null);
		if(totalCount%pageSize!=0) {
			pageCount = totalCount/pageSize+1;
			if(pageNum==pageCount) {
				pageSize = totalCount%pageSize;
			}
			startRow = (pageSize*pageNum)-(pageSize-1);
			endRow = startRow+(pageSize-1);
		}else {
			pageCount = totalCount/pageSize;
			startRow = (pageSize*pageNum)-(pageSize-1);
			endRow = startRow+(pageSize-1);
		}
		System.out.println("pageNumpageNum"+pageNum);
	}
}
