package com.ssafy.happyhouse.model.mapper;


import java.util.List;
import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.VueUserDto;


@Mapper
public interface VueUserMapper {
	public List<VueUserDto> selectVueUser() throws Exception;
	public VueUserDto login(String userId, String userPassword) throws Exception;
	public int idCheck(String checkId) throws Exception;
	public int JoinVueUser(VueUserDto vueuserDto) throws Exception;
	public VueUserDto getVueUser(String userId) throws Exception;
	public int updateVueUser(VueUserDto vueuserDto) throws Exception;
	public int deleteVueUser(String userId) throws Exception;
	public List<String> selectVueUserAgeColumn() throws Exception;
	public List<String> selectVueUserEmailColumn() throws Exception;
	public List<String> selectVueUserSexColumn() throws Exception;
	public List<String> selectVueJointimeColumn() throws Exception;
	public List<Integer> selectVueUserAgeCount() throws Exception;
	public List<Integer> selectVueUserEmailCount() throws Exception;
	public List<Integer> selectVueUserSexCount() throws Exception;
	public List<Integer> selectVueJointimeCount() throws Exception;
	public String selectpw(String userId, String userEmail) throws Exception;
}
