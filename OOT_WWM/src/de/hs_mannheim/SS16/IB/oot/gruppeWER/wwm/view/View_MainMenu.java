package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import javax.swing.JPanel;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class View_MainMenu extends JPanel {
	//MARK: - Constructor
	private JButton btnWeiterspielen;
	private JButton btnNeuesSpiel;
	private JButton btnSpeichern;
	private JButton btnLaden;
	private JButton btnBestenliste;
	private JButton btnBeenden;
	private WWMModel model;

	//MARK: - Constructor
	public View_MainMenu(WWMModel model, WWMController controller) {
		this.model = model;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {1};
		gridBagLayout.rowHeights = new int[] {0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1};
		setLayout(gridBagLayout);
		
		JPanel panelMainImage = new JPanel();
		GridBagConstraints gbc_panelMainImage = new GridBagConstraints();
		gbc_panelMainImage.fill = GridBagConstraints.BOTH;
		gbc_panelMainImage.insets = new Insets(0, 0, 5, 0);
		gbc_panelMainImage.gridx = 0;
		gbc_panelMainImage.gridy = 0;
		add(panelMainImage, gbc_panelMainImage);
		
		JPanel panelMainMenuButtons = new JPanel();
		GridBagConstraints gbc_panelMainMenuButtons = new GridBagConstraints();
		gbc_panelMainMenuButtons.anchor = GridBagConstraints.BASELINE;
		gbc_panelMainMenuButtons.fill = GridBagConstraints.BOTH;
		gbc_panelMainMenuButtons.gridx = 0;
		gbc_panelMainMenuButtons.gridy = 2;
		add(panelMainMenuButtons, gbc_panelMainMenuButtons);
		panelMainMenuButtons.setLayout(new GridLayout(6, 1, 0, 0));
		
		
		btnWeiterspielen = new View_JButton("Weiterspielen");
		btnWeiterspielen.addActionListener(controller);
		panelMainMenuButtons.add(btnWeiterspielen);
		
		btnNeuesSpiel = new View_JButton("Neues Spiel");
		btnNeuesSpiel.addActionListener(controller);
		panelMainMenuButtons.add(btnNeuesSpiel);
		
		btnSpeichern = new View_JButton("Speichern");
		btnSpeichern.addActionListener(controller);
		panelMainMenuButtons.add(btnSpeichern);
		
		btnLaden = new View_JButton("Laden");
		btnLaden.addActionListener(controller);
		panelMainMenuButtons.add(btnLaden);
		
		btnBestenliste = new View_JButton("Bestenliste");
		btnBestenliste.addActionListener(controller);
		panelMainMenuButtons.add(btnBestenliste);
		
		btnBeenden = new View_JButton("Beenden");
		btnBeenden.addActionListener(controller);
		panelMainMenuButtons.add(btnBeenden);
		updateMenuButtons();
	}
	
	//MARK: - Methods
	public void updateMenuButtons() {
		if (!model.gameStarted())
			btnWeiterspielen.setEnabled(false);
		else 
			btnWeiterspielen.setEnabled(true);
	}
}