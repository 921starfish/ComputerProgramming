package sec09;

class Line {
	// 直線 ax + by + c = 0
	double a;
	double b;
	double c;

	Line(double aa, double bb, double cc) {
		this.a = aa;
		this.b = bb;
		this.c = cc;
	}

	Line(double m, double b) {
		this(m, -1, b);
	}

	Line(Point p1, Point p2) {
		if (p1.x == p2.x) { // 垂直線
			this.a = 1;
			this.b = 0;
			this.c = -p1.x;
		} else if (p1.y == p2.y) { // 水平線
			this.a = 0;
			this.b = 1;
			this.c = -p1.y;
		} else { // その他の直線
			this.a = p2.y - p1.y;
			this.b = p1.x - p2.x;
			this.c = p1.y * p2.x - p1.x * p2.y;
		}
	}

	Line(Point p, double m) { // 点と傾き
		this.a = m;
		this.b = -1;
		this.c = p.y - m * p.x;
	}

	boolean onLine(Point p) { // 点 p が直線上にあれば true を返す
		double result = this.a * p.x + this.b * p.y + this.c;
		return (result == 0);
		/*
		 * if( result == 0 ) { return true; } else { return false; }
		 */
	}

	double distance(Point p) { // 点 p との距離を返す
		double dist = Math.abs(this.a * p.x + this.b * p.y + this.c)
				/ Math.sqrt(this.a * this.a + this.b * this.b);
		return dist;
	}

	boolean isCross(Line l) { // 直線 l と交差するとき true を返す
		if (this.a == 0 && l.a == 0) { // ２本とも水平線
			return false;
		} else if (this.b == 0 && l.b == 0) { // ２本とも垂直線
			return false;
		} else if (this.a * l.b == l.a * this.b) { // ２本が斜めの平行線
			return false;
		} else {// ２本が交差
			return true;
		}
	}

	Point crossPoint(Line l) { // 直線 l との交点を Point 型インスタンスとして返す
		if (isCross(l)) {
			double x = (this.b * l.c - l.b * this.c) / (this.a * l.b - l.a * this.b);
			double y = -(this.a * l.c - l.a * this.c) / (this.a * l.b - l.a * this.b);
			Point p = new Point(x, y);
			return p;
		} else { // ２直線が交差しないとき
			return null;
		}
	}
}