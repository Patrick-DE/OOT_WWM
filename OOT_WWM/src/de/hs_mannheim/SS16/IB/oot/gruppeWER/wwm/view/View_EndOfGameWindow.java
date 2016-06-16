package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import javax.swing.JPanel;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

public class View_EndOfGameWindow extends View_JPanel_withBackgroundImage {

	//MARK: - Assets
	private JTextField textField;
	private JLabel lblEuro;
	private JLabel lblTime;

	//MARK: - Constructor
	public View_EndOfGameWindow(WWMModel model) {
		//this.setBackground(Color.BLACK);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JLabel lblCong = new JLabel("Herzlichen Glückwunsch!");
		lblCong.setOpaque(false);
		lblCong.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblHerzlichenGlckwunsch = new GridBagConstraints();
		gbc_lblHerzlichenGlckwunsch.weighty = 0.3;
		gbc_lblHerzlichenGlckwunsch.gridwidth = 0;
		gbc_lblHerzlichenGlckwunsch.insets = new Insets(0, 0, 5, 0);
		gbc_lblHerzlichenGlckwunsch.gridx = 0;
		gbc_lblHerzlichenGlckwunsch.gridy = 0;
		add(lblCong, gbc_lblHerzlichenGlckwunsch);

		lblEuro = new JLabel("Sie haben " + model.generatePrize() + "€ gewonnen!");
		lblEuro.setOpaque(false);
		lblEuro.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblEuro = new GridBagConstraints();
		gbc_lblEuro.weighty = 0.3;
		gbc_lblEuro.gridwidth = 0;
		gbc_lblEuro.insets = new Insets(0, 0, 5, 0);
		gbc_lblEuro.gridx = 0;
		gbc_lblEuro.gridy = 1;
		add(lblEuro, gbc_lblEuro);

		JLabel lblName = new JLabel("Name:");
		lblName.setOpaque(false);
		lblName.setForeground(Color.WHITE);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.weighty = 0.2;
		gbc_lblName.weightx = 0.2;
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 0, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 2;
		add(lblName, gbc_lblName);

		textField = new JTextField();
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

		lblTime = new JLabel(model.getGameTime() + "s");
		lblTime.setOpaque(false);
		lblTime.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblTime = new GridBagConstraints();
		gbc_lblTime.gridwidth = 0;
		gbc_lblTime.weighty = 0.3;
		gbc_lblTime.weightx = 0.2;
		gbc_lblTime.gridx = 2;
		gbc_lblTime.gridy = 2;
		add(lblTime, gbc_lblTime);
	}
}