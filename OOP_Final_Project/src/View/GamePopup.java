//Yaakov Biblow 205460942
//Shalev Saban 322358466
package View;

import java.util.ArrayList;

import Model.Game;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public abstract class GamePopup extends Application {
	protected VBox mainvBox = new VBox(5);
	protected HBox mainhBox = new HBox(5);
	protected BorderPane bPane = new BorderPane(this.mainvBox);
	protected Stage primaryStage = new Stage();
	protected Scene scene = new Scene(bPane, 400, 400);
	protected VBox participantsVBox = new VBox(15);
	protected VBox scoreBoxesVBox = new VBox(5);
	protected HBox scoreBox1 = new HBox(5);
	protected HBox scoreBox2 = new HBox(5);
	protected Label par1 = new Label();
	protected Label par2 = new Label();
	protected Label titleLabel = new Label();
	protected Label errLabel = new Label();
	protected ArrayList<TextField> participant1ScoreBoxestxf = new ArrayList<>();
	protected ArrayList<TextField> participant2ScoreBoxestxf = new ArrayList<>();
	protected Button btn = new Button("Done");
	protected Game game;
	protected int winner = 0;

	public GamePopup(String title, Game game) {
		this.bPane.setPadding(new Insets(20));
		this.mainhBox.setPadding(new Insets(100, 10, 10, 50));
		this.btn.setTranslateX(150);
		this.errLabel.setTranslateX(100);
		this.participantsVBox.getChildren().addAll(this.par1, this.par2);
		this.scoreBoxesVBox.getChildren().addAll(this.scoreBox1, this.scoreBox2);
		this.mainhBox.getChildren().addAll(this.participantsVBox, this.scoreBoxesVBox);
		this.mainvBox.getChildren().addAll(this.mainhBox, this.errLabel);
		this.bPane.setTop(this.titleLabel);
		this.titleLabel.setText(title + " Game");
		this.game = game;
		this.bPane.setBottom(this.btn);
		this.primaryStage.setScene(this.scene);
		this.primaryStage.setTitle(title + " Game");
		this.primaryStage.setResizable(false);
	}

	public void start(Stage primaryStage) {
		primaryStage.show();
	}

	public void updatePlayGame(String participant1, String participant2) {
		this.par1.setText(participant1);
		this.par2.setText(participant2);
	}

	protected abstract void createScoreBoxes();

	protected void setTitle(int x) {
		DropShadow dropShadow = new DropShadow(15, Color.PURPLE);
		this.titleLabel.setTranslateX(x);
		this.titleLabel.setStyle("-fx-text-fill: black;-fx-font-size:40px;-fx-font-weight: bold");
		this.titleLabel.setEffect(dropShadow);
	}

	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public Button getBtn() {
		return btn;
	}

	public Label getErrLabel() {
		return errLabel;
	}

	public void displayError(String message) {
		this.errLabel.setText(message);
		this.errLabel.setStyle("-fx-background-color: VIOLET;-fx-font-weight: bold;");
	}

	public int getParticipant1Score() {
		int score = 0;
		for (int i = 0; i < this.participant1ScoreBoxestxf.size(); i++) {
			if (!this.participant1ScoreBoxestxf.get(i).getText().isEmpty()) {
				score = score + Integer.parseInt(this.participant1ScoreBoxestxf.get(i).getText());
			}
		}
		return score;
	}

	public int getParticipant2Score() {
		int score = 0;
		for (int i = 0; i < this.participant2ScoreBoxestxf.size(); i++) {
			if (!this.participant2ScoreBoxestxf.get(i).getText().isEmpty()) {
				score = score + Integer.parseInt(this.participant2ScoreBoxestxf.get(i).getText());
			}
		}
		return score;
	}

	public Game getGame() {
		return game;
	}

	public abstract void results(int i);

	public ArrayList<TextField> getParticipant1ScoreBoxestxf() {
		return participant1ScoreBoxestxf;
	}

	public ArrayList<TextField> getParticipant2ScoreBoxestxf() {
		return participant2ScoreBoxestxf;
	}

	public int getWinner() {
		return winner;
	}

	public Label getPar1() {
		return par1;
	}

	public Label getPar2() {
		return par2;
	}

	public abstract boolean isRoundsEmpty();
}
