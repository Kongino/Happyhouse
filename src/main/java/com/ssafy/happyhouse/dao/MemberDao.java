package com.ssafy.happyhouse.dao;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Member;

@Mapper
public interface MemberDao {
	public Member login(Member memberDto) throws SQLException;
	public Member userInfo(String userid) throws SQLException;
	public void updateMember(Member memberDto) throws SQLException;
	public void deleteMember(String id) throws SQLException;
	public void registerMember(Member memberDto) throws SQLException;
	public void update_pw(Member member) throws SQLException;
	public int check_id(String id) throws SQLException;
	public int check_email(String email) throws Exception;
	public int approval_member(Member memberDto) throws Exception;
}
