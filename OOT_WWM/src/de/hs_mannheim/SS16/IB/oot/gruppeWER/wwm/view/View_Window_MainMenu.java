package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import javax.swing.JPanel;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;

public class View_Window_MainMenu extends View_JPanel_withBackgroundImage {
	
	//MARK: - Assets
	private JButton btnContinue;
	private JButton btnNewGame;
	private JButton btnSave;
	private JButton btnLoad;
	private JButton btnHighScore;
	private JButton btnExit;
	private WWMModel model;

	//MARK: - Constructor
	public View_Window_MainMenu(WWMModel model, WWMController controller) {
		//this.setBackground(Color.BLACK);		
		this.model = model;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {1};
		gridBagLayout.rowHeights = new int[] {0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1};
		setLayout(gridBagLayout);
		
		JPanel panelMainImage = new View_JPanel_withBackgroundImage(1);
		GridBagConstraints gbc_panelMainImage = new GridBagConstraints();
		gbc_panelMainImage.fill = GridBagConstraints.BOTH;
		gbc_panelMainImage.insets = new Insets(50, 50, 20, 50);
		gbc_panelMainImage.gridx = 0;
		gbc_panelMainImage.gridy = 0;
		add(panelMainImage, gbc_panelMainImage);
		
		JPanel panelMainMenuButtons = new JPanel();
		GridBagConstraints gbc_panelMainMenuButtons = new GridBagConstraints();
		gbc_panelMainMenuButtons.anchor = GridBagConstraints.BASELINE;
		gbc_panelMainMenuButtons.fill = GridBagConstraints.BOTH;
		gbc_panelMainMenuButtons.gridx = 0;
		gbc_panelMainMenuButtons.gridy = 2;
		gbc_panelMainMenuButtons.insets = new Insets(0, 150, 50, 150);
		add(panelMainMenuButtons, gbc_panelMainMenuButtons);
		panelMainMenuButtons.setLayout(new GridLayout(6, 1, 0, 0));
		
		btnContinue = new View_JButton_withBackgroundImage("Weiterspielen");
		btnContinue.addActionListener(controller);
		panelMainMenuButtons.add(btnContinue);
		
		btnNewGame = new View_JButton_withBackgroundImage("Neues Spiel");
		btnNewGame.addActionListener(controller);
		panelMainMenuButtons.add(btnNewGame);
		
		btnSave = new View_JButton_withBackgroundImage("Speichern");
		btnSave.addActionListener(controller);
		panelMainMenuButtons.add(btnSave);
		
		
		btnLoad = new View_JButton_withBackgroundImage("Laden");
		btnLoad.addActionListener(controller);
		panelMainMenuButtons.add(btnLoad);
		
		btnHighScore = new View_JButton_withBackgroundImage("Bestenliste");
		btnHighScore.addActionListener(controller);
		panelMainMenuButtons.add(btnHighScore);
		
		btnExit = new View_JButton_withBackgroundImage("Beenden");
		btnExit.addActionListener(controller);
		panelMainMenuButtons.add(btnExit);
		updateMenuButtons();
	}
	
	//MARK: - Methods
	/**
	 * Disables the save button and the continue button until the user has started a game 
	 * and after a game has ended
	 */
	public void updateMenuButtons() {
		if(!model.getGameStartedStatus() || model.getGameFinishedStatus()) {
			btnContinue.setEnabled(false);
			btnSave.setEnabled(false);
		}
		else {
			btnContinue.setEnabled(true);
			btnSave.setEnabled(true);
		}
	}
}