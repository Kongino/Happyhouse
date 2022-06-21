package com.ssafy.happyhouse.service;

import java.sql.SQLException;
import java.util.List;

import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.SidoGugunCode;
public interface HouseDealService {
	
//	public List<HouseDeal> searchApt(String aptname)  ;
//	public List<HouseDeal> searchDong(String dongname)  ;
	public List<HouseDeal> searchAll(PageBean bean)  ;
	
//	public void add(HouseDeal housedeal)	  ;
//	public void update(HouseDeal housedeal) ;
//	public void remove(int id)     ;
	
	
	List<SidoGugunCode> getSido();
	List<SidoGugunCode> getGugunInSido(PageBean bean);
	List<SidoGugunCode> getDongName(PageBean bean);
}
