package sec09;

public class LineExample01 {

	public static void main(String[] args) {
		Line line1 = new Line(2, 1); // 傾き＝2 y切片＝１
		Line line2 = new Line(1, 2, 3); // 1x + 2y + 3 = 0
		Point p1 = new Point(1, 3); // line1 に乗ってる＆ line2 に乗ってない
		Line line3 = new Line(2, 2);

		double dist = line2.distance(p1);
		System.out.println("直線２から点１への距離は、" + dist);
		boolean onLine = line1.onLine(p1);
		if (onLine == true) {
			System.out.println("直線１に点１は乗っている");
		} else {
			System.out.println("直線１に点１は乗っていない");
		}

		Point p = line1.crossPoint(line2);
		System.out.println("(" + p.x + "," + p.y + ")");
		Point q = line1.crossPoint(line3);
		if (q != null) {
			System.out.println("(" + q.x + "," + q.y + ")");
		} else {
			System.out.println("２直線は交点を持たない！");
		}
	}
}
