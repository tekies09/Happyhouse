var root = "";

// 마커를 담을 배열입니다
var markers = [];
var markers2 = [];

var mapContainer = document.getElementById("map"); // 지도를 표시할 div	
var mapOption = {
	    center: new kakao.maps.LatLng(37.566826, 126.9786567), // 지도의 중심좌표
	    level: 3, // 지도의 확대 레벨
	};

// 지도를 생성합니다
var map = new kakao.maps.Map(mapContainer, mapOption);

// 장소 검색 객체를 생성합니다
var ps = new kakao.maps.services.Places();

// 검색 결과 목록이나 마커를 클릭했을 때 장소명을 표출할 인포윈도우를 생성합니다
var infowindow = new kakao.maps.InfoWindow({ zIndex: 1 });
// 커스텀 오버레이를 생성합니다
var customOverlay;
//주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

var infowindows = [];
var customOverlays = [];

/** 시도 + 구 선택 */
//주소-좌표 변환 
function getCoord(addresses, info){
	setMarkers(null);

	//지도를 재설정할 범위정보를 가지고 있을 LatLngBounds 객체를 생성합니다
	var bounds = new kakao.maps.LatLngBounds();    
	var fragment = document.createDocumentFragment();
	
	for(var i=0; i<addresses.length; i++){
		if(addresses[i]==null) continue;
		
		const title = info[i].aptName;
		const place = info[i];
		const addr = addresses[i];

		geocoder.addressSearch(addresses[i], function(result, status) {
		    // 정상적으로 검색이 완료됐으면 
		     if (status === kakao.maps.services.Status.OK) {
		        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
		     // 마커를 생성합니다
		        var marker = new kakao.maps.Marker({
		        	map: map,
		            position: coords
		        });
		        
		        // 마커가 지도 위에 표시되도록 설정합니다
		        marker.setMap(map);
		        
		        // 생성된 마커를 배열에 추가합니다
		        markers.push(marker);
		        
		     // 마커에 커서가 오버됐을 때 마커 위에 표시할 인포윈도우를 생성합니다
		        var iwContent =  `
					<div class="boxtitle">${title}</div>
					<div class="first"><img src="${root}/img/apt.png" style="width:247px; height:136px;" alt=""></div>
					<ul>
						<li class="up">
							<span class="title">건축년도</span>
							<span class="count">${place.buildYear}</span>
						</li>
						<li>
							<span class="title">주소</span>
							<span class="count">${addr};</span>
						</li>
						<li>
							<span class="title">최신거래금액</span>
							<span class="count">${place.recentPirce}</span>
						</li>
						<li>
							<span class="last" id="recenthistor" data-toggle="modal" data-target="#myModal">아파트정보 update</span>
						</li>
					</ul>
				
			`;

		        // 인포윈도우를 생성합니다
		        var infowindow = new kakao.maps.InfoWindow({
		            content : iwContent
		        });
		        
		        (function(marker, infowindow) {
		        	kakao.maps.event.addListener(marker, 'click', function() {
		        		closeAllInfo();
		        	    infowindow.open(map, marker);
		        	    infowindows.push(infowindow);
		        	    
		        	    //해당 아파트 매매정보 모두 불러오기
		        	    const aptCode = place.aptCode;
							var param = {
									serviceKey:'fFMOp0/FDsTgiB3XkujOAU1gkm8B4FS4F7pEZnAetz5r/dwK1Tz4UqOTQM9IvoPo2xnXXGpRTsFsUqkyFZwKrw==',
									pageNo:encodeURIComponent('1'),
									numOfRows:encodeURIComponent('100'),
									LAWD_CD:encodeURIComponent($("#gugun").val()),
									DEAL_YMD:encodeURIComponent('202110')
							};
							$.get('http://openapi.molit.go.kr/OpenAPI_ToolInstallPackage/service/rest/RTMSOBJSvc/getRTMSDataSvcAptTradeDev'
									,param
									,function(data, status){
										var items = $(data).find('item');
										var jsonArray2 = new Array();
										items.each(function() {
											var jsonObj	= new Object();
											jsonObj.aptCode = $(this).find('일련번호').text();
											jsonObj.aptName = $(this).find('아파트').text();
											jsonObj.dongCode = $(this).find('법정동읍면동코드').text();
											jsonObj.buildYear = $(this).find('건축년도').text();
											jsonObj.jibun = $(this).find('지번').text();
											jsonObj.recentPirce = $(this).find('거래금액').text().trim();
											jsonObj.gugun = $("#gugun").val();
												
											jsonArray2.push(jsonObj);
										});
										$.ajax({
											url:'/map/apt/'+aptCode,  
											type:'POST',
											contentType:'application/json;charset=utf-8',
											dataType:'json',
											data: JSON.stringify(jsonArray2),
											success:function(apts2) {
												$("tbody").empty();
												$.each(apts2, function(index, vo) {
													let str = `
														<tr class="${colorArr[index%3]}">
														<td>${index+1}</td>
														<td>${vo.aptName}</td>
														<td>${vo.sidoName} ${vo.gugunName} ${vo.dongName} ${vo.jibun}</td>
														<td>${vo.buildYear}</td>
														<td>${vo.recentPrice}</td>
														</tr>
													`;
													$("tbody").append(str);
												});
												
											},
											error:function(xhr,status,msg){
												console.log("상태값 : " + status + " Http에러메시지 : "+msg);
											}
										});
									}, "xml"
							);
							
		        	});
		        	
		        	kakao.maps.event.addListener(marker, 'click', function() {        
			        	  // 마커에 마우스클릭 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
							var Latlng = {
									lat : coords.La,
									lng : coords.Ma
							}
							//가장 가까운 선별진료소 가져오기
							$.ajax({
								url:'/map/corona/near',  
								type:'POST',
								contentType:'application/json;charset=utf-8',
								dataType:'json',
								data: JSON.stringify(Latlng),
								success:function(near) {
									addCoronaMarker(near);
								},
								error:function(xhr,status,msg){
									console.log("상태값 : " + status + " Http에러메시지 : "+msg);
								}
							});
			        	});
		        	
		        	
		        kakao.maps.event.addListener(map, 'click', function() {
		            // 마커에 마우스아웃 이벤트가 발생하면 인포윈도우를 제거합니다
		            infowindow.close();
		            setMarkers2(null);
		        });
		        })(marker, infowindow);
		        
		        // LatLngBounds 객체에 좌표를 추가합니다
		        bounds.extend(coords);
		        
		        map.setCenter(coords);
		        map.setLevel(6);
		        map.setBounds(bounds);
		    } 
		})
	}
}

function addCoronaMarker(near){
	// 마커가 표시될 위치입니다 
	var markerPosition2  = new kakao.maps.LatLng(near.lng, near.lat); 
	var imageSrc2 = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/markerStar.png"; 
	 // 마커 이미지의 이미지 크기 입니다
    var imageSize2 = new kakao.maps.Size(24, 35); 
    
    // 마커 이미지를 생성합니다    
    var markerImage2 = new kakao.maps.MarkerImage(imageSrc2, imageSize2); 

	// 마커를 생성합니다
	var marker2 = new kakao.maps.Marker({
		map: map,
	    position: markerPosition2,
	    image : markerImage2 // 마커 이미지 
	});
	
	// 마커가 지도 위에 표시되도록 설정합니다
	marker2.setMap(map);
	
    markers2.push(marker2);
    
	var iwContent2 = `<div>${near.yadmNm}<br></div>`, // 인포윈도우에 표출될 내용으로 HTML 문자열이나 document element가 가능합니다
	    iwPosition2 = new kakao.maps.LatLng(near.lat, near.lng); //인포윈도우 표시 위치입니다

	// 인포윈도우를 생성합니다
	var infowindow2 = new kakao.maps.InfoWindow({
	    position : iwPosition2, 
	    content : iwContent2 
	});
	  
	// 마커 위에 인포윈도우를 표시합니다. 두번째 파라미터인 marker를 넣어주지 않으면 지도 위에 표시됩니다
	infowindow2.open(map, marker2); 
	infowindows.push(infowindow2)
}

//배열에 추가된 마커들을 지도에 표시하거나 삭제하는 함수입니다
function setMarkers(map) {
    for (var i = 0; i < markers.length; i++) {
        markers[i].setMap(map);
    }            
}

function setMarkers2(map) {
    for (var i = 0; i < markers2.length; i++) {
        markers2[i].setMap(map);
    }            
}

function closeAllInfo(){
	for(var i=0; i<infowindows.length; i++){
        infowindows[i].close();
	}
}

/** 시도+구군+동 검색 */
//검색 결과 목록과 마커를 표출하는 함수입니다
function displayMarkers(places) {
	var fragment = document.createDocumentFragment();
    var bounds = new kakao.maps.LatLngBounds();
    var listStr = "";
    
	// 지도에 표시되고 있는 마커를 제거합니다
	removeMarker();
	for(var i=0; i<places.length; i++) {
		var placePosition = new kakao.maps.LatLng(places[i].lat, places[i].lng);
		var marker = addMarker(placePosition, i);
		var itemEl = getListItem(i, places[i]); // 검색 결과 항목 Element를 생성합니다
		const aptCode = places[i].aptCode;
		
		// 검색된 장소 위치를 기준으로 지도 범위를 재설정하기위해
		// LatLngBounds 객체에 좌표를 추가합니다
		bounds.extend(placePosition);
		// 마커와 검색결과 항목에 mouseover 했을때
		// 해당 장소에 인포윈도우에 장소명을 표시합니다
		// mouseout 했을 때는 인포윈도우를 닫습니다
		(function (marker, title, code, place) {
			kakao.maps.event.addListener(marker, "click", function () {
				displayInfowindow(marker, title, place);

				
				// 마커에 마우스클릭 이벤트가 발생하면 인포윈도우를 마커위에 표시합니다
							var Latlng = {
									lat : place.lng,
									lng : place.lat
							}
							//가장 가까운 선별진료소 가져오기
							$.ajax({
								url:'/map/corona/near',  
								type:'POST',
								contentType:'application/json;charset=utf-8',
								dataType:'json',
								data: JSON.stringify(Latlng),
								success:function(near) {
									addCoronaMarker(near);
								},
								error:function(xhr,status,msg){
									console.log("상태값 : " + status + " Http에러메시지 : "+msg);
								}
							});
				
				
				$.get(root + "/map/aptByCode"
						,{dong: $("#dong").val(), aptCode: aptCode}
						,function(data, status){
							$("tbody").empty();
							$.each(data, function(index, vo) {
								let str = `
									<tr class="${colorArr[index%3]}">
									<td>${vo.aptCode}</td>
									<td>${vo.aptName}</td>
									<td>${vo.sidoName} ${vo.gugunName} ${vo.dongName} ${vo.jibun}</td>
									<td>${vo.buildYear}</td>
									<td>${vo.recentPrice}</td>
									</tr>
								`;
								$("tbody").append(str);
							});
						}
						, "json"
				);
			});

		    kakao.maps.event.addListener(map, "click", function () {
		    	console.log(customOverlay);
		    	closeOverlay();
		    	closeAllInfo();
	            setMarkers2(null);
		    });

		    itemEl.onmouseover = function () {
		    	displayInfowindow(marker, title);
		    };

		    itemEl.onmouseout = function () {
		    	customOverlay.setMap(null);
		    };
		})(marker, places[i].aptName, places[i].aptCode, places[i]);

		fragment.appendChild(itemEl);
	}
	// 마커를 생성하고 지도에 표시합니다 

	// 검색된 장소 위치를 기준으로 지도 범위를 재설정합니다
	map.setBounds(bounds);
}

//마커를 생성하고 지도 위에 마커를 표시하는 함수입니다
function addMarker(position, idx, title) {
	var imageSrc = "https://t1.daumcdn.net/localimg/localimages/07/mapapidoc/marker_number_blue.png", // 마커 이미지 url, 스프라이트 이미지를 씁니다
	imageSize = new kakao.maps.Size(36, 37), // 마커 이미지의 크기
	imgOptions = {
		spriteSize: new kakao.maps.Size(36, 691), // 스프라이트 이미지의 크기
		spriteOrigin: new kakao.maps.Point(0, idx * 46 + 10), // 스프라이트 이미지 중 사용할 영역의 좌상단 좌표
		offset: new kakao.maps.Point(13, 37), // 마커 좌표에 일치시킬 이미지 내에서의 좌표
	},
	markerImage = new kakao.maps.MarkerImage(imageSrc, imageSize, imgOptions),
	marker = new kakao.maps.Marker({
		position: position, // 마커의 위치
		image: markerImage,
	});

	marker.setMap(map); // 지도 위에 마커를 표출합니다
	markers.push(marker); // 배열에 생성된 마커를 추가합니다

	return marker;
}

// 지도 위에 표시되고 있는 마커를 모두 제거합니다
function removeMarker() {
	for (var i = 0; i < markers.length; i++) {
		markers[i].setMap(null);
	}
	markers = [];
}

//검색결과 항목을 Element로 반환하는 함수입니다
function getListItem(index, place) {
	var el = document.createElement("li");
	var itemStr = `
		<span class="markerbg marker_${index + 1}></span>
		<div class="info"><h5>${place.aptName}</h5> <button>관심등록</button>
		<span>${place.sidoName} ${place.gugunName} ${place.dongName} ${place.jibun}</span>
	`;
	el.innerHTML = itemStr;
	el.className = "item";

	return el;
}

//검색결과 목록 또는 마커를 클릭했을 때 호출되는 함수입니다
//인포윈도우에 장소명을 표시합니다
function displayInfowindow(marker, title, place) {
	var content = `
		<div class="overlaybox">
			<div class="boxtitle">${title}</div>

			<div class="first"><img src="${root}/img/apt.png" style="width:247px; height:136px;" alt=""></div>
			<ul>
				<li class="up">
					<span class="title">건축년도</span>
					<span class="count">${place.buildYear}</span>
				</li>
				<li>
					<span class="title">주소</span>
					<span class="count">${place.sidoName} ${place.gugunName} ${place.dongName} ${place.jibun};</span>
				</li>
				<li>
					<span class="title">최신거래금액</span>
					<span class="count">${place.recentPrice}</span>
				</li>
				<li>
					<span class="last" id="recenthistor" data-toggle="modal" data-target="#myModal">아파트정보 update</span>
				</li>
			</ul>
		</div>
	`;
	var position = new kakao.maps.LatLng(marker.getPosition().getLat()+0.00033, marker.getPosition().getLng()-0.00003);
	customOverlay = new kakao.maps.CustomOverlay({
		position: position,
		content: content,
		xAnchor: 0.3,
		yAnchor: 0.91,
	});
	closeOverlay();
	customOverlay.setMap(map);
	customOverlays.push(customOverlay)
}

//커스텀 오버레이를 닫기 위해 호출되는 함수입니다 
function closeOverlay() {
	for(var i=0; i< customOverlays.length; i++){
		customOverlays[i].setMap(null);
	}
}


//검색결과 목록의 자식 Element를 제거하는 함수입니다
function removeAllChildNods(el) {
	while (el.hasChildNodes()) {
		el.removeChild(el.lastChild);
	}
}