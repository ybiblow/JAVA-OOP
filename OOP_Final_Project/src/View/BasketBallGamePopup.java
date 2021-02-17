//Yaakov Biblow 205460942
//Shalev Saban 322358466
package View;

import Model.BasketballGame;
import javafx.scene.control.TextField;

public class BasketBallGamePopup extends GamePopup {

	public BasketBallGamePopup() {
		super("Basketball", new BasketballGame());
		createScoreBoxes();
		setTitle(30);
	}

	@Override
	protected void createScoreBoxes() {
		for (int i = 0; i < 4; i++) {
			super.participant1ScoreBoxestxf.add(new TextField());
			super.participant1ScoreBoxestxf.get(i).setMaxWidth(40);

			super.participant2ScoreBoxestxf.add(new TextField());
			super.participant2ScoreBoxestxf.get(i).setMaxWidth(40);
		}
		super.scoreBox1.getChildren().addAll(super.participant1ScoreBoxestxf);
		super.scoreBox2.getChildren().addAll(super.participant2ScoreBoxestxf);
	}

	@Override
	public boolean isRoundsEmpty() {
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
		return false;
	}

	@Override
	public void results(int i) {
		switch (i) {
		case 0:
			displayError("  It's Time for Overtime!  ");
			overTime();
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
	public void overTime() {
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

}
