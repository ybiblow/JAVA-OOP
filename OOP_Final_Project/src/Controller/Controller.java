//Yaakov Biblow 205460942
//Shalev Saban 322358466
package Controller;

import Model.BasketballGame;
import Model.Model;
import Model.SoccerGame;
import Model.TennisGame;
import View.BasketBallGamePopup;
import View.SoccerGamePopup;
import View.TennisGamePopup;
import View.View;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {
	private View view;
	private Model model;

	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		mainScreen();
	}

	private void mainScreen() {
		this.view.getMainScreen().getTxfAddParticipant().setOnKeyPressed(new KeyEventAddParticipant(view));
		this.view.getMainScreen().getBtnAddParticipant().setOnAction(new ButtonAddParticipant(view));
		this.view.getMainScreen().getBtnRemoveParticipant().setOnAction(e -> {
			this.view.getMainScreen().removeParticipant();
		});
		this.view.getMainScreen().getBtnStartChampionship().setOnAction(new ButtonStartChampionship(view, this));
	}

	protected void checkEnableGameButton(int gameNumber) {
		switch (gameNumber) {
		case 0:
			if (!this.view.getTournament().getArrtxf2().get(0).getText().isEmpty()
					&& !this.view.getTournament().getArrtxf2().get(1).getText().isEmpty()) {
				this.view.getTournament().enableGameButton(5);
			}
			break;

		case 1:
			if (!this.view.getTournament().getArrtxf2().get(1).getText().isEmpty()
					&& !this.view.getTournament().getArrtxf2().get(0).getText().isEmpty()) {
				this.view.getTournament().enableGameButton(5);
			}
			break;
		case 2:
			if (!this.view.getTournament().getArrtxf2().get(2).getText().isEmpty()
					&& !this.view.getTournament().getArrtxf2().get(3).getText().isEmpty()) {
				this.view.getTournament().enableGameButton(6);
			}
			break;
		case 3:
			if (!this.view.getTournament().getArrtxf2().get(3).getText().isEmpty()
					&& !this.view.getTournament().getArrtxf2().get(2).getText().isEmpty()) {
				this.view.getTournament().enableGameButton(6);
			}
			break;
		case 4:
			if (!this.view.getTournament().getArrtxf3().get(0).getText().isEmpty()
					&& !this.view.getTournament().getArrtxf3().get(1).getText().isEmpty()) {
				this.view.getTournament().enableGameButton(7);
			}
			break;
		case 5:
			if (!this.view.getTournament().getArrtxf3().get(1).getText().isEmpty()
					&& !this.view.getTournament().getArrtxf3().get(0).getText().isEmpty()) {
				this.view.getTournament().enableGameButton(7);
			}
			break;
		}
	}

	protected void createTournamentButtons() {
		this.view.getTournament().getBtnGame1().setOnAction(new TournamentButtonAction(this.view, 0, 0));
		this.view.getTournament().getBtnGame2().setOnAction(new TournamentButtonAction(this.view, 2, 1));
		this.view.getTournament().getBtnGame3().setOnAction(new TournamentButtonAction(this.view, 4, 2));
		this.view.getTournament().getBtnGame4().setOnAction(new TournamentButtonAction(this.view, 6, 3));
		this.view.getTournament().getBtnGame5().setOnAction(new TournamentButtonAction(this.view, 0, 4));
		this.view.getTournament().getBtnGame6().setOnAction(new TournamentButtonAction(this.view, 2, 5));
		this.view.getTournament().getBtnGame7().setOnAction(new TournamentButtonAction(this.view, 0, 6));

	}

	public void tennisGameButtons() {
		this.view.getTournament().getGamesPopupList().get(0).getBtn()
				.setOnAction(new TennisButtonAction(this, this.view, this.model, 0));
		this.view.getTournament().getGamesPopupList().get(1).getBtn()
				.setOnAction(new TennisButtonAction(this, this.view, this.model, 1));
		this.view.getTournament().getGamesPopupList().get(2).getBtn()
				.setOnAction(new TennisButtonAction(this, this.view, this.model, 2));
		this.view.getTournament().getGamesPopupList().get(3).getBtn()
				.setOnAction(new TennisButtonAction(this, this.view, this.model, 3));
		this.view.getTournament().getGamesPopupList().get(4).getBtn()
				.setOnAction(new TennisButtonAction(this, this.view, this.model, 4));
		this.view.getTournament().getGamesPopupList().get(5).getBtn()
				.setOnAction(new TennisButtonAction(this, this.view, this.model, 5));
		this.view.getTournament().getGamesPopupList().get(6).getBtn()
				.setOnAction(new TennisButtonAction(this, this.view, this.model, 6));

	}

	public void basketballGameButtons() {
		this.view.getTournament().getGamesPopupList().get(0).getBtn()
				.setOnAction(new BasketballButtonAction(this, this.view, this.model, 0));
		this.view.getTournament().getGamesPopupList().get(1).getBtn()
				.setOnAction(new BasketballButtonAction(this, this.view, this.model, 1));
		this.view.getTournament().getGamesPopupList().get(2).getBtn()
				.setOnAction(new BasketballButtonAction(this, this.view, this.model, 2));
		this.view.getTournament().getGamesPopupList().get(3).getBtn()
				.setOnAction(new BasketballButtonAction(this, this.view, this.model, 3));
		this.view.getTournament().getGamesPopupList().get(4).getBtn()
				.setOnAction(new BasketballButtonAction(this, this.view, this.model, 4));
		this.view.getTournament().getGamesPopupList().get(5).getBtn()
				.setOnAction(new BasketballButtonAction(this, this.view, this.model, 5));
		this.view.getTournament().getGamesPopupList().get(6).getBtn()
				.setOnAction(new BasketballButtonAction(this, this.view, this.model, 6));

	}

	public void soccerGameButtons() {
		this.view.getTournament().getGamesPopupList().get(0).getBtn()
				.setOnAction(new SoccerButtonAction(this, this.view, this.model, 0));
		this.view.getTournament().getGamesPopupList().get(1).getBtn()
				.setOnAction(new SoccerButtonAction(this, this.view, this.model, 1));
		this.view.getTournament().getGamesPopupList().get(2).getBtn()
				.setOnAction(new SoccerButtonAction(this, this.view, this.model, 2));
		this.view.getTournament().getGamesPopupList().get(3).getBtn()
				.setOnAction(new SoccerButtonAction(this, this.view, this.model, 3));
		this.view.getTournament().getGamesPopupList().get(4).getBtn()
				.setOnAction(new SoccerButtonAction(this, this.view, this.model, 4));
		this.view.getTournament().getGamesPopupList().get(5).getBtn()
				.setOnAction(new SoccerButtonAction(this, this.view, this.model, 5));
		this.view.getTournament().getGamesPopupList().get(6).getBtn()
				.setOnAction(new SoccerButtonAction(this, this.view, this.model, 6));

	}

	public void displayWinner(int gameNumber) {
		switch (gameNumber) {
		case 0:
			displayRound1Winners(gameNumber);
			break;
		case 1:
			displayRound1Winners(gameNumber);
			break;
		case 2:
			displayRound1Winners(gameNumber);
			break;
		case 3:
			displayRound1Winners(gameNumber);
			break;
		case 4:
			displayRound2Winners(gameNumber);
			break;
		case 5:
			displayRound2Winners(gameNumber);
			break;
		case 6:
			displayChampion(gameNumber);
			break;

		}
	}

	private void displayRound1Winners(int gameNumber) {
		if (this.view.getTournament().getGamesPopupList().get(gameNumber).getWinner() == 1) {
			this.view.getTournament().getArrtxf2().get(gameNumber)
					.setText(this.view.getTournament().getGamesPopupList().get(gameNumber).getPar1().getText());
			this.view.getTournament().disableGameButton(gameNumber + 1);
			this.view.getTournament().getGamesPopupList().get(gameNumber).getBtn().setDisable(true);
		} else if (this.view.getTournament().getGamesPopupList().get(gameNumber).getWinner() == 2) {
			this.view.getTournament().getArrtxf2().get(gameNumber)
					.setText(this.view.getTournament().getGamesPopupList().get(gameNumber).getPar2().getText());
			this.view.getTournament().disableGameButton(gameNumber + 1);
			this.view.getTournament().getGamesPopupList().get(gameNumber).getBtn().setDisable(true);
		}
	}

	private void displayRound2Winners(int gameNumber) {
		if (this.view.getTournament().getGamesPopupList().get(gameNumber).getWinner() == 1) {
			this.view.getTournament().getArrtxf3().get(gameNumber - 4)
					.setText(this.view.getTournament().getGamesPopupList().get(gameNumber).getPar1().getText());
			this.view.getTournament().disableGameButton(gameNumber + 1);
			this.view.getTournament().getGamesPopupList().get(gameNumber).getBtn().setDisable(true);
		} else if (this.view.getTournament().getGamesPopupList().get(gameNumber).getWinner() == 2) {
			this.view.getTournament().getArrtxf3().get(gameNumber - 4)
					.setText(this.view.getTournament().getGamesPopupList().get(gameNumber).getPar2().getText());
			this.view.getTournament().disableGameButton(gameNumber + 1);
			this.view.getTournament().getGamesPopupList().get(gameNumber).getBtn().setDisable(true);
		}
	}

	private void displayChampion(int gameNumber) {
		if (this.view.getTournament().getGamesPopupList().get(gameNumber).getWinner() == 1) {
			this.view.getTournament().getTxfChampion()
					.setText(this.view.getTournament().getGamesPopupList().get(gameNumber).getPar1().getText());
			this.view.getTournament().disableGameButton(gameNumber + 1);
			this.view.getTournament().getGamesPopupList().get(gameNumber).getBtn().setDisable(true);
		} else if (this.view.getTournament().getGamesPopupList().get(gameNumber).getWinner() == 2) {
			this.view.getTournament().getTxfChampion()
					.setText(this.view.getTournament().getGamesPopupList().get(gameNumber).getPar2().getText());
			this.view.getTournament().disableGameButton(gameNumber + 1);
			this.view.getTournament().getGamesPopupList().get(gameNumber).getBtn().setDisable(true);
		}
	}

}

class KeyEventAddParticipant implements EventHandler<KeyEvent> {
	private View view;

	public KeyEventAddParticipant(View view) {
		this.view = view;
	}

	@Override
	public void handle(KeyEvent event) {

		if (event.getCode() == KeyCode.ENTER) {
			try {
				String pName = this.view.getMainScreen().getTxfAddParticipant().getText();
				if (pName.isEmpty()) {
					throw new Exception("  Please Enter Participant Name!  ");
				}
				this.view.getMainScreen().addParticipant(pName);
				this.view.getMainScreen().getTxfAddParticipant().setText("");
				this.view.getMainScreen().getTxfAddParticipant().requestFocus();
			} catch (Exception exception) {
				this.view.getMainScreen().getErrlbl().setText(exception.getMessage());
				this.view.getMainScreen().getErrlbl().setStyle("-fx-background-color: VIOLET;-fx-font-weight: bold;");
			}

		}

	}

}

class ButtonAddParticipant implements EventHandler<ActionEvent> {
	private View view;

	public ButtonAddParticipant(View view) {
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			String pName = this.view.getMainScreen().getTxfAddParticipant().getText();
			if (pName.isEmpty()) {
				throw new Exception("  Please Enter Participant Name!  ");
			}
			this.view.getMainScreen().addParticipant(pName);
			this.view.getMainScreen().getTxfAddParticipant().setText("");
			this.view.getMainScreen().getTxfAddParticipant().requestFocus();
		} catch (Exception exception) {
			this.view.getMainScreen().getErrlbl().setText(exception.getMessage());
			this.view.getMainScreen().getErrlbl().setStyle("-fx-background-color: VIOLET;-fx-font-weight: bold;");
		}
	}
}

class ButtonStartChampionship implements EventHandler<ActionEvent> {
	private Controller controller;
	private View view;

	public ButtonStartChampionship(View view, Controller controller) {
		this.controller = controller;
		this.view = view;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			if (!this.view.getMainScreen().isGameSelected()) {
				throw new Exception("  Please Choose a Game!  ");
			}
			if (!this.view.getMainScreen().isFull()) {
				throw new Exception("  Please have 8 Playes/Teams  ");
			}
			this.view.createTournament(this.view.getMainScreen().getGameType());
			this.controller.createTournamentButtons();
			createPopupGameButtons(this.view.getMainScreen().getGameType());
			this.view.displayTournament(this.view.getMainScreen().getArrtfx());
		} catch (Exception exception) {
			this.view.getMainScreen().getErrlbl().setText(exception.getMessage());
			this.view.getMainScreen().getErrlbl().setStyle("-fx-background-color: VIOLET;-fx-font-weight: bold;");
		}
	}

	private void createPopupGameButtons(int selectedGame) {
		switch (selectedGame) {
		case 0:
			this.controller.tennisGameButtons();
			break;
		case 1:
			this.controller.basketballGameButtons();
			break;
		case 2:
			this.controller.soccerGameButtons();
		}
	}
}

class TournamentButtonAction implements EventHandler<ActionEvent> {
	private View view;
	private int participant, gameNumber;

	public TournamentButtonAction(View view, int participant, int gameNumber) {
		this.view = view;
		this.participant = participant;
		this.gameNumber = gameNumber;
	}

	@Override
	public void handle(ActionEvent event) {
		switch (this.gameNumber) {
		case 0:
			firstRound();
			break;
		case 1:
			firstRound();
			break;
		case 2:
			firstRound();
			break;
		case 3:
			firstRound();
			break;
		case 4:
			secondRound();
			break;
		case 5:
			secondRound();
			break;
		case 6:
			thirdRound();
			break;

		}

	}

	private void firstRound() {
		String participant1 = this.view.getTournament().getParticipants().get(this.participant).getText();
		String participant2 = this.view.getTournament().getParticipants().get(this.participant + 1).getText();
		this.view.getTournament().getGamesPopupList().get(this.gameNumber).updatePlayGame(participant1, participant2);
		this.view.getTournament().getGamesPopupList().get(this.gameNumber)
				.start(this.view.getTournament().getGamesPopupList().get(this.gameNumber).getPrimaryStage());
	}

	private void secondRound() {
		String participant1 = this.view.getTournament().getArrtxf2().get(this.participant).getText();
		String participant2 = this.view.getTournament().getArrtxf2().get(this.participant + 1).getText();
		this.view.getTournament().getGamesPopupList().get(this.gameNumber).updatePlayGame(participant1, participant2);
		this.view.getTournament().getGamesPopupList().get(this.gameNumber)
				.start(this.view.getTournament().getGamesPopupList().get(this.gameNumber).getPrimaryStage());
	}

	private void thirdRound() {
		String participant1 = this.view.getTournament().getArrtxf3().get(this.participant).getText();
		String participant2 = this.view.getTournament().getArrtxf3().get(this.participant + 1).getText();
		this.view.getTournament().getGamesPopupList().get(this.gameNumber).updatePlayGame(participant1, participant2);
		this.view.getTournament().getGamesPopupList().get(this.gameNumber)
				.start(this.view.getTournament().getGamesPopupList().get(this.gameNumber).getPrimaryStage());

	}
}

class TennisButtonAction implements EventHandler<ActionEvent> {
	private int gameNumber;
	private View view;
	private Model model;
	private Controller controller;

	public TennisButtonAction(Controller controller, View view, Model model, int gameNumber) {
		this.view = view;
		this.model = model;
		this.gameNumber = gameNumber;
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			if (((TennisGamePopup) this.view.getTournament().getGamesPopupList().get(this.gameNumber))
					.isRoundsEmpty()) {
				throw new Exception(" Please Fill 3 sets at least! ");
			}
			playTennisGame();
			this.controller.displayWinner(this.gameNumber);
			this.controller.checkEnableGameButton(this.gameNumber);
		} catch (NumberFormatException exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber)
					.displayError("  Please Enter Numbers!  ");
		} catch (Exception exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber).displayError(exception.getMessage());
		}
	}

	private void playTennisGame() {
		this.view.getTournament().getGamesPopupList().get(this.gameNumber).results(this.model.playGame(
				(TennisGame) this.view.getTournament().getGamesPopupList().get(this.gameNumber).getGame(),
				this.view.getTournament().getGamesPopupList().get(this.gameNumber).getParticipant1ScoreBoxestxf(),
				this.view.getTournament().getGamesPopupList().get(this.gameNumber).getParticipant2ScoreBoxestxf()));
	}

}

class BasketballButtonAction implements EventHandler<ActionEvent> {
	private View view;
	private Model model;
	private int gameNumber;
	private Controller controller;

	public BasketballButtonAction(Controller controller, View view, Model model, int gameNumber) {
		this.view = view;
		this.model = model;
		this.gameNumber = gameNumber;
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event) {
		try {
			if (((BasketBallGamePopup) this.view.getTournament().getGamesPopupList().get(this.gameNumber))
					.isRoundsEmpty()) {
				throw new Exception("  Please fill in the Score!  ");
			}
			playBasketballGame();
			if (this.view.getTournament().getGamesPopupList().get(this.gameNumber).getWinner() != 0) {
				this.controller.displayWinner(this.gameNumber);
				this.controller.checkEnableGameButton(this.gameNumber);
			}
		} catch (NumberFormatException exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber)
					.displayError("  Please Enter Numbers!  ");
		} catch (Exception exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber).displayError(exception.getMessage());
		}
	}

	private void playBasketballGame() {
		this.view.getTournament().getGamesPopupList().get(this.gameNumber).results(this.model.playGame(
				(BasketballGame) this.view.getTournament().getGamesPopupList().get(this.gameNumber).getGame(),
				this.view.getTournament().getGamesPopupList().get(this.gameNumber).getParticipant1ScoreBoxestxf(),
				this.view.getTournament().getGamesPopupList().get(this.gameNumber).getParticipant2ScoreBoxestxf()));
	}
}

class SoccerButtonAction implements EventHandler<ActionEvent> {
	private View view;
	private Model model;
	private int gameNumber;
	private Controller controller;

	public SoccerButtonAction(Controller controller, View view, Model model, int gameNumber) {
		this.view = view;
		this.model = model;
		this.gameNumber = gameNumber;
		this.controller = controller;
	}

	@Override
	public void handle(ActionEvent event) {
		int a = ((SoccerGamePopup) this.view.getTournament().getGamesPopupList().get(this.gameNumber)).getGameStatus();
		switch (a) {
		case 0:
			regularGame();
			break;
		case 1:
			timeoutGame();
			break;
		case 2:
			penaltyShootout();
			break;
		}
	}

	private void regularGame() {
		try {
			if (((SoccerGamePopup) this.view.getTournament().getGamesPopupList().get(this.gameNumber))
					.isRoundsEmpty()) {
				throw new Exception("  Please fill in the Score!  ");
			}
			playSoccer();
			if (this.view.getTournament().getGamesPopupList().get(this.gameNumber).getWinner() != 0) {
				this.controller.displayWinner(this.gameNumber);
				this.controller.checkEnableGameButton(this.gameNumber);
			}

		} catch (NumberFormatException exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber)
					.displayError("  Please Enter Numbers!  ");
		} catch (Exception exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber).displayError(exception.getMessage());
		}
	}

	private void timeoutGame() {
		try {
			if (((SoccerGamePopup) this.view.getTournament().getGamesPopupList().get(this.gameNumber))
					.isRoundsEmpty()) {
				throw new Exception("  Please fill in the Score!  ");
			}
			playSoccer();
			if (this.view.getTournament().getGamesPopupList().get(this.gameNumber).getWinner() != 0) {
				this.controller.displayWinner(this.gameNumber);
				this.controller.checkEnableGameButton(this.gameNumber);
			}

		} catch (NumberFormatException exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber)
					.displayError("  Please Enter Numbers!  ");
		} catch (Exception exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber).displayError(exception.getMessage());
		}
	}

	private void penaltyShootout() {
		try {
			if (((SoccerGamePopup) this.view.getTournament().getGamesPopupList().get(this.gameNumber))
					.isRoundsEmpty()) {
				throw new Exception("  Please fill in the Score!  ");
			}
			playPenalties();
			if (this.view.getTournament().getGamesPopupList().get(this.gameNumber).getWinner() != 0) {
				this.controller.displayWinner(this.gameNumber);
				this.controller.checkEnableGameButton(this.gameNumber);
			}
		} catch (NumberFormatException exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber)
					.displayError("  Please Enter Numbers!  ");
		} catch (Exception exception) {
			this.view.getTournament().getGamesPopupList().get(this.gameNumber).displayError(exception.getMessage());
		}
	}

	private void playPenalties() {
		this.view.getTournament().getGamesPopupList().get(this.gameNumber).results(this.model.penalties(
				(SoccerGame) this.view.getTournament().getGamesPopupList().get(this.gameNumber).getGame(),
				this.view.getTournament().getGamesPopupList().get(this.gameNumber).getParticipant1ScoreBoxestxf(),
				this.view.getTournament().getGamesPopupList().get(this.gameNumber).getParticipant2ScoreBoxestxf()));

	}

	private void playSoccer() {
		this.view.getTournament().getGamesPopupList().get(this.gameNumber).results(this.model.playGame(
				(SoccerGame) this.view.getTournament().getGamesPopupList().get(this.gameNumber).getGame(),
				this.view.getTournament().getGamesPopupList().get(this.gameNumber).getParticipant1ScoreBoxestxf(),
				this.view.getTournament().getGamesPopupList().get(this.gameNumber).getParticipant2ScoreBoxestxf()));
	}
}