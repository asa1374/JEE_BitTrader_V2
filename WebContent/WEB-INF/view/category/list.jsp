<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
 	<ul class="list-group" id="cate_side">
		<li class="list-group-item" style="background-color: #ddd" id="cate_list">카테고리 목록</li>
 		<li class="list-group-item" id="cate_reg">카테고리 등록</li>
  		<li class="list-group-item" id="cate_search">카테고리 조회</li>
  		<li class="list-group-item" id="cate_update">카테고리 수정</li>
  		<li class="list-group-item" id="cate_delete">카테고리 삭제</li>
	</ul>
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
					<th>카테고리 번호</th>
					<th>카테고리 이름</th>
					<th>설명</th>
					<th>수정</th>
					<th>삭제</th>
				</tr>
				<c:forEach items="${list}" var="catelist" >
					<tr>
						<th>${catelist.categoryID}</th>
						<th>${catelist.categoryName}</th>
						<th>${catelist.description}</th>
						<th>
						<a href="${ctx}/category.do?cmd=cate_update&page=update&categoryID=${catelist.categoryID}">수정</a> 
						</th>
						<th>
						<a href="#">삭제</a>
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
$('.page').each(()=>{
	$(this).click(()=>{	
		location.assign('${ctx}/product.do?cmd=pro_list&page=list&page_size=5&page_num='+$(this).text());
	});
});

$('#confirm_btn').click(()=>{
	location.assign('${ctx}/product.do?cmd=move&page=proregi');
});

$('#update_btn').click(()=>{
	location.assign('${ctx}/product.do?cmd=cate_update&page=update&productID=${prolist.productID}');
});cate_side
$('#cate_reg').click(()=>{
	$('#cate_side > li').attr('style','background-color: white');
	$('#cate_reg').attr('style','background-color: #ddd');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">카테고리 이름:</label>'
			+'    <input type="text" class="form-control" name="cate_name">'
			+'  </div>'
			+'  <div class="form-group">'
			+'    <label for="text">상세설명</label>'
			+'    <textarea rows="4" cols="50" class="form-control" name="description"></textarea>'
			+'  </div>'
			+'  <button type="submit" class="btn btn-default">Submit</button>'
			+'</form>');
});
$('#cate_search').click(()=>{
	$('#cate_side > li').attr('style','background-color: white');
	$('#cate_search').attr('style','background-color: #ddd');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">카테고리 검색:</label>'
			+'		<select>'
			+'			<option name="cate_id" value="4000">스마트폰</option>'
			+'			<option name="cate_id" value="4001">데스크탑</option>'
			+'			<option name="cate_id" value="4002">노트북</option>'
			+'		</select>'
			+'    <input type="text" class="form-control" name="cate_name">'
			+'  </div>'
			+'  <button type="submit" class="btn btn-default">검색</button>'
			+'</form>');
});
$('#cate_delete').click(()=>{
	$('#cate_side > li').attr('style','background-color: white');
	$('#cate_delete').attr('style','background-color: #ddd');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">삭제할 카테고리:</label><br>'
			+'		<form action="/action_page.php">'
			+'			<input type="checkbox" name="vehicle1" value="Bike">스마트폰<br>'
			+'			<input type="checkbox" name="vehicle2" value="Car">데스크탑<br>'
			+'			<input type="checkbox" name="vehicle3" value="Boat" checked>노트북<br>'
			+'		</form>'
			+'  </div>'
			+'  <button type="submit" class="btn btn-default">삭제</button>'
			+'</form>');
});
$('#cate_update').click(()=>{
	$('#cate_side > li').attr('style','background-color: white');
	$('#cate_update').attr('style','background-color: #ddd');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">수정할 카테고리:</label><br>'
			+'		<form action="">'
			+'			<input type="radio" name="gender" value="male"> 스마트폰<br>'
			+'			<input type="radio" name="gender" value="female"> 데스크탑<br>'
			+'			<input type="radio" name="gender" value="other"> 노트북'
			+'		</form>'
			+'  </div>'
			+'  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">수정</button>'
			+'<div class="modal fade" id="myModal" role="dialog">'
			+'    <div class="modal-dialog">'
			+'      <!-- Modal content-->'
			+'      <div class="modal-content">'
			+'        <div class="modal-header">'
			+'          <button type="button" class="close" data-dismiss="modal">&times;</button>'
			+'          <h4 class="modal-title">Modal Header</h4>'
			+'        </div>'
			+'        <div class="modal-body">'
			+'  		<div class="form-group">'
			+'    			<label for="text">카테고리 이름:</label>'
			+'   			 <input type="text" class="form-control" name="cate_name">'
			+'  		</div>'
			+'  		<div class="form-group">'
			+'    			<label for="text">상세설명</label>'
			+'    			<textarea rows="4" cols="50" class="form-control" name="description"></textarea>'
			+'  		</div>'
			+'        </div>'
			+'        <div class="modal-footer">'
			+'          <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>'
			+'        </div>'
			+'      </div>'
			+'    </div>'
			+'</div>'
			+'</form>');
});
</script>