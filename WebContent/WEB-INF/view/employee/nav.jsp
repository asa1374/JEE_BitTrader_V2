<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" href="${css}/employee/nav.css" />    
<div class="navi_bar">
    <div id="navi_bar1"><a href="home.do">홈</a></div>
    <div id="navi_bar2"><a id="category">카테고리</a></div>
    <div id="navi_bar3"><a href="#">사원</a></div>
    <div id="navi_bar4"><a href="#">주문</a></div>
    <div id="navi_bar5"><a href="${ctx}/product.do?cmd=pro_list&page=list">상품</a></div>
    <div id="navi_bar6"><a href="#">선박</a></div>
    <div id="navi_bar7"><a href="#">공급업체</a></div>
</div>
<script>
$('#category').attr('style','cursor:pointer').click(function(){
	location.assign('${ctx}/category.do?cmd=cate_list&page=list');
});
</script>