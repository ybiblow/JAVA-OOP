//Yaakov Biblow 205460942
//Shalev Saban 322358466
package Model;

import java.util.ArrayList;

public abstract class Game {

	public abstract int play(ArrayList<Integer> participant1ScoreBoxesList,
			ArrayList<Integer> participant2ScoreBoxesList);
}