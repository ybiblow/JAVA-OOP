
//Yaakov Biblow 205460942
//Shalev Saban 322358466
import Controller.Controller;
import Model.Model;
import View.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		View view = new View(primaryStage);
		Model model = new Model();
		new Controller(view, model);

	}
}
