package swingGUI;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Swing03 {
	public static void main(String[] args) {
		MyFrame03 frame = new MyFrame03("３つ目の GUI");
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MyFrame03 extends JFrame {
	JPanel panel;
	JButton button;

	private final int frameWidth = 200;
	private final int frameHeight = 200;
	private final Color panelColor = Color.yellow; // パネルの背景色を緑

	MyFrame03(String title) {
		setTitle(title);
		setWindowSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(panelColor);
		this.add(panel); // パネルはコンテナとしてフレーム上に

		panel.setLayout(null); // パネル上ではレイアウトはなし
		// ボタンに "push" の文字
		// 基点から (50, 50) の位置を左上隅として、横100 × 縦20 の大きさで
		button = createButton("push", new int[] { 50, 50, 100, 20 });
		panel.add(button); // ボタンをパネルの上に
	}

	// ボタンを作成するためのプライベートメソッド
	private JButton createButton(String text, int[] bounds) {
		JButton button = new JButton(text);
		button.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return button;
	}

	// 窓の大きさを測定して、setSize の値を修正するメソッド
	private void setWindowSize(int width, int height) {
		setVisible(true); // 一旦表示しないと大きさを測定できないので表示
		Insets inst = getInsets(); // 枠の幅などは、Insets クラスのフィールドとして取得できる
		setVisible(false); // 窓は非表示に戻す
		System.out.println(inst);
		// 補正データを加えて窓の大きさを決める
		setSize(width + inst.left + inst.right, height + inst.top + inst.bottom);
	}
}