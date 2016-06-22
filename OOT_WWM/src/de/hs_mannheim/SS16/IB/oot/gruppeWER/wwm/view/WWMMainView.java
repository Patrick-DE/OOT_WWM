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
import javax.swing.KeyStroke;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.Model_Question;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Toolkit;

public class WWMMainView extends WWMView {

	//MARK: - Assets
	private JFrame frmWMM;
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
		frmWMM = new JFrame();
		frmWMM.setTitle("WWM");
		frmWMM.setBounds(100, 100, 450, 300);
		frmWMM.setSize(1200, 800);
		frmWMM.setResizable(false);
		frmWMM.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - frmWMM.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - frmWMM.getHeight()/2);
		frmWMM.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		card = new CardLayout();
		frmWMM.getContentPane().setLayout(card);
		menu = new View_Window_MainMenu(model,controller);
		questionWindow = new View_Window_Question(controller, model);
		questionWindow.registerKeyboardAction(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				controller.soundContainer.stopSound("musicBackground");
				controller.soundContainer.loopSound("musicIntro");
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
		frmWMM.getContentPane().add(menu, "menu");
		frmWMM.getContentPane().add(questionWindow, "questionWindow");
		frmWMM.getContentPane().add(saveWindow, "saveWindow");
		frmWMM.getContentPane().add(loadWindow, "loadWindow");
		frmWMM.getContentPane().add(highScoreWindow, "highScoreWindow");
		frmWMM.setBackground(Color.BLACK);
		frmWMM.setVisible(true);
		frmWMM.addWindowListener(new WindowAdapter() {
			@Override public void windowClosing(WindowEvent e) {
				new View_JDialog_Exit(controller);
			}
		});
	}
	@Override public void setQuestion(Model_Question question) {
		if(model.getQuestionIndex() < 15) {
			controller.soundContainer.stopSound("musicBackground");
			controller.soundContainer.loopSound("musicBackground");
			questionWindow.setQuestion(question);
		}
	}
	@Override public void provideAnswerFeedback(int answerIndex) {
		controller.soundContainer.stopSound("musicBackground");
		questionWindow.disableAllButtons();
		//Set answer logged
		controller.soundContainer.playSound("answerLogged");
		questionWindow.changeAnswerButtonBackgroundImage(answerIndex, 1);
		Timer delayTimer = new Timer();
		delayTimer.schedule(new TimerTask() {
			@Override public void run() {
				//Answer was correct
				if(model.getCorrectAnswerIndex() == answerIndex) {
					//Play answerCorrect Sound
					controller.soundContainer.playSound("answerCorrect");
					//Color the chosen answer GREEN
					questionWindow.changeAnswerButtonBackgroundImage(answerIndex, 2);
				}
				//Answer was wrong
				else {
					//Play answerWrong Sound
					controller.soundContainer.playSound("answerWrong");
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
		int[] audienceResults = model.generateAudienceJokerResults(model.getQuestionAtIndex(model.getQuestionIndex()));
		//Only one view will pass non-null parameters
		//Prevent the other views from opening empty windows
		if(audienceResults != null) {
			new View_Dialog_JokerAudience(audienceResults);
		}
	}
	@Override public void displayTelephoneJoker() {
		questionWindow.setTelephoneJokerUsed();
		String callerResult = model.generateTelephoneJokerResults(model.getQuestionAtIndex(model.getQuestionIndex()));
		//Only one view will pass non-null parameters
		//Prevent the other views from opening empty windows
		if(callerResult != null) {
			new View_Dialog_JokerTelephone(callerResult);
		}
	}
	@Override public void displayFiftyFiftyJoker() {
		questionWindow.useFiftyFiftyJoker(model.generateFiftyFiftyJokerResults(model.getQuestionAtIndex(model.getQuestionIndex())));
	}
	@Override public void displaySaveDialog() {
		saveWindow.updateSaveWindow();
		card.show(frmWMM.getContentPane(), "saveWindow");
	}
	@Override public void displayLoadDialog() {
		loadWindow.updateLoadWindow();
		card.show(frmWMM.getContentPane(), "loadWindow");
	}
	@Override public void displayGameWindow() {
		questionWindow.updateJokerButtons();
		card.show(frmWMM.getContentPane(), "questionWindow");
	}
	@Override public void displayHighScoreWindow() {
		highScoreWindow.updateHighScoreWindow();
		card.show(frmWMM.getContentPane(), "highScoreWindow");
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
		controller.soundContainer.stopSound("musicBackground");
		endGameWindow = new View_Window_EndOfGame(model);
		endGameWindow.registerKeyboardAction(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				card.first(frmWMM.getContentPane());
				controller.soundContainer.loopSound("musicIntro");
				displayMainMenu();
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		frmWMM.getContentPane().add(endGameWindow, "endGameWindow");

		card.show(frmWMM.getContentPane(), "endGameWindow");
	}
	@Override public void displayMainMenu() {
		menu.updateMenuButtons();
		card.show(frmWMM.getContentPane(), "menu");
	}
}