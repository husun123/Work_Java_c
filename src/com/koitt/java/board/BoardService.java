package com.koitt.java.board;

import java.util.List;




public class BoardService {

	
	private BoardDAO dao;
	private Integer count = 0;
	
	public BoardService() {
		this.dao = new BoardDAO();
	}
	
	public void add(Board b) throws BoardException {
			++count;
			b.setId(count);
			dao.insert(b);
	}
	
	public List<Board> read(){
		return dao.selectAll();
	}
	
	public void remove(Board b) throws BoardException {
		dao.delete(b);
	}
	
	public void modify(Board b) throws BoardException {
		dao.update(b);
	}
}
