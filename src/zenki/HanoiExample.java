package zenki;

// ハノイの塔のシミュレーション
public class HanoiExample {
	static int fcount = 0;

	public static void main(String[] args) {
		int n = 5;
		hanoi(n, 'A', 'B', 'C');
		System.out.println("fcount=" + fcount);
	}

	// n枚の円盤をaからbへ移動する
	static void hanoi(int n, char a, char b, char c) {
		fcount++;
		if (n == 0) {
			return;
		}
		hanoi(n - 1, a, c, b);
		System.out.printf("%sから%sへ円盤%dを移動%n", a, b, n);
		hanoi(n - 1, c, b, a);
	}
}
