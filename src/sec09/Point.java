package sec09;

class Point {
	double x; // ｘ座標
	double y; // ｙ座標

	Point(double xx, double yy) { // 座標を引数とするコンストラクタ
		this.x = xx;
		this.y = yy;
	}

	// 自分の情報を出力する
	void print() {
		System.out.println("(" + this.x + "," + this.y + ")");
	}

	// 原点との距離を返す
	double distance() {
		return Math.sqrt(this.x*this.x + this.y*this.y);
	}

	// 他の点 p との距離を返す
	double distance(Point p) {
		double dist = Math.sqrt(Math.pow(p.x-this.x,2)+Math.pow(p.y-this.y,2));
		return dist;
	}
}
