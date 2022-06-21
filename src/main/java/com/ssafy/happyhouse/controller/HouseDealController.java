package com.ssafy.happyhouse.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.dto.HouseDealException;
import com.ssafy.happyhouse.dto.InterestArea;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.service.HouseDealService;
import com.ssafy.happyhouse.service.InterestAreaService;

@Controller
//@RequestMapping("/happyhouse")
public class HouseDealController {

	@Autowired
	private HouseDealService service;
	
	@Autowired
	private InterestAreaService iservice;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("Error");
		if (e instanceof HouseDealException) {
			mav.addObject("msg", e.getMessage());
		}else {
			mav.addObject("msg", "처리중오류");
		}
		return mav;
	}
	
	@GetMapping("/search")
	public void listD(PageBean bean, Model model) {
		model.addAttribute("sidos", service.getSido());
		model.addAttribute("guguns", service.getGugunInSido(bean));
		model.addAttribute("dongs", service.getDongName(bean));
//		
//		System.out.println(model.getAttribute("dongs").toString());
//		System.out.println(bean.getPageNo());
	
		if (bean.getDongCode() !=null && !bean.getDongCode().equals("all")) {
			model.addAttribute("apts", service.searchAll(bean));
			List<InterestArea> list = iservice.selectInterest(bean);
			
			boolean iE = false;
			for (InterestArea ia : list) {
				if (bean.getDongName().equals(ia.getDongname()) && bean.getGugun().equals(ia.getGugun()) && bean.getSido().equals(ia.getSido()))
					iE = true;
				System.out.println(iE);
			}
			model.addAttribute("interestExist", iE);
			
			
			if (bean.getInsertOn() != null && bean.getInsertOn().equals("on")) {
				InterestArea ia = new InterestArea();
				ia.setSido(bean.getSido());
				ia.setGugun(bean.getGugun());
				ia.setDongName(bean.getDongName());
				ia.setUserid(bean.getUserid());

				iservice.insertInterest(ia);
				bean.setInsertOn("off");
				iE = true;
				model.addAttribute("interestExist", iE);
			}
			
			if (bean.getDeleteOn() != null && bean.getDeleteOn().equals("on")) {
				int x=-1;
				for (InterestArea ia : list) {
					if (bean.getDongName().equals(ia.getDongname()) && bean.getGugun().equals(ia.getGugun()) && bean.getSido().equals(ia.getSido()))
						x=ia.getNo();
				}

				iservice.deleteInterest(x);
				bean.setDeleteOn("off");
				iE=false;
				model.addAttribute("interestExist", iE);
			}
		}
	}
	
	@GetMapping("/search/insert")
	public String sinsert(PageBean bean, Model model) {
		System.out.println("안왔어?");
		
		
		InterestArea ia = new InterestArea();
		ia.setSido(bean.getSido());
		ia.setGugun(bean.getGugun());
		ia.setDongName(bean.getDongName());
		ia.setUserid(bean.getUserid());

		iservice.insertInterest(ia);
		return "redirect:/search";
	}
	
	@GetMapping("/search/delete")
	public String sdelete(PageBean bean, Model model) {
		System.out.println("안왔어?");
		
		
		List<InterestArea> list = iservice.selectInterest(bean);
		int x=-1;
		for (InterestArea ia : list) {
			if (bean.getDongName().equals(ia.getDongname()) && bean.getGugun().equals(ia.getGugun()) && bean.getSido().equals(ia.getSido()))
				x=ia.getNo();
		}

		iservice.deleteInterest(x);
		return "redirect:/search";
	}
	
	
//	@GetMapping("/search/search")
//	public String listS(PageBean bean, Model model) {
//		model.addAttribute("sidos", service.getSido());
//		model.addAttribute("guguns", service.getGugunInSido(bean));
//		model.addAttribute("dongs", service.getDongName(bean));
//		
//		model.addAttribute("apts", service.searchAll(bean));
//		return "redirect:/search";
//	}
	
	
}
