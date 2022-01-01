package com.ssafy.happyhouse.model.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.mapper.VueUserMapper;
import com.ssafy.happyhouse.model.VueChartDto;
import com.ssafy.happyhouse.model.VueUserDto;

@Service
public class VueAdminServiceImpl implements VueAdminService {

	
    @Autowired
	private VueUserMapper VueuserMapper;
	
	@Override
	public List<VueUserDto> selectVueUser() throws Exception {
		// TODO Auto-generated method stub
		return VueuserMapper.selectVueUser();
	}
	
	public List<String> selectVueUserAgeColumn() throws Exception{
		return VueuserMapper.selectVueUserAgeColumn();
	};
	public List<String> selectVueUserEmailColumn() throws Exception{
		return VueuserMapper.selectVueUserEmailColumn();
	}
	public List<String> selectVueUserSexColumn() throws Exception{
		return VueuserMapper.selectVueUserSexColumn();
	}
	public List<String> selectVueJointimeColumn() throws Exception{
		return VueuserMapper.selectVueJointimeColumn();
	}
	public List<Integer> selectVueUserAgeCount() throws Exception{
		return VueuserMapper.selectVueUserAgeCount();
	}
	public List<Integer> selectVueUserEmailCount() throws Exception{
		return VueuserMapper.selectVueUserEmailCount();
	}
	public List<Integer> selectVueUserSexCount() throws Exception{
		return VueuserMapper.selectVueUserSexCount();
	}
	public List<Integer> selectVueJointimeCount() throws Exception{
		return VueuserMapper.selectVueJointimeCount();
	}

}
