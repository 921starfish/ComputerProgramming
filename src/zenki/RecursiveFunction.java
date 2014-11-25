package zenki;

public class RecursiveFunction {

	public static void main(String[] args) {
		int n = 10;
		int result = fact(n);
		System.out.println(n + "!=" + result);
	}

	static int fact(int n) {
		if (n == 1) {
			return 1;
		} else {
			return n * fact(n - 1);
		}
	}

	static int recursiveLESSfact(int n) {
		int result = 1;
		for (int i = 2; i <= n; i++) {
			result *= i;
		}
		return result;
	}
}
