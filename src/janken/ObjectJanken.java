package janken;

public class ObjectJanken {

	public static void main(String[] args) {
		Judge judge = new Judge("次郎くん");
		Player player1 = new Player("太郎くん");
		Player player2 = new Player("花子さん");
		// Player player2 = new StonePlayer("三郎くん");
		judge.startGame(player1, player2, 3);
	}
}
