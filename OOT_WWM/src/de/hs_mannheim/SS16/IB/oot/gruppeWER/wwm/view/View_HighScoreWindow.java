package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import javax.swing.JPanel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.Model_HighScoreEntry;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import java.awt.GridLayout;

public class View_HighScoreWindow extends JPanel {
	
	//MARK: - Assets
	private JTextArea textAreaHighScore;
	private WWMModel model;
	
	//MARK: - Constructor
	public View_HighScoreWindow(WWMModel model) {
		this.model = model;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.weighty = 0.1;
		gbc_lblName.weightx = 0.5;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		add(lblName, gbc_lblName);
		
		JLabel lblZeit = new JLabel("Zeit");
		GridBagConstraints gbc_lblZeit = new GridBagConstraints();
		gbc_lblZeit.weighty = 0.1;
		gbc_lblZeit.weightx = 0.5;
		gbc_lblZeit.insets = new Insets(0, 0, 5, 0);
		gbc_lblZeit.gridx = 1;
		gbc_lblZeit.gridy = 0;
		add(lblZeit, gbc_lblZeit);
		
		JPanel panelHighScore = new JPanel();
		GridBagConstraints gbc_panelHighScore = new GridBagConstraints();
		gbc_panelHighScore.gridwidth = 0;
		gbc_panelHighScore.weightx = 1.0;
		gbc_panelHighScore.weighty = 0.9;
		gbc_panelHighScore.fill = GridBagConstraints.BOTH;
		gbc_panelHighScore.gridx = 0;
		gbc_panelHighScore.gridy = 1;
		add(panelHighScore, gbc_panelHighScore);
		panelHighScore.setLayout(new GridLayout(1, 1, 0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelHighScore.add(scrollPane);
		
		textAreaHighScore = new JTextArea();
		scrollPane.setViewportView(textAreaHighScore);
		
		ArrayList<Model_HighScoreEntry> highScoreList = model.getHighScoreEntries();
		for (Model_HighScoreEntry entry: highScoreList)
			textAreaHighScore.append(entry.getName() + " " + entry.getQuestionIndex() + " " + entry.getPlayTime() + "s\n");
	}
}