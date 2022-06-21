package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.InterestArea;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.SidoGugunCode;
@Mapper
public interface InterestAreaDao {
	public List<InterestArea> selectInterestAll();
	public List<InterestArea> selectInterest(PageBean bean);
	public int insertInterest(InterestArea interestarea);
	public void deleteInterest(int no);
	
	public List<SidoGugunCode> igetSido();
	public List<SidoGugunCode> igetGugunInSido(PageBean bean);
	public List<SidoGugunCode> igetDongName(PageBean bean);
	
}