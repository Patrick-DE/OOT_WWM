package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.Model_Question;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import java.awt.CardLayout;

public class WWMMainView extends WWMView {

	//MARK: - Assets
	private JFrame frmWwm;
	private View_MainMenu menu;
	private View_QuestionWindow questionWindow;
	private CardLayout card;
	private View_SaveWindow saveWindow;
	private View_LoadWindow loadWindow;
	private View_HighScoreWindow highScoreWindow;
	private View_EndOfGameWindow endGameWindow;

	//MARK: - Constructor
	public WWMMainView(WWMModel model, WWMController controller) {
		super(model, controller);
		initialize();
	}

	//MARK: - Initializer Methods
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmWwm = new JFrame();
		frmWwm.setTitle("WWM");
		frmWwm.setBounds(100, 100, 450, 300);
		frmWwm.setSize(600, 400);
		frmWwm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		card = new CardLayout();
		frmWwm.getContentPane().setLayout(card);
		menu = new View_MainMenu(model,controller);
		questionWindow = new View_QuestionWindow(controller, model);
		questionWindow.registerKeyboardAction(new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				displayMainMenu();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		saveWindow = new View_SaveWindow(model, "");
		saveWindow.registerKeyboardAction(new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				displayMainMenu();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		loadWindow = new View_LoadWindow(model, "");
		loadWindow.registerKeyboardAction(new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				displayMainMenu();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		highScoreWindow = new View_HighScoreWindow(model);
		highScoreWindow.registerKeyboardAction(new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				displayMainMenu();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		frmWwm.getContentPane().add(menu, "menu");
		frmWwm.getContentPane().add(questionWindow, "questionWindow");
		frmWwm.getContentPane().add(saveWindow, "saveWindow");
		frmWwm.getContentPane().add(loadWindow, "loadWindow");
		frmWwm.getContentPane().add(highScoreWindow, "highScoreWindow");
		frmWwm.setVisible(true);
	}

	//MARK: - Methods
	@Override public void setQuestion(Model_Question question) {
		questionWindow.setQuestion(question);
	}
	@Override public void displayAudienceJoker() {
		questionWindow.setAudienceJokerUsed();
		new View_JokerAudience(model.getAudienceJokerResults(model.getQuestionAtIndex(model.getQuestionIndex())));
	}
	@Override public void displayTelephoneJoker() {
		questionWindow.setTelephoneJokerUsed();
		
	}
	@Override public void displayFiftyFiftyJoker() {
		questionWindow.useFiftyFiftyJoker(model.getFiftyFiftyJokerResults(model.getQuestionAtIndex(model.getQuestionIndex())));
	}
	@Override public void displaySaveDialog() {
		card.show(frmWwm.getContentPane(), "saveWindow");
	}
	@Override public void displayLoadDialog() {
		card.show(frmWwm.getContentPane(), "loadWindow");
	}
	@Override public void displayGameWindow() {
		card.show(frmWwm.getContentPane(), "questionWindow");
	}
	@Override public void displayHighScoreWindow() {
		card.show(frmWwm.getContentPane(), "highScoreWindow");
	}
	@Override public void displayExitDialog() {
		new View_ExitDialogue(controller);
	}
	@Override public void displayDropOutDialog() {
		new View_DropOutDialogue(model);
	}
	@Override public void displayFalseAnswerDialog() {
		new View_FalseAnswerDialogue();
		displayEndOfGameDialog();
	}
	@Override public void displayEndOfGameDialog() {
		System.out.println("endOFgame");
		endGameWindow = new View_EndOfGameWindow(model);
		endGameWindow.registerKeyboardAction(new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				card.first(frmWwm.getContentPane());
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		frmWwm.getContentPane().add(endGameWindow, "endGameWindow");
		
		card.show(frmWwm.getContentPane(), "endGameWindow");
	}
	@Override public void displayMainMenu() {
		menu.updateMenuButtons();
		card.show(frmWwm.getContentPane(), "menu");
	}
}