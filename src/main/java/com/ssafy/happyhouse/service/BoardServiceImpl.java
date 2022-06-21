package com.ssafy.happyhouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.happyhouse.dao.BoardDao;
import com.ssafy.happyhouse.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {
	
    @Autowired
	private BoardDao boardDao;

    @Override
	public List<Board> retrieveBoard() {
		return boardDao.selectBoard();
	}
    
  	@Override
	public boolean writeBoard(Board board) {
		return boardDao.insertBoard(board) == 1;
	}

	@Override
	public Board detailBoard(int articleno) {
		return boardDao.selectBoardByNo(articleno);
	}
	
	@Override
	public void updateHit(int articleno) {
		boardDao.updateHit(articleno);
	}

	@Override
	@Transactional
	public boolean updateBoard(Board board) {
		return boardDao.updateBoard(board) == 1;
	}

	@Override
	@Transactional
	public boolean deleteBoard(int articleno) {
		return boardDao.deleteBoard(articleno) == 1;
	}
}
