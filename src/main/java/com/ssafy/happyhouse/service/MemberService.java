package com.ssafy.happyhouse.service;

import javax.servlet.http.HttpServletResponse;

import com.ssafy.happyhouse.dto.Member;

public interface MemberService {
	public Member login(Member memberDto) throws Exception;

	public Member userInfo(String id) throws Exception;

	public void updateMember(Member memberDto) throws Exception;

	public void deleteMember(String id) throws Exception;

	public boolean registerMember(Member memberDto) throws Exception;

	public void send_mail(Member memberDto, String div) throws Exception;

	public int check_id(String id) throws Exception;

	public int check_email(String email) throws Exception;
	
	public String create_key() throws Exception;
	
	public void approval_member(Member memberDto, HttpServletResponse response) throws Exception;
	
	public int find_pw(Member memberDto) throws Exception;
}
