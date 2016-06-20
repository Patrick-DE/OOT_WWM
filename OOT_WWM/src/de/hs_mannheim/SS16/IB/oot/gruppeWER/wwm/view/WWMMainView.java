package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.Model_Question;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;
import java.awt.CardLayout;
import java.awt.Color;

public class WWMMainView extends WWMView {

	//MARK: - Assets
	private JFrame frmWwm;
	private View_Window_MainMenu menu;
	private View_Window_Question questionWindow;
	private CardLayout card;
	private View_Window_SaveGame saveWindow;
	private View_Window_LoadSaveGame loadWindow;
	private View_Window_HighScore highScoreWindow;
	private View_Window_EndOfGame endGameWindow;

	//MARK: - Constructor
	public WWMMainView(WWMModel model, WWMController controller) {
		super(model, controller);
		initialize();
	}

	//MARK: - Methods
	private void initialize() {
		frmWwm = new JFrame();
		frmWwm.setTitle("WWM");
		frmWwm.setBounds(100, 100, 450, 300);
		frmWwm.setSize(600, 400);
		frmWwm.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		card = new CardLayout();
		frmWwm.getContentPane().setLayout(card);
		menu = new View_Window_MainMenu(model,controller);
		questionWindow = new View_Window_Question(controller, model);
		questionWindow.registerKeyboardAction(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				displayMainMenu();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		saveWindow = new View_Window_SaveGame(model, "");
		saveWindow.registerKeyboardAction(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				displayMainMenu();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		loadWindow = new View_Window_LoadSaveGame(model);
		loadWindow.registerKeyboardAction(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				displayMainMenu();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		highScoreWindow = new View_Window_HighScore(model);
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
		frmWwm.setBackground(Color.BLACK);
		frmWwm.setVisible(true);
		frmWwm.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				new View_JDialog_Exit(controller);
			}
		});
	}
	@Override public void setQuestion(Model_Question question) {
		if(model.getQuestionIndex() < 15) {
			questionWindow.setQuestion(question);
		}
	}
	@Override public void provideAnswerFeedback(int answerIndex) {
		questionWindow.disableAllButtons();
		questionWindow.changeAnswerButtonBackgroundImage(answerIndex, 1);
		Timer delayTimer = new Timer();
		delayTimer.schedule(new TimerTask() {
			@Override public void run() {
				//Answer was correct
				if(model.getCorrectAnswerIndex() == answerIndex) {
					//Color the chosen answer GREEN
					questionWindow.changeAnswerButtonBackgroundImage(answerIndex, 2);
				}
				//Answer was wrong
				else {
					//Color the chosen answer RED
					questionWindow.changeAnswerButtonBackgroundImage(answerIndex, 3);
					//Color the correct answer GREEN
					switch(model.getCorrectAnswerIndex()) {
					case 1:
						questionWindow.changeAnswerButtonBackgroundImage(1, 2);
						break;
					case 2:
						questionWindow.changeAnswerButtonBackgroundImage(2, 2);
						break;
					case 3:
						questionWindow.changeAnswerButtonBackgroundImage(3, 2);
						break;
					case 4:
						questionWindow.changeAnswerButtonBackgroundImage(4, 2);
						break;
					}
				}
			}
		}, 1 * 1000);
	}
	@Override public void displayAudienceJoker() {
		questionWindow.setAudienceJokerUsed();
		new View_JokerAudience(model.generateAudienceJokerResults(model.getQuestionAtIndex(model.getQuestionIndex())));
	}
	@Override public void displayTelephoneJoker() {
		questionWindow.setTelephoneJokerUsed();
		new View_JokerTelephone(model.generateTelephoneJokerResults(model.getQuestionAtIndex(model.getQuestionIndex())));
	}
	@Override public void displayFiftyFiftyJoker() {
		questionWindow.useFiftyFiftyJoker(model.generateFiftyFiftyJokerResults(model.getQuestionAtIndex(model.getQuestionIndex())));
	}
	@Override public void displaySaveDialog() {
		saveWindow.updateSaveWindow();
		card.show(frmWwm.getContentPane(), "saveWindow");
	}
	@Override public void displayLoadDialog() {
		loadWindow.updateLoadWindow();
		card.show(frmWwm.getContentPane(), "loadWindow");
	}
	@Override public void displayGameWindow() {
		questionWindow.updateJokerButtons();
		card.show(frmWwm.getContentPane(), "questionWindow");
	}
	@Override public void displayHighScoreWindow() {
		highScoreWindow.updateHighScoreWindow();
		card.show(frmWwm.getContentPane(), "highScoreWindow");
	}
	@Override public void displayExitDialog() {
		new View_JDialog_Exit(controller);
	}
	@Override public void displayDropOutDialog() {
		new View_JDialog_DropOut(model);
	}
	@Override public void displayFalseAnswerDialog() {
		new View_JDialog_FalseAnswer();
	}
	@Override public void displayEndOfGameDialog() {
		endGameWindow = new View_Window_EndOfGame(model);
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