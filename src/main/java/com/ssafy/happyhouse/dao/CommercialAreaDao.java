package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.CommercialArea;
import com.ssafy.happyhouse.dto.CommercialCount;
import com.ssafy.happyhouse.dto.PageBean;

@Mapper
public interface CommercialAreaDao {
	public List<CommercialArea> commercialAll(PageBean bean);
//	public List<HouseDeal> searchDongApt(String name);
//	public List<HouseDeal> searchApt(String AptName);
	public int countCom(PageBean bean);
	public CommercialCount stat(PageBean bean);
}
