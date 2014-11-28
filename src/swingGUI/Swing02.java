package swingGUI;

import javax.swing.JFrame;

public class Swing02 {
	public static void main(String[] args) {
		MyFrame02 frame = new MyFrame02("２つ目の GUI プログラム", 400, 200);
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MyFrame02 extends JFrame {

	MyFrame02(String title, int width, int height) {
		setTitle(title);
		setSize(width, height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);
	}
}