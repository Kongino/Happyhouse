package com.ssafy.happyhouse.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.happyhouse.dto.CommercialAreaException;
import com.ssafy.happyhouse.dto.InterestArea;
import com.ssafy.happyhouse.dto.PageBean;
import com.ssafy.happyhouse.service.CommercialAreaService;
import com.ssafy.happyhouse.service.InterestAreaService;

@Controller
//@RequestMapping("/happyhouse")
public class CommercialAreaController {

	@Autowired
	private CommercialAreaService service;
	
	@Autowired
	private InterestAreaService iservice;
	
	@ExceptionHandler
	public ModelAndView handler(Exception e) {
		ModelAndView mav = new ModelAndView("Error");
		if (e instanceof CommercialAreaException) {
			mav.addObject("msg", e.getMessage());
		}else {
			mav.addObject("msg", "처리중오류");
		}
		return mav;
	}
	
	@GetMapping("/commercialSearch")
	public void list(PageBean bean, Model model) {
		
		if (bean.getPageNo() == 0)
			bean.setPageNo(1);
		
		if (bean.getKey() != null && bean.getKey().equals("Dongname")) {
			model.addAttribute("commercials", service.commercialAll(bean));
			model.addAttribute("statistics", service.stat(bean));
		}
		
		model.addAttribute("sidos", iservice.getSido());
		model.addAttribute("guguns", iservice.getGugunInSido(bean));
		model.addAttribute("dongs", iservice.getDongName(bean));
		
		
		model.addAttribute("interests", iservice.selectInterestAll());
		
		model.addAttribute("interestExist", true);
			
	}
	
	@GetMapping("/interestcom")
	public String inlist(PageBean bean, Model model) {
		
		model.addAttribute("sidos", iservice.getSido());
		model.addAttribute("guguns", iservice.getGugunInSido(bean));
		model.addAttribute("dongs", iservice.getDongName(bean));
		model.addAttribute("interests", iservice.selectInterest(bean));
		
		List<InterestArea> list = iservice.selectInterest(bean);
		boolean iE = false;
		for (InterestArea ia : list) {
			if (bean.getDongName().equals(ia.getDongname()) && bean.getGugun().equals(ia.getGugun()) && bean.getSido().equals(ia.getSido()))
				iE = true;
			System.out.println(iE);
		}
		if (bean.getDongName().equals("all") || bean.getGugun().equals("all")) iE = true;
		model.addAttribute("interestExist", iE);
		return "commercialSearch";
	}
	
	@GetMapping("/interestcom/insert")
	public String insert(InterestArea interestarea, Model model) {
		
		//model.addAttribute("interests", iservice.selectInterest());
		iservice.insertInterest(interestarea);
		return "redirect:/commercialSearch";
	}
	

	
	@GetMapping("/interestcom/delete")
	public String delete(int no, Model model) {
//		memberService.deleteMember(member.getId());
		iservice.deleteInterest(no);
		return "redirect:/commercialSearch";
	}
	
}
