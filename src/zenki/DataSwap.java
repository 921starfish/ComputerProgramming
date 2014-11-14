package zenki;

//データを交換する
public class DataSwap {

	public static void main(String[] args) {
		//2変数の値の交換
		int a = 2;
		int b = 3;
		System.out.println("a=" + a + ",b=" + b );
		System.out.println("交換すると、");
		int c = a;
		a = b;
		b = c;
		System.out.println("a=" + a + ",b=" + b );

		//配列の中の2要素の交換
		int[] d = {2,3};
		System.out.println("d[0]=" + d[0] + ",d[1]=" + d[1]);
		System.out.println("交換すると、");
		int e =d[0];
		d[0] = d[1];
		d[1] = e;
		System.out.println("d[0]=" + d[0] + ",d[1]=" + d[1]);

		//2つの配列の中身を交換
		int[] f = {1,2,3,4};
		int[] g = {5,6,7,8};
		//方法１：
		for(int i = 0;i<f.length;i++){
			int h = f[i];
			f[i] = g[i];
			g[i] = h;
		}
		System.out.print("f=");
		for(int i=0;i<f.length;i++){
			System.out.print(f[i] + " ");
		}
		System.out.println();
		System.out.print("g=");
		for(int i=0;i<g.length;i++){
			System.out.print(g[i] + " ");
		}
		System.out.println();

		//方法２
			int[] k = f;
			f = g;
			g = k;

		System.out.print("f=");
		for(int i=0;i<f.length;i++){
			System.out.print(f[i] + " ");
		}
		System.out.println();
		System.out.print("g=");
		for(int i=0;i<g.length;i++){
			System.out.print(g[i] + " ");
		}
		System.out.println();
	}
}
