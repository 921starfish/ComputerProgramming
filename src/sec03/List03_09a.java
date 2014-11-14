package sec03;

public class List03_09a {

	public static void main(String[] args) {
		System.out.println("   θ      sin(θ)    cos(θ)");
		double theta = Math.PI/36;
		for(int d =0;d<=18;d++){
			System.out.printf("%2dπ/36 %10.5f %10.5f%n",d,Math.sin(d*theta),Math.cos(d*theta));
		}
	}
}
