var coronas = [];

//장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places(); 
//var hospitalSize=0;
$(document).ready(
		function() {
			var param = {
				serviceKey : 'fFMOp0/FDsTgiB3XkujOAU1gkm8B4FS4F7pEZnAetz5r/dwK1Tz4UqOTQM9IvoPo2xnXXGpRTsFsUqkyFZwKrw==',
				pageNo : encodeURIComponent('1'),
				numOfRows : encodeURIComponent('700'),
				spclAdmTyCd : encodeURIComponent('99')
			};

			$.ajax({
			    url: "http://apis.data.go.kr/B551182/pubReliefHospService/getpubReliefHospList",
			    type: "GET",
			    dataType: "xml",
			    data: param,
			    success: function (data) {
//			      console.log(data);
			     var items = $(data).find('item');
					items.each(function() {
						let jsonObj = new Object();
						jsonObj.yadmNm = $(this).find('yadmNm').text();
						jsonObj.telno = $(this).find('telno').text();
						jsonObj.adtFrDd = $(this).find('adtFrDd').text();
						var address = $(this).find('sidoNm').text()+" "+$(this).find('sgguNm').text()+" "+ $(this).find('yadmNm').text();
						// 키워드로 장소를 검색합니다
						getLatLng(address, function(data, status, pagination){
							 if (status === kakao.maps.services.Status.OK) {
								 var coords = new kakao.maps.LatLng(data[0].y, data[0].x);
								 jsonObj.lat = coords.La;
								 jsonObj.lng = coords.Ma;
								 makeJson(jsonObj);
//								 console.log(jsonObj);
//							     coronas.push(JSON.parse(JSON.stringify(jsonObj)));
							 }
						})
					}); //end of each
			    },
			    error: function (xhr, status, msg) {
			      console.log("상태값 : " + status + " Http에러메시지 : " + msg);
			    },
			  }); //end of ajax
			
});


function makeJson(jsonObj){
	coronas.push(JSON.parse(JSON.stringify(jsonObj)));
//	console.log(coronas.length)
	if(coronas.length == 656) sendData(coronas); 
}

function getLatLng(address, callback){
	ps.keywordSearch(address, callback); 
}

function sendData(coronas){
	console.log(coronas)
	$.ajax({
		url:'/map/corona',  
		type:'POST',
		contentType:'application/json;charset=utf-8',
		dataType:'json',
		data: JSON.stringify(coronas),
		success:function(infos) {
			$.each(infos, function(index, vo) {
				
			});
			
		},
		error:function(xhr,status,msg){
			console.log("상태값 : " + status + " Http에러메시지 : "+msg);
		}
	});
}


