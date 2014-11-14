package zenki;

public class ArrayExample03 {

	public static void main(String[] args) {
		//配列のコピー
		int[] a = {1,-2,3,4,-5,-6,7,8,-9,-10};
		int[] b = new int [a.length];

		for(int i = 0; i<a.length; i++){
			b[i]=a[i];
		}

		int[] c= new int [a.length];
		System.arraycopy(a, 0, c, 0, a.length);
		for(int i = 0; i<a.length; i++){
			System.out.printf("%4d",c[i]);
		}
		System.out.println();
	}

}
