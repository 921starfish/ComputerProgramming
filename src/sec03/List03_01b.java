package sec03;

public class List03_01b {

	public static void main(String[] args) {
		System.out.println("わしは、神楽坂の父じゃ！");
		System.out.println("ソチの運勢を占って進ぜよう！");
		double x = Math.random();
		System.out.println(x);//xの確認
		if (x < 0.6) {
			System.out.println("今日の運勢は、吉と出ておる！");
		} else {
			if (x < 0.9) {
				System.out.println("今日の運勢は、凶と出ておる！");
			} else {
				System.out.println("今日の運勢は、大凶じゃぞ！");
			}
		}
		System.out.println("権料はタダにしておこう。");
	}
}
