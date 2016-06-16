package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

public class View_Window_LoadSaveGame extends View_JPanel_withBackgroundImage implements ActionListener {

	//MARK: - Assets
	private static final long serialVersionUID = 394076361918986893L;
	private BufferedImage backdrop;
	private JButton btnLoadButton1;
	private JButton btnLoadButton2;
	private JButton btnLoadButton3;
	private JButton btnLoadButton4;
	private JButton btnLoadButton5;
	private JButton btnLoadButton6;
	private JButton btnLoadButton7;
	private JButton btnLoadButton8;
	private WWMModel model;

	
	//MARK: - Constructor
	public View_Window_LoadSaveGame(WWMModel model) {
		//this.setBackground(Color.BLACK);
		this.model = model;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblChooseGameSave = new JLabel("Wähle die Ladestelle aus:");
		lblChooseGameSave.setForeground(Color.WHITE);
		lblChooseGameSave.setOpaque(false);
		GridBagConstraints gbc_lblWhleDieSpeicherstelle = new GridBagConstraints();
		gbc_lblWhleDieSpeicherstelle.weighty = 0.1;
		gbc_lblWhleDieSpeicherstelle.insets = new Insets(0, 0, 5, 0);
		gbc_lblWhleDieSpeicherstelle.gridx = 0;
		gbc_lblWhleDieSpeicherstelle.gridy = 0;
		add(lblChooseGameSave, gbc_lblWhleDieSpeicherstelle);
		
		JPanel panelSave = new JPanel();
		panelSave.setOpaque(false);
		GridBagConstraints gbc_panelSave = new GridBagConstraints();
		gbc_panelSave.weighty = 0.9;
		gbc_panelSave.fill = GridBagConstraints.BOTH;
		gbc_panelSave.gridx = 0;
		gbc_panelSave.gridy = 1;
		add(panelSave, gbc_panelSave);
		panelSave.setLayout(new GridLayout(4, 2, 0, 0));
		
		btnLoadButton1 = new View_JButton_withBackgroundImage("Ladestelle 1");
		btnLoadButton1.setActionCommand("1");
		btnLoadButton1.addActionListener(this);
		panelSave.add(btnLoadButton1);
		
		btnLoadButton2 = new View_JButton_withBackgroundImage("Ladestelle 2");
		btnLoadButton2.setActionCommand("2");
		btnLoadButton2.addActionListener(this);
		panelSave.add(btnLoadButton2);
		
		btnLoadButton3 = new View_JButton_withBackgroundImage("Ladestelle 3");
		btnLoadButton3.setActionCommand("3");
		btnLoadButton3.addActionListener(this);
		panelSave.add(btnLoadButton3);
		
		btnLoadButton4 = new View_JButton_withBackgroundImage("Ladestelle 4");
		btnLoadButton4.setActionCommand("4");
		btnLoadButton4.addActionListener(this);
		panelSave.add(btnLoadButton4);
		
		btnLoadButton5 = new View_JButton_withBackgroundImage("Ladestelle 5");
		btnLoadButton5.setActionCommand("5");
		btnLoadButton5.addActionListener(this);
		panelSave.add(btnLoadButton5);
		
		btnLoadButton6 = new View_JButton_withBackgroundImage("Ladestelle 6");
		btnLoadButton6.setActionCommand("6");
		btnLoadButton6.addActionListener(this);
		panelSave.add(btnLoadButton6);
		
		btnLoadButton7 = new View_JButton_withBackgroundImage("Ladestelle 7");
		btnLoadButton7.setActionCommand("7");
		btnLoadButton7.addActionListener(this);
		panelSave.add(btnLoadButton7);
		
		btnLoadButton8 = new View_JButton_withBackgroundImage("Ladestelle 8");
		btnLoadButton8.setActionCommand("8");
		btnLoadButton8.addActionListener(this);
		panelSave.add(btnLoadButton8);
	}
	
	//MARK: - Methods
	@Override public void actionPerformed(ActionEvent e) {
		int loadIndex = Integer.parseInt(e.getActionCommand());
		if (loadGameExists(loadIndex)) {
			model.loadQuestionsFromSaveGame(loadIndex);
		}
	}
	private boolean loadGameExists (int index) {
		if (new File ("save/game" + index + ".wwm").exists())
			return true;
		return false;
	}
	public void updateLoadWindow() {
		btnLoadButton1.setEnabled(false);
		btnLoadButton2.setEnabled(false);
		btnLoadButton3.setEnabled(false);
		btnLoadButton4.setEnabled(false);
		btnLoadButton5.setEnabled(false);
		btnLoadButton6.setEnabled(false);
		btnLoadButton7.setEnabled(false);
		btnLoadButton8.setEnabled(false);
		
		if (loadGameExists(1))
			btnLoadButton1.setEnabled(true);
		if (loadGameExists(2))
			btnLoadButton2.setEnabled(true);
		if (loadGameExists(3))
			btnLoadButton3.setEnabled(true);
		if (loadGameExists(4))
			btnLoadButton4.setEnabled(true);
		if (loadGameExists(5))
			btnLoadButton5.setEnabled(true);
		if (loadGameExists(6))
			btnLoadButton6.setEnabled(true);
		if (loadGameExists(7))
			btnLoadButton7.setEnabled(true);
		if (loadGameExists(8))
			btnLoadButton8.setEnabled(true);
	}
}