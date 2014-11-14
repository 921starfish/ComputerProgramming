package sec02;

public class Example2_7a {

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		double avarage = (double)(a + b) /2; //(double)のキャストは(a+b)まで有効
		System.out.println("平均は"+avarage);

		/*
		よく出る試験問題。
		double a = (double)5/2;　これは2.5
		double b = (double)(5/2);　これは2.0
		違いを理解しておこう。
		*/

	}

}
