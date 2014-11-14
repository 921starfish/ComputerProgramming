package kouki;

class CenterPoint {

	public static void main(String[] args) {
		/*		double[][] data = { { 0.5, 1.8 }, { 1.2, 0.9 }, { 1.5, 3.2 }, { 1.7, 2.4 }, { 2.5, 3.9 }, { 1.9, 2.2 },
						{ 3.0, 0.7 }, { 3.3, 3.1 }, { 3.9, 1.9 }, { 4.0, 3.7 } };
		*/

		double[][] data = { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };
		Point[] points = new Point[data.length];
		for (int i = 0; i < data.length; i++) {
			points[i] = new Point(data[i][0], data[i][1]);
		}

		Point center = new Point(points[0]);

		for (int i = 1; i < points.length; i++) {
			center = Point.centroid(center, points[i]);
		}

		center.print();
	}
}

class Point {
	double x;
	double y;
	double w; // 点の重さ

	Point(double x, double y) {
		this.x = x;
		this.y = y;
		this.w = 1.0;
	}

	Point(double x, double y, double w) {
		this.x = x;
		this.y = y;
		this.w = w;
	}

	Point(Point p) {
		this.x = p.x;
		this.y = p.y;
		this.w = p.w;
	}

	static Point centroid(Point p, Point q) {
		double cx = p.x + q.w * (q.x - p.x) / (p.w + q.w);
		double cy = p.y + q.w * (q.y - p.y) / (p.w + q.w);
		double cw = p.w + q.w;
		return new Point(cx, cy, cw);
	}

	void print() {
		System.out.println("(" + this.x + "," + this.y + ") weight=" + this.w);
	}
}
