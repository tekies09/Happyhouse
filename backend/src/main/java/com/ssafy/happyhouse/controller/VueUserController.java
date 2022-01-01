package com.ssafy.happyhouse.controller;
import com.ssafy.happyhouse.model.VueUserDto;
import com.ssafy.happyhouse.model.service.VueUserService;

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
@RequestMapping("vue/api/vueuser")
public class VueUserController {
	
	private static final Logger logger = LoggerFactory.getLogger(VueUserController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private VueUserService VueuserService;
	
    @ApiOperation(value = "회원가입기능 . 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("join")
	public ResponseEntity<String> JoinVueUser(@RequestBody VueUserDto vueuserDto) throws Exception {
		logger.debug("회원가입 - 호출");
		logger.debug(vueuserDto.getUserName());
		if (VueuserService.JoinVueUser(vueuserDto)) {
			System.out.println("test");
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		System.out.println("test2");
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    @ApiOperation(value = "로그인기능 . 로그인 성공여부에 따라 null 또는 데이터값을 반환한다 .", response = String.class)
  	@PostMapping("login")
  	public ResponseEntity<VueUserDto> login(@RequestBody VueUserDto vueuserDto) throws Exception {
  		logger.debug("로그인 - 호출");
  		logger.debug(vueuserDto.getUserId() + " : "+ vueuserDto.getUserPassword());
  		String userId = vueuserDto.getUserId();
  		String userPw = vueuserDto.getUserPassword();
  		return new ResponseEntity<VueUserDto>(VueuserService.login(userId, userPw),HttpStatus.OK);
  	}
    
    @ApiOperation(value = "아이디에 해당하는 회원의 정보를 반환한다.", response = VueUserDto.class)    
	@GetMapping("{userId}")
	public ResponseEntity<VueUserDto> getVueUser(@PathVariable String userId) throws Exception {
		logger.debug("user정보 - 호출");
		return new ResponseEntity<VueUserDto>(VueuserService.getVueUser(userId), HttpStatus.OK);
	}
    
    @ApiOperation(value = "아이디에 해당하는 회원정보의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
  	@PutMapping("{userId}")
  	public ResponseEntity<String> updateVueUser(@RequestBody VueUserDto vueuserDto) throws Exception {
  		logger.debug("userUpdate - 호출");
  		logger.debug("" + vueuserDto);
  		
  		if (VueuserService.updateVueUser(vueuserDto)) {
  			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
  		}
  		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
  	}
    @ApiOperation(value = "아이디에 해당하는 회원정보의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
 	@DeleteMapping("{userId}")
 	public ResponseEntity<String> deleteVueUser(@PathVariable String userId) throws Exception {
 		logger.debug("deleteVueUser- 호출");
 		if (VueuserService.deleteVueUser(userId)) {
 			logger.debug(userId + ": delete성공");
 			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
 		}
 		logger.debug(userId +  ": delete실패");
 		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
 	}
    
    @ApiOperation(value = "패스워드찾기 . 아이디 이메일 일치 여부에 따라 null 또는 데이터값을 반환한다 .", response = String.class)
  	@PostMapping("findpw")
  	public ResponseEntity<String> findpw(@RequestBody VueUserDto vueuserDto) throws Exception {
  		logger.debug("로그인 - 호출");
  		logger.debug(vueuserDto.getUserId() + " : "+ vueuserDto.getUserEmail());
  		String userId = vueuserDto.getUserId();
  		String userEmail = vueuserDto.getUserEmail();
  		String userPw = VueuserService.selectpw(userId, userEmail);
  		if(userPw==null) {
  			return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
  		}
  		return new ResponseEntity<String>(userPw, HttpStatus.OK);
  	}
    
    
    
    
}
