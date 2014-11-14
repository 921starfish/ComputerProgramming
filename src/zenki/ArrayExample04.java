package zenki;

public class ArrayExample04 {
	//配列aの中から、正の数のみ取り出して新しい配列を作る
	public static void main(String[] args) {
		int[] a = {1,2,-3,0,5,-4,6,-7,9};
		//方法１：bはaと同じ長さ
		int[] b = new int [a.length];
		int bnum = 0; //bnumは入っている要素の数
		for(int i = 0; i<a.length; i++){
			if(a[i]>0){
				b[bnum]= a[i];
				bnum++;
			}
		}
		System.out.print("b=");
		for(int i=0;i<bnum;i++){
			System.out.print(b[i] + " ");
		}
		System.out.println();

		//方法２：cは正の数分の長さにする
		int cnum = 0;
		for (int i = 0; i<a.length; i++){
			if(a[i]>0){
				cnum++;
			}
		}

		int[] c =new int[cnum];
		cnum = 0;
		for(int i = 0; i<a.length;i++){
			if(a[i]>0){
				c[cnum]= a[i];
				cnum++;
			}
		}
		System.out.print("c=");
		for(int i=0;i<c.length;i++){
			System.out.print(c[i] + " ");
		}
		System.out.println();
	}
}
