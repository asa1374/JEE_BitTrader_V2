<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">회원 가입</font></h1>
</div>
<div class="grid-item" id="content">
<form class="form" id="form">
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">아이디</span>
		  <input type="text" id="cusid" name="cusid" class="form-control" placeholder="ID" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">이 름</span>
		  <input type="text" id="name" name="name" class="form-control" placeholder="NAME" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">비밀번호</span>
		  <input type="text" id="password" name="password" class="form-control" placeholder="PASSWORD" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">주소</span>
		  <input type="text" id="addr" name="addr" class="form-control" placeholder="ADDR" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">도시</span>
		  <input type="text" id="city" name="city" class="form-control" placeholder="CITY" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">우편번호</span>
		  <input type="text" id="post" name="post" class="form-control" placeholder="POST" aria-describedby="basic-addon1">
		</div>
		<div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">주민번호</span>
		  <input type="text" id="ssn" name="ssn" class="form-control" placeholder="SSN" aria-describedby="basic-addon1">
	    </div>
	    <div class="input-group">
		  <span class="input-group-addon" id="basic-addon1">핸드폰번호</span>
		  <input type="text" id="phone" name="phone" class="form-control" placeholder="PHONE" aria-describedby="basic-addon1">
	    </div>
		<button type="button" class="btn btn-default btn-lg" id="confirm_btn">
			<span class="glyphicon glyphicon-ok" aria-hidden="true">확인</span> 
		</button>
		<button type="button" class="btn btn-default btn-lg">
		  <span class="glyphicon glyphicon-remove" aria-hidden="true">취소</span> 
		</button>
	      <input type="hidden" name="cmd" value="signup" />
	      <input type="hidden" name="page" value="signin" />
</form>
</div>
<jsp:include page="../home/bottom.jsp"/>
<script>
$('#confirm_btn').click(function(){
	$('#form')
	.attr('action', '${ctx}/customer.do')
	.submit();
});
</script>