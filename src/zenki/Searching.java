package zenki;

import java.util.Scanner;

public class Searching {

	public static void main(String[] args) {
		int[] a = { 1, 3, 4, 6, 8, 10, 12, 14, 20, 35, 50, 66, 99, 100 };
		Scanner scan = new Scanner(System.in);
		System.out.print("探したい数は？");
		int x = scan.nextInt();
		scan.close();

		// 線形探索
		int ii = 0;
		boolean ok = false;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == x) {
				ii = i;
				ok = true;
				break;
			}
		}
		if (ok) {
			System.out.println("値" + x + "は、" + (ii + 1) + "番目にありました");
		} else {
			System.out.println("値" + x + "は、" + "ありませんでした");
		}

		// ２分探索
		int left = 0;
		int right = a.length - 1;
		int middle = 0;
		ok = false;
		while (left <= right) {
			middle = (left + right) / 2; // 整数をわっているので注意
			if (a[middle] == x) {
				ok = true;
				break;
			} else if (a[middle] > x) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		if (ok) {
			System.out.println("値" + x + "は、" + (middle + 1) + "番目にありました");
		} else {
			System.out.println("値" + x + "は、" + "ありませんでした");
		}
	}
}
