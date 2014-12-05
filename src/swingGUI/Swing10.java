package swingGUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Swing10 {

	public static void main(String[] args) {
		MyFrame10 frame = new MyFrame10("BorderLayout の例題");
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MyFrame10 extends JFrame {

	JPanel panel;
	JButton buttonN, buttonE, buttonS, buttonW, buttonC;

	private int frameWidth = 600;
	private int frameHeight = 500;

	public MyFrame10(String title) {
		setTitle(title);
		setResizable(true);
		setWindowSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);

		panel = new JPanel();
		panel.setBackground(Color.green);
		panel.setLayout(new BorderLayout());
		add(panel);

		buttonN = new JButton("押しましょう");
		buttonE = new JButton("押して下さい");
		buttonS = new JButton("押してね");
		buttonW = new JButton("押せよ");
		buttonC = new JButton("押して");

		panel.add(buttonN, BorderLayout.NORTH);
		panel.add(buttonE, BorderLayout.EAST);
		panel.add(buttonS, BorderLayout.SOUTH);
		panel.add(buttonW, BorderLayout.WEST);
		panel.add(buttonC, BorderLayout.CENTER);

	}

	private void setWindowSize(int width, int height) {
		setVisible(true);
		Insets inst = getInsets();
		setVisible(false);
		setSize(width + inst.left + inst.right, height + inst.top + inst.bottom);
	}

}