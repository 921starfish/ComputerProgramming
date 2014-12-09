package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

// Mac では画像がおかしい．．．
public class OseroGame {

	public static void main(String[] args) {
		OseroFrame frame = new OseroFrame();
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class OseroFrame extends JFrame implements ActionListener {

	JPanel basePanel, gamePanel;
	MyButton[][] button;
	JButton passButton;
	JLabel message;

	int nextDice; // 次の石の色 ( 1:白, -1:黒)
	int remains; // 残りのターン数
	int twopass; // ２人ともパスの場合に２

	OseroFrame() {
		setTitle("オセロゲーム");
		setResizable(false);
		setSize(600, 760);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		basePanel = new JPanel();
		basePanel.setBackground(Color.green);
		add(basePanel);

		basePanel.setLayout(null);

		passButton = new JButton("パス");
		passButton.setBounds(30, 20, 150, 50);
		passButton.addActionListener(this);
		basePanel.add(passButton);

		remains = 60;
		twopass = 0;
		nextDice = -1;

		message = new JLabel("あと" + remains + "。先手は黒です");
		message.setFont(new Font("MSゴシック", Font.BOLD, 24));
		message.setBounds(220, 20, 360, 50);
		basePanel.add(message);

		gamePanel = new JPanel();
		gamePanel.setBounds(0, 90, 600, 600);
		gamePanel.setLayout(new GridLayout(8, 8));
		basePanel.add(gamePanel);

		button = new MyButton[8][8];
		Color bgcolor = new Color(0.8f, 0.9f, 0.8f);
		for (int i = 7; i >= 0; i--) {
			for (int j = 7; j >= 0; j--) {
				button[i][j] = new MyButton(i, j, 0);
				button[i][j].addActionListener(this);
				button[i][j].setBackground(bgcolor);
				button[i][j].setOpaque(true);
				gamePanel.add(button[i][j]);
			}
		}
		button[3][3].setDice(1); // 1 = 白
		button[3][4].setDice(-1); // -1 = 黒
		button[4][3].setDice(-1);
		button[4][4].setDice(1);
	}

	@Override
	public  void actionPerformed(ActionEvent event) {
		if (((JButton) event.getSource()).equals(passButton)) {
			nextDice *= -1;
			message.setText("あと" + remains + "。次は" + ((nextDice == 1) ? "白" : "黒") + "です。");
			twopass += 1;
			if (twopass >= 2)
				gameEnd();
			return;
		}

		MyButton btn = (MyButton) event.getSource();

		int ii = btn.i;
		int jj = btn.j;
		int dd = btn.d;

		if (dd != 0)
			return; // 既に石が置かれた場所をクリックしている

		boolean set_ok = false; // 相手の石を１つでも裏返せたら set_ok = true に

		if (ii > 1 && button[ii - 1][jj].d == -nextDice) {
			// 上向き
			for (int i = ii - 1; i >= 0; i--) {
				if (button[i][jj].d == 0) {
					break;
				} else if (button[i][jj].d == nextDice) {
					for (int k = ii - 1; k > i; k--) {
						button[k][jj].setDice(nextDice);
					}
					set_ok = true;
					break;
				}
			}
		}

		if (ii < 6 && button[ii + 1][jj].d == -nextDice) {
			// 下向き
			for (int i = ii + 1; i <= 7; i++) {
				if (button[i][jj].d == 0) {
					break;
				} else if (button[i][jj].d == nextDice) {
					for (int k = ii + 1; k < i; k++) {
						button[k][jj].setDice(nextDice);
					}
					set_ok = true;
					break;
				}
			}
		}

		if (jj > 1 && button[ii][jj - 1].d == -nextDice) {
			// 左向き
			for (int j = jj - 1; j >= 0; j--) {
				if (button[ii][j].d == 0) {
					break;
				} else if (button[ii][j].d == nextDice) {
					for (int k = jj - 1; k > j; k--) {
						button[ii][k].setDice(nextDice);
					}
					set_ok = true;
					break;
				}
			}
		}

		if (jj < 6 && button[ii][jj + 1].d == -nextDice) {
			// 右向き
			for (int j = jj + 1; j <= 7; j++) {
				if (button[ii][j].d == 0) {
					break;
				} else if (button[ii][j].d == nextDice) {
					for (int k = jj + 1; k < j; k++) {
						button[ii][k].setDice(nextDice);
					}
					set_ok = true;
					break;
				}
			}
		}

		if (ii > 1 && jj > 1 && button[ii - 1][jj - 1].d == -nextDice) {
			// 左斜め上
			int kk = Math.min(ii, jj);
			for (int k = 2; k <= kk; k++) {
				if (button[ii - k][jj - k].d == 0) {
					break;
				} else if (button[ii - k][jj - k].d == nextDice) {
					for (int l = 1; l <= k; l++) {
						button[ii - l][jj - l].setDice(nextDice);
					}
					set_ok = true;
					break;
				}
			}
		}

		if (ii > 1 && jj < 7 && button[ii - 1][jj + 1].d == -nextDice) {
			// 右斜め上
			int kk = Math.min(ii, 7 - jj);
			for (int k = 2; k <= kk; k++) {
				if (button[ii - k][jj + k].d == 0) {
					break;
				} else if (button[ii - k][jj + k].d == nextDice) {
					for (int l = 1; l <= k; l++) {
						button[ii - 1][jj + 1].setDice(nextDice);
					}
					set_ok = true;
					break;
				}
			}
		}

		if (ii < 7 && jj > 1 && button[ii + 1][jj - 1].d == -nextDice) {
			// 左斜め下
			int kk = Math.min(7 - ii, jj);
			for (int k = 2; k <= kk; k++) {
				if (button[ii + k][jj - k].d == 0) {
					break;
				} else if (button[ii + k][jj - k].d == nextDice) {
					for (int l = 1; l <= k; l++) {
						button[ii + 1][jj - 1].setDice(nextDice);
					}
					set_ok = true;
					break;
				}
			}
		}

		if (ii < 7 && jj < 7 && button[ii + 1][jj + 1].d == -nextDice) {
			// 右斜め下
			int kk = Math.min(7 - ii, 7 - jj);
			for (int k = 2; k <= kk; k++) {
				if (button[ii + k][jj + k].d == 0) {
					break;
				} else if (button[ii + k][jj + k].d == nextDice) {
					for (int l = 1; l <= k; l++) {
						button[ii + 1][jj + 1].setDice(nextDice);
					}
					set_ok = true;
					break;
				}
			}
		}

		if (set_ok) {
			button[ii][jj].setDice(nextDice);
			nextDice *= -1;
			remains--;
			message.setText("あと" + remains + "。次は" + ((nextDice == 1) ? "白" : "黒") + "です。");
			if (remains == 0)
				gameEnd();
		}

	}

	void gameEnd() {
		int sum = 0;
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				sum += button[i][j].d;
			}
		}
		if (sum == 0) {
			message.setText("終了しました。引き分けです。");
		} else if (sum > 0) {
			message.setText("終了しました。白の勝ちです。");
		} else {
			message.setText("終了しました。黒の勝ちです。");
		}
		JOptionPane.showMessageDialog(this, "ゲームは終了です", "オセロゲーム", JOptionPane.INFORMATION_MESSAGE, null);
		System.exit(1);
	}

	class MyButton extends JButton {
		private final ImageIcon whiteDice = new ImageIcon("src/game/white.png");
		private final ImageIcon blackDice = new ImageIcon("src/game/black.png");

		int i, j;
		int d;

		MyButton(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		}

		void setDice(int nextDice) {
			if (nextDice > 0) {
				this.setIcon(whiteDice);
			} else {
				this.setIcon(blackDice);
			}
			d = nextDice;
		}
	}

}