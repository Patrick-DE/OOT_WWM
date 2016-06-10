package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import javax.swing.JPanel;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.Model_Question;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import java.awt.GridBagLayout;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class View_QuestionWindow extends JPanel {
	
	//MARK: - Assets
	private static final long serialVersionUID = -8111826866911799613L;
	private JButton btnAnswer1;
	private JButton btnAnswer2;
	private JButton btnAnswer3;
	private JButton btnAnswer4;
	private JButton btnTelefon;
	private JButton buttonFiftyFifty;
	private JButton btnPublikum;
	private JButton btnAussteigen;
	private boolean fiftyFiftyUsed = false;
	private View_QuestionPanel questionTextPanel;
	private View_GameInfoPanel paneGameInfo;
	private WWMModel model;

	//MARK: - Assets
	public View_QuestionWindow(WWMController controller, WWMModel model) {
		this.model = model;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] {1, 30, 30, 30, 30};
		gridBagLayout.columnWidths = new int[] {1, 1};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0};
		setLayout(gridBagLayout);
		
		paneGameInfo = new View_GameInfoPanel(model);
		GridBagConstraints gbc_paneGameInfo = new GridBagConstraints();
		gbc_paneGameInfo.gridwidth = 0;
		gbc_paneGameInfo.weightx = 1.0;
		gbc_paneGameInfo.fill = GridBagConstraints.BOTH;
		gbc_paneGameInfo.weighty = 0.02;
		gbc_paneGameInfo.insets = new Insets(0, 0, 5, 0);
		gbc_paneGameInfo.gridx = 0;
		gbc_paneGameInfo.gridy = 0;
		add(paneGameInfo, gbc_paneGameInfo);
		
		
		questionTextPanel = new View_QuestionPanel(model.getAnswerTime());
		questionTextPanel.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_labelQuestion = new GridBagConstraints();
		gbc_labelQuestion.fill = GridBagConstraints.BOTH;
		gbc_labelQuestion.gridwidth = 0;
		gbc_labelQuestion.weighty = 0.8;
		gbc_labelQuestion.weightx = 1.0;
		gbc_labelQuestion.insets = new Insets(0, 0, 5, 0);
		gbc_labelQuestion.gridx = 0;
		gbc_labelQuestion.gridy = 1;
		add(questionTextPanel, gbc_labelQuestion);
		
		btnAnswer1 = new View_JButton();
		btnAnswer1.setActionCommand("Antwort1");
		btnAnswer1.addActionListener(controller);
		GridBagConstraints gbc_lblAnswer1 = new GridBagConstraints();
		gbc_lblAnswer1.fill = GridBagConstraints.BOTH;
		gbc_lblAnswer1.weightx = 0.5;
		gbc_lblAnswer1.weighty = 0.3;
		gbc_lblAnswer1.insets = new Insets(0, 0, 0, 0);
		gbc_lblAnswer1.gridx = 0;
		gbc_lblAnswer1.gridy = 2;
		add(btnAnswer1, gbc_lblAnswer1);
		
		btnAnswer2 = new View_JButton();
		btnAnswer2.setActionCommand("Antwort2");
		btnAnswer2.addActionListener(controller);
		GridBagConstraints gbc_lblAnswer2 = new GridBagConstraints();
		gbc_lblAnswer2.fill = GridBagConstraints.BOTH;
		gbc_lblAnswer2.weightx = 0.5;
		gbc_lblAnswer2.weighty = 0.3;
		gbc_lblAnswer2.insets = new Insets(0, 0, 0, 0);
		gbc_lblAnswer2.gridx = 1;
		gbc_lblAnswer2.gridy = 2;
		add(btnAnswer2, gbc_lblAnswer2);
		
		btnAnswer3 = new View_JButton();
		btnAnswer3.setActionCommand("Antwort3");
		btnAnswer3.addActionListener(controller);
		GridBagConstraints gbc_lblAnswer3 = new GridBagConstraints();
		gbc_lblAnswer3.fill = GridBagConstraints.BOTH;
		gbc_lblAnswer3.weightx = 0.5;
		gbc_lblAnswer3.weighty = 0.3;
		gbc_lblAnswer3.insets = new Insets(0, 0, 0, 0);
		gbc_lblAnswer3.gridx = 0;
		gbc_lblAnswer3.gridy = 3;
		add(btnAnswer3, gbc_lblAnswer3);
		
		btnAnswer4 = new View_JButton();
		btnAnswer4.setActionCommand("Antwort4");
		btnAnswer4.addActionListener(controller);
		GridBagConstraints gbc_lblAnswer4 = new GridBagConstraints();
		gbc_lblAnswer4.fill = GridBagConstraints.BOTH;
		gbc_lblAnswer4.weighty = 0.3;
		gbc_lblAnswer4.weightx = 0.5;
		gbc_lblAnswer4.insets = new Insets(0, 0, 0, 0);
		gbc_lblAnswer4.gridx = 1;
		gbc_lblAnswer4.gridy = 3;
		add(btnAnswer4, gbc_lblAnswer4);
		
		JPanel buttonSpace = new JPanel();
		GridBagConstraints gbc_buttonSpace = new GridBagConstraints();
		gbc_buttonSpace.gridwidth = 0;
		gbc_buttonSpace.weighty = 0.025;
		gbc_buttonSpace.weightx = 1.0;
		gbc_buttonSpace.gridx = 0;
		gbc_buttonSpace.gridy = 4;
		add(buttonSpace, gbc_buttonSpace);
		
		btnTelefon = new View_JButton("Telefon");
		btnTelefon.addActionListener(controller);
		buttonSpace.add(btnTelefon);
		
		buttonFiftyFifty = new View_JButton("50/50");
		buttonFiftyFifty.addActionListener(controller);
		buttonSpace.add(buttonFiftyFifty);
		
		btnPublikum = new View_JButton("Publikum");
		btnPublikum.addActionListener(controller);
		buttonSpace.add(btnPublikum);
		
		btnAussteigen = new View_JButton("Aussteigen");
		btnAussteigen.addActionListener(controller);
		buttonSpace.add(btnAussteigen);
	}
	
	//MARK: - Methods
	public void setQuestion (Model_Question question) {
		if (model.telephone.getStatus())
			btnTelefon.setEnabled(false);
		if (model.fiftyFifty.getStatus())
			buttonFiftyFifty.setEnabled(false);
		if (model.audience.getStatus())
			btnPublikum.setEnabled(false);
		if (fiftyFiftyUsed) {
			fiftyFiftyUsed = false;
			btnAnswer1.setForeground(Color.BLACK);
			btnAnswer2.setForeground(Color.BLACK);
			btnAnswer3.setForeground(Color.BLACK);
			btnAnswer4.setForeground(Color.BLACK);
		}
		paneGameInfo.animationRestart();
		questionTextPanel.setText("<HTML><BODY>" + question.getQuestionText() + "</BODY></HTML>");
		questionTextPanel.animationRestart();
		btnAnswer1.setText("<HTML><BODY>" + question.getAnswerAtIndex(1) + "</BODY></HTML>");
		btnAnswer2.setText("<HTML><BODY>" + question.getAnswerAtIndex(2) + "</BODY></HTML>");
		btnAnswer3.setText("<HTML><BODY>" + question.getAnswerAtIndex(3) + "</BODY></HTML>");
		btnAnswer4.setText("<HTML><BODY>" + question.getAnswerAtIndex(4) + "</BODY></HTML>");
	}
	public void useFiftyFiftyJoker (int[] jokerResults) {
		buttonFiftyFifty.setEnabled(false);
		fiftyFiftyUsed = true;
		for (int i = 0; i < jokerResults.length; i++) {
			if (jokerResults[i] == 1)
				btnAnswer1.setForeground(Color.BLUE);
			else if (jokerResults[i] == 2)
				btnAnswer2.setForeground(Color.BLUE);
			else if (jokerResults[i] == 3)
				btnAnswer3.setForeground(Color.BLUE);
			else if (jokerResults[i] == 4)
				btnAnswer4.setForeground(Color.BLUE);
		}
	}
	public void setAudienceJokerUsed () {
		btnPublikum.setEnabled(false);
	}
	public void setTelephoneJokerUsed() {
		btnTelefon.setEnabled(false);
	}
}