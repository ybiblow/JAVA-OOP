//Yaakov Biblow 205460942
//Shalev Saban 322358466
package Model;

import java.util.ArrayList;

import javafx.scene.control.TextField;

public class Model {

	public int playGame(Game Game, ArrayList<TextField> participant1ScoreBoxes,
			ArrayList<TextField> participant2ScoreBoxes) {
		ArrayList<Integer> participant1ScoreBoxesList = new ArrayList<>();
		ArrayList<Integer> participant2ScoreBoxesList = new ArrayList<>();
		for (int i = 0; i < participant1ScoreBoxes.size(); i++) {
			if (!participant1ScoreBoxes.get(i).getText().isEmpty()) {
				participant1ScoreBoxesList.add(Integer.parseInt(participant1ScoreBoxes.get(i).getText()));
			}
		}
		for (int i = 0; i < participant2ScoreBoxes.size(); i++) {
			if (!participant2ScoreBoxes.get(i).getText().isEmpty()) {
				participant2ScoreBoxesList.add(Integer.parseInt(participant2ScoreBoxes.get(i).getText()));
			}
		}
		return Game.play(participant1ScoreBoxesList, participant2ScoreBoxesList);
	}

	public int penalties(SoccerGame game, ArrayList<TextField> participant1ScoreBoxestxf,
			ArrayList<TextField> participant2ScoreBoxestxf) {
		ArrayList<Integer> participant1ScoreBoxesList = new ArrayList<>();
		ArrayList<Integer> participant2ScoreBoxesList = new ArrayList<>();
		for (int i = 0; i < participant1ScoreBoxestxf.size(); i++) {
			if (!participant1ScoreBoxestxf.get(i).getText().isEmpty()) {
				participant1ScoreBoxesList.add(Integer.parseInt(participant1ScoreBoxestxf.get(i).getText()));
			}
		}
		for (int i = 0; i < participant2ScoreBoxestxf.size(); i++) {
			if (!participant2ScoreBoxestxf.get(i).getText().isEmpty()) {
				participant2ScoreBoxesList.add(Integer.parseInt(participant2ScoreBoxestxf.get(i).getText()));
			}
		}
		return game.penaltiesShootout(participant1ScoreBoxesList, participant2ScoreBoxesList);
	}

}
