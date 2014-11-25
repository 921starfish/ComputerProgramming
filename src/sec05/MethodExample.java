package sec05;

public class MethodExample {

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		int c = add(a, b);
		System.out.println(a + "+" + b + "=" + c);

		int d = 4;
		int e = add(a, b, d);
		System.out.println(a + "+" + b + "+" + d + "=" + e);

		int[] f = { 1, 0, 3, -2, 4, 9, 12, 8 };
		int g = add(f);
		System.out.println("配列の要素の和は、" + g);
	}

	static int add(int x, int y) {
		int z = x + y;
		return z;
		// return x + y; でもよい
	}

	static int add(int x, int y, int z) {
		int w = x + y + z;
		return w;
	}

	static int add(int[] x) {

		int sum = 0;
		for (int element : x) {
			sum += element;
		}
		return sum;
	}

}
