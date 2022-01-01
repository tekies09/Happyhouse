package com.ssafy.happyhouse.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.BookmarkDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

public interface HouseMapMapper {

	List<SidoGugunCodeDto> getSido() throws SQLException;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;
	List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;
	List<HouseInfoDto> getAptInDong(String dong) throws SQLException;
	String getAddress(Map<String, Object> apt) throws SQLException;
	HouseInfoDto getAptByAptCode(Map<String, Object> apt) throws SQLException;
	List<HouseInfoDto> getAptByCodeAndDong(Map<String, Object> apt) throws SQLException;
	void addBookmark(Map<String, Object> map) throws SQLException;
	List<BookmarkDto> getBookmarks(String userId) throws SQLException;
	List<HouseInfoDto> getHouseDeal(String aptCode) throws SQLException;
	void delBookmark(Map<String, Object> map) throws SQLException;
}
