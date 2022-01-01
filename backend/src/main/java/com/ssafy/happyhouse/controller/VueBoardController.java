package com.ssafy.happyhouse.controller;

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

import com.ssafy.happyhouse.model.VueBoardDto;
import com.ssafy.happyhouse.model.service.VueBoardService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = { "http://192.168.35.67:8080","http://localhost:8080" }, maxAge = 6000)
@RestController
@RequestMapping("vue/api/vueboard")
public class VueBoardController {
	private static final Logger logger = LoggerFactory.getLogger(VueBoardController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private VueBoardService VueboardService;

    @ApiOperation(value = "모든 공지사항글의 정보를 반환한다.", response = List.class)
    @GetMapping("notice")
	public ResponseEntity<List<VueBoardDto>> selectVueNotice() throws Exception {
		logger.debug("selectVueNotice - 호출");
		return new ResponseEntity<List<VueBoardDto>>(VueboardService.selectVueNotice(), HttpStatus.OK);
	}

    @ApiOperation(value = "공지사항 번호에 해당하는 게시글의 정보를 반환한다.", response = VueBoardDto.class)    
	@GetMapping("notice/{no}")
	public ResponseEntity<VueBoardDto> selectVueNoticeByNo(@PathVariable int no) {
		logger.debug("selectVueNoticeByNo - 호출");
		return new ResponseEntity<VueBoardDto>(VueboardService.selectVueNoticeByNo(no), HttpStatus.OK);
	}

    @ApiOperation(value = "새로운 공지사항 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("notice")
	public ResponseEntity<String> insertVueNotice(@RequestBody VueBoardDto vueboardDto) {
		logger.debug("insertVueNotice - 호출");
		if (VueboardService.insertVueNotice(vueboardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 공지글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("notice/{no}")
	public ResponseEntity<String> updateVueNotice(@RequestBody VueBoardDto vueboardDto) {
		logger.debug("updateVueNotice - 호출");
		logger.debug("" + vueboardDto);
		
		if (VueboardService.updateVueNotice(vueboardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 공지글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("notice/{no}")
	public ResponseEntity<String> deleteVueNotice(@PathVariable int no) {
		logger.debug("deleteVueNotice - 호출");
		if (VueboardService.deleteVueNotice(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
    @ApiOperation(value = "모든 자유게시판 글의 정보를 반환한다.", response = List.class)
    @GetMapping("free")
	public ResponseEntity<List<VueBoardDto>> selectVueFree() throws Exception {
		logger.debug("selectVueFree - 호출");
		return new ResponseEntity<List<VueBoardDto>>(VueboardService.selectVueFree(), HttpStatus.OK);
	}

    @ApiOperation(value = "자유게시판 번호에 해당하는 게시글의 정보를 반환한다.", response = VueBoardDto.class)    
	@GetMapping("free/{no}")
	public ResponseEntity<VueBoardDto> selectVueFreeByNo(@PathVariable int no) {
		logger.debug("selectVueFreeByNo - 호출");
		return new ResponseEntity<VueBoardDto>(VueboardService.selectVueFreeByNo(no), HttpStatus.OK);
	}

    @ApiOperation(value = "새로운 자유게시판 글의 정보를 입력한다. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("free")
	public ResponseEntity<String> insertVueFree(@RequestBody VueBoardDto vueboardDto) {
		logger.debug("insertVueFree - 호출");
		if (VueboardService.insertVueFree(vueboardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 자유게시판 글의 정보를 수정한다. 그리고 DB수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping("free/{no}")
	public ResponseEntity<String> updateVueFree(@RequestBody VueBoardDto vueboardDto) {
		logger.debug("updateVueFree - 호출");
		logger.debug("" + vueboardDto);
		
		if (VueboardService.updateVueFree(vueboardDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

    @ApiOperation(value = "글번호에 해당하는 자유게시판글의 정보를 삭제한다. 그리고 DB삭제 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@DeleteMapping("free/{no}")
	public ResponseEntity<String> deleteVueFree(@PathVariable int no) {
		logger.debug("deleteVueFree - 호출");
		if (VueboardService.deleteVueFree(no)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
    
}
