package com.koitt.java.board;

import java.util.Date;
import java.util.List;
import java.util.Scanner;



public class BoardController {

	private BoardService service;
	public Scanner input;



	public BoardController() {
		this.service = new BoardService();
		this.input = new Scanner(System.in);
	}

	public void menuAdd() {
		System.out.println();
		System.out.println("======게시물 등록하기======");
		
		
		System.out.println("제목 : ");
		String title = this.input.nextLine();
		System.out.println("내용 : ");
		String content = this.input.nextLine();
		System.out.println("작성자 : ");
		String writer = this.input.nextLine();

		Date regDate = new Date();
		
		Board b = new Board(null, title, content, writer, regDate);

		try {
			this.service.add(b);
			System.out.println("정상적으로 등록되었습니다.");
		} 
		catch (BoardException e) {
			System.out.println(e.getMessage());
			
		}
	}

	public void menuRead() {
		System.out.println();
		System.out.println("=======전체글보기=======");

		List<Board> list = this.service.read();

		for(Board item : list) {
			System.out.println(item.toString());
		}
	}

	public void menuRemove() {
		System.out.println("삭제하실 게시물의 번호를 입력하시오.");
		Integer number = Integer.parseInt(this.input.nextLine());
		Board b = new Board(number, null, null, null, null); 
		
		try {
			service.remove(b);
			System.out.println("정상적으로 삭제되었습니다.");
		} 
		catch (BoardException e) {
			System.out.println(e.getMessage());
		}
	}

	public void menuModify() {
		System.out.println("수정하실 게시물의 번호를 입력하시오.");
		System.out.println("번호 : ");
		Integer id = Integer.parseInt(this.input.nextLine());
		System.out.println("제목 : ");
		String title = this.input.nextLine();
		System.out.println("내용 : ");
		String content = this.input.nextLine();
	
		
		Board b = new Board(id, title, content, null, null);
		
		try {
			service.modify(b);
			System.out.println("정상적으로 수정되었습니다.");
		}
		catch (BoardException e) {
		}
	}
	
	public static void main(String[] args) {
		BoardController c = new BoardController();
		Scanner input = new Scanner(System.in);

		while(true) {
			System.out.println();
			System.out.println("=======게시판=======");
			System.out.println("1. 게시물 작성");
			System.out.println("2. 게시판 보기");
			System.out.println("3. 게시물 삭제");
			System.out.println("4. 게시물 수정");
			System.out.println("5. 닫기");
			int menu = 0;
			try {
				menu = Integer.parseInt(input.nextLine());
			}
			catch (NumberFormatException e) {
				System.out.println();
				System.out.println("숫자로만 입력하시오.");
				continue;
			}
			switch (menu) {
			case 1:
				c.menuAdd();
				break;
			case 2:
				c.menuRead();
				break;
			case 3:
				c.menuRemove();
				break;
			case 4:
				c.menuModify();
				break;
			case 5:
				System.out.println("종료");
				System.exit(0);
				break;
				
			default:
				System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}


































