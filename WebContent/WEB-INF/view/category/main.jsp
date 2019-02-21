<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/category/navi.css" />
<div class="grid-item" id="grid-navi">
	<div class="grid-category">
	<div id="navi">
	    <a href="home.do">마이페이지</a>
	</div>
	<div id="navi2">
	    <a href="#">${customer.customerName}의 페이지</a>
	</div>
</div>
</div>
<link rel="stylesheet" href="${css}/customer/detail.css" />
<div class="grid-item" id="grid-category-details">
	<div class="grid-category-detail">
		<div id="category-detail1">
		   <div class="thumbnail">
		     <img data-src="holder.js/100%x200" alt="100%x200" src="${img}/desk.jpg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
		     <div class="caption">
		       <h3 id="thumbnail-label">데스크탑<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
		       <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
		       <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
		     </div>
		   </div>
		</div>
		<div id="category-detail2">
		   <div class="thumbnail">
		     <img data-src="holder.js/100%x200" alt="100%x200" src="${img}/notebook.jpg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
		     <div class="caption">
		       <h3 id="thumbnail-label">노트북<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
		       <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
		       <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
		     </div>
		   </div>
	   </div>
		<div id="category-detail3">
		 <div class="thumbnail">
		   <img data-src="holder.js/100%x200" alt="100%x200" src="${img}/smartphone.jpg" data-holder-rendered="true" style="height: 200px; width: 100%; display: block;">
		     <div class="caption">
		       <h3 id="thumbnail-label">스마트폰<a class="anchorjs-link" href="#thumbnail-label"><span class="anchorjs-icon"></span></a></h3>
		       <p>Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.</p>
		       <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
		     </div>
		   </div>
		</div>
	</div>
</div>
<jsp:include page="../home/bottom.jsp"/>  
<script>
$('#navi2').click(function(){
	alert('마이페이지 클릭');
	location.assign('${ctx}/customer.do?cmd=cust_retrieve&page=detail&customerID=${customer.customerID}');
});
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