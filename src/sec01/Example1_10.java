package sec01;

public class Example1_10 {

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		System.out.println(a / b); //整数を整数で割るから
		System.out.println(1.0 * a / b); //旧式なやり方。
		System.out.println((double) a / b);
		System.out.println((double) (a / b)); //(a/b)が先に計算されて0、それをdouble型でキャスト
		/*ここから別内容*/
		System.out.println("a + b = " + a + b); //間違い。100点満点中30点ぐらいの解答。aとbは文字列扱いになっている｡ので、23と並ぶだけ。
		System.out.println("a + b = " + (a + b));
		System.out.printf("a + b = %2d%n", a + b);//printfを用いた書き方の例。

		System.out.printf("%d + %d = %2d%n", a, b, a + b);//printfで。
		System.out.println(a + " + " + b + " = " + (a + b));//printlnで。
	}

}
