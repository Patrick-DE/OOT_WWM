package werWirdMillionär.model;

public abstract class Joker {

	/**
	 * indicates if the joker is valid
	 */
	private boolean isAlreadyUserd = false;
	
	public boolean getStatus () {
		return isAlreadyUserd;
	}
	
	public void setStatus (boolean state) {
		this.isAlreadyUserd = state;
	}
}
