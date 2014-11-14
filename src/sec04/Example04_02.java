package sec04;

public class Example04_02 {

	public static void main(String[] args) {
		int[][] a = {{1,2,3},{4,5}};
		System.out.println("a[1][1]=" + a[1][1]);
		// System.out.println("a[1][2]=" + a[1][2]);
		System.out.println("a.length=" + a.length);
		System.out.println("a[0].length=" + a[0].length);
		System.out.println("a[1].length=" + a[1].length);
		a[1] = new int[] {4,5,6,7};
		System.out.println("a[1].length=" + a[1].length);
		System.out.println("a[1][3]=" + a[1][3]);
	}

}
