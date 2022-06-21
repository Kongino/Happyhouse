package com.ssafy.happyhouse.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.SidoGugunCode;

@Mapper
public interface HouseDealDao {
	public List<HouseDeal> searchAll(PageBean bean);
//	public List<HouseDeal> searchDongApt(String name);
//	public List<HouseDeal> searchApt(String AptName);
	public int count(PageBean bean);
	
	
	public List<SidoGugunCode> getSido();
	public List<SidoGugunCode> getGugunInSido(PageBean bean);
	public List<SidoGugunCode> getDongName(PageBean bean);
}
