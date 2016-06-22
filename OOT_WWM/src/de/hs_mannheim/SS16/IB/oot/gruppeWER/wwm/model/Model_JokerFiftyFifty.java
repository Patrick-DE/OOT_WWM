package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;
/**
 * 
 * @author Anusan Ranjan
 * this class models the fifty fifty joker
 */
public class Model_JokerFiftyFifty extends Model_Joker {

	//MARK: - Constructor
	public Model_JokerFiftyFifty() {}
	
	//MARK: - Methods
	/**
	 * @param question
	 *                 current question to be answered
	 * @return an integer array containing two false answer positions.
	 */
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