package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

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
		super(4);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblCong = new JLabel("Herzlichen Glückwunsch!");
		lblCong.setForeground(Color.WHITE);
		lblCong.setFont(lblCong.getFont().deriveFont(24.0f));
		GridBagConstraints gbc_lblCong = new GridBagConstraints();
		gbc_lblCong.weighty = 0.3;
		gbc_lblCong.gridwidth = 0;
		gbc_lblCong.insets = new Insets(0, 0, 5, 0);
		gbc_lblCong.gridx = 0;
		gbc_lblCong.gridy = 0;
		add(lblCong, gbc_lblCong);

		JLabel lblEuro = new JLabel("Sie haben " + model.generatePrizeAtSecurityTier() + "€ gewonnen!");
		lblEuro.setForeground(Color.WHITE);
		lblEuro.setFont(lblEuro.getFont().deriveFont(24.0f));
		GridBagConstraints gbc_lblEuro = new GridBagConstraints();
		gbc_lblEuro.weighty = 0.3;
		gbc_lblEuro.gridwidth = 0;
		gbc_lblEuro.insets = new Insets(0, 0, 5, 0);
		gbc_lblEuro.gridx = 0;
		gbc_lblEuro.gridy = 1;
		add(lblEuro, gbc_lblEuro);

		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(lblName.getFont().deriveFont(22.0f));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.weighty = 0.2;
		gbc_lblName.weightx = 0.2;
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 0, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		add(lblName, gbc_lblName);

		JTextField textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() > 1)
					model.highScoreAddEntry(textField.getText(), (int) model.getGameTime());
			}
		});
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.weighty = 0.3;
		gbc_textField.weightx = 0.6;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 2;
		add(textField, gbc_textField);
		textField.setColumns(10);

		JLabel lblTime = new JLabel(model.getGameTime() + "s");
		lblTime.setForeground(Color.WHITE);
		lblTime.setFont(lblTime.getFont().deriveFont(22.0f));
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.gridwidth = 0;
		gbc_lblTime.weighty = 0.3;
		gbc_lblTime.weightx = 0.2;
		gbc_lblTime.gridx = 2;
		gbc_lblTime.gridy = 2;
		add(lblTime, gbc_lblTime);
	}
}