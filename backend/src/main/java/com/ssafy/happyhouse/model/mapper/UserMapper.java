package com.ssafy.happyhouse.model.mapper;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.UserDto;


public interface UserMapper {
	UserDto login(Map<String, String> map) throws Exception;
	
	int idCheck(String checkId) throws Exception;
	void registerMember(UserDto memberDto) throws Exception;
	
	List<UserDto> listMember() throws Exception;
	UserDto getMember(String userId) throws Exception;
	void updateMember(UserDto memberDto) throws Exception;
	void deleteMember(String userId) throws Exception;
}
