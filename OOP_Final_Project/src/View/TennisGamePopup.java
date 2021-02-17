//Yaakov Biblow 205460942
//Shalev Saban 322358466
package View;

import Model.TennisGame;
import javafx.scene.control.TextField;

public class TennisGamePopup extends GamePopup {

	public TennisGamePopup() {
		super("Tennis", new TennisGame());
		createScoreBoxes();
		setTitle(60);
	}

	protected void createScoreBoxes() {
		for (int i = 0; i < 5; i++) {
			super.participant1ScoreBoxestxf.add(new TextField());
			super.participant1ScoreBoxestxf.get(i).setMaxWidth(40);

			super.participant2ScoreBoxestxf.add(new TextField());
			super.participant2ScoreBoxestxf.get(i).setMaxWidth(40);
		}

		super.scoreBox1.getChildren().addAll(super.participant1ScoreBoxestxf);
		super.scoreBox2.getChildren().addAll(super.participant2ScoreBoxestxf);

	}

	public boolean isRoundsEmpty() {
		if (participantsScoreBoxestxfIsEmpty()) {
			return true;
		}
		return false;
	}

	private boolean participantsScoreBoxestxfIsEmpty() {
		for (int i = 0; i < 3; i++) {
			if (this.participant1ScoreBoxestxf.get(i).getText().isEmpty()) {
				return true;
			}
		}
		for (int i = 0; i < 3; i++) {
			if (this.participant2ScoreBoxestxf.get(i).getText().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	public void results(int i) {
		switch (i) {
		case 0:
			displayError("  The Game Hasen't Finished yet!  ");
			break;
		case 1:
			this.winner = 1;
			super.errLabel.setText("  " + this.par1.getText() + " is the Winner  ");
			super.errLabel.setStyle("-fx-background-color: DARKSEAGREEN;-fx-font-weight: bold;");
			break;
		case 2:
			this.winner = 2;
			super.errLabel.setText("  " + this.par2.getText() + " is the Winner  ");
			super.errLabel.setStyle("-fx-background-color: DARKSEAGREEN;-fx-font-weight: bold;");
			break;
		case 3:
			displayError("  Please enter the rounds correctly!  ");
			break;
		case 4:
			displayError("  Please Enter the score correctly!  ");
			break;
		}
	}
}
