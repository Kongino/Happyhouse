package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.Pollution;

@Mapper
public interface PollutionDao {
	public List<Pollution> searchAllP(PageBean bean);
//	public List<Pollution> searchDongApt(String name);
	public int countP(PageBean bean);
}
