//Yaakov Biblow 205460942
//Shalev Saban 322358466
package View;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

public class Tournament extends Pane {
	private ArrayList<Line> arrLines = new ArrayList<>();
	private ArrayList<TextField> participants = new ArrayList<>();
	private ArrayList<TextField> arrtxf2 = new ArrayList<>();
	private ArrayList<TextField> arrtxf3 = new ArrayList<>();
	private TextField txfChampion = new TextField();
	private Button btnGame1 = new Button("Play Game");
	private Button btnGame2 = new Button("Play Game");
	private Button btnGame3 = new Button("Play Game");
	private Button btnGame4 = new Button("Play Game");
	private Button btnGame5 = new Button("Play Game");
	private Button btnGame6 = new Button("Play Game");
	private Button btnGame7 = new Button("Play Game");
	private Label titleLbl = new Label("Championship");
	private HBox hBox = new HBox(240);
	private VBox vBox1 = new VBox(40);
	private VBox vBox2 = new VBox(105);
	private VBox vBox3 = new VBox(234);
	private VBox vBox4 = new VBox(40);
	private DropShadow dropShadow = new DropShadow(15, Color.PURPLE);
	private ArrayList<GamePopup> gamesPopupList = new ArrayList<>();

	public Tournament(int gameType) {
		this.titleLbl.setText(" Championship");
		this.dropShadow.setOffsetX(3);
		this.dropShadow.setOffsetY(3);
		createTextFields();
		createLines();
		createGames(gameType);
		addButtons();
		addTitle();
	}

	private void createGames(int gameType) {
		switch (gameType) {
		case 0:
			for (int i = 0; i < 7; i++) {
				gamesPopupList.add(new TennisGamePopup());
			}
			break;
		case 1:
			for (int i = 0; i < 7; i++) {
				gamesPopupList.add(new BasketBallGamePopup());
			}
			break;
		case 2:
			for (int i = 0; i < 7; i++) {
				gamesPopupList.add(new SoccerGamePopup());
			}
			break;
		}
	}

	private void addTitle() {
		this.titleLbl.setLayoutX(470);
		this.getChildren().addAll(this.titleLbl);
		this.titleLbl.setStyle("-fx-text-fill: black;-fx-font-size:50px;-fx-font-weight: bold");
		this.titleLbl.setEffect(dropShadow);
	}

	private void createTextFields() {
		for (int i = 0; i < 8; i++) {
			this.participants.add(new TextField());
			this.participants.get(i).setEditable(false);
			this.participants.get(i).setEffect(dropShadow);
			this.participants.get(i).setStyle("-fx-focus-color: Purple;-fx-text-fill: Purple;-fx-font-weight: Bold");
		}
		for (int i = 0; i < 4; i++) {
			this.arrtxf2.add(new TextField());
			this.arrtxf2.get(i).setEditable(false);
			this.arrtxf2.get(i).setEffect(dropShadow);
			this.arrtxf2.get(i).setStyle("-fx-focus-color: Purple;-fx-text-fill: Purple;-fx-font-weight: Bold");
		}
		for (int i = 0; i < 2; i++) {
			this.arrtxf3.add(new TextField());
			this.arrtxf3.get(i).setEditable(false);
			this.arrtxf3.get(i).setEffect(dropShadow);
			this.arrtxf3.get(i).setStyle("-fx-focus-color: Purple;-fx-text-fill: Purple;-fx-font-weight: Bold");
		}
		this.vBox1.getChildren().addAll(participants);
		this.vBox1.setPadding(new Insets(65, 0, 0, 0));
		this.vBox2.getChildren().addAll(arrtxf2);
		this.vBox2.setPadding(new Insets(100, 0, 0, 0));
		this.vBox3.getChildren().addAll(arrtxf3);
		this.vBox3.setPadding(new Insets(165, 0, 0, 0));
		DropShadow dropShadowTMP = new DropShadow(15, Color.RED);
		this.txfChampion.setEditable(false);
		this.txfChampion.setStyle("-fx-focus-color: Red;-fx-text-fill: Red;-fx-font-weight: Bold");
		this.txfChampion.setEffect(dropShadowTMP);
		this.vBox4.getChildren().addAll(this.txfChampion);
		this.vBox4.setPadding(new Insets(288, 0, 0, 0));

		this.hBox.setPadding(new Insets(50));
		this.hBox.getChildren().addAll(this.vBox1, this.vBox2, this.vBox3, this.vBox4);
		this.getChildren().addAll(this.hBox);
	}

	private void createLines() {
		// First Round Lines
		this.arrLines.add(new Line(220, 128, 320, 128)); // Top Line
		this.arrLines.add(new Line(220, 194, 320, 194)); // Bottom Line
		this.arrLines.add(new Line(320, 128, 320, 148)); // Top to Bottom Line
		this.arrLines.add(new Line(320, 194, 320, 174)); // Bottom to Top Line
		this.arrLines.add(new Line(362, 162, 444, 162)); // Left to Right Line

		this.arrLines.add(new Line(220, 258, 320, 258)); // Top Line
		this.arrLines.add(new Line(220, 324, 320, 324)); // Bottom Line
		this.arrLines.add(new Line(320, 258, 320, 278)); // Top to Bottom Line
		this.arrLines.add(new Line(320, 324, 320, 304)); // Bottom to Top Line
		this.arrLines.add(new Line(362, 292, 444, 292)); // Left to Right Line

		this.arrLines.add(new Line(220, 388, 320, 388)); // Top Line
		this.arrLines.add(new Line(220, 454, 320, 454)); // Bottom Line
		this.arrLines.add(new Line(320, 388, 320, 408)); // Top to Bottom Line
		this.arrLines.add(new Line(320, 454, 320, 434)); // Bottom to Top Line
		this.arrLines.add(new Line(362, 422, 444, 422)); // Left to Right Line

		this.arrLines.add(new Line(220, 518, 320, 518)); // Top Line
		this.arrLines.add(new Line(220, 584, 320, 584)); // Bottom Line
		this.arrLines.add(new Line(320, 518, 320, 538)); // Top to Bottom Line
		this.arrLines.add(new Line(320, 584, 320, 564)); // Bottom to Top Line
		this.arrLines.add(new Line(362, 552, 444, 552)); // Left to Right Line
		// Second Round Lines
		this.arrLines.add(new Line(616, 162, 670, 162)); // Top Line
		this.arrLines.add(new Line(616, 292, 670, 292)); // Bottom Line
		this.arrLines.add(new Line(670, 162, 670, 214)); // Top to Bottom Line
		this.arrLines.add(new Line(670, 292, 670, 240)); // Bottom to Top Line
		this.arrLines.add(new Line(712, 228, 844, 228)); // Left to Right Line

		this.arrLines.add(new Line(616, 422, 670, 422)); // Top Line
		this.arrLines.add(new Line(616, 552, 670, 552)); // Bottom Line
		this.arrLines.add(new Line(670, 422, 670, 474)); // Top to Bottom Line
		this.arrLines.add(new Line(670, 552, 670, 500)); // Bottom to Top Line
		this.arrLines.add(new Line(712, 486, 844, 486)); // Left to Right Line
		// Last Round Lines
		this.arrLines.add(new Line(1012, 227, 1058, 227)); // Top Line
		this.arrLines.add(new Line(1012, 485, 1058, 485)); // Bottom Line
		this.arrLines.add(new Line(1058, 227, 1058, 337)); // Top to Bottom Line
		this.arrLines.add(new Line(1058, 485, 1058, 365)); // Bottom to Top Line
		this.arrLines.add(new Line(1100, 351, 1242, 351)); // Left to Right Line

		this.getChildren().addAll(this.arrLines);

	}

	private void addButtons() {
		this.btnGame1.setLayoutX(290);
		this.btnGame1.setLayoutY(149);

		this.btnGame2.setLayoutX(290);
		this.btnGame2.setLayoutY(279);

		this.btnGame3.setLayoutX(290);
		this.btnGame3.setLayoutY(409);

		this.btnGame4.setLayoutX(290);
		this.btnGame4.setLayoutY(539);

		this.btnGame5.setLayoutX(640);
		this.btnGame5.setLayoutY(215);
		this.btnGame5.setDisable(true);

		this.btnGame6.setLayoutX(640);
		this.btnGame6.setLayoutY(474);
		this.btnGame6.setDisable(true);

		this.btnGame7.setLayoutX(1028);
		this.btnGame7.setLayoutY(338);
		this.btnGame7.setDisable(true);

		this.getChildren().addAll(this.btnGame1, this.btnGame2, this.btnGame3, this.btnGame4, this.btnGame5,
				this.btnGame6, this.btnGame7);
	}

	public void updateParticipants(ArrayList<TextField> participants) {
		for (int i = 0; i < this.participants.size(); i++) {
			this.participants.get(i).setText(participants.get(i).getText());
		}
	}

	public Button getBtnGame1() {
		return btnGame1;
	}

	public Button getBtnGame2() {
		return btnGame2;
	}

	public Button getBtnGame3() {
		return btnGame3;
	}

	public Button getBtnGame4() {
		return btnGame4;
	}

	public Button getBtnGame5() {
		return btnGame5;
	}

	public Button getBtnGame6() {
		return btnGame6;
	}

	public Button getBtnGame7() {
		return btnGame7;
	}

	public ArrayList<TextField> getParticipants() {
		return participants;
	}

	public ArrayList<GamePopup> getGamesPopupList() {
		return gamesPopupList;
	}

	public ArrayList<TextField> getArrtxf2() {
		return arrtxf2;
	}

	public ArrayList<TextField> getArrtxf3() {
		return arrtxf3;
	}

	public void disableGameButton(int i) {
		switch (i) {
		case 1:
			this.btnGame1.setDisable(true);
			break;

		case 2:
			this.btnGame2.setDisable(true);
			break;
		case 3:
			this.btnGame3.setDisable(true);
			break;
		case 4:
			this.btnGame4.setDisable(true);
			break;
		case 5:
			this.btnGame5.setDisable(true);
			break;
		case 6:
			this.btnGame6.setDisable(true);
			break;
		case 7:
			this.btnGame7.setDisable(true);
			break;

		}
	}

	public void enableGameButton(int button) {
		switch (button) {
		case 5:
			this.btnGame5.setDisable(false);
			break;
		case 6:
			this.btnGame6.setDisable(false);
			break;
		case 7:
			this.btnGame7.setDisable(false);
			break;
		}
	}

	public TextField getTxfChampion() {
		return txfChampion;
	}

}