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
		임시비밀번호: <br />
		</div>
		<div id="right-detail">
			<form id="update_form">
				<input type="text" name="customer_ID" value="${cust.customerID}" readonly="readonly" /><br />
				<input type="text" name="customerName" value="${cust.customerName}" readonly="readonly" /><br />
				<input type="text" name="ssn" value="${cust.ssn}" readonly="readonly" /><br />
				남<br />
				<input type="text" name="phone" value="${cust.phone}" placeholder="${cust.phone}" /> <br />
				<input type="text" name="postalCode" value="${cust.postalCode}" placeholder="${cust.postalCode}" /> <br />
				<input type="text" name="city" value="${cust.city}" placeholder="${cust.city}" /> <br />
				<input type="text" name="address" placeholder="${cust.address}" /><br />
				<input type="text" name="password" placeholder="임시비밀번호" /><br />
				<input type="hidden" name="cmd" value="cus_update" /><br />
			    <input type="hidden" name="page" value="detail" />
		    </form>
		</div>
	</div>
</div>
<div class="grid-item" id="update">
	<span class="label label-info" id="confirm_btn">확인</span>
</div>
<div class="grid-item" id="delete">
	<span class="label label-danger" id="cancel_btn">취소</span>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').attr('style','cursor:pointer').click(function(){
	$('#update_form').attr('action','${ctx}/customer.do');
	$('#update_form').attr('method','post').submit();
});
$('#cancel_btn').attr('style','cursor:pointer').click(function(){
	alert('취소버튼클릭');
});
</script>