<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">상품 목록</font></h1>
</div>
<div class="grid-item" id="content">
	<div class="pro_list">
		<div id="pro_search"><input type="text" placeholder="검색할 단어입력"/>
			<span class="glyphicon glyphicon-search"></span>
			<button type="button" class="btn btn-default btn-lg" id="confirm_btn">
				<span class="glyphicon glyphicon-ok" aria-hidden="true">등록</span> 
			</button>
		</div>
		<div id="pro_list">
			<table style="margin-left: auto;  margin-right: auto;">
				<tr>
					<th>상품 번호</th>
					<th>상품 이름</th>
					<th>제조사</th>
					<th>카테고리 이름</th>
					<th>갯수</th>
					<th>가격</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${list}" var="prolist" >
					<tr>
						<th>${prolist.productID}</th>
						<th>${prolist.productName}</th>
						<th>${prolist.supplierID}</th>
						<th>${prolist.categoryID}</th>
						<th>${prolist.unit}</th>
						<th>${prolist.price}</th>
						<th>
						<a href="${ctx}/product.do?cmd=pro_update&page=update&productID=${prolist.productID}">수정</a> 
						</th>
						<th>
						<a href="${ctx}/product.do?cmd=pro_delete&page=list&productID=${prolist.productID}">삭제</a>
						</th>
					</tr>
				</c:forEach>
			</table>
			<div style="height: 50px"></div>
			<form id="list_form">
				<div class="center">
				  <div class="pagination">
				  <c:if test="${pagination.existPrev }">
					  <a href='${ctx}/customer.do?cmd=cus_list&page=list&page_size=5&page_num=${pagination.prevBlock}' >&laquo;</a>
				  </c:if>
				  <c:forEach begin="${pagination.startPage }" end="${pagination.endPage }" varStatus="status" >
					  <c:choose>
					  	<c:when test="${pagination.pageNum eq status.index }">
					  		<a href="#" class="page active">${status.index }</a>
					  	</c:when>
					  	<c:otherwise>
					  		<a href="#" class="page">${status.index }</a>
					  	</c:otherwise>	
					  </c:choose>
					  
				  </c:forEach>
				  <c:if test="${pagination.existnext }">
					  <a href='${ctx}/customer.do?cmd=cus_list&page=list&page_size=5&page_num=${pagination.nextBlock}' class="posblock">&raquo;</a>
				  </c:if>
				  </div>
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('.page').each(function( index ){
	$(this).click(function(){	
		location.assign('${ctx}/product.do?cmd=pro_list&page=list&page_size=5&page_num='+$(this).text());
	});
});

$('#confirm_btn').click(function( index ){
	location.assign('${ctx}/product.do?cmd=move&page=proregi');
});

$('#update_btn').click(function(){
	location.assign('${ctx}/product.do?cmd=pro_update&page=update&productID=${prolist.productID}');
});

</script>