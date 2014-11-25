package zenki;

public class DataSorting {

	public static void main(String[] args) {
		// ２つの値を昇順に並び替え
		int a = 3;
		int b = 2;
		if (a > b) {
			int c = a;
			a = b;
			b = c;
		}

		// ３つの値を昇順に並び替え
		a = 4;
		b = 3;
		int c = 2;
		if (a > b) {
			int d = a;
			a = b;
			b = d;
		}
		if (b > c) {
			int d = b;
			b = c;
			c = d;
			if (a > b) {
				int e = a;
				a = b;
				b = e;
			}
		}
		System.out.printf("a=%d b=%d c=%d%n", a, b, c);

		// 配列の値を昇順に並び替え
		int[] m = { 4, 5, 2, 0, -2, -1, 2, 3, -3 };

		/* 考え方
		 * 最小値を見つけて[min]番目とする
		 * [0]と[min]を入れ換える
		 * [1]から先で最小値を見つけて[min]
		 * [1]と[min]を入れ換え
		 * [2]～も同様に行う
		*/

		for (int i = 0; i < m.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < m.length; j++) {
				if (m[j] < m[min]) {
					min = j;
				}
			}
			if (min > i) {
				int d = m[i];
				m[i] = m[min];
				m[min] = d;
			}
		}
		System.out.print("m=");
		for (int i = 0; i < m.length; i++) {
			System.out.print(m[i] + " ");
		}
		System.out.println();
	}
}
