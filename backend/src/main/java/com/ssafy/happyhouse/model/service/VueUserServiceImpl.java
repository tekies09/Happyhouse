package com.ssafy.happyhouse.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.model.mapper.VueUserMapper;
import com.ssafy.happyhouse.model.VueUserDto;




@Service
public class VueUserServiceImpl implements VueUserService {

    @Autowired
	private VueUserMapper VueuserMapper;
    
	@Override
	public VueUserDto login(String userId, String userPassword) throws Exception {
		// TODO Auto-generated method stub
		VueUserDto vueuser = VueuserMapper.login(userId, userPassword);
		return vueuser;
	}

	@Override
	public boolean idCheck(String checkId) throws Exception {
		// TODO Auto-generated method stub
		return VueuserMapper.idCheck(checkId)==0;
	}

	@Override
	public boolean JoinVueUser(VueUserDto vueuserDto) throws Exception {
		// TODO Auto-generated method stub
		return VueuserMapper.JoinVueUser(vueuserDto)==1;
	}

	@Override
	public VueUserDto getVueUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return VueuserMapper.getVueUser(userId);
	}

	@Override
	@Transactional
	public boolean updateVueUser(VueUserDto vueuserDto) throws Exception {
		// TODO Auto-generated method stub
		return VueuserMapper.updateVueUser(vueuserDto)==1;
	}

	@Override
	@Transactional
	public boolean deleteVueUser(String userId) throws Exception {
		// TODO Auto-generated method stub
		return VueuserMapper.deleteVueUser(userId)==1;
	}
	
	public String selectpw(String userId, String userEmail) throws Exception {
		return VueuserMapper.selectpw(userId, userEmail);
	}

}
