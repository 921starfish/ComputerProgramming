package swingGUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Swing05 {
	public static void main(String[] args) {
		MyFrame05 frame = new MyFrame05("イベント・ドリブン");
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MyFrame05 extends JFrame implements ActionListener {
	JPanel panel;
	JButton button;

	private final int frameWidth = 600;
	private final int frameHeight = 400;
	private final Font buttonFont = new Font("Mathematica7", Font.BOLD | Font.ITALIC, 32);

	public MyFrame05(String title) {
		setTitle(title);
		setWindowSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);

		panel = new JPanel();
		panel.setBackground(Color.green);
		add(panel);

		panel.setLayout(null);

		button = createButton("push", buttonFont, new int[] { 150, 200, 300, 100 });
		button.addActionListener(this);
		panel.add(button);

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (panel.getBackground().equals(Color.green)) {
			panel.setBackground(Color.red);
		} else if(panel.getBackground().equals(Color.red)){
			panel.setBackground(Color.blue);
		} else {
			panel.setBackground(Color.green);
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