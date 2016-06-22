package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

public class View_Window_EndOfGame extends View_JPanel_withBackgroundImage {

	//MARK: - Assets
	private static final long serialVersionUID = -3259538374945872250L;

	//MARK: - Constructor
	public View_Window_EndOfGame(WWMModel model) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[] {0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblCong = new View_JLabel_withBackgroundImage(1, "Herzlichen Glückwunsch!");
		lblCong.setHorizontalAlignment(SwingConstants.CENTER);
		lblCong.setFont(lblCong.getFont().deriveFont(24.0f));
		GridBagConstraints gbc_lblCong = new GridBagConstraints();
		gbc_lblCong.fill = GridBagConstraints.BOTH;
		gbc_lblCong.weighty = 0.3;
		gbc_lblCong.gridwidth = 0;
		gbc_lblCong.insets = new Insets(20, 20, 80, 20);
		gbc_lblCong.gridx = 0;
		gbc_lblCong.gridy = 0;
		add(lblCong, gbc_lblCong);

		JLabel lblEuro;
		if(model.getGameEndFalseAnswer() || model.getQuestionIndex()==15 && model.getGameFinishedStatus())
			lblEuro = new View_JLabel_withBackgroundImage(1, "Sie haben " + model.generatePrizeAtSecurityTier() + "€ gewonnen!");			
		else lblEuro = new View_JLabel_withBackgroundImage(1, "Sie haben " + model.getPrizesAtPos(model.getQuestionIndex()) + "€ gewonnen!");
		lblEuro.setHorizontalAlignment(SwingConstants.CENTER);
		lblEuro.setFont(lblEuro.getFont().deriveFont(24.0f));
		GridBagConstraints gbc_lblEuro = new GridBagConstraints();
		gbc_lblEuro.fill = GridBagConstraints.BOTH;
		gbc_lblEuro.weighty = 0.3;
		gbc_lblEuro.gridwidth = 0;
		gbc_lblEuro.insets = new Insets(0, 20, 80, 20);
		gbc_lblEuro.gridx = 0;
		gbc_lblEuro.gridy = 1;
		add(lblEuro, gbc_lblEuro);

		//Panel for the Highscore Entry
		JPanel highscoreEintrag = new View_JPanel_withBackgroundImage(2, new GridLayout(2, 1));
		highscoreEintrag.setOpaque(false);
		GridBagConstraints gbc_highscoreEintrag = new GridBagConstraints();
		gbc_highscoreEintrag.fill = GridBagConstraints.BOTH;
		gbc_highscoreEintrag.weighty = 0.3;
		gbc_highscoreEintrag.gridwidth = 0;
		gbc_highscoreEintrag.insets = new Insets(0, 20, 20, 20);
		gbc_highscoreEintrag.gridx = 0;
		gbc_highscoreEintrag.gridy = 2;
		add(highscoreEintrag, gbc_highscoreEintrag);

		//Label telling the user to enter 
		JLabel lblEintragen = new JLabel("Tragen Sie sich in die Highscore Liste ein:");
		lblEintragen.setHorizontalAlignment(SwingConstants.CENTER);
		lblEintragen.setForeground(Color.WHITE);
		lblEintragen.setFont(lblEuro.getFont().deriveFont(22.0f));
		highscoreEintrag.add(lblEintragen);

		//Panel holding the second line items for the highscore entry panel
		JPanel secondLineItems = new JPanel(new GridLayout(1, 3));
		secondLineItems.setOpaque(false);
		highscoreEintrag.add(secondLineItems);

		//Second Line Item #1 -> Labal explaining the textfield
		JLabel lblName = new JLabel("Name:");
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setFont(lblName.getFont().deriveFont(22.0f));
		secondLineItems.add(lblName);

		//Second Line Item #2 -> textfield-panel
		JPanel textFieldPanel = new JPanel(new GridLayout(3, 1));
		textFieldPanel.setOpaque(false);
		secondLineItems.add(textFieldPanel);

		//Blank Item 1
		JLabel lblBlank1 = new JLabel("");
		textFieldPanel.add(lblBlank1);

		//TextField
		JTextField textField = new JTextField();
		textField.setColumns(10);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() > 1)
					model.highScoreAddEntry(textField.getText(), (int) model.getGameTime());
			}
		});
		textFieldPanel.add(textField);

		//Blank Item 1
		JLabel lblBlank2 = new JLabel("");
		textFieldPanel.add(lblBlank2);

		//Second Line Item #3 -> the user's play-time
		JLabel lblTime = new JLabel(model.getGameTime()/60 + "min " + + model.getGameTime()%60 + "s");
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(lblTime.getFont().deriveFont(22.0f));
		secondLineItems.add(lblTime);
	}
}