//Yaakov Biblow 205460942
//Shalev Saban 322358466
package View;

import java.util.ArrayList;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class MainScreen extends BorderPane {
	private VBox vBoxParticipants = new VBox(15);
	private VBox vBoxCenter = new VBox(15);
	private VBox vBoxGames = new VBox(15);
	private HBox hBox = new HBox(15);
	private Label lbl = new Label("Championship");
	private Label lblParticipant = new Label("Participant Name: ");
	private BorderPane lblPane = new BorderPane(lbl);
	private ArrayList<TextField> arrtfx = new ArrayList<>();
	private TextField txfAddParticipant = new TextField();
	private Button btnAddParticipant = new Button("Add Participant");
	private Button btnRemoveParticipant = new Button("Remove Participant");
	private Button btnStartChampionship = new Button("Start Championship");
	private RadioButton rdb1 = new RadioButton("Tennis");
	private RadioButton rdb2 = new RadioButton("BasketBall");
	private RadioButton rdb3 = new RadioButton("Soccer");
	private ToggleGroup tg = new ToggleGroup();
	private Label errlbl = new Label();
	private int counter = 0;
	private boolean full = false;

	public MainScreen() {
		DropShadow dropShadow = new DropShadow(15, Color.PURPLE);
		dropShadow.setOffsetX(3);
		dropShadow.setOffsetY(3);
		this.arrtfx.add(new TextField());
		this.arrtfx.add(new TextField());
		this.arrtfx.add(new TextField());
		this.arrtfx.add(new TextField());
		this.arrtfx.add(new TextField());
		this.arrtfx.add(new TextField());
		this.arrtfx.add(new TextField());
		this.arrtfx.add(new TextField());
		for (TextField textField : arrtfx) {
			textField.setEditable(false);
			textField.setEffect(dropShadow);
			textField.setStyle("-fx-focus-color: Purple;-fx-text-fill: Purple;-fx-font-weight: Bold");
		}
		super.setPadding(new Insets(30));
		this.vBoxParticipants.setPadding(new Insets(120, 0, 0, 0));
		this.txfAddParticipant.setPromptText("Enter Participant Name");
		this.txfAddParticipant.setMinWidth(266);
		this.txfAddParticipant.setEffect(dropShadow);
		this.txfAddParticipant.setStyle("-fx-focus-color:Purple;-fx-text-fill: Purple");
		this.vBoxParticipants.getChildren().addAll(this.arrtfx);
		super.setLeft(vBoxParticipants);
		this.lblParticipant
				.setStyle("-fx-text-fill: Purple;-fx-font-weight: bold;-fx-font-size:13.64px;-fx-focus-color: Purple");
		this.lblParticipant.setGraphic(this.txfAddParticipant);
		this.lblParticipant.setContentDisplay(ContentDisplay.RIGHT);
		this.hBox.getChildren().addAll(this.btnAddParticipant, this.btnRemoveParticipant, this.btnStartChampionship);
		this.vBoxCenter.getChildren().addAll(this.lblParticipant, this.hBox, this.errlbl);
		this.vBoxCenter.setPadding(new Insets(240, 0, 0, 350));
		super.setCenter(vBoxCenter);
		lbl.setStyle("-fx-text-fill: black;-fx-font-size:50px;-fx-font-weight: bold");
		this.lbl.setEffect(dropShadow);
		super.setTop(lblPane);
		rdb1.setToggleGroup(this.tg);
		rdb2.setToggleGroup(this.tg);
		rdb3.setToggleGroup(this.tg);
		rdb1.setEffect(dropShadow);
		rdb1.setStyle("-fx-text-fill: Purple;-fx-font-weight: bold;-fx-focus-color: Purple;-fx-mark-color: Purple");
		rdb2.setEffect(dropShadow);
		rdb2.setStyle("-fx-text-fill: Purple;-fx-font-weight: bold;-fx-focus-color: Purple;-fx-mark-color: Purple");
		rdb3.setEffect(dropShadow);
		rdb3.setStyle("-fx-text-fill: Purple;-fx-font-weight: bold;-fx-focus-color: Purple;-fx-mark-color: Purple");
		this.btnAddParticipant.setEffect(dropShadow);
		this.btnAddParticipant.setStyle("-fx-text-fill: Purple;-fx-font-weight: bold;-fx-focus-color: Purple");
		this.btnRemoveParticipant.setEffect(dropShadow);
		this.btnRemoveParticipant.setStyle("-fx-text-fill: Purple;-fx-font-weight: bold;-fx-focus-color: Purple");
		this.btnStartChampionship.setEffect(dropShadow);
		this.btnStartChampionship.setStyle("-fx-text-fill: Purple;-fx-font-weight: bold;-fx-focus-color: Purple");
		this.vBoxGames.setPadding(new Insets(220, 0, 0, 0));
		this.vBoxGames.getChildren().addAll(this.rdb1, this.rdb2, this.rdb3);
		super.setRight(this.vBoxGames);
	}

	public Button getBtnAddParticipant() {
		return btnAddParticipant;
	}

	public Button getBtnStartChampionship() {
		return btnStartChampionship;
	}

	public TextField getTxfAddParticipant() {
		return txfAddParticipant;
	}

	public void addParticipant(String pName) throws Exception {
		if (!this.isFull()) {
			for (TextField textField : arrtfx) {
				if (textField.getText().equalsIgnoreCase(pName)) {
					throw new Exception("  The Participant Has Already Been Added!  ");
				}
			}
			this.arrtfx.get(counter).setText(pName);
			this.errlbl.setText("");
			if (counter + 1 == 8) {
				this.full = true;
			} else {
				counter++;
			}
		} else {
			throw new Exception("  Can't Add More Participants!  ");
		}
	}

	public Button getBtnRemoveParticipant() {
		return btnRemoveParticipant;
	}

	public void removeParticipant() {
		if (counter > 0) {
			if (this.counter == 7) {
				if (this.full) {
					this.full = false;
					this.arrtfx.get(this.counter).setText("");
//					this.counter--;
				} else {
					this.counter--;
					this.arrtfx.get(this.counter).setText("");
				}
			} else {
				this.counter--;
				this.arrtfx.get(this.counter).setText("");
//				if (this.counter == this.arrtfx.size() - 1) {
//					this.errlbl.setText("");
//				}
			}
		} else {
			if (!this.arrtfx.get(this.counter).getText().isEmpty()) {
				this.arrtfx.get(this.counter).setText("");
			} else {
				this.errlbl.setText(" No Playes/Teams to Remove! ");
				this.errlbl.setStyle("-fx-background-color: VIOLET;-fx-font-weight: bold;");
			}
		}

	}

	public Label getErrlbl() {
		return errlbl;
	}

	public int getCounter() {
		return counter;
	}

	public boolean isGameSelected() {
		if (rdb1.isSelected() || rdb2.isSelected() || rdb3.isSelected()) {
			return true;
		} else {
			return false;
		}
	}

	public RadioButton getRdb1() {
		return rdb1;
	}

	public RadioButton getRdb2() {
		return rdb2;
	}

	public RadioButton getRdb3() {
		return rdb3;
	}

	public boolean isFull() {
		return full;
	}

	public ArrayList<TextField> getArrtfx() {
		return arrtfx;
	}

	public String getSelectedGame() {
		if (this.rdb1.isSelected()) {
			return "Tennis";
		} else if (this.rdb2.isSelected()) {
			return "Basketball";
		} else if (this.rdb3.isSelected()) {
			return "Soccer";
		}
		return null;
	}

	public int getGameType() {
		if (this.getSelectedGame().equalsIgnoreCase("Tennis")) {
			return 0;
		} else if (this.getSelectedGame().equalsIgnoreCase("Basketball")) {
			return 1;
		} else if (this.getSelectedGame().equalsIgnoreCase("Soccer")) {
			return 2;
		}
		return 0;
	}
}
