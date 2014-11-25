package complexNumber;

public class ComplexExample {

	public static void main(String[] args) {
		Complex x = new Complex(1, 2);
		Complex y = new Complex(3, 5);
		System.out.println("x=" + x.toString());
		System.out.println("y=" + y.toString());

		System.out.println("x+y=" + x.add(y).toString());
		System.out.println("y+x=" + y.add(x).toString());

		System.out.println("x+x+x=" + x.add(x).add(x).toString());

		Complex z = x.multiply(y);
		System.out.println("x*y=" + z.toString());

		Complex w = Complex.add(x, y);
		System.out.println("x*y=" + w.toString());
	}

}
