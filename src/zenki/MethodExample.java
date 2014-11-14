package zenki;

// 配列の行ごとの平均値を求める
public class MethodExample {

	public static void main(String[] args) {
		int[][] m = { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9 }, { 10, 11 },
				{ 12, 13, 14, 15, 16, 17 } };

		calcAverageRow(m);
	}

	// 引数の配列の行ごとの平均値を求めてコンソールに出力
	static void calcAverageRow(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			double ave = getAverage(a[i]);
			averagePrint(i, ave);
		}
	}

	// １次元配列の平均値を求める
	static double getAverage(int[] x) {
		int sum = 0;
		for (int i = 0; i < x.length; i++) {
			sum += x[i];
		}
		double ave = (double) sum / x.length;
		return ave;
	}

	// 平均値をコンソールに出力
	static void averagePrint(int i, double ave) {
		System.out.println((i + 1) + "行目の平均値は、" + ave);
	}
}