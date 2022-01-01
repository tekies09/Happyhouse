package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.VueBoardDto;


public interface VueBoardService {
	public List<VueBoardDto> selectVueNotice();
	public VueBoardDto selectVueNoticeByNo(int no);
	public boolean insertVueNotice(VueBoardDto vueboardDto);
	public boolean updateVueNotice(VueBoardDto vueboardDto);
	public boolean deleteVueNotice(int no);
	public List<VueBoardDto> selectVueFree();
	public VueBoardDto selectVueFreeByNo(int no);
	public boolean insertVueFree(VueBoardDto vueboardDto);
	public boolean updateVueFree(VueBoardDto vueboardDto);
	public boolean deleteVueFree(int no);
}
