package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.util.Observable;
import java.util.Observer;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.Model_Question;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

public abstract class WWMView implements Observer {

	//MARK: - Assets
	protected WWMModel model;
	protected WWMController controller;

	//MARK: - Methods
	WWMView(WWMModel model, WWMController controller) {
		this.model = model;
		this.controller = controller;
		controller.addViews(this);
		model.addObserver(this);
	}

	//MARK: - Methods
	/**
	 * set the question in the question window
	 * @param question
	 */
	public abstract void setQuestion(Model_Question question);
	/**
	 * display the audience joker
	 */
	public abstract void displayAudienceJoker();
	/**
	 * display the telephone joker
	 */
	public abstract void displayTelephoneJoker();
	/**
	 * display the fifty-fifty joker
	 */
	public abstract void displayFiftyFiftyJoker();
	/**
	 * display the save-game window
	 */
	public abstract void displaySaveDialog();
	/**
	 * display the load screen
	 */
	public abstract void displayLoadDialog();
	/**
	 * display the question window 
	 */
	public abstract void displayGameWindow();
	/**
	 * display the high-score window
	 */
	public abstract void displayHighScoreWindow();
	/**
	 * display the exit dialog
	 */
	public abstract void displayExitDialog();
	/**
	 * display the drop out dialog
	 */
	public abstract void displayDropOutDialog();
	/**
	 * display the false answer screen
	 */
	public abstract void displayFalseAnswerDialog();
	/**
	 * display the end-of-game window
	 */
	public abstract void displayEndOfGameDialog();
	/**
	 * display the main menu
	 */
	public abstract void displayMainMenu();
	
	@Override public void update(Observable o, Object arg) {
		if (!model.getGameFinishedStatus()) { // if game is running
			setQuestion(model.getQuestionAtIndex(model.getQuestionIndex())); // set the next question
			displayGameWindow();
		} else if (model.getGameStartedStatus()){ // game was valid
			if (model.getGameEndFalseAnswer()) // if game ended with a false answer
				displayFalseAnswerDialog();
			displayEndOfGameDialog();
		} else {
			displayMainMenu();
		}	
	}	
}