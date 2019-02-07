<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/category/main.css" />
  	<div class="grid-item" id="category1" >
  	노트북<br />
    <a href="#" id="cust_join" >이동</a>
    </div>
	  <div class="grid-item" id="category2">
	  스마트폰<br />
    <a href="#" id="cust_join" >이동</a>
    </div> 
	  <div class="grid-item" id="category3">
	  데스크탑<br />
    <a href="#" id="cust_join" >이동</a>
    </div>
<jsp:include page="../home/bottom.jsp"/>  
<script>
$('#emp_register').click(function(){
	location.assign('employee.do?cmd=move&page=register');
});
$('#cust_login').click(function(){
	location.assign('employee.do?cmd=login&page=login');
});
$('#emp_access').click(function(){
	location.assign('employee.do?cmd=move&page=access');
});
$('#cust_join').click(function(){
	location.assign('customer.do?cmd=move&page=signup');
});
</script>