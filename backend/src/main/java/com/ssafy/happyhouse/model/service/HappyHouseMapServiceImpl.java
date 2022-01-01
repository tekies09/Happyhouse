package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.BookmarkDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.mapper.HouseMapMapper;

@Service
public class HappyHouseMapServiceImpl implements HappyHouseMapService {

	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<SidoGugunCodeDto> getSido() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapMapper.class).getSido();
	}

	@Override
	public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapMapper.class).getGugunInSido(sido);
	}

	@Override
	public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapMapper.class).getDongInGugun(gugun);
	}

	@Override
	public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapMapper.class).getAptInDong(dong);
	}

	@Override
	public String getAddress(Map<String, Object> apt) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapMapper.class).getAddress(apt);
	}

	@Override
	public HouseInfoDto getAptByAptCode(Map<String, Object> apt) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapMapper.class).getAptByAptCode(apt);
	}

	@Override
	public List<HouseInfoDto> getAptByCodeAndDong(Map<String, Object> info) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapMapper.class).getAptByCodeAndDong(info);
	}

	@Override
	public void addBookmark(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(HouseMapMapper.class).addBookmark(map);
	}

	@Override
	public List<BookmarkDto> getBookmarks(String userId) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapMapper.class).getBookmarks(userId);
	}

	@Override
	public List<HouseInfoDto> getHouseDeal(String aptCode) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(HouseMapMapper.class).getHouseDeal(aptCode);
	}

	@Override
	public void delBookmark(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.getMapper(HouseMapMapper.class).delBookmark(map);

	}
	
	


}
