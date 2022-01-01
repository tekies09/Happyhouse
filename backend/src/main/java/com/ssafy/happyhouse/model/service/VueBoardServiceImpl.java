package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.mapper.VueBoardMapper;
import com.ssafy.happyhouse.model.VueBoardDto;

@Service
public class VueBoardServiceImpl implements VueBoardService {

	@Autowired
	private VueBoardMapper VueboardMapper;
	
	
	
	@Override
	public List<VueBoardDto> selectVueNotice() {
		// TODO Auto-generated method stub
		return VueboardMapper.selectVueNotice();
	}

	@Override
	public VueBoardDto selectVueNoticeByNo(int no) {
		// TODO Auto-generated method stub
		return VueboardMapper.selectVueNoticeByNo(no);
	}

	@Override
	public boolean insertVueNotice(VueBoardDto vueboardDto) {
		// TODO Auto-generated method stub
		return VueboardMapper.insertVueNotice(vueboardDto)==1;
	}

	@Override
	public boolean updateVueNotice(VueBoardDto vueboardDto) {
		// TODO Auto-generated method stub
		return VueboardMapper.updateVueNotice(vueboardDto)==1;
	}

	@Override
	public boolean deleteVueNotice(int no) {
		// TODO Auto-generated method stub
		return VueboardMapper.deleteVueNotice(no)==1;
	}

	@Override
	public List<VueBoardDto> selectVueFree() {
		// TODO Auto-generated method stub
		return VueboardMapper.selectVueFree();
	}

	@Override
	public VueBoardDto selectVueFreeByNo(int no) {
		// TODO Auto-generated method stub
		return VueboardMapper.selectVueFreeByNo(no);
	}

	@Override
	public boolean insertVueFree(VueBoardDto vueboardDto) {
		// TODO Auto-generated method stub
		return VueboardMapper.insertVueFree(vueboardDto)==1;
	}

	@Override
	public boolean updateVueFree(VueBoardDto vueboardDto) {
		// TODO Auto-generated method stub
		return VueboardMapper.updateVueFree(vueboardDto)==1;
	}

	@Override
	public boolean deleteVueFree(int no) {
		// TODO Auto-generated method stub
		return VueboardMapper.deleteVueFree(no)==1;
	}

}
