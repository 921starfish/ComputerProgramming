package sec08;

class Wizard {

	String name;
	int hp;

	void heal(Hero01 hero) {
		hero.hp += 10;
		System.out.println(hero.name + " の HP を 10 回復した！");
	}

	void heal() {
		this.hp += 10;
		System.out.println(this.name + " は自分の HP を 10 回復した！");
	}

	void attack() {

	}

	void run() {

	}

	void fireball() {

	}
}
