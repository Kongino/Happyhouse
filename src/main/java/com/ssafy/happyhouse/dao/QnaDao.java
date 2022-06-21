package com.ssafy.happyhouse.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.dto.Qna;
@Mapper
public interface QnaDao {
	public List<Qna> selectQna();
	public Qna selectQnaByNo(int no);
	public int insertQna(Qna qna);
	public int updateQna(Qna qna);
	public int deleteQna(int no);
}