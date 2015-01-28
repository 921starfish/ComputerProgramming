package game;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

// 美術館パズル
// "http://ja.wikipedia.org/wiki/美術館_(パズル)"
// "http://www.nikoli.com/ja/puzzles/bijutsukan/"

/*
 * 読み込むデータファイルの形式：
 * 　置き場所は、プロジェクトからの相対アドレスを MuseumFrame のコンストラクタに渡すこと
 *
 * 　ファイルの中身
 * 　　第１レコード：パズルの縦のボタン数
 * 　　第２レコード：パズルの横のボタン数
 * 　　第３レコード：各ボタン（正方形）の１辺のドット数
 * 　　　　　　　　　（スクリーンに入り切るかのチェックはしていないので、あまり大きくしない）
 * 　　第４レコード以降：壁の縦位置、横位置、壁に書き込む数値の３つの値の対で与える
 * 　　　　　　　　　　　壁の数値を書かない場合は数値を－１とすること
 * 　　第４レコード以降のレコードの数は事前に読み込んでいないので、無駄な空行は入れないこと
 */
public class MuseumPuzzle {

	public static void main(String[] args) {
		// データファイル名を与えて美術館パズルを実行する
		MuseumFrame frame = new MuseumFrame("src/game/museum02.txt");
		frame.setVisible(true);
	}
}

@SuppressWarnings("serial")
class MuseumFrame extends JFrame implements ActionListener {
	int height, width; // ボタンの数（縦と横）
	int buttonSize; // １つのボタンの大きさ
	int lampCount; // ゲーム中、置かれているランプの数
	int[][] gameData; // データファイルから読み込まれた壁データの一次保管場所
	int dataCount; // 壁データ配列 gameData 内のデータ数

	final Color panelColor = Color.white; // コンテナ・パネルの色（ほとんど見えない）
	final Color buttonDefaultColor = Color.white; // ボタンの色
	final Color wallColor = Color.black; // 壁の色
	final Color wallFontColor = Color.white; // 壁に書かれる文字の色
	final Color lampColor = Color.yellow; // 明るくなった通路に塗る色
	/*final*/ Color brightColor = Color.green; // ランプを置いた場所に塗る色
	final Font messageFont = new Font(Font.SANS_SERIF, Font.BOLD, 36); //メッセージ欄に書く文字の種類
	final Font dialogFont = new Font(Font.SANS_SERIF, Font.BOLD, 24); // ダイアログに書く文字の種類
	Font buttonFont = null; // ボタンに書く文字の種類：ボタンの大きさを読み込んだ時点 getFileData() で自動設定

	private final ImageIcon light = new ImageIcon("src/game/電球.jpg");

	final int messageHeight = 100; // メッセージ用 JLabel の表示高
	final String negativeMark = "x"; // ランプを消した際の削除マーク（ランプを置けない場所のマーキングにも使用）

	final boolean isWall = true; // ボタンが壁であるときの真偽値
	final boolean isNotWall = false; // ボタンが壁でない時の真偽値

	JPanel basePanel; // コンテナ・パネル（上部に message、下部に puzzlePanel を乗せる）
	JLabel message; // 様々なメッセージ表示用ラベル
	JPanel puzzlePanel; // コンテナ・パネル（button を GridLayout で並べる）
	MyButton[][] button; // クリックするボタンたち
	MyButton[] lamp; // 置かれたランプの情報を管理する配列

	Timer timer;

	MuseumFrame(String dataFileName) {

		// MacOS でも Windows と同じ表示させるための try & catch
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		getFileData(dataFileName); // ファイルからデータの読み込み

		this.setTitle("美術館パズル");
		this.setWindowSize(width * buttonSize, height * buttonSize + messageHeight);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationByPlatform(true);
		this.setResizable(false);

		// パネルの設置
		basePanel = new JPanel();
		basePanel.setBackground(panelColor);
		basePanel.setLayout(null);
		this.add(basePanel);

		message = new JLabel("ゲーム開始");
		message.setFont( messageFont );
		message.setBounds(10,10,(int)(this.getWidth()*.8),(int)(messageHeight*0.8));
		basePanel.add(message);

		puzzlePanel = new JPanel();
		puzzlePanel.setBounds(0, messageHeight, width*buttonSize, height*buttonSize);
		puzzlePanel.setLayout(new GridLayout(height, width));
		basePanel.add(puzzlePanel);

		// ボタンの設置
		button = new MyButton[height][width];
		// まずは、全てのボタンを通路状態として配置
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				button[h][w] = new MyButton(h, w);
				button[h][w].set(isNotWall); // とりあえず壁にはしない
				button[h][w].setBackground(buttonDefaultColor);
				button[h][w].setFont(buttonFont);
				button[h][w].setOpaque(true);
				button[h][w].setMargin(new Insets(3,3,3,3)); // ボタンに数値を書く際の周囲のマージン
				button[h][w].addActionListener(this);
				puzzlePanel.add(button[h][w]);
			}
		}
		// 次に、壁ボタンを配置
		for (int i = 0; i < dataCount; i++) {
			int h = gameData[i][0]; // 壁の縦位置
			int w = gameData[i][1]; // 壁の横位置
			int value = gameData[i][2]; // 壁に書かれる数値
			button[h][w].set(isWall); // 壁とする
			button[h][w].setBackground(wallColor);
			button[h][w].setForeground(wallFontColor);
			if (value >= 0) {
				button[h][w].setText(String.valueOf(value)); //非負の数値の時はボタンに書き込む
			}
		}
		// ランプ情報用の配列設定
		lamp = new MyButton[height * width];

		//タイマークラスのインスタンスを作成
		timer = new Timer();

		//タイマーの処理内容として、MyTimerTaskクラスを設定。呼び出し間隔は1.5秒に設定。
		timer.schedule(new MyTimerTask(),0,1500);
	}

	// データファイルからのデータ読み込み
	private void getFileData(String dataFileName) {
		try {
			Scanner scan = new Scanner(new File(dataFileName));

			this.height = scan.nextInt(); // グリッド・ボタンの縦の数
			this.width = scan.nextInt(); // グリッド・ボタンの横の数
			this.buttonSize = scan.nextInt(); // 各ボタンのドット数

			//画面の解像度を DPI=96 として、ボタンに書くフォントの大きさを計算（結構いい加減！）
			int fontSize = (int)(buttonSize * 72 / 96 * 0.9);
			buttonFont = new Font(Font.SANS_SERIF, Font.BOLD, fontSize);

			gameData = new int[height * width][3]; // ファイルから読み込む壁データの保管用配列の宣言

			// 壁データの読み込み
			dataCount = 0; // 読み込まれた壁の数
			// ファイルの各レコードはカンマで区切った３つの整数値なので、カンマと改行コードをデリミタとする
			scan.useDelimiter(",|\r\n|[\n\r\u2028\u2029\u0085]");
			while ( scan.hasNext() ) {
				gameData[dataCount][0] = scan.nextInt(); // 壁の位置（縦）
				gameData[dataCount][1] = scan.nextInt(); // 壁の位置（横）
				gameData[dataCount][2] = scan.nextInt(); // 壁の書かれる数値（数値なしの場合は -1）
				dataCount++;
			}
			scan.close();
		} catch ( FileNotFoundException e ) {
			System.out.println("指定のデータファイルがありません。実行を中止します。");
			System.exit(0); //プログラムの強制停止
		}
	}

	@Override
	// ボタンがクリックされた時の処理
	public void actionPerformed( ActionEvent e ) {

		// この中身を授業中に作成する

		MyButton button = getLocation(e);

		if(button.isWall()){// クリックされたボタンが壁ならばパス
			return;
		}else if(button.getBackground().equals(brightColor)){
			// クリックされたボタンがすでに明るい場合はパス
			return;
		}else if(button.getBackground().equals(lampColor)){
			// クリックされたボタンがランプならランプを削除する
			button.setText(negativeMark);// ランプ削除マークを書き込む
			button.setIcon(null);
			lampDelete(button);// ランプ情報の配列lampから情報を削除
		}else if(button.getText().equals(negativeMark)){
			// クリックされたボタンがランプ削除マークがある場合
			button.setText("");// ランプ削除マークを消す
		}else{// それ以外はランプを置く
			lamp[lampCount++] = button;//ランプ情報の配列lampに情報を書き込む
			button.setIcon(light);

		}

		message.setText("");//メッセージ欄のテキストを削除
		rewrite();// 窓内のボタンをすべて表示しなおす
		check();// ゲームが終了したかをチェックをする

	}

	// 窓内のボタンを全て表示し直す
	private void rewrite() {
		passageToDefault(); // 通路の色を全てデフォルトの色に戻す
		for (int i = 0; i < lampCount; i++) { // ランプ情報の配列 lamp の情報を用いて通路に色を塗って行く
			lamp[i].setBackground(lampColor);
			for (int k = lamp[i].h - 1; k >= 0; k--) { // 上方向に塗って行く
				if ( button[k][lamp[i].w].isWall() ) break;
				button[k][lamp[i].w].setBackground(brightColor);
			}
			for (int k = lamp[i].h + 1; k < height; k++) { // 下方向に塗って行く
				if ( button[k][lamp[i].w].isWall() ) break;
				button[k][lamp[i].w].setBackground(brightColor);
			}
			for (int k = lamp[i].w - 1; k >= 0; k--) { // 左方向に塗って行く
				if ( button[lamp[i].h][k].isWall() ) break;
				button[lamp[i].h][k].setBackground(brightColor);
			}
			for (int k = lamp[i].w + 1; k < width; k++) { // 右方向に塗って行く
				if ( button[lamp[i].h][k].isWall() ) break;
				button[lamp[i].h][k].setBackground(brightColor);
			}
		}
	}

	// ランプの削除に対し、ランプ用配列からそのボタン（ランプ）の情報の削除
	private void lampDelete(MyButton button) {
		for (int i = 0; i < lampCount; i++) {
			if ( lamp[i] == button ) {
				if ( i < lampCount - 1 ) {
					lamp[i] = lamp[lampCount - 1];
				}
				lampCount--;
				break;
			}
		}
	}

	// 通路の色を全てデフォルト色に戻す
	private void passageToDefault() {
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				if ( ! button[h][w].isWall() ) {
					button[h][w].setBackground(buttonDefaultColor);
				}
			}
		}
	}

	// ゲームが終了しているかをチェックし、ダイアログを表示
	private void check() {
		// 全てのボタンが照らされている場合に、ランプの位置が指定通りかをチェック
		boolean isComplete = true; // 数値の書かれた壁について数値通りランプが置かれていたら for 文の後でも true
		for (int i = 0; i < dataCount; i++) {
			int h = gameData[i][0];
			int w = gameData[i][1];
			int v = gameData[i][2];
			int count = 0;
			if ( v >= 0 ) { //壁に数値が書かれていたら、その四方のランプの数 count を数える
				if ( h > 0 && button[h - 1][w].getBackground().equals(lampColor) ) count += 1;
				if ( h < height - 1 && button[h + 1][w].getBackground().equals(lampColor) ) count += 1;
				if ( w > 0 && button[h][w - 1].getBackground().equals(lampColor) ) count += 1;
				if ( w < width - 1 && button[h][w + 1].getBackground().equals(lampColor) ) count += 1;
				if ( count > v ) { // もし、壁の数値より多くのランプが置かれていたら
					message.setText("ランプの置き場が間違ってる");
					return;
				} else if( count < v ) { // まだ壁の数値よりランプの数が少なければ
					isComplete = false;
				}
			}
		}
		if( isComplete ) { // 壁の数値については全てＯＫの場合に
			// まだランプで照らされていない通路が存在しないかのチェック
			for (int h = 0; h < height; h++) {
				for (int w = 0; w < width; w++) {
					if ( button[h][w].getBackground().equals(buttonDefaultColor) ) { //存在したら、何もせずに返す
						message.setText( "" );
						return;
					}
				}
			}
			// 全ての通路が明るくなっていて、壁の数値分のランプが置かれていたら完成！
			message.setText( "おめでとう完成です" );
		}
	}

	// イベント（ボタンのクリック）の発生場所の特定
	private MyButton getLocation(ActionEvent e) {
		for (int h = 0; h < height; h++) {
			for (int w = 0; w < width; w++) {
				if (e.getSource() == button[h][w]) {
					return button[h][w];
				}
			}
		}
		return null; // ここから return されることはない！
	}

	// OS によって異なる窓の大きさを測定し、setSize の値を修正するメソッド
	private void setWindowSize(int width, int height) {
		setVisible(true); // 一旦表示しないと大きさを測定できないので表示
		Insets inst = getInsets(); // 枠の幅などは、Insets クラスのフィールドとして取得できる
		setVisible(false); // 一度、窓を非表示に戻す
		// 補正データを加えて窓の大きさを決める
		this.setSize(width + inst.left + inst.right, height + inst.top + inst.bottom);
	}

	class MyTimerTask extends TimerTask
	{
		//タイマー割り込みによる処理内容を記述
		public void run()
		{
			if(brightColor ==Color.green){
				brightColor = Color.cyan;
				rewrite();
				return;
			}else if(brightColor == Color.cyan){
				brightColor = Color.green;
				rewrite();
				return;
			}
		}
	}
}

@SuppressWarnings("serial")
// ボタンの定義
class MyButton extends JButton {
	int h, w; //置かれる位置（縦と横）共に 0,0 が最も左上のボタン
	boolean isWall; // そのボタンが壁か否かの真偽値

	MyButton(int h, int w) {
		this.h = h;
		this.w = w;
	}

	// ボタンが壁か否かの決定
	void set(boolean isWall) {
		this.isWall = isWall;
	}

	// ボタンが壁なら true を返す
	boolean isWall() {
		return isWall;
	}
}