package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

public abstract class Model_Joker {

	//MARK: - Assets
	/**
	 * indicates if the joker is valid
	 */
	private boolean isAlreadyUsed = false;
	
	//MARK: - Getter and Setter Methods
	public boolean getStatus () {
		return isAlreadyUsed;
	}
	public void setStatus (boolean state) {
		this.isAlreadyUsed = state;
	}
}