//Yaakov Biblow 205460942
//Shalev Saban 322358466
package Model;

import java.util.ArrayList;

public class BasketballGame extends Game {
	private int participant1Score = 0;
	private int participant2Score = 0;
	private int result;

	public BasketballGame() {
		super();
	}

	@Override
	public int play(ArrayList<Integer> participant1ScoreBoxesList, ArrayList<Integer> participant2ScoreBoxesList) {
		for (int i = 0; i < participant1ScoreBoxesList.size(); i++) {
			this.participant1Score = this.participant1Score + participant1ScoreBoxesList.get(i);
			this.participant2Score = this.participant2Score + participant2ScoreBoxesList.get(i);
		}
		this.result = this.participant1Score - this.participant2Score;
		if (result == 0) {
			return 0;
		} else if (result > 0) {
			return 1;
		} else {
			return 2;
		}
	}

}
