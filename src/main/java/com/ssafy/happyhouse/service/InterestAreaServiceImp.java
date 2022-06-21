package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.dao.InterestAreaDao;
import com.ssafy.happyhouse.dto.InterestArea;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.SidoGugunCode;

@Service
public class InterestAreaServiceImp implements InterestAreaService {

	@Autowired
	private InterestAreaDao dao;
	
	@Override
	public List<InterestArea> selectInterest(PageBean bean) {
		return dao.selectInterest(bean);
	}
	
	@Override
	public List<InterestArea> selectInterestAll(){
		return dao.selectInterestAll();
	}

	@Override
	public void deleteInterest(int no) {
		dao.deleteInterest(no);
	}

	@Override
	public int insertInterest(InterestArea interestarea) {
		return dao.insertInterest(interestarea);
	}
	@Override
	public List<SidoGugunCode> getSido(){
		return dao.igetSido();
	}

	@Override
	public List<SidoGugunCode> getGugunInSido(PageBean bean) {
		return dao.igetGugunInSido(bean);
	}
	
	@Override
	public List<SidoGugunCode> getDongName(PageBean bean) {
		return dao.igetDongName(bean);
	}


}
