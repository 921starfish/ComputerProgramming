package sec02;

public class Example2_4 {

	public static void main(String[] args) {
		int a = 10;
		int b = a++;
		System.out.println("変数bの値は" + b);
		//System.out.println("変数bの値は"+b);//aの値が11になるが、bは10のまま。
		//System.out.println("変数aの値は"+a);//行番号8が実行された後、aに1が足されている。

		a = 10;
		int c = ++a;
		System.out.println("変数cの値は" + c);

		a = 10;
		int d = (a++) + (++a);
		System.out.println("変数dの値は" + d);
		System.out.println("変数aの値は" + a);
	}

}
