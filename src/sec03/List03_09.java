package sec03;

public class List03_09 {

	public static void main(String[] args) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				System.out.printf("%4d", i * j);
			}
			System.out.println();//改行だけする。
		}
	}
}
