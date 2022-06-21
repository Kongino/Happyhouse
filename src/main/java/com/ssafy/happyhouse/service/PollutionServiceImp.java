package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.PollutionDao;
import com.ssafy.happyhouse.dto.HouseDealException;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.Pollution;
import com.ssafy.happyhouse.util.PageUtility;

@Service
public class PollutionServiceImp implements PollutionService {

	@Autowired
	private PollutionDao dao;

	@Transactional
	public List<Pollution> searchAll(PageBean bean) {
		int cnt = dao.countP(bean);
		try {
			PageUtility page = new PageUtility(bean.getInterval(), cnt, bean.getPageNo(), "");
			bean.setPageLink(page.getPageBar());
		}catch (Exception e) {
			throw new HouseDealException("페이징 오류");
		}
		return dao.searchAllP(bean);
	}

}
