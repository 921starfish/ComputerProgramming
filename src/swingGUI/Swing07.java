package swingGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Swing07 {
	public static void main(String[] args) {
		MyFrame07 frame = new MyFrame07("小学生電卓");
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MyFrame07 extends JFrame implements ActionListener {
	JPanel panel;
	JButton plusButton, multiplyButton;
	JTextField value1, value2, answer;
	JLabel labelValue1, labelValue2, labelAnswer;

	private final int frameWidth = 360;
	private final int frameHeight = 480;
	private final Color panelColor = Color.cyan;
	private final Font defaultFont = new Font("ＭＳゴシック", Font.BOLD, 32);
	private final Font labelFont = defaultFont;
	private final Font textFieldFont = defaultFont;
	private final Font buttonFont = defaultFont;

	public MyFrame07(String title) {
		setTitle(title);
		setWindowSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(panelColor);
		add(panel);

		panel.setLayout(null);

		// ラベルの設定
		labelValue1 = createLabel("値１＝", labelFont, new int[] { 20, 40, 110, 70 });
		panel.add(labelValue1);
		labelValue2 = createLabel("値２＝", labelFont, new int[] { 20, 150, 110, 70 });
		panel.add(labelValue2);
		labelAnswer = createLabel("答え＝", labelFont, new int[] { 20, 370, 110, 70 });
		panel.add(labelAnswer);

		// テキストフィールドの設定
		value1 = createTextField(textFieldFont, new int[] { 140, 40, 200, 70 });
		panel.add(value1);
		value2 = createTextField(textFieldFont, new int[] { 140, 150, 200, 70 });
		panel.add(value2);
		answer = createTextField(textFieldFont, new int[] { 140, 370, 200, 70 });
		panel.add(answer);

		// ボタンの設定
		plusButton = createButton("＋", buttonFont, new int[] { 20, 260, 150, 70 });
		plusButton.addActionListener(this);
		panel.add(plusButton);
		multiplyButton = createButton("÷", buttonFont, new int[] { 190, 260, 150, 70 });
		multiplyButton.addActionListener(this);
		panel.add(multiplyButton);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		int x = Integer.valueOf(value1.getText());
		int y = Integer.valueOf(value2.getText());
		double z = 0;
		if (event.getSource().equals(plusButton)) {
			z = x + y;
		} else { // event.getSource().equals(multiplyButton)
			z = (double)x / y;
		}
		answer.setText(String.valueOf(z));
	}

	private JLabel createLabel(String text, Font font, int[] bounds) {
		JLabel label = new JLabel(text);
		label.setFont(font);
		label.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return label;
	}

	private JTextField createTextField(Font font, int[] bounds) {
		JTextField textField = new JTextField();
		textField.setFont(font);
		textField.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		textField.setHorizontalAlignment(JTextField.RIGHT);
		return textField;
	}

	private JButton createButton(String text, Font font, int[] bounds) {
		JButton button = new JButton(text);
		button.setFont(font);
		button.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return button;
	}

	private void setWindowSize(int width, int height) {
		setVisible(true);
		Insets inst = getInsets();
		setVisible(false);
		setSize(width + inst.left + inst.right, height + inst.top + inst.bottom);
	}
}