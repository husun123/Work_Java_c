package com.koitt.java.board;

public class BoardException extends Exception{
	
		public BoardException(String msg) {
		super(msg);					// getMessage() 호출 시 출력되는 메시지
	}
}
