package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomerServiceImpl;

@Data
public class Pagination implements Proxy{
	private int pageNum, pageSize, blockSize,totalCount,blockNum,
				startRow,endRow,startPage,endPage,prevBlock,nextBlock,pageCount;
	private boolean existPrev, existnext;
	@Override
	public void carryOut(Object o) {
		HttpServletRequest request = (HttpServletRequest)o;
		pageSize = (request.getParameter("page_size")==null)?5:Integer.parseInt(request.getParameter("page_size"));
		pageNum = (request.getParameter("page_num")==null)?1:Integer.parseInt(request.getParameter("page_num"));
		blockSize = (request.getParameter("block_size")==null)?5:Integer.parseInt(request.getParameter("block_size"));
		blockNum = (request.getParameter("block_num")==null)?0:Integer.parseInt(request.getParameter("block_num"));
		totalCount = CustomerServiceImpl.getInstance().countCustomer(null);
		
		startRow = pageSize*(pageNum-1)+1;
		endRow = pageNum * pageSize;
		endRow = (totalCount > endRow)?endRow:totalCount;
		pageCount = totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			pageCount++;
		}
		blockNum = (int)Math.floor((pageNum-1)/ blockSize);
		startPage = blockNum*blockSize+1;
		endPage = startPage+(blockSize-1);
		if(endPage>pageCount) {
			endPage=pageCount;
		}
		existPrev = (blockSize>=pageNum)?false:true;
		existnext = (pageCount<=(startPage + pageSize))?false:true;
		prevBlock = startPage - pageSize;
		nextBlock = startPage + pageSize;
	}
}
