<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/employee/login.css" />
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">로그인 중입니다.</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
	<div class="grid-container">
	    <div class="grid-item" id="item_1">아이디</div>
	    <div class="grid-item" id="item_2"><input type="text" id="emplo" name="empno" ></div>
	    <div class="grid-item" id="item_3">비밀번호</div>
	    <div class="grid-item" id="item_4"><input type="text" id="name" name="name" ></div>
	    <div class="grid-item" id="item_11"><input type="submit" id="confirm_btn" value='로그인'></div>
	    <input type="hidden" name="cmd" value="move" />
	    <input type="hidden" name="page" value="access" />
	</div>
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	var empno = $('#empno').val();
	var name = $('#name').val();
	var manager = $('#manager').val();
	var birthday = $('#birthday').val();
	$('#form')
	.attr('action', '${ctx}/employee.do')
	.submit();
});
</script>