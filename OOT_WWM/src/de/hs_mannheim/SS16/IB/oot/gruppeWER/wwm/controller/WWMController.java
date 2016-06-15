package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view.WWMMainView;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view.WWMView;

public class WWMController implements ActionListener {

	//MARK: - Assets
	private WWMModel model;
	private ArrayList<WWMView> views;
	
	//MARK: - Constructor
	public WWMController (WWMModel model) {
		this.model = model;
		views = new ArrayList<WWMView>();
	}
	
	//MARK: - Methods
	public void addViews (WWMView view) {
		views.add(view);
	}
	@Override public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand().equals("Neues Spiel")) {
			model.restartGame();
			for (WWMView view : views)
				view.displayGameWindow();
		} 
		else if (arg0.getActionCommand().equals("Weiterspielen")) {
			if (model.getGameStartedStatus())
				for (WWMView view : views)
					view.displayGameWindow();
		} 
		else if (arg0.getActionCommand().equals("Speichern")) {
			for (WWMView view : views)
				view.displaySaveDialog();
		} 
		else if (arg0.getActionCommand().equals("Laden")) {
			for (WWMView view : views)
				view.displayLoadDialog();
		} 
		else if (arg0.getActionCommand().equals("Bestenliste")) {
			for (WWMView view : views)
				view.displayHighScoreWindow();
		} 
		else if (arg0.getActionCommand().equals("Beenden")) {
			for (WWMView view : views)
				view.displayExitDialog();
		} 
		else if (arg0.getActionCommand().equals("Antwort1")) {
			model.validateAnswer(1);
		} 
		else if (arg0.getActionCommand().equals("Antwort2")) {
			model.validateAnswer(2);
		} 
		else if (arg0.getActionCommand().equals("Antwort3")) {
			model.validateAnswer(3);
		} 
		else if (arg0.getActionCommand().equals("Antwort4")) {
			model.validateAnswer(4);
		} 
		else if (arg0.getActionCommand().equals("Telefon")) {
			for (WWMView view : views)
				view.displayTelephoneJoker();
		} 
		else if (arg0.getActionCommand().equals("50/50")) {
			for (WWMView view : views)
				view.displayFiftyFiftyJoker();
		} 
		else if (arg0.getActionCommand().equals("Publikum")) {
			for (WWMView view : views)
				view.displayAudienceJoker();
		} 
		else if (arg0.getActionCommand().equals("Aussteigen")) {
			for (WWMView view : views)
				view.displayDropOutDialog();
		}
	}
	public static void main(String[] args) {
		WWMModel model = new WWMModel();
		WWMController controller = new WWMController(model);
		WWMView view = new WWMMainView(model, controller);
	}
}