package com.ssafy.happyhouse.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ssafy.happyhouse.dto.Member;
import com.ssafy.happyhouse.service.JwtServiceImpl;
import com.ssafy.happyhouse.service.MemberService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@CrossOrigin(origins = { "*" }, maxAge = 6000)
@Controller
@RequestMapping("/member")
public class MemberController {

//	@Autowired
//	private MemberService memberService;
//
//	@GetMapping("/register")
//	public String register() {
//		return "user/Register";
//	}
//
//	@GetMapping("/forgot")
//	public String forgot() {
//		return "user/ForgotPassword";
//	}
//
//	@PostMapping("/forgot")
//	@ResponseBody
//	public String changePassword(@RequestParam("id") String id, @RequestParam("phone") String phone) throws Exception {
//		int idCount = memberService.idCheck(id, phone);
//		if (idCount > 0) {
//			Member member = memberService.getMember(id);
//			return member.getPassword();
//		} else {
//			return "wrong information";
//		}
//	}
//
	@GetMapping("/profile")
	public String profile() {
		return "user/Profile";
	}

//
//	@PostMapping("/profile")
//	public String pprofile() {
//		return "user/Profile";
//	}
//
////	@GetMapping("/idcheck")
//////	@ResponseBody
////	public @ResponseBody String idCheck(@RequestParam("ckid") String checkId) throws Exception {
////		int idCount = memberService.idCheck(checkId);
////		JSONObject json = new JSONObject();
////		json.put("idcount", idCount);
////		return json.toString();
////	}
//
//	@PostMapping("/register")
//	public String register(Member member, Model model) throws Exception {
//		memberService.registerMember(member);
//		return "user/Login";
//	}
//
//	@GetMapping("/login")
//	public String login() {
//		return "user/Login";
//	}
//
//	@PostMapping("/login")
//	public String login(@RequestParam Map<String, String> map, Model model, HttpSession session,
//			HttpServletResponse response) throws Exception {
//		Member member = memberService.login(map);
//		if (member != null) {
//			session.setAttribute("userInfo", member);
//
//			Cookie cookie = new Cookie("ssafy_id", map.get("userId"));
//			cookie.setPath("/");
//			if ("saveok".equals(map.get("idsave"))) {
//				cookie.setMaxAge(60 * 60 * 24 * 365 * 40);
//			} else {
//				cookie.setMaxAge(0);
//			}
//			response.addCookie(cookie);
//			return "redirect:/";
//		} else {
//			model.addAttribute("msg", "????????? ?????? ???????????? ?????? ??? ?????? ??????????????????!");
//			return "user/Login";
//		}
//	}
//
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "notice";
	}
//
//	@GetMapping("/list")
//	public String list() {
//		return "user/list";
//	}
//
//	@PostMapping("/update")
//	public String update(HttpSession session, Member member, Model model) throws Exception {
//		memberService.updateMember(member);
//		session.setAttribute("userInfo", member);
//		return "user/Profile";
//	}
//
//	@PostMapping("/delete")
//	public String delete(Member member, Model model, HttpSession session) throws Exception {
//		memberService.deleteMember(member.getId());
//		session.invalidate();
//		return "redirect:/";
//	}

	public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";

	@Autowired
	private JwtServiceImpl jwtService;

	@Autowired
	private MemberService memberService;

//	@GetMapping("/login")
//	public String login() {
//		return "user/Login";
//	}

	@ApiOperation(value = "?????????", notes = "Access-token??? ????????? ?????? ???????????? ????????????.", response = Map.class)
	@ResponseBody
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @ApiParam(value = "????????? ??? ????????? ????????????(?????????, ????????????).", required = true) Member memberDto,
			HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			Member loginUser = memberService.login(memberDto);
			if (loginUser != null) {
				String token = jwtService.create("id", loginUser.getId(), "access-token");// key, data, subject
				logger.debug("????????? ???????????? : {}", token);
				resultMap.put("access-token", token);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
				session.setAttribute("userInfo", loginUser); // ????????? ?????? ??????
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.error("????????? ?????? : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ResponseBody
	@PostMapping("/update")
	public ResponseEntity<Map<String, Object>> update(@RequestBody Member memberDto, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			logger.info("???????????? ?????? : {}", memberDto);
			memberService.updateMember(memberDto);
			session.setAttribute("userInfo", memberService.userInfo(memberDto.getId()));
			resultMap.put("userInfo", memberService.userInfo(memberDto.getId()));
			status = HttpStatus.ACCEPTED;
		} catch (Exception e) {
			logger.debug("???????????? ?????? : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ApiOperation(value = "????????????", notes = "?????? ????????? ?????? Token??? ????????????.", response = Map.class)
	@ResponseBody
	@GetMapping("/info/{id}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("id") @ApiParam(value = "????????? ????????? ?????????.", required = true) String id,
			HttpServletRequest request) {
		logger.debug("userid : {} ", id);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			logger.info("?????? ????????? ??????!!!");
			try {
//				????????? ????????? ??????.
				Member memberDto = memberService.userInfo(id);
				resultMap.put("userInfo", memberDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				logger.error("???????????? ?????? : {}", e);
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			logger.error("?????? ????????? ??????!!!");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ResponseBody
	@GetMapping("/withdrawal/{id}")
	public ResponseEntity<Map<String, Object>> withdrawal(@PathVariable("id") String id, HttpSession session) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			logger.info("?????? ????????? : {}", id);
			memberService.deleteMember(id);
			session.invalidate();
			status = HttpStatus.ACCEPTED;
			resultMap.put("message", SUCCESS);
		} catch (Exception e) {
			logger.info("?????? ?????? : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);

	}

	@ResponseBody
	@PostMapping("/register")
	public ResponseEntity<Map<String, Object>> register(@RequestBody Member memberDto) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			logger.info("???????????? ?????? : {}", memberDto);
			if (memberService.registerMember(memberDto)) {
				resultMap.put("userInfo", memberDto);
				status = HttpStatus.ACCEPTED;
				resultMap.put("message", SUCCESS);
			} else {
				resultMap.put("message", FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			logger.debug("???????????? ?????? : {}", e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@ResponseBody
	@GetMapping(value = "/check_id/{id}")
	public ResponseEntity<Map<String, Object>> check_id(@PathVariable("id") String id) throws Exception {
		logger.info("????????? ????????? : {}", id);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		resultMap.put("result", memberService.check_id(id));
		resultMap.put("message", SUCCESS);
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	// ????????? ?????? ??????(AJAX)
	@ResponseBody
	@GetMapping(value = "/check_email/{email}")
	public ResponseEntity<Map<String, Object>> check_email(@PathVariable("email") String id) throws Exception {
		logger.info("????????? ????????? : {}", id);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		resultMap.put("result", memberService.check_email(id));
		resultMap.put("message", SUCCESS);
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}

	@PostMapping(value = "/approval_member")
	public void approval_member(@ModelAttribute Member memberDto, HttpServletResponse response) throws Exception {
		memberService.approval_member(memberDto, response);
	}

	@ResponseBody
	@PostMapping(value = "/find_pw")
	public ResponseEntity<Map<String, Object>> find_pw(@RequestBody Member memberDto)
			throws Exception {
		int num = memberService.find_pw(memberDto);
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (num == 1) {
			resultMap.put("result", 1);
			resultMap.put("message", FAIL);
		} else if (num == 2) {
			resultMap.put("result", 2);
			resultMap.put("message", FAIL);
		} else {
			resultMap.put("result", 3);
			resultMap.put("message", SUCCESS);
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
}
