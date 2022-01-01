package com.ssafy.happyhouse.controller;
import com.ssafy.happyhouse.model.VueChartDto;
import com.ssafy.happyhouse.model.VueUserDto;
import com.ssafy.happyhouse.model.service.VueAdminService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "http://192.168.35.67:8080","http://localhost:8080" }, maxAge = 6000)
@RestController
@RequestMapping("vue/api/vueadmin")
public class VueAdminController {
	private static final Logger logger = LoggerFactory.getLogger(VueAdminController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private VueAdminService VueadminService;
	
	
	@ApiOperation(value = "모든 유저의의 정보를 리스트로 반환한다.", response = List.class)
	@GetMapping("userlist")
	public ResponseEntity<List<VueUserDto>> selectVueUser() throws Exception {
	logger.debug("관리자 회원정보 호출");
	List<VueUserDto> listcheck = VueadminService.selectVueUser();
	logger.debug(listcheck.get(0).getUserName());
	return new ResponseEntity<List<VueUserDto>>(listcheck, HttpStatus.OK);
		}
	
	
	@ApiOperation(value = "10~60대 나이정보 컬럼 반환.", response = List.class)
	@GetMapping("useragecolumn")
	public ResponseEntity<List<String>> selectVueUserAgeColumn() throws Exception {
	logger.debug("나이정보컬럼호출");
	List<String> listcheck = VueadminService.selectVueUserAgeColumn();
	logger.debug(listcheck.get(0)+"0 대");
	return new ResponseEntity<List<String>>(listcheck, HttpStatus.OK);
		}
	@ApiOperation(value = "10~60대 나이정보 컬럼  값반환.", response = List.class)
	@GetMapping("useragecount")
	public ResponseEntity<List<Integer>> selectVueUserAgeCount() throws Exception {
	logger.debug("나이정보컬럼값호출");
	List<Integer> listcheck = VueadminService.selectVueUserAgeCount();
	logger.debug(listcheck.get(0)+"value");
	return new ResponseEntity<List<Integer>>(listcheck, HttpStatus.OK);
		}
	
	
	@ApiOperation(value = "email  컬럼 반환.", response = List.class)
	@GetMapping("useremailcolumn")
	public ResponseEntity<List<String>> selectVueUserEmailColumn() throws Exception {
	logger.debug("이메일정보차트호출");
	List<String> listcheck = VueadminService.selectVueUserEmailColumn();
	logger.debug(listcheck.get(0)+"도메인 ");
	return new ResponseEntity<List<String>>(listcheck, HttpStatus.OK);
		}
	
	@ApiOperation(value = "email  컬럼 value 반환.", response = List.class)
	@GetMapping("useremailcount")
	public ResponseEntity<List<Integer>> selectVueUserEmailCount() throws Exception {
	logger.debug("이메일정보차트값호출");
	List<Integer> listcheck = VueadminService.selectVueUserEmailCount();
	logger.debug(listcheck.get(0)+"value ");
	return new ResponseEntity<List<Integer>>(listcheck, HttpStatus.OK);
		}
	
	
	@ApiOperation(value = "성별 컬럼 변환.", response = List.class)
	@GetMapping("usersexcolumn")
	public ResponseEntity<List<String>> selectVueUserSexColumn() throws Exception {
	logger.debug("성별차트호출");
	List<String> listcheck = VueadminService.selectVueUserSexColumn();
	logger.debug(listcheck.get(0)+" : sex");
	return new ResponseEntity<List<String>>(listcheck, HttpStatus.OK);
		}
	
	@ApiOperation(value = "성별 컬럼 value 변환.", response = List.class)
	@GetMapping("usersexcount")
	public ResponseEntity<List<Integer>> selectVueUserSexCount() throws Exception {
	logger.debug("성별차트value호출");
	List<Integer> listcheck = VueadminService.selectVueUserSexCount();
	logger.debug(listcheck.get(0)+" : value");
	return new ResponseEntity<List<Integer>>(listcheck, HttpStatus.OK);
		}
	
	@ApiOperation(value = "가입차트변환.", response = List.class)
	@GetMapping("userjointimecolumn")
	public ResponseEntity<List<String>> selectVueJointimeColumn() throws Exception {
	logger.debug("가입일 차트 호출");
	List<String> listcheck = VueadminService.selectVueJointimeColumn();
	logger.debug(listcheck.get(0)+"월 : ");
	return new ResponseEntity<List<String>>(listcheck, HttpStatus.OK);
		}
	
	@ApiOperation(value = "가입차트 value 변환.", response = List.class)
	@GetMapping("userjointimecount")
	public ResponseEntity<List<Integer>> selectVueJointimeCount() throws Exception {
	logger.debug("가입일 차트 호출");
	List<Integer> listcheck = VueadminService.selectVueJointimeCount();
	logger.debug(listcheck.get(0)+" : value ");
	return new ResponseEntity<List<Integer>>(listcheck, HttpStatus.OK);
		}
}
