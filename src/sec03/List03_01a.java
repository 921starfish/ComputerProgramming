package sec03;

public class List03_01a {

	public static void main(String[] args) {
		System.out.println("わしは、神楽坂の父じゃ！");
		System.out.println("ソチの運勢を占って進ぜよう！");
		double x = Math.random();
		int y = (int) (x*3) -1; //これで{-1,0,1}の整数乱数ができた。
		if (y == 0){
			System.out.println("今日の運勢は、吉と出ておる！");
		} else {
			if (y == 1){
				System.out.println("今日の運勢は、凶と出ておる！");
			} else {
				System.out.println("今日の運勢は、大凶じゃぞ！");
			}
		}
		System.out.println("権料はタダにしておこう。");
	}
}
