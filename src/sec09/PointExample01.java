package sec09;

public class PointExample01 {

	public static void main(String[] args) {
		Point p1 = new Point(1.0, 2.5);
		// p1.x = 1.0;
		// p1.y = 2.5;
		p1.print();
		System.out.println("原点からの距離は、" + p1.distance());
		Point p2 = new Point(2.0, 1.0);
		// p2.x = 2.0;
		// p2.y = 1.0;
		double dist = p1.distance(p2);
		System.out.println("p1 と p2 の距離は、" + dist);
		dist = p2.distance(p1);
		System.out.println("p2 と p1 の距離は、" + dist);
	}

}
