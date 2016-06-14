package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.GridLayout;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;

public class View_SaveWindow extends JPanel implements ActionListener{
	
	//MARK: - Assets
	private BufferedImage backdrop;
	private JButton btnSaveButton1;
	private JButton btnSaveButton2;
	private JButton btnSaveButton3;
	private JButton btnSaveButton4;
	private JButton btnSaveButton5;
	private JButton btnSaveButton6;
	private JButton btnSaveButton7;
	private JButton btnSaveButton8;
	private WWMModel model;
	private String path;

	//MARK: - Constructor
	public View_SaveWindow(WWMModel model, String path) {
		//this.setBackground(Color.BLACK);
		loadImage();
		this.model = model;
		this.path = path;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblChoose = new JLabel("Wähle die Speicherstelle aus:");
		lblChoose.setForeground(Color.WHITE);
		GridBagConstraints gbc_lblWhleDieSpeicherstelle = new GridBagConstraints();
		gbc_lblWhleDieSpeicherstelle.weighty = 0.1;
		gbc_lblWhleDieSpeicherstelle.insets = new Insets(0, 0, 5, 0);
		gbc_lblWhleDieSpeicherstelle.gridx = 0;
		gbc_lblWhleDieSpeicherstelle.gridy = 0;
		add(lblChoose, gbc_lblWhleDieSpeicherstelle);
		
		JPanel panelSave = new JPanel();
		panelSave.setOpaque(false);
		GridBagConstraints gbc_panelSave = new GridBagConstraints();
		gbc_panelSave.weighty = 0.9;
		gbc_panelSave.fill = GridBagConstraints.BOTH;
		gbc_panelSave.gridx = 0;
		gbc_panelSave.gridy = 1;
		add(panelSave, gbc_panelSave);
		panelSave.setLayout(new GridLayout(4, 2, 0, 0));
		
		btnSaveButton1 = new View_JButton("Speicherstelle 1");
		btnSaveButton1.setActionCommand("1");
		btnSaveButton1.addActionListener(this);
		panelSave.add(btnSaveButton1);
		
		btnSaveButton2 = new View_JButton("Speicherstelle 2");
		btnSaveButton2.setActionCommand("2");
		btnSaveButton2.addActionListener(this);
		panelSave.add(btnSaveButton2);
		
		btnSaveButton3 = new View_JButton("Speicherstelle 3");
		btnSaveButton3.setActionCommand("3");
		btnSaveButton3.addActionListener(this);
		panelSave.add(btnSaveButton3);
		
		btnSaveButton4 = new View_JButton("Speicherstelle 4");
		btnSaveButton4.setActionCommand("4");
		btnSaveButton4.addActionListener(this);
		panelSave.add(btnSaveButton4);
		
		btnSaveButton5 = new View_JButton("Speicherstelle 5");
		btnSaveButton5.setActionCommand("5");
		btnSaveButton5.addActionListener(this);
		panelSave.add(btnSaveButton5);
		
		btnSaveButton6 = new View_JButton("Speicherstelle 6");
		btnSaveButton6.setActionCommand("6");
		btnSaveButton6.addActionListener(this);
		panelSave.add(btnSaveButton6);
		
		btnSaveButton7 = new View_JButton("Speicherstelle 7");
		btnSaveButton7.setActionCommand("7");
		btnSaveButton7.addActionListener(this);
		panelSave.add(btnSaveButton7);
		
		btnSaveButton8 = new View_JButton("Speicherstelle 8");
		btnSaveButton8.setActionCommand("8");
		btnSaveButton8.addActionListener(this);
		panelSave.add(btnSaveButton8);
	}

	//MARK: - Methods
	@Override public void actionPerformed(ActionEvent e) {
		int saveIndex = Integer.parseInt(e.getActionCommand());
		if (saveGameExists(path, saveIndex)) {
			new View_SaveDialogue(model, path, saveIndex);
		} else {
			model.saveToFile(path, saveIndex);
		}
		updateSaveWindow();
	}
	private boolean saveGameExists (String parentPath, int index) {
		if (new File (parentPath + "save/game" + index + ".wwm").exists())
			return true;
		return false;
	}
	public void updateSaveWindow() {
		btnSaveButton1.setForeground(Color.RED);
		btnSaveButton2.setForeground(Color.RED);
		btnSaveButton3.setForeground(Color.RED);
		btnSaveButton4.setForeground(Color.RED);
		btnSaveButton5.setForeground(Color.RED);
		btnSaveButton6.setForeground(Color.RED);
		btnSaveButton7.setForeground(Color.RED);
		btnSaveButton8.setForeground(Color.RED);
		if (saveGameExists(path, 1))
			btnSaveButton1.setForeground(Color.GREEN);
		if (saveGameExists(path, 2))
			btnSaveButton2.setForeground(Color.GREEN);
		if (saveGameExists(path, 3))
			btnSaveButton3.setForeground(Color.GREEN);
		if (saveGameExists(path, 4))
			btnSaveButton4.setForeground(Color.GREEN);
		if (saveGameExists(path, 5))
			btnSaveButton5.setForeground(Color.GREEN);
		if (saveGameExists(path, 6))
			btnSaveButton6.setForeground(Color.GREEN);
		if (saveGameExists(path, 7))
			btnSaveButton7.setForeground(Color.GREEN);
		if (saveGameExists(path, 8))
			btnSaveButton8.setForeground(Color.GREEN);
	}
	@Override protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(backdrop != null) {
	    	g.drawImage(backdrop, 0, 0, getWidth(), getHeight(), null);
	    }
	}
	private void loadImage() {
		try {
			backdrop = ImageIO.read(new File("data/Backdrop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
}