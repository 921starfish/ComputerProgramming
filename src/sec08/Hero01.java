package sec08;

class Hero01 {
	String name;  // 名前の宣言
	int hp;	//  HP の宣言


	Hero01() { // コンストラクタ
		this("ダミー", 100);
		// this.hp = 100; // HP を 100 で初期化
		// this.name = "ダミー";
	}

	Hero01(String name) { // コンストラクタの２つ目
		this(name, 100);
		// this.hp = 100;
		// this.name = name; // 名前も設定
	}

	Hero01(String name, int hp) { // コンストラクタの３つ目
		this.hp = hp;
		this.name = name;
	}

	void attack() { // 攻撃する

	}
	void run() { // 逃げる
		System.out.println(this.name + " は、逃げ出した！");
		System.out.println("GAMEOVER");
		System.out.println("最終 HP は、" + this.hp + "でした");
	}
	void sit(int sec) { // 座る
		this.hp += sec;
		System.out.println(this.name + "は、" + sec + "秒座った！");
		System.out.println("HP が" + sec + "ポイント回復した。");
	}
	void slip() { // 転ぶ
		this.hp -= 5;
		System.out.println(this.name + " は、転んだ！");
		System.out.println("5 のダメージ！");
	}
	void sleep() { // 眠る
		this.hp = 100;
		System.out.println(this.name + "は、眠って回復した！");
	}

}
