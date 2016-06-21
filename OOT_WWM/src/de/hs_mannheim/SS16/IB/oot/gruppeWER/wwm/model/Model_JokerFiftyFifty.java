package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

public class Model_JokerFiftyFifty extends Model_Joker {

	//MARK: - Constructor
	public Model_JokerFiftyFifty() {}
	
	//MARK: - Methods
	public int[] getFalseAnswerPositions (Model_Question question) {
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