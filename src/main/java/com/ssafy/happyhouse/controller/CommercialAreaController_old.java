//package com.ssafy.happyhouse.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//
//import com.ssafy.happyhouse.dto.CommercialAreaException;
//import com.ssafy.happyhouse.dto.PageBean;
//import com.ssafy.happyhouse.service.CommercialAreaService;
//
//@Controller
////@RequestMapping("/happyhouse")
//public class CommercialAreaController_old {
//
//	@Autowired
//	private CommercialAreaService service;
//	
//	@ExceptionHandler
//	public ModelAndView handler(Exception e) {
//		ModelAndView mav = new ModelAndView("Error");
//		if (e instanceof CommercialAreaException) {
//			mav.addObject("msg", e.getMessage());
//		}else {
//			mav.addObject("msg", "처리중오류");
//		}
//		return mav;
//	}
//	
//	@GetMapping("/commercialSearch")
//	public void list(PageBean bean, Model model) {
//		if (bean.getPageNo() == 0)
//			bean.setPageNo(1);
//		model.addAttribute("commercials", service.commercialAll(bean));
//		model.addAttribute("statistics", service.statisticsAll(bean));
//		
//	}
//	
//}
