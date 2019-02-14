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
		
		startRow = pageSize*(pageNum-1)+1;
		endRow = pageNum * pageSize;
		endRow = (totalCount > endRow)?endRow:totalCount;
		
		pageCount = totalCount/pageSize;
		if(totalCount%pageSize!=0) {
			pageCount++;
		}
		existPrev = (blockSize>=pageNum)?false:true;
		existnext = (pageCount<=pageNum)?false:true;
		System.out.println("프리 익짓" + existPrev);
		System.out.println("넥스트 잇짓" + existnext);
		System.out.println("블록 사이즈"+ blockSize);
		if(startPage<=pageCount&&pageCount<=endPage) {
			blockSize = totalCount%pageSize;
		}
		if(existPrev) {
			startPage = pageNum;
			endPage =startPage+blockSize-1;
			if(endPage>pageCount) {
				endPage = pageCount;
			}
		}else {
			startPage =1;
			endPage =startPage+blockSize-1;
		}
		if(startPage==pageCount) {
			endPage = pageCount;
		}
		System.out.println("스타트 페이지"+startPage);
		System.out.println("엔드 페이지"+endPage);
		prevBlock = startPage - pageSize;
		nextBlock = startPage + pageSize;
		System.out.println("프리 블락 "+ prevBlock);
		System.out.println("넥스트 블락 "+ nextBlock);

	}
}
