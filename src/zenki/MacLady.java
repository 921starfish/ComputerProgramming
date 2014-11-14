package zenki;

import java.util.Scanner;

// if文の練習（マクドナルド版）
public class MacLady {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("いらっしゃいませ");
		System.out.print("店内で食べられますか？ 1:はい 2:いいえ");
		int yesNo = scan.nextInt();
		if (yesNo != 1) {
			System.out.println("お持ち帰りですね。");
		}
		System.out.println("何をご注文ですか");
		System.out.println("1:ビッグマック 2:ダブルチーズバーガー");
		System.out.print("3: チキンフィレオ 4:てりやきバーガー");
		int itemNo = scan.nextInt();
		int price = 0;
		if (itemNo == 1) {
			System.out.println("ビッグマックですね");
			price += 320;
		} else if (itemNo == 2) {
			System.out.println("ダブルチーズバーガーですね");
			price += 200;
		} else if (itemNo == 3) {
			System.out.println("チキンフィレオですね");
			price += 200;
		} else if (itemNo == 4) {
			System.out.println("てりやきバーガーですね");
			price += 280;
		}

		System.out.println("お飲み物はいかがですか");
		System.out.print("1: コカ・コーラ 2: ジンジャーエール");
		itemNo = scan.nextInt();
		switch (itemNo) {
		case 1:
			System.out.println("コカ・コーラですね");
			price += 100;
			break;
		case 2:
			System.out.println("ジンジャーエールですね");
			price += 100;
			break;
		}
		System.out.println("代金は" + price + "円になります。");
		scan.close();
	}
}
