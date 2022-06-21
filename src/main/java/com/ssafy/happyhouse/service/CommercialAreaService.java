package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.CommercialArea;
import com.ssafy.happyhouse.dto.CommercialCount;
import com.ssafy.happyhouse.dto.PageBean;

public interface CommercialAreaService{

	public List<CommercialArea> commercialAll(PageBean bean)  ;
//	public int[] statisticsAll(PageBean bean);
	public CommercialCount stat(PageBean bean);
}
