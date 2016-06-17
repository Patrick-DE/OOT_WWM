package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import javax.swing.JPanel;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.Model_Question;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import java.awt.GridBagLayout;
import java.awt.GridLayout;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class View_Window_Question extends View_JPanel_withBackgroundImage {

	//MARK: - Assets
	private static final long serialVersionUID = -8111826866911799613L;

	private View_JButton_withBackgroundImage btnAnswer1;
	private View_JButton_withBackgroundImage btnAnswer2;
	private View_JButton_withBackgroundImage btnAnswer3;
	private View_JButton_withBackgroundImage btnAnswer4;
	private JButton btnTelephone;
	private JButton btnFiftyFifty;
	private JButton btnAudience;
	private JButton btnDropOut;

	private View_JLabel_withBackgroundImage questionTextLabel;
	private View_JPanel_GameStatus gameStatusPanel;
	private JPanel answerPanel;

	private WWMModel model;
	private WWMController controller;

	private boolean fiftyFiftyUsed = false;
	private boolean answerLogged = false;

	//MARK: - Constructor
	public View_Window_Question(WWMController controller, WWMModel model) {
		//this.setBackground(Color.BLACK);
		this.model = model;
		this.controller = controller;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] {0, 20, 20, 30};
		gridBagLayout.columnWidths = new int[] {1, 1};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0};
		setLayout(gridBagLayout);

		gameStatusPanel = new View_JPanel_GameStatus(this.model);
		GridBagConstraints gbc_paneGameInfo = new GridBagConstraints();
		gbc_paneGameInfo.gridwidth = 1;
		gbc_paneGameInfo.weightx = 1.0;
		gbc_paneGameInfo.fill = GridBagConstraints.BOTH;
		gbc_paneGameInfo.weighty = 0;
		gbc_paneGameInfo.insets = new Insets(0, 0, 0, 0);
		gbc_paneGameInfo.gridx = 0;
		gbc_paneGameInfo.gridy = 0;
		add(gameStatusPanel, gbc_paneGameInfo);

		questionTextLabel = new View_JLabel_withBackgroundImage(this.model.getAnswerTime(),1);
		questionTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelQuestion = new GridBagConstraints();
		gbc_labelQuestion.fill = GridBagConstraints.BOTH;
		gbc_labelQuestion.gridwidth = 0;
		gbc_labelQuestion.weighty = 1;
		gbc_labelQuestion.weightx = 1.0;
		gbc_labelQuestion.insets = new Insets(0, 0, 0, 0);
		gbc_labelQuestion.gridx = 0;
		gbc_labelQuestion.gridy = 1;
		add(questionTextLabel, gbc_labelQuestion);

		answerPanel = new JPanel(new GridLayout(2, 2));
		answerPanel.setOpaque(false);
		btnAnswer1 = new View_JButton_withBackgroundImage();
		btnAnswer1.setActionCommand("Antwort1");
		btnAnswer1.addActionListener(this.controller);
		answerPanel.add(btnAnswer1);

		btnAnswer2 = new View_JButton_withBackgroundImage();
		btnAnswer2.setActionCommand("Antwort2");
		btnAnswer2.addActionListener(this.controller);
		answerPanel.add(btnAnswer2);

		btnAnswer3 = new View_JButton_withBackgroundImage();
		btnAnswer3.setActionCommand("Antwort3");
		btnAnswer3.addActionListener(this.controller);
		answerPanel.add(btnAnswer3);

		btnAnswer4 = new View_JButton_withBackgroundImage();
		btnAnswer4.setActionCommand("Antwort4");
		btnAnswer4.addActionListener(this.controller);
		answerPanel.add(btnAnswer4);

		GridBagConstraints gbc_answerPanel = new GridBagConstraints();
		gbc_answerPanel.fill = GridBagConstraints.BOTH;
		gbc_answerPanel.gridwidth = 0;
		gbc_answerPanel.gridheight = 1;
		gbc_answerPanel.weighty = 0.6;
		gbc_answerPanel.weightx = 1.0;
		gbc_answerPanel.insets = new Insets(0, 0, 0, 0);
		gbc_answerPanel.gridx = 0;
		gbc_answerPanel.gridy = 2;
		add(answerPanel, gbc_answerPanel);

		JPanel buttonSpace = new JPanel();
		buttonSpace.setOpaque(false);
		GridBagConstraints gbc_buttonSpace = new GridBagConstraints();
		gbc_buttonSpace.fill = GridBagConstraints.HORIZONTAL;
		gbc_buttonSpace.gridwidth = 2;
		gbc_buttonSpace.weighty = 0.2;
		gbc_buttonSpace.weightx = 1.0;
		gbc_buttonSpace.gridx = 0;
		gbc_buttonSpace.gridy = 3;
		add(buttonSpace, gbc_buttonSpace);

		//btnTelephone = new View_JButton_withBackgroundImage(new ImageIcon("data/Joker_Telefon.png"));
		btnTelephone = new View_JButton_withBackgroundImage(4);
		btnTelephone.addActionListener(this.controller);
		btnTelephone.setActionCommand("Telefon");
		buttonSpace.add(btnTelephone);

		//btnFiftyFifty = new View_JButton_withBackgroundImage(new ImageIcon("data/Joker_50_50.png"));
		btnFiftyFifty = new View_JButton_withBackgroundImage(5);
		btnFiftyFifty.addActionListener(this.controller);
		btnFiftyFifty.setActionCommand("50/50");
		buttonSpace.add(btnFiftyFifty);

		//btnAudience = new View_JButton_withBackgroundImage(new ImageIcon("data/Joker_Publikum.png"));
		btnAudience = new View_JButton_withBackgroundImage(6);
		btnAudience.addActionListener(this.controller);
		btnAudience.setActionCommand("Publikum");
		buttonSpace.add(btnAudience);

		//btnDropOut = new View_JButton_withBackgroundImage("Aussteigen");
		btnDropOut = new View_JButton_withBackgroundImage(7);
		btnDropOut.addActionListener(this.controller);
		btnDropOut.setActionCommand("Aussteigen");
		buttonSpace.add(btnDropOut);
	}

	//MARK: - Methods
	public void setQuestion(Model_Question question) {
		//re-enable the buttons
		this.enableAllButtons();
		
		gameStatusPanel.repaint();
		gameStatusPanel.animationRestart(true);
		if (model.getTelephoneStatus()) {
			btnTelephone.setEnabled(false);
		}
		if (model.getFiftyFiftyStatus()) {
			btnFiftyFifty.setEnabled(false);
		}
		if (model.getAudienceStatus()) {
			btnAudience.setEnabled(false);
		}
		if (fiftyFiftyUsed) {
			fiftyFiftyUsed = false;

			btnAnswer1.setEnabled(true);
			btnAnswer2.setEnabled(true);
			btnAnswer3.setEnabled(true);
			btnAnswer4.setEnabled(true);
		}
		
		//reset to default button images
		if(answerLogged) {
			answerLogged = false;
			btnAnswer1.changeImageIndex(0);
			btnAnswer2.changeImageIndex(0);
			btnAnswer3.changeImageIndex(0);
			btnAnswer4.changeImageIndex(0);
		}
		
		questionTextLabel.setText("<HTML><BODY><div style='text-align: center;'>" + question.getQuestionText() + "</BODY></HTML>");
		//questionTextLabel.animationRestart();
		btnAnswer1.setText("<HTML><BODY>" + question.getAnswerAtIndex(1) + "</BODY></HTML>");
		btnAnswer2.setText("<HTML><BODY>" + question.getAnswerAtIndex(2) + "</BODY></HTML>");
		btnAnswer3.setText("<HTML><BODY>" + question.getAnswerAtIndex(3) + "</BODY></HTML>");
		btnAnswer4.setText("<HTML><BODY>" + question.getAnswerAtIndex(4) + "</BODY></HTML>");
	}
	public void useFiftyFiftyJoker(int[] jokerResults) {
		btnFiftyFifty.setEnabled(false);
		fiftyFiftyUsed = true;
		for (int i = 0; i < jokerResults.length; i++) {
			if (jokerResults[i] == 1)
				btnAnswer1.setEnabled(false);
			else if (jokerResults[i] == 2)
				btnAnswer2.setEnabled(false);
			else if (jokerResults[i] == 3)
				btnAnswer3.setEnabled(false);
			else if (jokerResults[i] == 4)
				btnAnswer4.setEnabled(false);
		}
	}
	public void setAudienceJokerUsed () {
		btnAudience.setEnabled(false);
	}
	public void setTelephoneJokerUsed() {
		btnTelephone.setEnabled(false);
	}
	public void updateJokerButtons () {
		if (!model.getAudienceStatus()){
			btnAudience.setEnabled(true);
		}
		if (!model.getFiftyFiftyStatus()) {
			btnFiftyFifty.setEnabled(true);
		}
		if (!model.getTelephoneStatus()) {
			btnTelephone.setEnabled(true);
		}
	}
	public void changeAnswerButtonBackgroundImage(int answerIndex, int imageIndex) {
		answerLogged = true;
		switch(answerIndex) {
		case 1:
			btnAnswer1.changeImageIndex(imageIndex);
			btnAnswer1.repaint();
			break;
		case 2:
			btnAnswer2.changeImageIndex(imageIndex);
			btnAnswer2.repaint();
			break;
		case 3:
			btnAnswer3.changeImageIndex(imageIndex);
			btnAnswer3.repaint();
			break;
		case 4:
			btnAnswer4.changeImageIndex(imageIndex);
			btnAnswer4.repaint();
			break;
		}
	}
	public void disableAllButtons() {
		gameStatusPanel.animationRestart(false);
		btnAnswer1.removeActionListener(this.controller);
		btnAnswer2.removeActionListener(this.controller);
		btnAnswer3.removeActionListener(this.controller);
		btnAnswer4.removeActionListener(this.controller);
		btnTelephone.removeActionListener(this.controller);
		btnFiftyFifty.removeActionListener(this.controller);
		btnAudience.removeActionListener(this.controller);
	}
	public void enableAllButtons() {
		btnAnswer1.addActionListener(this.controller);
		btnAnswer2.addActionListener(this.controller);
		btnAnswer3.addActionListener(this.controller);
		btnAnswer4.addActionListener(this.controller);
		btnTelephone.addActionListener(this.controller);
		btnFiftyFifty.addActionListener(this.controller);
		btnAudience.addActionListener(this.controller);
	}
}