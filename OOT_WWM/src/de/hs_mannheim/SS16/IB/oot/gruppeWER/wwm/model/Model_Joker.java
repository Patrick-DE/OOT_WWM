package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

public abstract class Model_Joker {

	//MARK: - Assets
	/**
	 * Indicates if the joker is valid
	 */
	private boolean isAlreadyUsed = false;
	/**
	 * Indicates at which question the user activated the joker 
	 */
	private int usedAtQuestionIndex;
	
	//MARK: - Getter and Setter Methods
	public boolean getStatus () {
		return isAlreadyUsed;
	}
	public void setStatus (boolean state) {
		this.isAlreadyUsed = state;
	}
	public int getUsedAtQuestionIndex() {
		return this.usedAtQuestionIndex;
	}
	public void setUsedAtQuestionIndex(int index) {
		this.usedAtQuestionIndex = index;
	}
}