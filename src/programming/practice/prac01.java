package programming.practice;

import java.util.InputMismatchException;
import java.util.Scanner;

public class prac01 {

	public static void main(String[] args) {

		int x = 0;
		int y = 0;
		int z = 0;

		Scanner input = new Scanner(System.in);
		System.out.println("정수 두 개 입력 : ");
		
		try {
			x = input.nextInt();
			y = input.nextInt();
			z = x*y;
			System.out.printf("%d * %d = %d %n", x, y, z);
			
		}
		catch (InputMismatchException e) {
			System.out.println("정수만 입력하시오.");
			
		}
		input.close();
	}
}

