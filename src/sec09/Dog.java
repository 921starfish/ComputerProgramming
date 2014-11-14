package sec09;

public class Dog {
	String name; // 名前
	String kind; // 犬種
	int age; // 年齢
	Human owner; // 主人

	void eat(DogFood food) {
		System.out.println(this.name + "は、" + food.name + "を食べた");
	}
	void print() {
		System.out.println(this.name + "は、犬種が" + this.kind + "で、" + this.age + "才");
		System.out.println("    飼い主は、" + this.owner.name);
	}
}

class DogFood {
	String name; // 名前
}

class Human {
	String name; // 名前

	void call(Dog dog) {
		System.out.print(this.name + "が" + dog.name + "を呼んだら、");
		if( dog.owner== this ) {
			System.out.println("わん！と答えた");
		} else {
			System.out.println("無視された");
		}
	}
}
