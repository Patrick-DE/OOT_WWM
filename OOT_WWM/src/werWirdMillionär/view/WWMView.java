package werWirdMillionär.view;

import java.util.Observable;
import java.util.Observer;

import werWirdMillionär.controller.WWMController;
import werWirdMillionär.model.Question;
import werWirdMillionär.model.WWMModel;

public abstract class WWMView implements Observer {

	protected WWMModel model;
	protected WWMController controller;

	WWMView(WWMModel model, WWMController controller) {
		this.model = model;
		this.controller = controller;
		controller.addViews(this);
		model.addObserver(this);
	}

	public abstract void setQuestion(Question question);

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
	
	@Override
	public void update(Observable o, Object arg) {
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
