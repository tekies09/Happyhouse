package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.VueBoardDto;
@Mapper
public interface VueBoardMapper {
	public List<VueBoardDto> selectVueNotice();
	public VueBoardDto selectVueNoticeByNo(int no);
	public int insertVueNotice(VueBoardDto vueboardDto);
	public int updateVueNotice(VueBoardDto vueboardDto);
	public int deleteVueNotice(int no);
	public List<VueBoardDto> selectVueFree();
	public VueBoardDto selectVueFreeByNo(int no);
	public int insertVueFree(VueBoardDto vueboardDto);
	public int updateVueFree(VueBoardDto vueboardDto);
	public int deleteVueFree(int no);
}
