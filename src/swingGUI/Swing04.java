package swingGUI;

import java.awt.Color;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class Swing04 {
	public static void main(String[] args) {
		MyFrame04 frame = new MyFrame04("Components いろいろ乗せ Frame");
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MyFrame04 extends JFrame {
	JPanel panel; // パネル：他の部品を乗せるコンテナ
	JButton button; // ボタン
	JLabel label1, label2, label3; // ラベル
	JTextField textField; // テキストフィールド
	JTextArea textArea; // テキストエリア
	JCheckBox[] checkBox; // チェックボタンの配列
	ButtonGroup buttonGroup; // ラジオボタンのグループ化
	JRadioButton[] radioButton; // ラジオボタンの配列

	private final int frameWidth = 600;
	private final int frameHeight = 400;
	private final Color panelColor = new Color(255,255,0);

	public MyFrame04(String title) {
		setTitle(title);
		setWindowSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(panelColor);
		add(panel);

		panel.setLayout(null);

		// button の定義
		button = createButton("push", new int[] { 10, 10, 100, 20 });
		panel.add(button);

		// lanel1 の定義
		label1 = createLabel("↓ここに入力 → ", new int[] { 10, 35, 100, 20 });
		panel.add(label1);

		// textField の定義
		textField = createTextField("ここはtextField", new int[] { 110, 35, 200, 20 });
		panel.add(textField);

		//textArea の定義: 背景色を RGB 値設定による中間色で
		textArea = createTextArea("ここはtextArea\n何行でも書けます",
				new Color(220, 220, 255), new int[] { 10, 60, 400, 300 });
		panel.add(textArea);

		// label2, Checkbox の定義
		label2 = createLabel("CheckBox の例", new int[] { 420, 10, 100, 20 });
		panel.add(label2);

		checkBox = new JCheckBox[3];
		String[] checkBoxText = { "Apple", "Windows", "otherwise" };
		boolean[] selected = { true, true, false };
		for (int i = 0; i < 3; i++) {
			checkBox[i] = createCheckBox(checkBoxText[i], selected[i],
					new int[] { 420, 10 + 20 * (i + 1) * 3 / 2, 100, 20 });
			panel.add(checkBox[i]);
		}

		// label3, radioButton の定義
		label3 = createLabel("RadioButtonの例", new int[] { 420, 200, 150, 20 });
		panel.add(label3);

		buttonGroup = new ButtonGroup();
		radioButton = new JRadioButton[3];
		String[] radioButtonText = { "Apple", "Windows", "otherwise" };
		for (int i = 0; i < 3; i++) {
			radioButton[i] = createRadioButton(radioButtonText[i],
					new int[] { 420, 200 + 20 * (i + 1) * 3 / 2, 150, 20 });
			buttonGroup.add(radioButton[i]);
			panel.add(radioButton[i]);
		}
		radioButton[0].setSelected(true);
	}

	private JButton createButton(String text, int[] bounds) {
		JButton button = new JButton(text);
		button.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return button;
	}

	private JLabel createLabel(String text, int[] bounds) {
		JLabel label = new JLabel(text);
		label.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		label.setHorizontalAlignment(JLabel.RIGHT); // 文字は右詰め
		//label.setOpaque(true); // ラベルを不透明に
		//label.setBackground(Color.white); // 背景色を白に
		return label;
	}

	private JTextField createTextField(String text, int[] bounds) {
		JTextField textField = new JTextField(text);
		textField.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return textField;
	}

	private JTextArea createTextArea(String text, Color color, int[] bounds) {
		JTextArea textArea = new JTextArea(text);
		textArea.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		textArea.setBackground(color);
		textArea.setLineWrap(true); // 右まで到達したら、改行
		textArea.setWrapStyleWord(true); // 単語単位で改行
		textArea.setBorder(new EtchedBorder(EtchedBorder.RAISED)); // 外枠に高低差を
		return textArea;
	}

	private JCheckBox createCheckBox(String text, boolean selected, int[] bounds) {
		JCheckBox checkBox = new JCheckBox(text);
		checkBox.setSelected(selected);
		checkBox.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return checkBox;
	}

	private JRadioButton createRadioButton(String text, int[] bounds) {
		JRadioButton radioButton = new JRadioButton(text);
		radioButton.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return radioButton;
	}

	private void setWindowSize(int width, int height) {
		setVisible(true);
		Insets inst = getInsets();
		setVisible(false);
		setSize(width + inst.left + inst.right, height + inst.top + inst.bottom);
	}
}