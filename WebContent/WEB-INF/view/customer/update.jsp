<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/customer/detail.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
	<img src="${img}/default_img.png" style="height: 260px; width: 280px"/>
</div>
<div class="detail">
	<form id="update_form">
		<div class="grid-detail">
			<div id="left-detail">아이디</div>
			<div id="right-detail"><input type="text" name="customer_ID" value="${cust.customerID}" readonly="readonly" /></div>
			<div id="left-detail">이 름</div>
			<div id="right-detail"><input type="text" name="customerName" value="${cust.customerName}" readonly="readonly" /></div>
			<div id="left-detail">생년월일</div>
			<div id="right-detail"><input type="text" name="ssn" value="${cust.ssn}" readonly="readonly" /></div>
			<div id="left-detail">성 별</div>
			<div id="right-detail">남</div>
			<div id="left-detail">전화번호</div>
			<div id="right-detail"><input type="text" name="phone" value="${cust.phone}" placeholder="${cust.phone}" /></div>
			<div id="left-detail">우편번호</div>
			<div id="right-detail"><input type="text" name="postalCode" value="${cust.postalCode}" placeholder="${cust.postalCode}" /></div>
			<div id="left-detail">지번주소</div>
			<div id="right-detail"><input type="text" name="city" value="${cust.city}" placeholder="${cust.city}" /></div>
			<div id="left-detail">상세주소</div>
			<div id="right-detail"><input type="text" name="address" placeholder="${cust.address}" /></div>
			<div id="left-detail">임시비밀번호: </div>
			<div id="right-detail"><input type="text" name="password" placeholder="임시비밀번호" /></div>
			<input type="hidden" name="cmd" value="cus_update" /><br />
		    <input type="hidden" name="page" value="detail" />
		</div>
	</form>
</div>
<div class="grid-item" id="photo">
	<span class="label label-danger" id="photo_btn">사진수정</span>
</div>
<div class="grid-item" id="update">
	<span class="label label-info" id="confirm_btn">수정</span>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').attr('style','cursor:pointer').click(function(){
	$('#update_form').attr('action','${ctx}/customer.do');
	$('#update_form').attr('method','post').submit();
});
$('#photo_btn').attr('style','cursor:pointer').click(function(){
	alert('사진업로드 클릭');
});
</script>