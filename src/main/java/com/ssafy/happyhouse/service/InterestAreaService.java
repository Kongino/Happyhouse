package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.InterestArea;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.SidoGugunCode;

public interface InterestAreaService {
	public List<InterestArea> selectInterestAll();
	public List<InterestArea> selectInterest(PageBean bean);
	public int insertInterest(InterestArea interestarea);
	public void deleteInterest(int no);
	
	List<SidoGugunCode> getSido();
	List<SidoGugunCode> getGugunInSido(PageBean bean);
	List<SidoGugunCode> getDongName(PageBean bean);
}
