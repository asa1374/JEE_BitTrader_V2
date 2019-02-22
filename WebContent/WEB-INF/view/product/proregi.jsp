<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">상품 등록</font></h1>
</div>
<div class="grid-item" id="content">
	<form class="form" id="form">
			<div class="input-group">
			  <span class="input-group-addon" id="basic-addon1">상품 이름</span>
			  <input type="text" id="productName" name="productName" class="form-control" placeholder="productName" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
			  <span class="input-group-addon" id="basic-addon1">제조사 ID</span>
			  <input type="text" id="supplierID" name="supplierID" class="form-control" placeholder="supplierID" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
			  <span class="input-group-addon" id="basic-addon1">카테고리 ID</span>
			  <input type="text" id="categoryID" name="categoryID" class="form-control" placeholder="categoryID" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
			  <span class="input-group-addon" id="basic-addon1">수량</span>
			  <input type="text" id="unit" name="unit" class="form-control" placeholder="unit" aria-describedby="basic-addon1">
			</div>
			<div class="input-group">
			  <span class="input-group-addon" id="basic-addon1">가격</span>
			  <input type="text" id="price" name="price" class="form-control" placeholder="price" aria-describedby="basic-addon1">
			</div>
			<button type="button" class="btn btn-default btn-lg" id="confirm_btn">
				<span class="glyphicon glyphicon-ok" aria-hidden="true">등록</span> 
			</button>
			<button type="button" class="btn btn-default btn-lg">
			  <span class="glyphicon glyphicon-remove" aria-hidden="true">취소</span> 
			</button>
		      <input type="hidden" name="cmd" value="pro_regist" />
		      <input type="hidden" name="page" value="list" />
	</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	$('#form')
	.attr('action', '${ctx}/product.do')
	.submit();
});

</script>