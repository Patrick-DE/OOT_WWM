package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

public class View_LoadWindow extends JPanel implements ActionListener{

	//MARK: - Assets
	private JButton btnLadestelle1;
	private JButton btnLadestelle2;
	private JButton btnLadestelle3;
	private JButton btnLadestelle4;
	private JButton btnLadestelle5;
	private JButton btnLadestelle6;
	private JButton btnLadestelle7;
	private JButton btnLadestelle8;
	private WWMModel model;
	private String path;

	
	//MARK: - Constructor
	public View_LoadWindow(WWMModel model, String path) {
		this.model = model;
		this.path = path;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblWhleDieSpeicherstelle = new JLabel("Wähle die Ladestelle aus:");
		GridBagConstraints gbc_lblWhleDieSpeicherstelle = new GridBagConstraints();
		gbc_lblWhleDieSpeicherstelle.weighty = 0.1;
		gbc_lblWhleDieSpeicherstelle.insets = new Insets(0, 0, 5, 0);
		gbc_lblWhleDieSpeicherstelle.gridx = 0;
		gbc_lblWhleDieSpeicherstelle.gridy = 0;
		add(lblWhleDieSpeicherstelle, gbc_lblWhleDieSpeicherstelle);
		
		JPanel panelSave = new JPanel();
		GridBagConstraints gbc_panelSave = new GridBagConstraints();
		gbc_panelSave.weighty = 0.9;
		gbc_panelSave.fill = GridBagConstraints.BOTH;
		gbc_panelSave.gridx = 0;
		gbc_panelSave.gridy = 1;
		add(panelSave, gbc_panelSave);
		panelSave.setLayout(new GridLayout(4, 2, 0, 0));
		
		btnLadestelle1 = new View_JButton("Ladestelle 1");
		btnLadestelle1.setActionCommand("1");
		if (loadGameExists(path, 1))
			btnLadestelle1.setForeground(Color.BLUE);
		btnLadestelle1.addActionListener(this);
		panelSave.add(btnLadestelle1);
		
		btnLadestelle2 = new View_JButton("Ladestelle 2");
		btnLadestelle2.setActionCommand("2");
		if (loadGameExists(path, 2))
			btnLadestelle2.setForeground(Color.BLUE);
		btnLadestelle2.addActionListener(this);
		panelSave.add(btnLadestelle2);
		
		btnLadestelle3 = new View_JButton("Ladestelle 3");
		btnLadestelle3.setActionCommand("3");
		if (loadGameExists(path, 3))
			btnLadestelle3.setForeground(Color.BLUE);
		btnLadestelle3.addActionListener(this);
		panelSave.add(btnLadestelle3);
		
		btnLadestelle4 = new View_JButton("Ladestelle 4");
		btnLadestelle4.setActionCommand("4");
		if (loadGameExists(path, 4))
			btnLadestelle4.setForeground(Color.BLUE);
		btnLadestelle4.addActionListener(this);
		panelSave.add(btnLadestelle4);
		
		btnLadestelle5 = new View_JButton("Ladestelle 5");
		btnLadestelle5.setActionCommand("5");
		if (loadGameExists(path, 5))
			btnLadestelle5.setForeground(Color.BLUE);
		btnLadestelle5.addActionListener(this);
		panelSave.add(btnLadestelle5);
		
		btnLadestelle6 = new View_JButton("Ladestelle 6");
		btnLadestelle6.setActionCommand("6");
		if (loadGameExists(path, 6))
			btnLadestelle6.setForeground(Color.BLUE);
		btnLadestelle6.addActionListener(this);
		panelSave.add(btnLadestelle6);
		
		btnLadestelle7 = new View_JButton("Ladestelle 7");
		btnLadestelle7.setActionCommand("7");
		if (loadGameExists(path, 7))
			btnLadestelle7.setForeground(Color.BLUE);
		btnLadestelle7.addActionListener(this);
		panelSave.add(btnLadestelle7);
		
		btnLadestelle8 = new View_JButton("Ladestelle 8");
		btnLadestelle8.setActionCommand("8");
		if (loadGameExists(path, 8))
			btnLadestelle8.setForeground(Color.BLUE);
		btnLadestelle8.addActionListener(this);
		panelSave.add(btnLadestelle8);
	}

	//MARK: - Methods
	@Override public void actionPerformed(ActionEvent e) {
		int loadIndex = Integer.parseInt(e.getActionCommand());
		if (loadGameExists(path, loadIndex)) {
			model.loadQuestionsFromSaveGame(path, loadIndex);
		}
	}
	private boolean loadGameExists (String parentPath, int index) {
		if (new File (parentPath + "save/game" + index + ".wwm").exists())
			return true;
		return false;
	}
}