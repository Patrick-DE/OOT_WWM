package werWirdMillionär.view;

import javax.swing.JPanel;

import werWirdMillionär.controller.WWMController;
import werWirdMillionär.model.Question;
import werWirdMillionär.model.WWMModel;

import java.awt.GridBagLayout;
import javax.swing.JProgressBar;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class WWMQuestionWindow extends JPanel {
	/**
	 * 
	 */
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
	private WWMQuestionPanel questionTextPanel;
	private WWMGameInfoPanel paneGameInfo;
	private WWMModel model;

	/**
	 * Create the panel.
	 */
	public WWMQuestionWindow(WWMController controller, WWMModel model) {
		this.model = model;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.rowHeights = new int[] {1, 30, 30, 30, 30};
		gridBagLayout.columnWidths = new int[] {1, 1};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0};
		setLayout(gridBagLayout);
		
		paneGameInfo = new WWMGameInfoPanel(model);
		GridBagConstraints gbc_paneGameInfo = new GridBagConstraints();
		gbc_paneGameInfo.gridwidth = 0;
		gbc_paneGameInfo.weightx = 1.0;
		gbc_paneGameInfo.fill = GridBagConstraints.BOTH;
		gbc_paneGameInfo.weighty = 0.02;
		gbc_paneGameInfo.insets = new Insets(0, 0, 5, 0);
		gbc_paneGameInfo.gridx = 0;
		gbc_paneGameInfo.gridy = 0;
		add(paneGameInfo, gbc_paneGameInfo);
		
		
		questionTextPanel = new WWMQuestionPanel(model.getAnswerTime());
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
		
		btnAnswer1 = new JButton();
		btnAnswer1.setActionCommand("Antwort1");
		btnAnswer1.setBorderPainted(false);
		btnAnswer1.addActionListener(controller);
		btnAnswer1.setOpaque(false);
		btnAnswer1.setContentAreaFilled(false);
		GridBagConstraints gbc_lblAnswer1 = new GridBagConstraints();
		gbc_lblAnswer1.fill = GridBagConstraints.BOTH;
		gbc_lblAnswer1.weightx = 0.5;
		gbc_lblAnswer1.weighty = 0.3;
		gbc_lblAnswer1.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer1.gridx = 0;
		gbc_lblAnswer1.gridy = 2;
		add(btnAnswer1, gbc_lblAnswer1);
		
		btnAnswer2 = new JButton();
		btnAnswer2.setActionCommand("Antwort2");
		btnAnswer2.setBorderPainted(false);
		btnAnswer2.addActionListener(controller);
		btnAnswer2.setContentAreaFilled(false);
		GridBagConstraints gbc_lblAnswer2 = new GridBagConstraints();
		gbc_lblAnswer2.fill = GridBagConstraints.BOTH;
		gbc_lblAnswer2.weightx = 0.5;
		gbc_lblAnswer2.weighty = 0.1;
		gbc_lblAnswer2.insets = new Insets(0, 0, 5, 0);
		gbc_lblAnswer2.gridx = 1;
		gbc_lblAnswer2.gridy = 2;
		add(btnAnswer2, gbc_lblAnswer2);
		
		btnAnswer3 = new JButton();
		btnAnswer3.setActionCommand("Antwort3");
		btnAnswer3.setBorderPainted(false);
		btnAnswer3.addActionListener(controller);
		btnAnswer3.setContentAreaFilled(false);
		GridBagConstraints gbc_lblAnswer3 = new GridBagConstraints();
		gbc_lblAnswer3.fill = GridBagConstraints.BOTH;
		gbc_lblAnswer3.weightx = 0.5;
		gbc_lblAnswer3.weighty = 0.3;
		gbc_lblAnswer3.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnswer3.gridx = 0;
		gbc_lblAnswer3.gridy = 3;
		add(btnAnswer3, gbc_lblAnswer3);
		
		btnAnswer4 = new JButton();
		btnAnswer4.setActionCommand("Antwort4");
		btnAnswer4.setBorderPainted(false);
		btnAnswer4.addActionListener(controller);
		btnAnswer4.setContentAreaFilled(false);
		GridBagConstraints gbc_lblAnswer4 = new GridBagConstraints();
		gbc_lblAnswer4.fill = GridBagConstraints.BOTH;
		gbc_lblAnswer4.weighty = 0.1;
		gbc_lblAnswer4.weightx = 0.5;
		gbc_lblAnswer4.insets = new Insets(0, 0, 5, 0);
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
		
		btnTelefon = new JButton("Telefon");
//		System.out.println(model);
		if (model.telephone.getStatus())
			btnTelefon.setEnabled(false);
		btnTelefon.setBorderPainted(false);
		btnTelefon.addActionListener(controller);
		btnTelefon.setContentAreaFilled(false);
		buttonSpace.add(btnTelefon);
		
		buttonFiftyFifty = new JButton("50/50");
		if (model.fiftyFifty.getStatus()) {
			buttonFiftyFifty.setEnabled(false);
		}
		buttonFiftyFifty.setBorderPainted(false);
		buttonFiftyFifty.addActionListener(controller);
		buttonFiftyFifty.setContentAreaFilled(false);
		buttonSpace.add(buttonFiftyFifty);
		
		btnPublikum = new JButton("Publikum");
		if (model.audience.getStatus())
			btnPublikum.setEnabled(false);
		btnPublikum.setBorderPainted(false);
		btnPublikum.addActionListener(controller);
		btnPublikum.setContentAreaFilled(false);
		buttonSpace.add(btnPublikum);
		
		btnAussteigen = new JButton("Aussteigen");
		btnAussteigen.addActionListener(controller);
		btnAussteigen.setContentAreaFilled(false);
		btnAussteigen.setBorderPainted(false);
		buttonSpace.add(btnAussteigen);
	}
	
	public void setQuestion (Question question) {
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
