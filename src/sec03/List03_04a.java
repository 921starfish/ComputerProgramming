package sec03;

import java.util.Scanner;

public class List03_04a {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		boolean while_break = false;
		while (!while_break) {
			String mess = scanner.nextLine();
			switch (mess) {
			case "hello":
				System.out.println("はい、こんにちは");
				break;
			default:
				System.out.println("むにゃむにゃ");
			}
		}
		scanner.close();
	}
}
