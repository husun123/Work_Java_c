package thread;

class MyThread extends Thread{

	// 스레드 기능을 구현하기 위한 메소드 재정의
	public void run() {
		
		// 기능 구현
		for (int i = 1; i < 10; i++) 
			System.out.println(getName() + " : " + i
											+ " / 실제스레드 : " + Thread.currentThread().getName()); 
	}
}
public class SimpleThread {
	public static void main(String[] args) {
		MyThread th = new MyThread();		// 스레드 생성
		th.start(); 			// 스레드 시작 메소드 호출
		// th.run();
		
		MyThread th0 = new MyThread();
		th0.start();
		// th0.run();
	}
}





