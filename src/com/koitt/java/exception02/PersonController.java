package com.koitt.java.exception02;

import java.util.List;
import java.util.Scanner;



public class PersonController {

	private PersonService service;
	private Scanner input;

	public PersonController() {
		// Service 사용을 위해 객체 생성
		this.service = new PersonService();

		// 사람 정보를 입력받기 위해 객체 생성
		this.input = new Scanner(System.in);
	}

	public static void main(String[] args) {
		PersonController controller = new PersonController();
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("=== 인적사항 관리 프로그램 ===");
			System.out.println("1. 인적사항 입력");
			System.out.println("2. 인적사항 전체출력");
			System.out.println("3. 프로그램 종료");
			System.out.print("메뉴번호 입력 > ");
			// 입력받은 메뉴 번호
			int menu = input.nextInt();

			switch (menu) {
			case 1:
				controller.menuAdd();
				break;
				
			case 2:
				controller.menuRead();
				break;
				
			case 3:
				System.out.println("프로그램 종료하겠습니다. 안녕히 계세요.");
				System.exit(0);				// 프로그램 종료, 0 : 정상종료, -1 : 비정상종료
				// exit의 숫자는 운영체제가 사용
				break;
				
			default:
				System.out.println("메뉴 번호를 잘못 입력하셨습니다.");
			}
		}
	}


	public void menuAdd() {

		System.out.println("====사람 정보를 입력해 주세요.(quit : 종료)====");

		System.out.println("이름 : ");
		String name = this.input.next();

		System.out.println("나이 : ");
		int age = this.input.nextInt();

		// 입력받은 정보를 객체화
		Person p = new Person(name, age);

		// Service로 입력받은 사람 객체를 전달 (추가)
		this.service.add(p);

		System.out.println("입력 완료");
	}
	
	public void menuRead() {
		System.out.println("====인적사항 전체 목록====");
		
		// Service를 통해 입력했던 인적사항 모두를 불러오기
		List<Person> list = this.service.read();
		
		// for-each문을 통해 list에 담긴 인적사항 하나하나 출력하기
		for(Person item : list) {
			System.out.println(item);
		}
	}
}




























