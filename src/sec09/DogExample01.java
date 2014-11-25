package sec09;

public class DogExample01 {

	public static void main(String[] args) {
		Human taro = new Human();
		taro.name = "太郎";
		Human hanako = new Human();
		hanako.name = "花子";
		Dog pochi = new Dog();
		pochi.name = "ぽち";
		pochi.kind = "柴犬";
		pochi.age = 5;
		pochi.owner = taro;
		pochi.print();
		DogFood food = new DogFood();
		food.name = "高級ドッグフード";
		pochi.eat(food);
		Dog kuro = new Dog();
		kuro.name = "くろ";
		kuro.kind = "プードル";
		kuro.age = 7;
		kuro.owner = hanako;
		kuro.print();
		DogFood meat = new DogFood();
		meat.name = "牛肉";
		kuro.eat(meat);
		kuro.eat(food);
		taro.call(pochi);
		taro.call(kuro);
	}
}
