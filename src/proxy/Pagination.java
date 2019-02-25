package proxy;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import domain.CustomerDTO;
import domain.ProductDTO;
import enums.Action;
import lombok.Data;
import service.CategoryServiceImpl;
import service.CustomerServiceImpl;
import service.ProductServiceImpl;

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
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS : case CUS_LIST: 
			totalCount = CustomerServiceImpl.getInstance().countCustomer(null);
			break;
		case PRO_LIST: case PRO_REGIST :
			totalCount = ProductServiceImpl.getInstance().countProduct(null);
			break;	
		case CATE_LIST:
			totalCount = CategoryServiceImpl.getInstance().countCategory(null);
			break;
		default:
			break;
		}
		
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
		System.out.println(totalCount);
		System.out.println("pageCountpageCount"+pageCount);
		System.out.println("startPage + pageSize"+startPage + pageSize);
		System.out.println("프리"+existPrev);
		System.out.println(existnext);
	}
}
