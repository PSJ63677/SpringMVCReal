<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Api 샘플 화면</title>
	<script type="text/javascript" src="https://openapi.map.naver.com/openapi/v3/maps.js?ncpClientId=ijeb1lirtk&submodules=geocoder"></script>
	</head>
	<body>
		<h1>Api 샘플</h1>
		<h2>네이버 지도</h2>
			<!-- 1.HTML코드 있어야 함 -->
		<div id="map" style="width:100%;height:400px;"></div>
		<script>
			// 2. HTML 코드 위에 그려주는 JS Library, Code필요
			var mapOptions = {
			    center: new naver.maps.LatLng(37.5679212, 126.9830358),
			    zoom: 17
			};
			
			var map = new naver.maps.Map('map', mapOptions);
			var marker = new naver.maps.Marker({
			    position: new naver.maps.LatLng(37.5679212, 126.9830358),
			    map: map
			});
			var contentString = "<div style='color:blue;'>인포윈도우</div>";
			var infowindow = new naver.maps.InfoWindow({
			    content: contentString
			});
			infowindow.open(map, marker);
			naver.maps.Event.addListener(map,"click", function(e) {
				// 지도 클릭되었을때
				marker.setPosition(e.coord);	// 클릭한 위치로 마커 옮기기
				if(infowindow != null) {
					if(infowindow.getMap()) {
						infowindow.close();
					}
				}
				naver.maps.Service.reverseGeocode({
					location : new naver.maps.LatLng(e.coord.lat(), e.coord.lng())
				}, function(status, response) {
					// console.log(responce);
					var result = response.result;
					// console.log(result);
					var items = result.items;
					var address = items[1].address;
					contentString = address;
				});
				// infowindow.open(map, marker);
			});
			naver.maps.Event.addListener(marker,"click", function(e) {
				// 마커 클릭되었을때
				if(infowindow != null) {
					if(infowindow.getMap()) {
						infowindow.close();
					} else {
						infowindow = new naver.maps.InfoWindow({
							content : contentString
						});
						infowindow.open(map, marker);
					}
				}
			});
		</script>
	</body>
</html>