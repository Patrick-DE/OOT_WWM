package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.assets.WWMImageContainer;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.assets.WWMSoundContainer;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view.WWMMainView;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view.WWMView;

public class WWMController implements ActionListener {

	//MARK: - Assets
	private WWMModel model;
	private ArrayList<WWMView> views;
	public static WWMImageContainer imageContainer = new WWMImageContainer();
	public static WWMSoundContainer soundContainer = new WWMSoundContainer();

	//MARK: - Constructor
	public WWMController (WWMModel model) {
		this.model = model;
		views = new ArrayList<WWMView>();
	}

	//MARK: - Main Method
	public static void main(String[] args) {
		WWMModel model = new WWMModel();
		WWMController controller = new WWMController(model);
		WWMView view = new WWMMainView(model, controller);
		soundContainer.loopSound("musicIntro");
	}

	//MARK: - Methods
	public void addViews(WWMView view) {
		views.add(view);
	}
	@Override public void actionPerformed(ActionEvent arg0) {
		if(arg0.getActionCommand().equals("Neues Spiel")) {
			soundContainer.stopSound("musicIntro");
			model.restartGame();
			for (WWMView view : views) {
				view.displayGameWindow();
			}
		} 
		else if(arg0.getActionCommand().equals("Weiterspielen")) {
			soundContainer.stopSound("musicIntro");
			soundContainer.loopSound("musicBackground");
			if(model.getGameStartedStatus()) {
				for (WWMView view : views) {
					view.displayGameWindow();
				}
			}
		} 
		else if(arg0.getActionCommand().equals("Speichern")) {
			soundContainer.stopSound("musicIntro");
			for(WWMView view : views) {
				view.displaySaveDialog();
			}
		} 
		else if(arg0.getActionCommand().equals("Laden")) {
			soundContainer.stopSound("musicIntro");
			for(WWMView view : views) {
				view.displayLoadDialog();
			}
		} 
		else if(arg0.getActionCommand().equals("Bestenliste")) {
			soundContainer.stopSound("musicIntro");
			for(WWMView view : views) {
				view.displayHighScoreWindow();
			}
		} 
		else if(arg0.getActionCommand().equals("Beenden")) {
			for(WWMView view : views) {
				view.displayExitDialog();
			}
		} 
		else if(arg0.getActionCommand().equals("Antwort1")) {
			for(WWMView view : views) {
				view.provideAnswerFeedback(1);
			}
			model.logInAnswer(1);
		} 
		else if(arg0.getActionCommand().equals("Antwort2")) {
			for(WWMView view : views) {
				view.provideAnswerFeedback(2);
			}
			model.logInAnswer(2);
		} 
		else if(arg0.getActionCommand().equals("Antwort3")) {
			for(WWMView view : views) {
				view.provideAnswerFeedback(3);
			}
			model.logInAnswer(3);
		} 
		else if(arg0.getActionCommand().equals("Antwort4")) {
			for(WWMView view : views) {
				view.provideAnswerFeedback(4);
			}
			model.logInAnswer(4);
		} 
		else if(arg0.getActionCommand().equals("Telefon")) {
			soundContainer.playSound("joker");
			for(WWMView view : views) {
				//This function may be called multiple times, since during the initial question multiple views in the views-array are applicable
				//Only one view will pass non-null parameters
				view.displayTelephoneJoker();
			}
		} 
		else if(arg0.getActionCommand().equals("50/50")) {
			soundContainer.playSound("joker");
			for(WWMView view : views) {
				//This function may be called multiple times, since during the initial question multiple views in the views-array are applicable
				//Only one view will pass non-null parameters
				view.displayFiftyFiftyJoker();
			}
		} 
		else if (arg0.getActionCommand().equals("Publikum")) {
			soundContainer.playSound("joker");
			for (WWMView view : views) {
				//This function may be called multiple times, since during the initial question multiple views in the views-array are applicable
				//Only one view will pass non-null parameters
				view.displayAudienceJoker();
			}
		} 
		else if (arg0.getActionCommand().equals("Aussteigen")) {
			for (WWMView view : views) {
				view.displayDropOutDialog();
			}
		}
	}
}