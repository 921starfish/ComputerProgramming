package zenki;

public class DataMarge {

	public static void main(String[] args) {
		int[] a = { 1, 2, 2, 4, 6, 7, 10, 23, 30, 36 };
		int[] b = { 2, 4, 4, 6, 8, 12, 20, 32, 42 };
		int[] c = new int[a.length + b.length];

		// ２つの昇順配列a，bを配列cにマージする
		{
			int i = 0;
			int j = 0;
			int k = 0;
			while (i < a.length && j < b.length) {
				if (a[i] < b[j]) {
					c[k++] = a[i++];
					// i++; ←インクリメントは上のように纏められる。
					// k++;
				} else {
					c[k++] = b[j++];
					// j++;
					// k++;
				}
			}

			while (i < a.length) {
				c[k++] = a[i++];
				// i++;
				// k++;
			}

			while (j < b.length) {
				c[k++] = b[j++];
				// j++;
				// k++;
			}
		}

		for (int i = 0; i < c.length; i++) {
			System.out.print(c[i] + " ");
		}
		System.out.println();
	}
}
