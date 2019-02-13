<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" 
	href="${css}/customer/list.css" />
<div class="grid-item" id="nav">
	<jsp:include page="../employee/nav.jsp"/>
</div>
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">고객 목록</font>
 	</h1>
</div>
<div class="grid-item" id="content">
	<table id="cust_tab">
	  <tr>
	    <th>No.</th>
	    <th>아이디</th>
	    <th>이 름</th>
	    <th>생년월일</th>
	    <th>성 별</th>
	    <th>전화번호</th>
	    <th>우편번호</th>
	    <th>지번주소</th>
	    <th>상세주소</th>
	  </tr>
	  <c:forEach items="${list}" var="cust" >
		  <tr>
		    <td>${cust.count}</td>
		    <td>${cust.customerID}</td>
		    <td>${cust.customerName}</td>
		    <td>${cust.ssn}</td>
		    <td>남</td>
		    <td>${cust.phone}</td>
		    <td>${cust.postalCode}</td>
		    <td>${cust.city}</td>
		    <td>${cust.address}</td>
		  </tr>
	  </c:forEach>
	</table>
	<div style="height: 50px"></div>
<form id="list_form">
	<div class="center">
	  <div class="pagination">
	  <a href="#">&laquo;</a>
	  <c:forEach begin="1" end="5" varStatus="status" >
	  <a href="#" id="${status.count }page">${status.count }</a>
	  </c:forEach>
	  <a href="#">&raquo;</a>
	  </div>
	</div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
//class="active"
$('#2page').click(function(){
	location.assign('${ctx}/customer.do?cmd=cus_list&page=list&page_size=5&page_num=2');
	
	//page_num, page_size, cmd, dir, page
	//cmd=list&page=list&page_num=2&page_size=5
});
</script>