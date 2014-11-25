package janken;

public class SimpleJanken {

	public static void main(String[] args) {
		// 定数宣言
		final int STONE = 0; // グー
		final int SCISSORS = 1; // チョキ
		final int PAPER = 2; // パー

		// 変数宣言
		int player1WinCount = 0;// プレイヤ１の勝ち数
		int player2WinCount = 0;// プレイヤ２の勝ち数

		// じゃんけんの開始を表示
		System.out.println("\n 《じゃんけんを開始します》");
		// じゃんけんを３回実施する
		for (int count = 0; count < 3; count++) {
			System.out.printf("[%d回戦]%n", (count + 1));// 何回目かの表示
			// プレイヤ１の手を決める
			int player1Hand = 0; // プレイヤ１の出す手
			switch ((int) (Math.random() * 3)) {
			case 0:
				player1Hand = STONE;
				System.out.print("ぐー");
				break;
			case 1:
				player1Hand = SCISSORS;
				System.out.print("ちょき");
				break;
			case 2:
			default:
				player1Hand = PAPER;
				System.out.print("ぱー");
				break;
			}
			System.out.print("vs.");

			// プレイヤ２の手を決める
			int player2Hand = 0; // プレイヤ２の出す手
			switch ((int) (Math.random() * 3)) {
			case 0:
				player2Hand = STONE;
				System.out.print("ぐー");
				break;
			case 1:
				player2Hand = SCISSORS;
				System.out.print("ちょき");
				break;
			case 2:
				player2Hand = PAPER;
				System.out.print("ぱー");
				break;
			}

			System.out.println();

			// どちらが勝者かを判定
			if ((player1Hand == STONE && player2Hand == SCISSORS)
					|| (player1Hand == SCISSORS && player2Hand == PAPER)
					|| (player1Hand == PAPER && player2Hand == STONE)) {// プレイヤ１が勝利
				System.out.println("プレイヤ１が勝ちました");
				player1WinCount++;// プレイヤ１の勝ち数に１加える
			} else if ((player1Hand == STONE && player2Hand == PAPER)
					|| (player1Hand == SCISSORS && player2Hand == STONE)
					|| (player1Hand == PAPER && player2Hand == SCISSORS)) {// プレイヤ２が勝利
				System.out.println("プレイヤ２が勝ちました");
				player2WinCount++;// プレイヤ２の勝ち数に１加える
			} else {// 引き分け
				System.out.println("引き分けです");
			}
		}

		// ３回戦の最終集計を行う
		System.out.print(player1WinCount + "対" + player2WinCount + "で、");
		if (player1WinCount > player2WinCount) {
			System.out.println("プレイヤ１の勝ちです");
		} else if (player1WinCount < player2WinCount) {
			System.out.println("プレイヤ２の勝ちです");
		} else {
			System.out.println("引き分けです");
		}
		// じゃんけんの終了を表示
		System.out.println("《じゃんけんを終了します》");
	}
}
