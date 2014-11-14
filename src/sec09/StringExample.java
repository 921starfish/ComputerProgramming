package sec09;

public class StringExample {

	public static void main(String[] args) {
		String s1 = "はじめまして";
		String s2 = "はじめまして";
		String s3 = new String("はじめまして");

		System.out.println( s1 == s2 );
		System.out.println( s1 == s3 );
		System.out.println( s1.equals( s2 ) );
		System.out.println( s1.equals( s3 ) );

		int[] a1 = {1,2,3};
		int[] a2 = {1,2,3}; // int[] a2 = a1;
		int[] a3 = new int[] {1,2,3};

		System.out.println( a1 == a2 );
		System.out.println( a1 == a3 );

		// a1 = {4,5}; はダメだけど
		a1 = new int[] {4,5};

		int[][] matrix = new int[2][];
		matrix[0] = new int[]{1,2,3}; // matrix[0]={1,2,3}; はダメ
		matrix[1] = new int[]{4,5};

	}
}
