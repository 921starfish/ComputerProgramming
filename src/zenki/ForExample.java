package zenki;

public class ForExample {

	public static void main(String[] args) {
		int sum = 0;
		int i_max = 0;
		for(int i = 1;i <=100; i++){
			sum += i * i;
			if(i*i > 30){
				i_max = i;
				break;
			}
		}
		System.out.println("２乗和の合計は、" + sum);
		System.out.println("i_maxは、" + i_max);


		//ここからはやってほしくないプログラム
		int j;
		for(j = 1;j <=100; j++){
			sum += j * j;
			if(j * j > 30){
				break;
			}
		}
		System.out.println("i_maxは、" + j);
		//ここまで

		//繰り返しは、実数カウンタでもＯＫ
		for(double theta = 0; theta <= Math.PI;theta += Math.PI/12){
			System.out.printf("sin(%f)=%f%n",theta,Math.sin(theta));
		}

		System.out.println();

		for(int i=0;i<=12;i++){
			double theta = Math.PI * i/12;
			System.out.printf("sin(%f)=%f%n",theta,Math.sin(theta));
		}
	}
}
