package exception;

public class ExceptionHandling {

	static int num[];

	public static void main(String[] args) {

		String str[] = {"안녕하세요!", "Hello!"};

		try {
			System.out.println(str[0]);
			System.out.println(num.length);			// 예외발생
			System.out.println(str[2]);					// 위 문장에서 예외가 발생하여 이 문장은 실행되지 못함
			
		} catch (Exception e) {							// 발생한 예외가 이 유형의 하부 객체여야 catch 내부를 실행함
			// System.out.println("예외 발생 : " + e.toString());
			System.out.println("예외 발생" +  e);
		
		} finally {												// 예외 발생과 상관없이 한 번 실행되는 모듈
			System.out.println("try 실행");
		}
		
		System.out.println("프로그램이 정상적으로 종료됩니다.");


	}

}
