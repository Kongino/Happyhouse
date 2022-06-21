package com.ssafy.happyhouse.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.HouseDealDao;
import com.ssafy.happyhouse.dto.HouseDeal;
import com.ssafy.happyhouse.dto.HouseDealException;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.dto.SidoGugunCode;
import com.ssafy.happyhouse.util.PageUtility;

@Service
public class HouseDealServiceImp implements HouseDealService {

	@Autowired
	private HouseDealDao dao;
	
//	@Transactional
//	public List<HouseDeal> searchDongApt(String name) {
//		return dao.searchDongApt(name);
//	}

//	@Transactional
//	public List<HouseDeal> searchDong(String Dongname) {
//		return dao.searchDong(Dongname);
//	}
//	Comparator<HouseDeal> comp = new Comparator<HouseDeal>() {
//		@Override
//		public int compare(HouseDeal a, HouseDeal b) {
//			if (a.getDealYear() != b.getDealYear()) 
//				return b.getDealYear() - a.getDealYear();
//			else if (a.getDealMonth() != b.getDealMonth())
//				return b.getDealMonth() - a.getDealMonth();
//			else
//				return b.getDealDay() - a.getDealDay();		
//		}
//	};

	@Transactional
	public List<HouseDeal> searchAll(PageBean bean) {
		int cnt = dao.count(bean);
		try {
			PageUtility page = new PageUtility(bean.getInterval(), cnt, bean.getPageNo(), "");
			bean.setPageLink(page.getPageBar());
		}catch (Exception e) {
			throw new HouseDealException("페이징 오류");
		}
		List<HouseDeal> list = dao.searchAll(bean);
		for (HouseDeal hd : list) {
			String da = hd.getDealAmount();
			String []daa = da.split(",");
			da = daa[0] + daa[1];
			float fa = Float.parseFloat(da);
			fa = fa/10000;
			hd.setDealAmount(fa + "억");
		}
		return dao.searchAll(bean);
	}

	@Override
	public List<SidoGugunCode> getSido(){
		return dao.getSido();
	}

	@Override
	public List<SidoGugunCode> getGugunInSido(PageBean bean) {
		return dao.getGugunInSido(bean);
	}
	
	@Override
	public List<SidoGugunCode> getDongName(PageBean bean) {
		return dao.getDongName(bean);
	}

}
