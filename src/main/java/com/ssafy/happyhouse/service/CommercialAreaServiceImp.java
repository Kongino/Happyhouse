package com.ssafy.happyhouse.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.CommercialAreaDao;
import com.ssafy.happyhouse.dto.CommercialArea;
import com.ssafy.happyhouse.dto.CommercialCount;
import com.ssafy.happyhouse.dto.HouseDealException;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.util.PageUtility;

@Service
public class CommercialAreaServiceImp implements CommercialAreaService {

	@Autowired
	private CommercialAreaDao dao;

//	@Transactional
//	public List<HouseDeal> searchDongApt(String name) {
//		return dao.searchDongApt(name);
//	}

//	@Transactional
//	public List<HouseDeal> searchDong(String Dongname) {
//		return dao.searchDong(Dongname);
//	}

	@Transactional
	public List<CommercialArea> commercialAll(PageBean bean) {
		int cnt = dao.countCom(bean);
		try {
			PageUtility page = new PageUtility(bean.getInterval(), cnt, bean.getPageNo(), "");
			bean.setPageLink(page.getPageBar());
		} catch (Exception e) {
			throw new HouseDealException("페이징 오류");
		}

		return dao.commercialAll(bean);
	}
	
//	@Transactional
//	public int[] statisticsAll(PageBean bean){
//		int cnt = dao.countCom(bean);
//		try {
//			PageUtility page = new PageUtility(bean.getInterval(), cnt, bean.getPageNo(), "");
//			bean.setPageLink(page.getPageBar());
//		} catch (Exception e) {
//			throw new HouseDealException("페이징 오류");
//		}
//		
//		List<CommercialArea> all = dao.commercialAll(bean);
//		int[] arr = new int[9];
//		for(int i=0,end=all.size();i<end;i++) {
//			if (all.get(i).getCode1().equals("D")) {
//				arr[0]++;
//			}else if (all.get(i).getCode1().equals("Q")) {
//				arr[1]++;
//			}else if (all.get(i).getCode1().equals("R")) {
//				arr[2]++;
//			}else if (all.get(i).getCode1().equals("F")) {
//				arr[3]++;
//			}else if (all.get(i).getCode1().equals("S")) {
//				arr[4]++;
//			}else if (all.get(i).getCode1().equals("N")) {
//				arr[5]++;
//			}else if (all.get(i).getCode1().equals("L")) {
//				arr[6]++;
//			}else if (all.get(i).getCode1().equals("O")) {
//				arr[7]++;
//			}else {
//				arr[8]++;
//			}
//		}
//		return arr;
//	}

	@Transactional
	public CommercialCount stat(PageBean bean) {
		// TODO Auto-generated method stub
		return dao.stat(bean);
	}

}
