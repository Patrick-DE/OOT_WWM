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

public class View_QuestionWindow extends View_JPanel_withBackdrop {
	
	//MARK: - Assets
	private static final long serialVersionUID = -8111826866911799613L;
	
	private JButton btnAnswer1;
	private JButton btnAnswer2;
	private JButton btnAnswer3;
	private JButton btnAnswer4;
	private JButton btnTelephone;
	private JButton btnFiftyFifty;
	private JButton btnAudience;
	private JButton btnDropOut;
	private boolean fiftyFiftyUsed = false;
	private View_QuestionLabel questionTextPanel;
	private View_GameInfoPanel paneGameInfo;
	private WWMModel model;

	//MARK: - Constructor
	public View_QuestionWindow(WWMController controller, WWMModel model) {
		//this.setBackground(Color.BLACK);
		this.model = model;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] {0, 20, 20, 30};
		gridBagLayout.columnWidths = new int[] {1, 1};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0};
		setLayout(gridBagLayout);
		
		paneGameInfo = new View_GameInfoPanel(model);
		GridBagConstraints gbc_paneGameInfo = new GridBagConstraints();
		gbc_paneGameInfo.gridwidth = 1;
		gbc_paneGameInfo.weightx = 1.0;
		gbc_paneGameInfo.fill = GridBagConstraints.BOTH;
		gbc_paneGameInfo.weighty = 0;
		gbc_paneGameInfo.insets = new Insets(0, 0, 0, 0);
		gbc_paneGameInfo.gridx = 0;
		gbc_paneGameInfo.gridy = 0;
		add(paneGameInfo, gbc_paneGameInfo);
		
		questionTextPanel = new View_QuestionLabel(model.getAnswerTime(),1);
		questionTextPanel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelQuestion = new GridBagConstraints();
		gbc_labelQuestion.fill = GridBagConstraints.BOTH;
		gbc_labelQuestion.gridwidth = 0;
		gbc_labelQuestion.weighty = 1;
		gbc_labelQuestion.weightx = 1.0;
		gbc_labelQuestion.insets = new Insets(0, 0, 0, 0);
		gbc_labelQuestion.gridx = 0;
		gbc_labelQuestion.gridy = 1;
		add(questionTextPanel, gbc_labelQuestion);
		
		JPanel answerPanel = new JPanel(new GridLayout(2, 2));
		answerPanel.setOpaque(false);
		btnAnswer1 = new View_JButton();
		btnAnswer1.setActionCommand("Antwort1");
		btnAnswer1.addActionListener(controller);
		answerPanel.add(btnAnswer1);
		
		btnAnswer2 = new View_JButton();
		btnAnswer2.setActionCommand("Antwort2");
		btnAnswer2.addActionListener(controller);
		answerPanel.add(btnAnswer2);
		
		btnAnswer3 = new View_JButton();
		btnAnswer3.setActionCommand("Antwort3");
		btnAnswer3.addActionListener(controller);
		answerPanel.add(btnAnswer3);
		
		btnAnswer4 = new View_JButton();
		btnAnswer4.setActionCommand("Antwort4");
		btnAnswer4.addActionListener(controller);
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
		
		btnTelephone = new View_JButton(new ImageIcon("data/Joker_Telefon.png"));
		btnTelephone.addActionListener(controller);
		btnTelephone.setActionCommand("Telefon");
		buttonSpace.add(btnTelephone);
		
		btnFiftyFifty = new View_JButton(new ImageIcon("data/Joker_50_50.png"));
		btnFiftyFifty.addActionListener(controller);
		btnFiftyFifty.setActionCommand("50/50");
		buttonSpace.add(btnFiftyFifty);
		
		btnAudience = new View_JButton(new ImageIcon("data/Joker_Publikum.png"));
		btnAudience.addActionListener(controller);
		btnAudience.setActionCommand("Publikum");
		buttonSpace.add(btnAudience);
		
		btnDropOut = new View_JButton("Aussteigen");
		btnDropOut.addActionListener(controller);
		buttonSpace.add(btnDropOut);
	}
	
	//MARK: - Methods
	public void setQuestion (Model_Question question) {
		paneGameInfo.repaint();
		paneGameInfo.animationRestart();
		if (model.getTelephoneStatus())
			btnTelephone.setEnabled(false);
		if (model.getFiftyFiftyStatus())
			btnFiftyFifty.setEnabled(false);
		if (model.getAudienceStatus())
			btnAudience.setEnabled(false);
		if (fiftyFiftyUsed) {
			fiftyFiftyUsed = false;
			
			btnAnswer1.setEnabled(true);
			btnAnswer2.setEnabled(true);
			btnAnswer3.setEnabled(true);
			btnAnswer4.setEnabled(true);
			
//			btnAnswer1.setForeground(Color.WHITE);
//			btnAnswer2.setForeground(Color.WHITE);
//			btnAnswer3.setForeground(Color.WHITE);
//			btnAnswer4.setForeground(Color.WHITE);
		}
		questionTextPanel.setText("<HTML><BODY><div style='text-align: center;'>" + question.getQuestionText() + "</BODY></HTML>");
		questionTextPanel.animationRestart();
		btnAnswer1.setText("<HTML><BODY>" + question.getAnswerAtIndex(1) + "</BODY></HTML>");
		btnAnswer2.setText("<HTML><BODY>" + question.getAnswerAtIndex(2) + "</BODY></HTML>");
		btnAnswer3.setText("<HTML><BODY>" + question.getAnswerAtIndex(3) + "</BODY></HTML>");
		btnAnswer4.setText("<HTML><BODY>" + question.getAnswerAtIndex(4) + "</BODY></HTML>");
	}
	public void useFiftyFiftyJoker (int[] jokerResults) {
		btnFiftyFifty.setEnabled(false);
		fiftyFiftyUsed = true;
		for (int i = 0; i < jokerResults.length; i++) {
			if (jokerResults[i] == 1)
				btnAnswer1.setEnabled(false);
				//btnAnswer1.setForeground(Color.GRAY);
			else if (jokerResults[i] == 2)
				btnAnswer2.setEnabled(false);
				//btnAnswer2.setForeground(Color.GRAY);
			else if (jokerResults[i] == 3)
				btnAnswer3.setEnabled(false);
				//btnAnswer3.setForeground(Color.GRAY);
			else if (jokerResults[i] == 4)
				btnAnswer4.setEnabled(false);
				//btnAnswer4.setForeground(Color.GRAY);
		}
	}
	public void setAudienceJokerUsed () {
		btnAudience.setEnabled(false);
	}
	public void setTelephoneJokerUsed() {
		btnTelephone.setEnabled(false);
	}
	public void updateQuestionWindow () {
		if (!model.getAudienceStatus())
			btnAudience.setEnabled(true);
		if (!model.getFiftyFiftyStatus())
			btnFiftyFifty.setEnabled(true);
		if (!model.getTelephoneStatus())
			btnTelephone.setEnabled(true);
	}
}