package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.UserDto;
import com.ssafy.happyhouse.model.mapper.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public UserDto login(Map<String, String> map) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).login(map);
	}

	@Override
	public int idCheck(String checkId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).idCheck(checkId); // 0 or 1
	}

	@Override
	public void registerMember(UserDto userDto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(UserMapper.class).registerMember(userDto);
	}

	@Override
	public List<UserDto> listMember() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).listMember();
	}

	@Override
	public UserDto getMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).getMember(userId);
	}

	@Override
	public void updateMember(UserDto userDto) throws Exception {
		sqlSession.getMapper(UserMapper.class).updateMember(userDto);

	}

	@Override
	public void deleteMember(String userId) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(UserMapper.class).deleteMember(userId);
	}

}
