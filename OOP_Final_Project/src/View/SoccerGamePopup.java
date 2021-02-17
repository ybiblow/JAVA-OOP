//Yaakov Biblow 205460942
//Shalev Saban 322358466
package View;

import Model.SoccerGame;
import javafx.scene.control.TextField;

public class SoccerGamePopup extends GamePopup {
	private int gameStatus = 0; // 0 - Regular Game, 1 - OverTime, 2 - Penalty Shootout.

	public SoccerGamePopup() {
		super("Soccer", new SoccerGame());
		this.createScoreBoxes();
		super.setTitle(65);
	}

	@Override
	protected void createScoreBoxes() {
		for (int i = 0; i < 2; i++) {
			super.participant1ScoreBoxestxf.add(new TextField());
			super.participant1ScoreBoxestxf.get(i).setMaxWidth(40);

			super.participant2ScoreBoxestxf.add(new TextField());
			super.participant2ScoreBoxestxf.get(i).setMaxWidth(40);
		}
		super.scoreBox1.getChildren().addAll(super.participant1ScoreBoxestxf);
		super.scoreBox2.getChildren().addAll(super.participant2ScoreBoxestxf);
	}

	@Override
	public void results(int i) {
		switch (i) {
		case 0:
			if (this.gameStatus == 0) {
				super.displayError("  It's Time for Overtime!  ");
				this.gameStatus = 1;
				overTime();
			} else if (this.gameStatus == 1) {
				super.displayError("  Going for Penalties!  ");
				this.gameStatus = 2;
				penaltyShootout();
			} else if (this.gameStatus == 2) {
				super.displayError("  Another Round of Penalties!  ");
				penaltyTie();
			}
			break;
		case 1:
			this.winner = 1;
			this.errLabel.setText("  " + this.par1.getText() + " is the Winner  ");
			this.errLabel.setStyle("-fx-background-color: DARKSEAGREEN;-fx-font-weight: bold;");
			break;
		case 2:
			this.winner = 2;
			this.errLabel.setText("  " + this.par2.getText() + " is the Winner  ");
			this.errLabel.setStyle("-fx-background-color: DARKSEAGREEN;-fx-font-weight: bold;");
			break;
		}
	}

	private void penaltyTie() {
		TextField tmp1 = new TextField();
		TextField tmp2 = new TextField();
		tmp1.setMaxWidth(40);
		tmp2.setMaxWidth(40);
		super.participant1ScoreBoxestxf.add(tmp1);
		super.participant2ScoreBoxestxf.add(tmp2);
		super.scoreBox1.getChildren().clear();
		super.scoreBox2.getChildren().clear();
		super.scoreBox1.getChildren().addAll(super.participant1ScoreBoxestxf);
		super.scoreBox2.getChildren().addAll(super.participant2ScoreBoxestxf);
	}

	private void penaltyShootout() {
		super.participant1ScoreBoxestxf.clear();
		super.participant2ScoreBoxestxf.clear();
		for (int i = 0; i < 5; i++) {
			TextField tmp1 = new TextField();
			TextField tmp2 = new TextField();
			tmp1.setMaxWidth(40);
			tmp2.setMaxWidth(40);
			super.participant1ScoreBoxestxf.add(tmp1);
			super.participant2ScoreBoxestxf.add(tmp2);
		}
		super.scoreBox1.getChildren().clear();
		super.scoreBox2.getChildren().clear();
		super.scoreBox1.getChildren().addAll(super.participant1ScoreBoxestxf);
		super.scoreBox2.getChildren().addAll(super.participant2ScoreBoxestxf);
	}

	private void overTime() {
		TextField tmp1 = new TextField();
		tmp1.setMaxWidth(40);
		TextField tmp2 = new TextField();
		tmp2.setMaxWidth(40);
		super.participant1ScoreBoxestxf.add(tmp1);
		super.participant2ScoreBoxestxf.add(tmp2);
		super.scoreBox1.getChildren().clear();
		super.scoreBox1.getChildren().addAll(super.participant1ScoreBoxestxf);

		super.scoreBox2.getChildren().clear();
		super.scoreBox2.getChildren().addAll(super.participant2ScoreBoxestxf);
	}

	@Override
	public boolean isRoundsEmpty() {
		switch (this.gameStatus) {
		case 0:
			for (int i = 0; i < 2; i++) {
				if (super.participant1ScoreBoxestxf.get(i).getText().isEmpty()) {
					return true;
				}
			}
			for (int i = 0; i < 2; i++) {
				if (super.participant2ScoreBoxestxf.get(i).getText().isEmpty()) {
					return true;
				}
			}
			break;
		case 1:
			for (int i = 0; i < 3; i++) {
				if (super.participant1ScoreBoxestxf.get(i).getText().isEmpty()) {
					return true;
				}
			}
			for (int i = 0; i < 3; i++) {
				if (super.participant2ScoreBoxestxf.get(i).getText().isEmpty()) {
					return true;
				}
			}
			break;
		case 2:
			for (int i = 0; i < super.participant1ScoreBoxestxf.size(); i++) {
				if (super.participant1ScoreBoxestxf.get(i).getText().isEmpty()) {
					return true;
				}
			}
			for (int i = 0; i < super.participant2ScoreBoxestxf.size(); i++) {
				if (super.participant2ScoreBoxestxf.get(i).getText().isEmpty()) {
					return true;
				}
			}
			break;
		}
		return false;
	}

	public int getGameStatus() {
		return gameStatus;
	}

}
