package janken;

class Judge {
	private String name;
	private int gameCount;

	Judge(String name) {
		this.name = name;
	}

	void startGame(Player player1, Player player2, int gameCount) {
		this.gameCount = gameCount;
		System.out.println("試合を始める前に、ジャッジは" + this.name +"が行います");
		System.out.printf("【%s と %s によるじゃんけん%d回戦を行います】%n",
				player1.getName(), player2.getName(), this.gameCount);
		for(int count=1; count<=this.gameCount; count++) {
			System.out.printf("《第%d回戦》%n", count );
			Player winner = judgeGame(player1, player2);
			if( winner == null ) {
				System.out.println("引き分けです。");
			} else {
				System.out.printf("%s の勝ちです。%n", winner.getName());
				winner.notifyResult( );
			}
		}
		Player finalWinner = judgeFinalWinner(player1, player2);
		System.out.printf("%d 対 %d で、", player1.getWinCount(),
				                                                 player2.getWinCount() );
		if( finalWinner == null ) {
			System.out.println("引き分けです。");
		} else {
			System.out.printf("%s の勝ちです。", finalWinner.getName() );
		}
	}

	private Player judgeGame(Player player1, Player player2) {
		Choice player1Hand = player1.showHand();
		Choice player2Hand = player2.showHand();

		System.out.printf("%s 対 %s %n", player1Hand.toString(),
																player2Hand.toString() );
		Player winner = null;
		if( (player1Hand.getChoice() == Choice.STONE &&
				player2Hand.getChoice() == Choice.SCISSORS) ||
			(player1Hand.getChoice() == Choice.SCISSORS &&
				player2Hand.getChoice() == Choice.PAPER) ||
			(player1Hand.getChoice() == Choice.PAPER &&
				player2Hand.getChoice() == Choice.STONE) ) {
			winner = player1;
		} else if(
			(player1Hand.getChoice() == Choice.STONE &&
				player2Hand.getChoice() == Choice.PAPER) ||
			(player1Hand.getChoice() == Choice.SCISSORS &&
				player2Hand.getChoice() == Choice.STONE) ||
			(player1Hand.getChoice() == Choice.PAPER &&
				player2Hand.getChoice() == Choice.SCISSORS) ) {
			winner = player2;
		}
		return winner;
	}

	private Player judgeFinalWinner(Player player1, Player player2) {
		int player1WinCount = player1.getWinCount();
		int player2WinCount = player2.getWinCount();

		Player finalWinner = null;
		if( player1WinCount > player2WinCount ) {
			finalWinner = player1;
		} else if( player1WinCount < player2WinCount ) {
			finalWinner = player2;
		}
		return finalWinner;
	}

}