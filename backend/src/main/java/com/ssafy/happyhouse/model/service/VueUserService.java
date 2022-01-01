package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.VueUserDto;


public interface VueUserService {
	VueUserDto login(String userId, String userPassword) throws Exception;
	boolean idCheck(String checkId) throws Exception;
	boolean JoinVueUser(VueUserDto vueuserDto) throws Exception;
	VueUserDto getVueUser(String userId) throws Exception;
	boolean updateVueUser(VueUserDto vueuserDto) throws Exception;
	boolean deleteVueUser(String userId) throws Exception;
	String selectpw(String userId, String userEmail) throws Exception;
}
