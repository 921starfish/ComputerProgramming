package swingGUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Swing08 {
	public static void main(String[] args) {
		MyFrame08 frame = new MyFrame08("円しか書けないお絵描き板");
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MyFrame08 extends JFrame implements MouseListener, ChangeListener, ActionListener {
	JPanel basePanel, drawPanel;
	JLabel message1, message2;
	ButtonGroup colorsGroup;
	JRadioButton[] colorButton;
	String[] colorName = { "黒", "赤", "緑", "青", "橙", "黄", "空" };
	Color[] colors = new Color[] { Color.black, Color.red, Color.green, Color.blue,
			Color.orange, Color.yellow, Color.cyan };
	Color currentColor;
	JSlider slider;
	int radius;
	JButton saveButton, clearButton;

	private int frameWidth = 600;
	private int frameHeight = 500;

	public MyFrame08(String title) {
		setTitle(title);
		setWindowSize(frameWidth, frameHeight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationByPlatform(true);
		setResizable(false);

		basePanel = new JPanel();
		basePanel.setBackground(Color.cyan);
		add(basePanel);

		basePanel.setLayout(null);

		drawPanel = createPanel(new int[] { 0, 0, 600, 400 });
		drawPanel.addMouseListener(this);
		basePanel.add(drawPanel);

		message1 = createLabel("白い領域でマウスを使ってみましょう。", new int[] { 10, 460, 270, 20 });
		basePanel.add(message1);

		colorsGroup = new ButtonGroup();
		colorButton = new JRadioButton[colorName.length];
		int buttonWidth = (basePanel.getWidth() - 20) / colorName.length;
		for (int i = 0; i < colorName.length; i++) {
			colorButton[i] = new JRadioButton(colorName[i]);
			colorButton[i].setBounds(10 + buttonWidth * i, 400, buttonWidth, 60);
			colorButton[i].addChangeListener(this);
			colorsGroup.add(colorButton[i]);
			colorButton[i].setOpaque(false);
			basePanel.add(colorButton[i]);
		}
		colorButton[2].setSelected(true);

		radius = 10;
		slider = new JSlider(5, 99, radius);
		slider.setBounds(300, 460, 290, 20);
		slider.addChangeListener(this);
		slider.setOpaque(false);
		basePanel.add(slider);

		message2 = new JLabel(String.valueOf(slider.getValue()));
		message2.setBounds(280, 460, 20, 20);
		basePanel.add(message2);

		saveButton = new JButton("Save");
		saveButton.setBounds(500, 480, 80, 20);
		saveButton.addActionListener(this);
		basePanel.add(saveButton);

		clearButton = new JButton("Clear");
		clearButton.setBounds(410, 480, 80, 20);
		clearButton.addActionListener(this);
		basePanel.add(clearButton);
	}

	@Override
	public void stateChanged(ChangeEvent event) {
		if (event.getSource().equals(slider)) {
			radius = slider.getValue();
			message2.setText(String.valueOf(radius));
		} else {
			for (int i = 0; i < colorButton.length; i++) {
				if (colorButton[i].isSelected()) {
					currentColor = colors[i];
					break;
				}
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent event) { // マウスがクリックされたとき
		int x = event.getX();
		int y = event.getY();
		message1.setText("(" + x + "," + y + ") でクリックされました");
		Graphics g = drawPanel.getGraphics();
		g.setColor(currentColor);
		g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius);
	}

	@Override
	public void mousePressed(MouseEvent event) { // マウスが押されたとき
		message1.setText("マウスが押されています");
	}

	@Override
	public void mouseReleased(MouseEvent event) { // マウスが離されたとき
		message1.setText("マウスが離されました");
	}

	@Override
	public void mouseEntered(MouseEvent event) { // マウス(ポインタ)が入って来たとき
		message1.setText("マウスが入って来ました");
	}

	@Override
	public void mouseExited(MouseEvent event) { // マウス(ポインタ)が出て行ったとき
		message1.setText("マウスが出て行きました");
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource().equals(clearButton)) {
			Graphics g = drawPanel.getGraphics();
			g.clearRect(0, 0, drawPanel.getWidth(), drawPanel.getHeight());
		} else { // event.getSource().equals(saveButton)
			// 未着手
			// このボタンをクリックしたら、ファイルに画像を書き出したい
			Graphics g = drawPanel.getGraphics();
			g.drawString("このボタンにはまだ機能が付加されていません", 10, 20);
		}
	}

	private JPanel createPanel(int[] bounds) {
		JPanel panel = new JPanel();
		panel.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return panel;
	}

	private JLabel createLabel(String text, int[] bounds) {
		JLabel label = new JLabel(text);
		label.setBounds(bounds[0], bounds[1], bounds[2], bounds[3]);
		return label;
	}

	private void setWindowSize(int width, int height) {
		setVisible(true);
		Insets inst = getInsets();
		setVisible(false);
		setSize(width + inst.left + inst.right, height + inst.top + inst.bottom);
	}
}