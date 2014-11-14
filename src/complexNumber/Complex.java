package complexNumber;

/*
 * 複素数のクラス
 */

public class Complex {
	private double real; // 実部の値
	private double imag; // 虚部の値

	// コンストラクタ
	public Complex(double x, double y) {
		this.real = x;
		this.imag = y;
	}

	// 実部のsetter
	public void setReal(double x) {
		this.real = x;
	}

	// 虚部のsetter
	public void setImag(double y) {
		this.imag = y;
	}

	// 実部のgetter;
	public double getReal() {
		return real;
	}

	// 虚部のgetter
	public double getImag() {
		return imag;
	}

	// ２つの複素数の和を求めて返すクラスメソッド
	public static Complex add(Complex x, Complex y) {
		double real = x.real + y.real;
		double imag = x.imag + y.imag;
		Complex c = new Complex(real, imag);
		return c;
	}

	// 自分と他の複素数 z の和を求めて返すメソッド
	public Complex add(Complex z) {
		double real = this.real + z.real;
		double imag = this.imag + z.imag;
		Complex c = new Complex(real, imag);
		return c;
		/*
		 * この量なら return new Complex(this.real + z.real, this.imag + z.imag);
		 * でいい気もする。
		 */
	}

	// 自分と他の複素数 z の差を求めて返すメソッド
	public Complex subtract(Complex z) {
		double real = this.real - z.real;
		double imag = this.real - z.real;
		Complex c = new Complex(real, imag);
		return c;
	}

	// 自分と他の複素数 z の積を求めて返すメソッド
	public Complex multiply(Complex z) {
		double real = this.real * z.real - this.imag * z.imag;
		double imag = this.real * z.imag + this.imag * z.real;
		Complex c = new Complex(real, imag);
		return c;
	}

	// 自分を他の複素数 z で割った値を求めて返すメソッド
	public Complex divide(Complex z) {
		if (z.real == 0 && z.imag == 0) {
			System.out.println("0で割ろうとしてるぞ！");
			return null;
		}
		/*
		 * 一例 double real = (this.real * z.real + this.imag * z.imag) / (z.real
		 * * z.real + z.imag * z.imag); double imag = (-this.real * z.imag +
		 * this.imag * z.real) / (z.real * z.real + z.imag * z.imag); Complex c
		 * = new Complex(real, imag); return c;
		 */
		Complex z_conj = z.conjugate(); // zの共役複素数
		double d = Math.pow(z.abs(), 2); // zの絶対値の２乗(分母)
		Complex f = this.multiply(z_conj); // 分子
		Complex c = new Complex(f.real / d, f.imag / d);
		return c;
	}

	// 自分の共役複素数を返すメソッド
	public Complex conjugate() {
		Complex c = new Complex(this.real, -this.imag);
		return c;
	}

	// 複素数の絶対値を返すメソッド
	public double abs() {
		double abs = Math.sqrt(this.real * this.real + this.imag * this.imag);
		return abs;
	}

	// 複素空間での実軸からの角度を返すメソッド
	public double arg() {
		double theta = 2 * Math.PI;// z=0の時に返される所定外の値 2π
		if (this.real == 0) {
			if (this.imag > 0) {
				theta = Math.PI / 2;
			} else if (this.imag < 0) {
				theta = -Math.PI / 2;
			}
		} else {
			// 実は、ここはまだ不完全！
			theta = Math.atan(this.imag / this.real);
		}
		return theta;
	}

	// 値を文字列化して返すメソッド
	public String toString() {
		return "(" + this.real + "," + this.imag + "i)";
	}
}
