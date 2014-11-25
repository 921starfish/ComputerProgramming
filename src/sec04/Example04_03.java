package sec04;

public class Example04_03 {

	public static void main(String[] args) {
		int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] b = { { -1, 3 }, { 0, 1 }, { 2, -4 } };

		int[][] ab = new int[a.length][b[0].length];
		for (int i = 0; i < ab.length; i++) {
			for (int j = 0; j < ab[0].length; j++) {
				int sum = 0;
				for (int k = 0; k < a[0].length; k++) {
					sum += a[i][k] * b[k][j];
				}
				ab[i][j] = sum;
			}
		}

		for (int i = 0; i < ab.length; i++) {
			for (int j = 0; j < ab[i].length; j++) {
				System.out.printf("%4d", ab[i][j]);
			}
			System.out.println();//改行だけ
		}
	}

}
