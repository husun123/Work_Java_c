package programming.practice;

class BankAccount extends Thread {

	int miniBalance;

	public BankAccount(int miniBalance) {
		this.miniBalance = miniBalance;
	}

	public void deposit(int money) {
		if (money < 0) {
			System.out.println("금액을 잘못입력하셨습니다.");
			return;
		}
		miniBalance += money;
		System.out.printf("정상 입금처리 : 입금금액 = %d, 잔금 = %d %n", money, miniBalance );
	}

	public void withdraw(int money) {
		if (money < 0 || money > miniBalance) {
			try {
				myException(true);
			}
			catch (InvalidWithdraw e){
				System.out.println(e.getMessage());
			}
		}
		else if(money > 0){
			miniBalance -= money;
			System.out.printf("정상 출금처리 : 인출금액 = %d, 잔금 = %d %n", money, miniBalance);
		}
	}
	

	public static void myException(boolean bool) throws InvalidWithdraw{
		if (bool)
			throw new InvalidWithdraw("금액을 잘못입력하셨습니다.");
	}
}

public class Exam03 {

	public static void main(String[] args) {
		
		BankAccount ba = new BankAccount(-100000);
		
		ba.deposit(500000);
		ba.withdraw(50000);
		ba.withdraw(400000);
		
	}
}
