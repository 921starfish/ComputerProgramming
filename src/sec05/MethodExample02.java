package sec05;

// 値の交換をメソッドで
public class MethodExample02 {

	public static void main(String[] args) {
		int a = 2;
		int b = 3;
		// この方法ではうまくいかない！
		swap(a, b);
		System.out.println("a=" + a + ",b=" + b);
	}

	static void swap(int x, int y) {//
		int z = x;
		x = y;
		y = z;
	}
}
