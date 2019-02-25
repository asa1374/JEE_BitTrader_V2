var ctx = "${ctx}";
$('.page').click(()=>{	
		location.assign(ctx+'${ctx}/product.do?cmd=pro_list&page=list&page_size=5&page_num='+$(this).text());
});

$('#confirm_btn').click(()=>{
	location.assign('${ctx}/product.do?cmd=move&page=proregi');
});

$('#update_btn').click(()=>{
	location.assign('${ctx}/product.do?cmd=cate_update&page=update&productID=${prolist.productID}');
});cate_side
$('#cate_reg').click(()=>{
	$('#cate_side > li').attr('style','background-color: white');
	$('#cate_reg').attr('style','background-color: #ddd');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">카테고리 이름:</label>'
			+'    <input type="text" class="form-control" name="cate_name">'
			+'  </div>'
			+'  <div class="form-group">'
			+'    <label for="text">상세설명</label>'
			+'    <textarea rows="4" cols="50" class="form-control" name="description"></textarea>'
			+'  </div>'
			+'  <button type="submit" class="btn btn-default">Submit</button>'
			+'</form>');
});
$('#cate_search').click(()=>{
	$('#cate_side > li').attr('style','background-color: white');
	$('#cate_search').attr('style','background-color: #ddd');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">카테고리 검색:</label>'
			+'		<select>'
			+'			<option name="cate_id" value="4000">스마트폰</option>'
			+'			<option name="cate_id" value="4001">데스크탑</option>'
			+'			<option name="cate_id" value="4002">노트북</option>'
			+'		</select>'
			+'    <input type="text" class="form-control" name="cate_name">'
			+'  </div>'
			+'  <button type="submit" class="btn btn-default">검색</button>'
			+'</form>');
});
$('#cate_delete').click(()=>{
	$('#cate_side > li').attr('style','background-color: white');
	$('#cate_delete').attr('style','background-color: #ddd');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">삭제할 카테고리:</label><br>'
			+'		<form action="/action_page.php">'
			+'			<input type="checkbox" name="vehicle1" value="Bike">스마트폰<br>'
			+'			<input type="checkbox" name="vehicle2" value="Car">데스크탑<br>'
			+'			<input type="checkbox" name="vehicle3" value="Boat" checked>노트북<br>'
			+'		</form>'
			+'  </div>'
			+'  <button type="submit" class="btn btn-default">삭제</button>'
			+'</form>');
});
$('#cate_update').click(()=>{
	$('#cate_side > li').attr('style','background-color: white');
	$('#cate_update').attr('style','background-color: #ddd');
	$('#content').html('<form id="form">'
			+'  <div class="form-group">'
			+'    <label for="text">수정할 카테고리:</label><br>'
			+'		<form action="">'
			+'			<input type="radio" name="gender" value="male"> 스마트폰<br>'
			+'			<input type="radio" name="gender" value="female"> 데스크탑<br>'
			+'			<input type="radio" name="gender" value="other"> 노트북'
			+'		</form>'
			+'  </div>'
			+'  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">수정</button>'
			+'<div class="modal fade" id="myModal" role="dialog">'
			+'    <div class="modal-dialog">'
			+'      <!-- Modal content-->'
			+'      <div class="modal-content">'
			+'        <div class="modal-header">'
			+'          <button type="button" class="close" data-dismiss="modal">&times;</button>'
			+'          <h4 class="modal-title">Modal Header</h4>'
			+'        </div>'
			+'        <div class="modal-body">'
			+'  		<div class="form-group">'
			+'    			<label for="text">카테고리 이름:</label>'
			+'   			 <input type="text" class="form-control" name="cate_name">'
			+'  		</div>'
			+'  		<div class="form-group">'
			+'    			<label for="text">상세설명</label>'
			+'    			<textarea rows="4" cols="50" class="form-control" name="description"></textarea>'
			+'  		</div>'
			+'        </div>'
			+'        <div class="modal-footer">'
			+'          <button type="button" class="btn btn-default" data-dismiss="modal">확인</button>'
			+'        </div>'
			+'      </div>'
			+'    </div>'
			+'</div>'
			+'</form>');
});