package sec08;

public class List08_02 {

	public static void main(String[] args) {
		Hero01 minato = new Hero01();
		minato.name = "ミナト";
		minato.hp = 100;

		Matango m1 = new Matango();
		m1.hp = 50;
		m1.suffix = 'A';

		Matango m2 = new Matango();
		m2.hp = 48;
		m2.suffix = 'B';

		Wizard sugawara = new Wizard();
		sugawara.name = "スガワラ";
		sugawara.hp = 50;

		// 冒険の始まり
		minato.slip();
		m1.run();
		m2.run();
		sugawara.heal(minato);
		sugawara.heal();
		minato.run();

	}

}
