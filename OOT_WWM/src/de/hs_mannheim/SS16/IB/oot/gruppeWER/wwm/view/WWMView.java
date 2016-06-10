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

	//MARK: - Constructor
	WWMView(WWMModel model, WWMController controller) {
		this.model = model;
		this.controller = controller;
		controller.addViews(this);
		model.addObserver(this);
	}

	//MARK: - Abstract Methods
	public abstract void setQuestion(Model_Question question);

	public abstract void displayAudienceJoker();

	public abstract void displayTelephoneJoker();

	public abstract void displayFiftyFiftyJoker();

	public abstract void displaySaveDialog();

	public abstract void displayLoadDialog();
	
	public abstract void displayGameWindow();
	
	public abstract void displayHighScoreWindow();
	
	public abstract void displayExitDialog();
	
	public abstract void displayDropOutDialog();
	
	public abstract void displayFalseAnswerDialog();
	
	public abstract void displayEndOfGameDialog();
	
	public abstract void displayMainMenu();
	
	//MARK: - Methods (don't need to be implemented by extension classes)
	@Override public void update(Observable o, Object arg) {
		if (!model.getGameFinishedStatus()) {
			if (model.getGameStatus()) {
				setQuestion(model.getQuestionAtIndex(model.getQuestionIndex()));
				displayGameWindow();
			} else
				displayFalseAnswerDialog();
		} else
			displayEndOfGameDialog();
	}
}