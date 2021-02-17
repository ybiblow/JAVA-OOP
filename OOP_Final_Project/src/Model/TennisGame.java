//Yaakov Biblow 205460942
//Shalev Saban 322358466
package Model;

import java.util.ArrayList;

public class TennisGame extends Game {
	private int participant1Score = 0;
	private int participant2Score = 0;
	private int result = 0;

	public TennisGame() {
		super();
	}

	public int play(ArrayList<Integer> participant1ScoreBoxesList, ArrayList<Integer> participant2ScoreBoxesList) {
		if (participant1ScoreBoxesList.size() != participant2ScoreBoxesList.size()) {
			return 3;
		}
		for (int i = 0; i < participant1ScoreBoxesList.size(); i++) {
			if (participant1ScoreBoxesList.get(i) == participant2ScoreBoxesList.get(i)) {
				resetScore();
				return 4;
			}
			if (participant1ScoreBoxesList.get(i) > participant2ScoreBoxesList.get(i)) {
				this.participant1Score = this.participant1Score + 1;
			} else if (participant1ScoreBoxesList.get(i) < participant2ScoreBoxesList.get(i)) {
				this.participant2Score = this.participant2Score + 1;
			}
		}
		this.result = this.participant1Score - this.participant2Score;
		switch (this.result) {
		case 3:
			resetScore();
			return 1;
		case -3:
			resetScore();
			return 2;
		case 1:
			if (this.participant1Score == 3 && this.participant2Score == 2) {
				resetScore();
				return 1;
			} else {
				resetScore();
				return 0;
			}
		case -1:
			if (this.participant1Score == 2 && this.participant2Score == 3) {
				resetScore();
				return 2;
			} else {
				resetScore();
				return 0;
			}
		}
		resetScore();
		return 0;
	}

	private void resetScore() {
		this.participant1Score = 0;
		this.participant2Score = 0;
		this.result = 0;
	}

}
