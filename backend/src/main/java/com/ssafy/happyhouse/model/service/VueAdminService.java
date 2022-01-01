package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.VueChartDto;
import com.ssafy.happyhouse.model.VueUserDto;

public interface VueAdminService {
	public List<VueUserDto> selectVueUser() throws Exception;
	public List<String> selectVueUserAgeColumn() throws Exception;
	public List<String> selectVueUserEmailColumn() throws Exception;
	public List<String> selectVueUserSexColumn() throws Exception;
	public List<String> selectVueJointimeColumn() throws Exception;
	public List<Integer> selectVueUserAgeCount() throws Exception;
	public List<Integer> selectVueUserEmailCount() throws Exception;
	public List<Integer> selectVueUserSexCount() throws Exception;
	public List<Integer> selectVueJointimeCount() throws Exception;
}
