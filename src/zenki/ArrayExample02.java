package zenki;

public class ArrayExample02 {

	public static void main(String[] args) {
		int[] a = { 1, 2, -3, -4, 5, 6, -7, -8, 9, -10 };

		//正の数だけ出力する
		int n = 6;
		String format = "%" + n + "d";
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				System.out.printf(format, a[i]);
			}
		}
		System.out.println();

		//正の数の個数を求める
		int sum = 0;
		int count = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) {
				sum += a[i];
				count += 1;
				//count++;でもよい
			}
		}
		System.out.println("正の数の個数は、" + count);
		System.out.println("正の数の平均値は、" + (double) sum / count);

		//配列内の最大値を求める
		int max = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] > max) {
				max = a[i];
			}
		}
		System.out.println("配列内の最大値は、" + max);

		//配列内の最小値を求める
		int min = a[0];
		for (int i = 1; i < a.length; i++) {
			if (a[i] < min) {
				min = a[i];
			}
		}
		System.out.println("配列内の最小値は、" + min);

	}

}
