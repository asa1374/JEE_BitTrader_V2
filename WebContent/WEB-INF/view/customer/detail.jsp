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
<div class="grid-detail">
<div id="left-detail">
아이디<br />
이 름<br />
생년월일<br />
성 별<br />
전화번호<br />
우편번호<br />
지번주소<br />
상세주소<br />
</div>
<div id="right-detail">
${cust.customerID}<br />
${cust.customerName}<br />
${cust.ssn}<br />
남<br />
${cust.phone}<br />
${cust.postalCode}<br />
${cust.city}<br />
${cust.address}
</div>
</div>
</div>
<div class="grid-item" id="update">
	<span class="label label-info" id="update_btn">수정</span>
</div>
<div class="grid-item" id="delete">
	<span class="label label-danger" id="delete_btn">삭제</span>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#update_btn').attr('style','cursor:pointer').click(function(){
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=update&customerID=${cust.customerID}');
});
$('#delete_btn').attr('style','cursor:pointer').click(function(){
	alert('삭제버튼클릭');
});
</script>