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
		<div id="left-detail">아이디</div>
		<div id="right-detail">${cust.customerID}</div>
		<div id="left-detail">이 름</div>
		<div id="right-detail">${cust.customerName}</div>
		<div id="left-detail">생년월일</div>
		<div id="right-detail">${cust.ssn}</div>
		<div id="left-detail">성 별</div>
		<div id="right-detail">남</div>
		<div id="left-detail">전화번호</div>
		<div id="right-detail">${cust.phone}</div>
		<div id="left-detail">우편번호</div>
		<div id="right-detail">${cust.postalCode}</div>
		<div id="left-detail">지번주소</div>
		<div id="right-detail">${cust.city}</div>
		<div id="left-detail">상세주소</div>
		<div id="right-detail">${cust.address}</div>
	</div>
</div>
<div class="grid-item" id="photo">
	<span class="label label-danger" id="photo_btn">사진수정</span>
</div>
<div class="grid-item" id="update">
	<span class="label label-info" id="update_btn">수정</span>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#update_btn').attr('style','cursor:pointer').click(function(){
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customerID=${cust.customerID}');
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