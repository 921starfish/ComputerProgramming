package sec03;

public class List03_09b {

	public static void main(String[] args) {
		System.out.printf("%7s %10s %10s%n", "θ", "sin(θ)", "cos(θ)");
		double theta = Math.PI/36;
		for(int d = 0; d<=18; d++) {
			System.out.printf("%2d%5s %10.5f %10.5f%n", d, "π/36",Math.sin(d*theta), Math.cos(d*theta));
		}
	}

}
