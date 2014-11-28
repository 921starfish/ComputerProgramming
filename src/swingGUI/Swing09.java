package swingGUI;

import java.awt.Color;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Swing09 {

	public static void main(String[] args) {
		MyFrame09 frame = new MyFrame09("テキストをファイルにセーブ", "text.txt");
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MyFrame09 extends JFrame implements ActionListener {
	JPanel panel;
	JTextArea area;
	JScrollPane scrollpane;
	JButton button;

	String fileName;

	private int frameWidth = 600;
	private int frameHeight = 500;

	public MyFrame09(String title, String fileName) {
		setTitle(title);
		setResizable(false);
		setWindowSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);

		this.fileName = fileName;

		panel = new JPanel();
		panel.setBackground(Color.blue);
		add(panel);

		panel.setLayout(null);

		area = new JTextArea();
		area.setBackground(Color.white);
		scrollpane = new JScrollPane(area,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollpane.setBounds(10, 10, frameWidth - 40, frameHeight - 140);
		panel.add(scrollpane);

		button = new JButton("save");
		button.setBounds(frameWidth - 120, frameHeight - 100, 100, 20);
		button.addActionListener(this);
		panel.add(button);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			BufferedWriter bf = new BufferedWriter(new FileWriter(fileName));
			bf.write(area.getText());
			bf.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void setWindowSize(int width, int height) {
		setVisible(true);
		Insets inst = getInsets();
		setVisible(false);
		setSize(width + inst.left + inst.right, height + inst.top + inst.bottom);
	}
}