package sec03;

public class List03_07a {

	public static void main(String[] args) {
		int total = 0;
		int k = 1;
		while (k <= 10) {
			total += k;
			if (k == 1) {
				System.out.println("1 = " + total);
			} else {
				System.out.println("1 + ... + " + k + " = " + total);
			}
			k++;
		}
	}
}
