package sec03;

import java.util.Scanner;

public class List03_04b {

	public static void main(String[] args) {
		Scanner scanner = new Scanner (System.in);
		boolean while_break = false;
		while (! while_break){
			String mess =scanner.nextLine();
			if( mess.equals("hello")){
				System.out.println("はい、こんにちは");
				while_break = true;
			}else{
				System.out.println("むにゃむにゃ");
			}
		}
		scanner.close();
	}
}
