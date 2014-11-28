package swingGUI;

import javax.swing.JFrame;

public class Swing01 {

	public static void main(String[] args) {
		JFrame frame = new JFrame(); // JFrame が「窓」
		JFrame frame2 = new JFrame(); // ２つ目の窓を作る
		JFrame frame3 = new JFrame();

		frame.setTitle("Swing で作る最初の GUI プログラム"); // 窓のタイトル
		frame.setSize(500, 200); // 窓の大きさを横400 × 縦200
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 赤×で窓を閉じてアプリケーション終了
		frame.setLocationByPlatform(true); // 窓を画面の左上から少し離して表示
		frame.setResizable(false); // 窓の大きさの変更不可
		frame.setVisible(true); // 窓を表示

		frame2.setTitle("２つめの窓"); // こちらは赤×で閉じてもアプリケーションは終了しない
		frame2.setSize(300, 400);
		frame2.setVisible(true);

		frame3.setVisible(true);

	}
}