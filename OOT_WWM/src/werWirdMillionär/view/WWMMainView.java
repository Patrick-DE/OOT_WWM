package werWirdMillionär.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

import werWirdMillionär.controller.WWMController;
import werWirdMillionär.model.Question;
import werWirdMillionär.model.WWMModel;
import java.awt.CardLayout;

public class WWMMainView extends WWMView {

	private JFrame frmWwm;
	private WWMMainMenu menu;
	private WWMQuestionWindow questionWindow;
	private CardLayout card;
	private WWMSaveWindow saveWindow;
	private WWMLoadWindow loadWindow;
	private WWMHighScoreWindow highScoreWindow;
	private WWMEndOfGameWindow endGameWindow;

	/**
	 * Create the application.
	 */
	public WWMMainView(WWMModel model, WWMController controller) {
		super(model, controller);
		initialize();
	}

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
		menu = new WWMMainMenu(controller);
		questionWindow = new WWMQuestionWindow(controller, model);
		questionWindow.registerKeyboardAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.first(frmWwm.getContentPane());
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		saveWindow = new WWMSaveWindow(model, "");
		saveWindow.registerKeyboardAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.first(frmWwm.getContentPane());
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		loadWindow = new WWMLoadWindow(model, "");
		loadWindow.registerKeyboardAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.first(frmWwm.getContentPane());
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		highScoreWindow = new WWMHighScoreWindow(model);
		highScoreWindow.registerKeyboardAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.first(frmWwm.getContentPane());
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		frmWwm.getContentPane().add(menu, "menu");
		frmWwm.getContentPane().add(questionWindow, "questionWindow");
		frmWwm.getContentPane().add(saveWindow, "saveWindow");
		frmWwm.getContentPane().add(loadWindow, "loadWindow");
		frmWwm.getContentPane().add(highScoreWindow, "highScoreWindow");
		frmWwm.setVisible(true);
	}


	@Override
	public void setQuestion(Question question) {
		questionWindow.setQuestion(question);
	}

	@Override
	public void displayAudienceJoker() {
		questionWindow.setAudienceJokerUsed();
		new WWMAudienceJoker(model.getAudienceJokerResults(model.getQuestionAtIndex(model.getQuestionIndex())));
	}

	@Override
	public void displayTelephoneJoker() {
		questionWindow.setTelephoneJokerUsed();
		// TODO Auto-generated method stub
		
	}

	@Override
	public void displayFiftyFiftyJoker() {
		questionWindow.useFiftyFiftyJoker(model.getFiftyFiftyJokerResults(model.getQuestionAtIndex(model.getQuestionIndex())));
	}

	@Override
	public void displaySaveDialog() {
		card.show(frmWwm.getContentPane(), "saveWindow");
	}

	@Override
	public void displayLoadDialog() {
		card.show(frmWwm.getContentPane(), "loadWindow");
	}

	@Override
	public void displayGameWindow() {
		card.show(frmWwm.getContentPane(), "questionWindow");
	}

	@Override
	public void displayHighScoreWindow() {
		card.show(frmWwm.getContentPane(), "highScoreWindow");
	}

	@Override
	public void displayExitDialog() {
		new WWMExitDialog(controller);
	}

	@Override
	public void displayDropOutDialog() {
		new WWMDropOutDialog(model);
	}

	@Override
	public void displayFalseAnswerDialog() {
		new WWMFalseAnswerDialog();
		displayEndOfGameDialog();
	}

	@Override
	public void displayEndOfGameDialog() {
		endGameWindow = new WWMEndOfGameWindow(model);
		endGameWindow.registerKeyboardAction(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				card.first(frmWwm.getContentPane());
			}
		}, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_IN_FOCUSED_WINDOW);
		frmWwm.getContentPane().add(endGameWindow, "endGameWindow");
		
		card.show(frmWwm.getContentPane(), "endGameWindow");
	}

}
