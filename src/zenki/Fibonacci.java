package zenki;

// Fibonacii数列
// 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
// f[i + 2] = f[i + 1] + f[i], f[0] = f[1] = 1

public class Fibonacci {

	public static void main(String[] args) {
		int n = 30;

		// 配列バージョン
		int[] f = new int[n + 1];
		f[0] = f[1] = 1;
		for (int i = 2; i < f.length; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		for (int i = 0; i < f.length; i++) {
			System.out.print(f[i] + " ");
		}
		System.out.println();

		// 配列を使わないバージョン
		int f0 = 1;
		int f1 = 1;
		int f2 = 1;
		for (int i = 2; i <= n; i++) {
			f2 = f0 + f1;
			f0 = f1;
			f1 = f2;
		}
		System.out.println(n + "番目の値は、" + f2);
	}
}
