package com.ssafy.happyhouse.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.happyhouse.model.BookmarkDto;
import com.ssafy.happyhouse.model.CoronaDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.service.HappyHouseMapService;

import net.sf.json.JSONArray;
@RestController
@RequestMapping("/map")
@CrossOrigin("*")
public class HappyHouseMapController {
	
	@Autowired
	private HappyHouseMapService happyHouseMapService;
	
	public List<CoronaDto> hospitals = new ArrayList<>();
	
	@GetMapping("/sido")
	public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception{
		return new ResponseEntity<List<SidoGugunCodeDto>>(happyHouseMapService.getSido(), HttpStatus.OK);
	}
	
	@GetMapping("/gugun")
	public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception{
		return new ResponseEntity<List<SidoGugunCodeDto>>(happyHouseMapService.getGugunInSido(sido), HttpStatus.OK);
	}

	@GetMapping("/dong")
	public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception{
		return new ResponseEntity<List<HouseInfoDto>>(happyHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
	}
	
	@GetMapping("/apt")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception{
		return new ResponseEntity<List<HouseInfoDto>>(happyHouseMapService.getAptInDong(dong), HttpStatus.OK);
	}
	
	@PostMapping("/apt-by-sigu")
	public ResponseEntity<List<Map<String, Object>>> aptByDong(@RequestBody Map<String,Object> param) throws Exception{
		    List<Map<String,Object>> info = JSONArray.fromObject(param.get("params"));
			List<Map<String, Object>> list = new ArrayList<>();

		    for (Map<String, Object> apt : info) {
		    	Map<String, Object> map = new HashMap<String, Object>();
		    	map.put("aptCode", apt.get("aptCode"));
		    	map.put("aptName", apt.get("aptName"));
		    	map.put("dongCode", apt.get("dongCode"));
		    	map.put("buildYear", apt.get("buildYear"));
		    	map.put("jibun", apt.get("jibun"));
		    	map.put("recentPrice", apt.get("recentPirce"));
		    	map.put("gugunName", apt.get("gugunName"));
		    	String address = happyHouseMapService.getAddress(apt);
		    	map.put("address", address);
		    	StringTokenizer st = new StringTokenizer(address," ");
		    	map.put("sidoName", st.nextToken());
		    	map.put("gugunName", st.nextToken());
		    	map.put("dongName", st.nextToken());
		    	map.put("gugunCode", apt.get("gugun"));
		    	System.out.println(happyHouseMapService.getAddress(apt));
		    	list.add(map);
				}  
		return new ResponseEntity<List<Map<String, Object>>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/aptByCode")
	public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong, @RequestParam("aptCode") String aptCode) throws Exception{
		Map<String,Object> info = new HashMap<String, Object>();
		info.put("dong", dong);
		info.put("aptCode", aptCode);
		
		return new ResponseEntity<List<HouseInfoDto>>(happyHouseMapService.getAptByCodeAndDong(info), HttpStatus.OK);
	}
	
	@PostMapping(value = "/apt/{aptCode}")
	public ResponseEntity<List<HouseInfoDto>> aptByAptCode(@RequestBody Map<String, Map<String, Object>> param, @PathVariable("aptCode") String aptCode)
			throws Exception {
		System.out.println(aptCode);
//		System.out.println((param.get("params")).get("jsonArray"));
		List<Map<String, Object>> info = JSONArray.fromObject((param.get("params")).get("jsonArray"));

		List<HouseInfoDto> list = new ArrayList<>();
//		System.out.println(aptCode);
		for (Map<String, Object> apt : info) {
			if (aptCode.equals(apt.get("aptCode"))) {
				System.out.println(apt.toString());
				HouseInfoDto house = new HouseInfoDto();
				house = happyHouseMapService.getAptByAptCode(apt);
				System.out.println(house.toString());
				list.add(house);
			}
		}
//		System.out.println(list.size());

		return new ResponseEntity<List<HouseInfoDto>>(list, HttpStatus.OK);
	}
	
	@PostMapping(value="/corona")
	public void getCoronaInfo(@RequestBody Map<String,CoronaDto[]> param){
		for(CoronaDto c: param.get("params")) {
			hospitals.add(c);
		}
		System.out.println(hospitals.size());
	}
	
	@PostMapping(value="/corona/near")
	public ResponseEntity<CoronaDto> getNearHospital(@RequestBody Map<String, Map<String,Object>> params) {
		Map<String, Object> map = params.get("params");
		String lat = String.valueOf(map.get("lng"));
		String lng = String.valueOf(map.get("lat"));
		HashMap<Integer, Double> distance = new HashMap<Integer, Double>();
		
		double lat1 = Double.parseDouble(lat);
		double lng1 = Double.parseDouble(lng);
		
		for(int i=0; i<hospitals.size(); i++) {
			CoronaDto c = hospitals.get(i);
			double lat2 = Double.parseDouble(c.getLat());
			double lng2 = Double.parseDouble(c.getLng());
			
			double len = Math.pow((lat1-lat2),2)+Math.pow((lng1-lng2),2);
			len = Math.sqrt(len);
			
			distance.put(i, len);
		}
		
		List<Integer> keySetList = new ArrayList<>(distance.keySet());
		Collections.sort(keySetList, (o1, o2) -> (distance.get(o1).compareTo(distance.get(o2))));
		
		System.out.println(hospitals.get(keySetList.get(0)).toString());
		CoronaDto near = hospitals.get(keySetList.get(0));
		
		return new ResponseEntity<CoronaDto>(near, HttpStatus.OK);
	}
	
	@GetMapping(value="/addBookmark")
	public HttpStatus addBookmark(@RequestParam("gugunCode") String gugunCode, @RequestParam("userId") String userid) throws Exception {
		System.out.println(gugunCode+" "+userid);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("gugunCode", gugunCode);
		
		happyHouseMapService.addBookmark(map);
		return HttpStatus.OK;
	}
	
	@GetMapping(value="/deleteBookmark")
	public HttpStatus delBookmark(@RequestParam("gugunCode") String gugunCode, @RequestParam("userId") String userid) throws Exception {
		System.out.println(gugunCode+" "+userid);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("gugunCode", gugunCode);
		
		happyHouseMapService.delBookmark(map);
		return HttpStatus.OK;
	}
	
	@GetMapping(value="/getBookmarks")
	public ResponseEntity<List<BookmarkDto>> getBookmarks(@RequestParam("userId") String userid) throws Exception{
		
		List<BookmarkDto> list = new ArrayList<BookmarkDto>();
		
		list = happyHouseMapService.getBookmarks(userid);
		
		return new ResponseEntity<List<BookmarkDto>>(list, HttpStatus.OK);
		
	}
	
	@GetMapping(value="/houseDeal")
	public ResponseEntity<List<HouseInfoDto>> getHouseDeal(@RequestParam("aptCode") String aptCode) throws Exception{
		return new ResponseEntity<List<HouseInfoDto>>(happyHouseMapService.getHouseDeal(aptCode), HttpStatus.OK);
	}

}
