package com.koitt.java.board;

import java.util.ArrayList;
import java.util.List;

public class BoardDAO {

	List<Board> list;

	public BoardDAO() {
		this.list = new ArrayList<Board>();
	}

	public void insert(Board b) throws BoardException {
		for (Board item : this.list) {
			if(item.equals(b)) {
				throw new BoardException("중복된 번호입니다.");
			}
		}
		this.list.add(b);
	}	
	
	public List<Board> selectAll(){
		return this.list;
	}

	public void delete(Board b) throws BoardException {
		for (int i = 0; i < this.list.size(); i++) {
			if(this.list.get(i).equals(b)) {
				this.list.remove(i);
				return;
			}
		}
		throw new BoardException("삭제할 게시물이 없습니다.");
	}

	public void update(Board b) throws BoardException {
		for (Board item : this.list) {
			if (item.equals(b)) {
				item.setTitle(b.getTitle());
				item.setContent(b.getContent());
				
				return;
			}
		}
		throw new BoardException("수정할 게시물이 없습니다.");
	}

}
