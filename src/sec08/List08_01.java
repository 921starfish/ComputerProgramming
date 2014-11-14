package sec08;

public class List08_01 {

	public static void main(String[] args) {
		// 勇者を生成
		Hero01 minato = new Hero01( "ミナト" );
		// minato.name = "ミナト";
		// minato.hp = 100;
		System.out.println("勇者 " + minato.name + " を生み出しました！");
		System.out.println( minato.name + "の HP は、" + minato.hp);

		Hero01 wada = new Hero01("わだくん", 10000);
		// wada.name = "わだくん";
		// wada.hp = 10000;
		System.out.println("勇者 " + wada.name + " を生み出しました！");

		minato.sit( 5 );
		minato.slip();
		minato.sit( 25 );
		wada.sit(10);
		wada.sleep();
		minato.run();

	}
}

