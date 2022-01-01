
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
<style>
.bm {
	background-color: yellow
}
</style>
<script type="text/javascript">
var bookmarks = [];
$(document).ready(function(){		
	$.get("${root}/map/getBookmarks"
		,function(data, status){
			$("tbody").empty();
			
			$.each(data, function(index, vo) {
				bookmarks.push(vo);
				let str = `
					<tr data-id="${'${vo.gugunCode}'}" id="bookmarkBtn" class="bm">
					<td>${'${index+1}'}</td>
					<td>${'${vo.gugunName}'}</td>
					</tr>
				`;
				$("tbody").append(str);
			}); 
		}
		, "json"
	);
	
	$(document).on("click", "#bookmarkBtn", function() {
		let btn = $(this);
		let gugunCode = $(this).attr("data-id");
		console.log(gugunCode)
		var param = {
				serviceKey : "fFMOp0/FDsTgiB3XkujOAU1gkm8B4FS4F7pEZnAetz5r/dwK1Tz4UqOTQM9IvoPo2xnXXGpRTsFsUqkyFZwKrw==",
				pageNo : encodeURIComponent('1'),
				numOfRows : encodeURIComponent('100'),
				divId : encodeURIComponent('signguCd'),
				key : encodeURIComponent(gugunCode),
				indsLclsCd : encodeURIComponent('Q'),
				indsMclsCd : encodeURIComponent('Q12'),
				indsSclsCd : encodeURIComponent('Q12A01'),
				type : encodeURIComponent('xml'),
		};
		$.get('http://apis.data.go.kr/B553077/api/open/sdsc2/storeListInDong'
				, param
				, function(data, status){
					var items = $(data).find('item');
					var itemsArr = [];
					$.each(items, function(){
						var obj = new Object();
						obj.name = $(this).find('bizesNm').text()+" "+$(this).find('brchNm').text();
						obj.address = $(this).find('lnoAdr').text();
						obj.lng = $(this).find('lon').text();
						obj.lat = $(this).find('lat').text();
						
						itemsArr.push(obj);
					})
					console.log(itemsArr);
					console.log($(this));
					$.each(itemsArr, function(index, item) {
						let str = `
							<tr> 
								<td>${'${item.name}'}</td>
								<td>${'${item.address}'}</td>
							<tr>
						`;
						
						btn.after(str);
					})
				})
	});
});
</script>

<div class="container">
	<header id="index_header" class="jumbotron text-center mb-1">
		<h4>행복한 우리 집</h4>
	</header>
	<!-- nav start -->
	<nav class="navbar navbar-expand-sm bg-dark navbar-dark rounded">
		<ul class="navbar-nav">
			<li class="nav-item"><a class="nav-link" href="#">Home</a></li>
			<li class="nav-item dropdown"><a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown"> 동네 정보 </a>
				<div class="dropdown-menu">
					<a class="dropdown-item" href="#">APT 매매</a> <a class="dropdown-item" href="#">APT 전월세</a> <a class="dropdown-item" href="#">주택 매매</a> <a class="dropdown-item" href="#">주택 전월세</a> <a class="dropdown-item" href="#">상권 정보</a> <a class="dropdown-item" href="#">환경 정보</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="/notice/list?pg=1&key=&word=">Notice</a></li>
			<li class="nav-item"><a class="nav-link" href="/bookmark">BookMark</a></li>
			<li class="nav-item"><a class="nav-link" href="#">Contact</a></li>
			<li class="nav-item"><a class="nav-link" href="/user/loginMain">Community</a></li>
		</ul>
	</nav>
	<table class="table mt-2">
		<thead>
			<tr>
				<th>번호</th>
				<th>구군</th>
			</tr>
		</thead>
		<tbody></tbody>
	</table>
</div>
</body>
</html>