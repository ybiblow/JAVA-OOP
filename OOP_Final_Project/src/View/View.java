//Yaakov Biblow 205460942
//Shalev Saban 322358466
package View;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class View {
	private Stage primarystage;
	private MainScreen mainScreen = new MainScreen();
	private Tournament tournament;
	private Scene scene = new Scene(this.mainScreen, 1420, 700);

	public View(Stage primaryStage) {
		this.primarystage = primaryStage;
		this.primarystage.setScene(scene);
		this.primarystage.setTitle("Championship");
		this.primarystage.setResizable(false);
		this.primarystage.show();
	}

	public MainScreen getMainScreen() {
		return mainScreen;
	}

	public void displayTournament(ArrayList<TextField> participants) {
		this.tournament.updateParticipants(participants);
		this.scene.setRoot(this.tournament);
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void createTournament(int gameType) {
		this.tournament = new Tournament(gameType);
	}

}
