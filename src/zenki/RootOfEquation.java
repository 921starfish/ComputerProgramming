package zenki;

//ax^2 + bx + c = 0の根を求める
public class RootOfEquation {

	public static void main(String[] args) {
		double a = 1;
		double b = 2;
		double c = 3;

		// 判別式：Ｄ
		double d = Math.pow(b, 2)-4*a*c;
		//Math.pow(b, 2)はbの二乗。
		if (d > 0){// 2実根
			//Math.pow(d, 0.5)よりMath.sqrt( d )を使おう！
			double x1 =(-b - Math.sqrt(d))/(2*a);
			double x2 =(-b + Math.sqrt(d))/(2*a);
			System.out.println("２実根あります");
			System.out.println("x1=" + x1);
			System.out.println("x2=" + x2);
		}else if(d < 0){// 2虚根
			double re = -b/(2*a);
			double im = Math.sqrt(-d)/(2*a);
			System.out.println("2虚根あります");
			System.out.println("x1=" + re + "-(" +im + ")i");
			System.out.println("x2=" + re + "+(" +im + ")i");
		}else{// 重根
			double x = -b/(2*a);
			System.out.println("x=" + x);
		}

	}

}
