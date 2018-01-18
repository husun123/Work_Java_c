package thread;

import java.util.Random;

class BankAccount{
	int balance = 0;				// 은행 잔고
	
	// 출금 메소드
	public synchronized void withdraw(int money) {
		// 현재 출금하려는 금액보다 잔고가 많은지 검사
		if (money >= 0 && balance >= money) {
			try {
				Thread.sleep(100);
			}
			catch (InterruptedException e) {
				System.err.println(e);
			}
			balance -= money;
			System.out.printf("%s가 %d 인출하여 현재잔고 %d입니다. %n" ,Thread.currentThread().getName() ,money, balance);
		}
		else if (balance < money) {
			System.out.println("잔고가 부족하여 인출할 수 없습니다.");
		}
	}
	public void deposit(int money) {
		synchronized (this) {			// 중괄호 시작부터 중괄호 끝나는 부분까지 임계영역으로 설정
		if (money > 0) {
			balance += money;
			System.out.printf("%s가 %d원 입금하여 현재잔고 %d원입니다. %n", Thread.currentThread().getName() ,money, balance);
			}
		}
	}
}


public class SyncTest implements Runnable{

	BankAccount act = new BankAccount();
	
	@Override
	public void run() {
		for (int i = 0; i < 3; i++){
			int amount = new Random().nextInt(10000);			// 0에서 10000까지 랜덤숫자를 끄집어 낸다.
			amount = amount%10 * 1000;									// 10으로 나눈 나머지이기 때문에 1의자리 값에 1000을 곱한 값
			System.out.printf("[%s] 금액 = %d %n", Thread.currentThread().getName(), amount);
			act.deposit(amount);				// 입금
			act.withdraw(amount*2);			// 출금 (2배로 한 이유는 잔고를 바닥나게 하기 위해서)
			if (act.balance < 0) {
				System.out.printf("[%s] ", Thread.currentThread().getName());
				System.out.println("잔고 : " + act.balance + " => 오류 종료");
				return;
			}
		}
	}
	public static void main(String[] args) {
	Runnable r = new SyncTest();
		
		Thread th = new Thread(r);
		Thread th1 = new Thread(r);
		
		th.setName("철수");
		th1.setName("영희");
		
		th.start();
		th1.start();
	}
	
}
