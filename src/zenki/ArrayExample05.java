package zenki;

public class ArrayExample05 {

	public static void main(String[] args) {
		// 配列を２つの名前で参照する
		int[] a = { 1, 2, 3 };
		int[] b = a;
		a[0] = 0;
		arrayPrint(b);
		printBar();

		// ２次元配列の１つの行を１次元配列として参照
		int[][] m = { { 1, 2 }, { 3, 4 }, { 5, 6 } };
		int[] n = m[0];
		m[0][1] = 0;
		arrayPrint(n);
		printBar();

		// ２次元配列で２つの行の値の交換：方法１
		for (int j = 0; j < m[0].length; j++) {
			int k = m[0][j];
			m[0][j] = m[1][j];
			m[1][j] = k;
		}

		for (int i = 0; i < m.length; i++) {
			arrayPrint(m[i]);
		}
		printBar();

		// ２次元配列で２つの行の値の交換：方法２
		int[] p = m[1];
		m[1] = m[2];
		m[2] = p;
		for (int i = 0; i < m.length; i++) {
			arrayPrint(m[i]);
		}
		printBar();

		int[][] c = new int[3][];
		int[] c1 = { 1, 2, 3 };
		int[] c2 = { 4, 5 };
		int[] c3 = { 6 };
		c[0] = c1;
		c[1] = c2;
		c[2] = c3;
		for (int i = 0; i < c.length; i++) {
			arrayPrint(c[i]);
		}
	}

	// １次元配列のコンソール出力
	static void arrayPrint(int[] x) {
		for (int i = 0; i < x.length; i++) {
			System.out.print(x[i] + " ");
		}
		System.out.println();
	}

	// 横線を引く
	static void printBar() {
		System.out.println("-----------------------------");
	}
}
