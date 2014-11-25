package sec02;

import java.util.Random;

public class List2_14 {

	public static void main(String[] args) {
		//int r = new java.util.Random().nextInt( 90 );
		//System.out.println("あなたはたぶん、" + r + "歳ですね？");

		Random random = new Random();
		int r = random.nextInt(90);
		System.out.println("あなたはたぶん、" + r + "歳ですね？"); //0≦r<90

		double r2 = Math.random(); //0以上1未満の乱数発生メソッド
		r = (int) (r2 * 90);
		System.out.println("あなたはたぶん、" + r + "歳ですね？");//0≦r<90
		//ちょっといい加減な乱数発生法となる。論文には向かない。ゲーム制作などには向く。

	}

}
