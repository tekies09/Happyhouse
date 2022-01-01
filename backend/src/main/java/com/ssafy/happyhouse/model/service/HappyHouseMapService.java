package com.ssafy.happyhouse.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.happyhouse.model.BookmarkDto;
import com.ssafy.happyhouse.model.HouseInfoDto;
import com.ssafy.happyhouse.model.SidoGugunCodeDto;

public interface HappyHouseMapService {

	List<SidoGugunCodeDto> getSido() throws Exception;
	List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception;
	List<HouseInfoDto> getDongInGugun(String gugun) throws Exception;
	List<HouseInfoDto> getAptInDong(String dong) throws Exception;
	String getAddress(Map<String, Object> apt) throws Exception;
	HouseInfoDto getAptByAptCode(Map<String, Object> apt) throws Exception;
	List<HouseInfoDto> getAptByCodeAndDong(Map<String, Object> apt) throws Exception;
	void addBookmark(Map<String, Object> map) throws Exception;
	List<BookmarkDto> getBookmarks(String userId) throws Exception;
	List<HouseInfoDto> getHouseDeal(String aptCode) throws Exception;
	void delBookmark(Map<String, Object> map) throws Exception;
}
