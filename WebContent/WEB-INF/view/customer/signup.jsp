<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="../home/top.jsp"/>
<link rel="stylesheet" href="${css}/employee/register.css" />
<div class="grid-item" id="side_menu">
 	<h1><font style="font-size: 30px">회원 가입</font></h1>
</div>
<div class="grid-item" id="content">
<form id="form" name="form" >
	<div class="grid-container">
	    <div class="grid-item" id="item_3">아이디</div>
	    <div class="grid-item" id="item_4"><input type="text" id="cusid" name="cusid" ></div>
	    <div class="grid-item" id="item_5">이 름</div>
	    <div class="grid-item" id="item_6"><input type="text" id="name" name="name" ></div>
	    <div class="grid-item" id="item_1">비밀번호</div>
	    <div class="grid-item" id="item_2"><input type="text" id="password" name="password" ></div>
	    <div class="grid-item" id="item_7">주소</div>
	    <div class="grid-item" id="item_8"><input type="text" id="addr" name="addr" ></div>
	    <div class="grid-item" id="item_7">도시</div>
	    <div class="grid-item" id="item_8"><input type="text" id="city" name="city" ></div>
	    <div class="grid-item" id="item_7">우편번호</div>
	    <div class="grid-item" id="item_8"><input type="text" id="post" name="post" ></div>
	    <div class="grid-item" id="item_9">주민번호</div>
	    <div class="grid-item" id="item_10"><input type="text" id="ssn" name="ssn" ></div>
	    <div class="grid-item" id="item_11"><input type="submit" id="confirm_btn" value='확 인'></div>
	    <div class="grid-item" id="item_12"><input type="reset" id="cancel_btn" value='취 소'> </div>
	    <input type="hidden" name="cmd" value="signup" />
	    <input type="hidden" name="page" value="signin" />
	</div>
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