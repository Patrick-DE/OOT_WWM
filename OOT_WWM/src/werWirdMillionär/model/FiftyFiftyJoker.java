package werWirdMillionär.model;

public class FiftyFiftyJoker extends Joker {

	FiftyFiftyJoker (){
		
	}
	
	public int[] getFalseAnserPositions (Question question) {
		switch (question.getRightAnswerIndex()) {
		case 1:
			return new int[] {2, 3};
		case 2:
			return new int[] {1, 3};
		case 3:
			return new int[] {2, 4};
		case 4:
			return new int[] {1, 3};
		default:
			return new int[] {-1, -1};
		}
 	}
}
