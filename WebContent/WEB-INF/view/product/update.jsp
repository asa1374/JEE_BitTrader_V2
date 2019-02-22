<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/detail.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
	<form id="file_form">
		<img src="${img}/${image.imgName}.${image.imgExtention}" style="height: 260px; width: 280px"/>
		<input type="file" name="file_upload" />
		<input type="submit" id="file_upload_btn" />
	</form>
</div>
<div class="detail">
	<div class="grid-detail">
		<div id="left-detail">No.</div>
		<div id="right-detail"><input type="text" name="productID" value="${prolist.productID}" readonly="readonly" /></div>
		<div id="left-detail">상품 이름</div>
		<div id="right-detail"><input type="text" name="productName" placeholder="${prolist.productName}" /></div>
		<div id="left-detail">제조사 ID</div>
		<div id="right-detail"><input type="text" name="supplierID" value="${prolist.supplierID}"  readonly="readonly" /></div>
		<div id="left-detail">카테고리 ID</div>
		<div id="right-detail"><input type="text" name="categoryID" placeholder="${prolist.categoryID}" /></div>
		<div id="left-detail">수량</div>
		<div id="right-detail"><input type="text" name="unit" placeholder="${prolist.unit}" /></div>
		<div id="left-detail">가격</div>
		<div id="right-detail"><input type="text" name="price" placeholder="${prolist.price}"/></div>
	</div>
</div>
<div class="grid-item" id="photo">
	<span class="label label-danger" id="photo_btn">사진수정</span>
</div>
<div class="grid-item" id="update">
	<span class="label label-info" id="update_btn">수정</span>
</div>
<div class="grid-item" id="delete">
	<span class="label label-info" id="delete_btn">삭제</span>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#update_btn').attr('style','cursor:pointer').click(function(){
	location.assign('${ctx}/product.do?cmd=pro_update&page=list&productID=${prolist.productID}');
});
$('#delete_btn').attr('style','cursor:pointer').click(function(){
	alert('삭제버튼클릭');
	location.assign('${ctx}/customer.do?cmd=cust_delete&dir=home&page=main&productID=${prolist.productID}');
});
$('#file_upload_btn').attr('style','cursor:pointer').click(function(){
	alert('사진업로드 클릭');
	$('#file_form')
	.attr('method','post')
	.attr('action','${ctx}/customer.do?cmd=cus_file_upload&page=detail&customer_id=${cust.customerID}')
	.attr('enctype','multipart/form-data')
	.submit();
});
</script>