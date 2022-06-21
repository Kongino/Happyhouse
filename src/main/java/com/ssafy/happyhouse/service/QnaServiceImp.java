package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dto.Qna;
import com.ssafy.happyhouse.dao.QnaDao;

@Service
public class QnaServiceImp implements QnaService {
	
    @Autowired
	private QnaDao qnaDao;

    @Override
	public List<Qna> retrieveQna() {
		return qnaDao.selectQna();
	}
    
  	@Override
	public boolean writeQna(Qna qna) {
		return qnaDao.insertQna(qna) == 1;
	}

	@Override
	public Qna detailQna(int no) {
		return qnaDao.selectQnaByNo(no);
	}

	@Override
	@Transactional
	public boolean updateQna(Qna qna) {
		return qnaDao.updateQna(qna) == 1;
	}

	@Override
	@Transactional
	public boolean deleteQna(int no) {
		return qnaDao.deleteQna(no) == 1;
	}
}