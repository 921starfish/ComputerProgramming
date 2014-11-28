package swingGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Swing06 {
	public static void main(String[] args) {
		MyFrame06 frame = new MyFrame06("２つのボタン");
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MyFrame06 extends JFrame implements ActionListener {
	JPanel panel;
	JButton buttonBlue, buttonRed;

	private final int frameWidth = 600;
	private final int frameHeight = 400;
	private final Font buttonFont = new Font("ＭＳゴシック", Font.BOLD, 32);

	public MyFrame06(String title) {
		setTitle(title);
		setWindowSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(Color.green);
		add(panel);

		panel.setLayout(null);

		buttonBlue = createButton("Blue", buttonFont, new int[] { 50, 160, 200, 80 });
		buttonBlue.addActionListener(this);
		panel.add(buttonBlue);

		buttonRed = createButton("Red", buttonFont, new int[] { 350, 160, 200, 80 });
		buttonRed.addActionListener(this);
		panel.add(buttonRed);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(buttonBlue)) {
			if (buttonBlue.getText().equals("Green")) {
				panel.setBackground(Color.green);
				buttonBlue.setText("Blue");
				buttonRed.setText("Red");
			} else { // buttonBlue.getText().equals("Blue")
				panel.setBackground(Color.blue);
				buttonBlue.setText("Green");
				buttonRed.setText("Red");
			}
		} else { // event.getSource().equals(buttonRed)
			if (buttonRed.getText().equals("Green")) {
				panel.setBackground(Color.green);
				buttonBlue.setText("Blue");
				buttonRed.setText("Red");
			} else { // buttonRed.getText().equals("Red")
				panel.setBackground(Color.red);
				buttonBlue.setText("Blue");
				buttonRed.setText("Green");
			}
		}
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