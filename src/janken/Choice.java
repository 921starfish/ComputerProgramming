package janken;

class Choice {
	static final int STONE = 0;
	static final int SCISSORS = 1;
	static final int PAPER = 2;
	private int choice;

	void setChoice(int choice) {
		this.choice = choice;
	}
	int getChoice() {
		return this.choice;
	}
	public String toString() {
		String hand = null;
		if( choice == STONE ) {
			hand = "ぐー";
		} else if( choice == SCISSORS ) {
			hand = "ちょき";
		} else if( choice == PAPER ) {
			hand = "ぱー";
		}
		return hand;
	}


}