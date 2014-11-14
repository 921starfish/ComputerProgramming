package zenki;

public class ArrayExample01 {

	public static void main(String[] args) {
		int[] a = new int [100];
		System.out.println("a[0]=" + a[0]);
		// でも、デフォルトの値0(ｾﾞﾛ)を期待しないこと。
		// 0で初期化
		for(int i=0;i<100;i++){
			a[i]=0;
		}

		//int b; 基本系の変数は初期化しないと出力できない
		//System.out.println("b=" + b);

		//1,2,3,4,5,…,100を作ってる。
		for(int i = 0; i<a.length;i++){
			a[i]=i+1;
		}

		System.out.println("a[3]=" + a[3]);







	}

}
