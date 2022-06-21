package com.ssafy.happyhouse.service;

import java.util.List;

import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.Pollution;

public interface PollutionService {
	public List<Pollution> searchAll(PageBean bean);
}
