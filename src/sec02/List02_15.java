package sec02;

import java.util.Scanner;

public class List02_15 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("あなたの名前を入力してください。");
		String name = scanner.nextLine();
		System.out.println("あなたの年齢を入力してください。");
		int age = scanner.nextInt();
		System.out.println("ようこそ、" + age + "歳の " + name + " さん");
		scanner.close();
	}

}
