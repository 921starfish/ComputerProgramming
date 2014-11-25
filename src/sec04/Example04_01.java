package sec04;

import java.util.Scanner;

public class Example04_01 {

	public static void main(String[] args) {
		int[] month = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		String[] smonth = { "Sun", "Mon", "Tue", "Wed", "Thr", "Fri", "Sat" };

		Scanner scan = new Scanner(System.in);

		System.out.println("何月？");
		int m = scan.nextInt();
		System.out.println("何日？");
		int d = scan.nextInt();
		scan.close();

		int sum = 0;
		for (int i = 0; i < m - 1; i++) {
			sum += month[i];
		}
		sum += d - 1;

		System.out.println(m + "月" + d + "日は" + smonth[sum % 7] + "です");
	}
}
