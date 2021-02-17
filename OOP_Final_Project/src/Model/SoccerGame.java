//Yaakov Biblow 205460942
//Shalev Saban 322358466
package Model;

import java.util.ArrayList;

public class SoccerGame extends Game {
	private int participant1Score = 0;
	private int participant2Score = 0;
	private int result;

	public SoccerGame() {
		super();
	}

	@Override
	public int play(ArrayList<Integer> participant1ScoreBoxesList, ArrayList<Integer> participant2ScoreBoxesList) {
		for (int i = 0; i < participant1ScoreBoxesList.size(); i++) {
			this.participant1Score = this.participant1Score + participant1ScoreBoxesList.get(i);
			this.participant2Score = this.participant2Score + participant2ScoreBoxesList.get(i);
		}
		this.result = this.participant1Score - this.participant2Score;
		if (this.result == 0) {
			resetScore();
			return 0;
		} else if (this.result > 0) {
			return 1;
		} else {
			return 2;
		}
	}

	public int penaltiesShootout(ArrayList<Integer> participant1ScoreBoxesList,
			ArrayList<Integer> participant2ScoreBoxesList) {
		if (participant1ScoreBoxesList.size() == 5) {
			for (int i = 0; i < participant1ScoreBoxesList.size(); i++) {
				if (participant1ScoreBoxesList.get(i) > participant2ScoreBoxesList.get(i)) {
					this.participant1Score = this.participant1Score + 1;
				} else if (participant1ScoreBoxesList.get(i) < participant2ScoreBoxesList.get(i)) {
					this.participant2Score = this.participant2Score + 1;
				}
			}
			this.result = this.participant1Score - participant2Score;
			if (this.result == 0) {
				resetScore();
				return 0;
			} else if (this.result > 0) {
				return 1;
			} else {
				return 2;
			}
		} else {
			this.result = participant1ScoreBoxesList.get(participant1ScoreBoxesList.size() - 1)
					- participant2ScoreBoxesList.get(participant2ScoreBoxesList.size() - 1);
			if (this.result == 0) {
				resetScore();
				return 0;
			} else if (this.result > 0) {
				return 1;
			} else {
				return 2;
			}
		}
	}

	private void resetScore() {
		this.participant1Score = 0;
		this.participant2Score = 0;
	}
}
