package janken;

class Player {
	private String name;
	private int winCount;

	Player(String name) {
		this.name = name;
		winCount = 0;
	}

	String getName() {
		return this.name;
	}

	int getWinCount() {
		return this.winCount;
	}

	Choice showHand() {
		Choice hand = new Choice();
		switch( (int)(Math.random() * 3) ) {
		case 0:
			hand.setChoice( Choice.STONE );
			break;
		case 1:
			hand.setChoice( Choice.SCISSORS );
			break;
		case 2:
			hand.setChoice( Choice.PAPER );
			break;
		}
		return hand;
	}

	void notifyResult() {
		winCount++;
	}
}