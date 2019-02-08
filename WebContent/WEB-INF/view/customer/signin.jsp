<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<div class="grid-item" id="side_menu">
	<h1><font style="font-size: 30px">사원 접속</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
	    <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">아이디</span>
		  <input type="text" id="cusid" name="cusid" class="form-control" placeholder="ID" aria-describedby="basic-addon1">
		</div>
	    <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">비밀번호</span>
		  <input type="text" id="password" name="password" class="form-control" placeholder="PASSWORD" aria-describedby="basic-addon1">
		</div>
		<button type="button" class="btn btn-default btn-lg" id="confirm_btn">
			<span class="glyphicon glyphicon-ok" aria-hidden="true">확인</span> 
		</button>
		<button type="button" class="btn btn-default btn-lg">
		  <span class="glyphicon glyphicon-remove" aria-hidden="true">취소</span> 
		</button>
	    <input type="hidden" name="cmd" value="signin" />
	    <input type="hidden" name="dir" value="category" />
	    <input type="hidden" name="page" value="main" />
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	var empno = $('#empno').val();
	var name = $('#name').val();
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
</script>