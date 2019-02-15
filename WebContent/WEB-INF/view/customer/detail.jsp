<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" 
	href="${css}/customer/detail.css" />
<div class="grid-item" id="side_menu">
	<img src="http://cdn.mydaily.co.kr/FILES/201901/201901311014554026_1.jpg" style="height: 350px; width: 250px"/>
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
<jsp:include page="../home/bottom.jsp"/>