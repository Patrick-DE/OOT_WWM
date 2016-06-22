package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.GridLayout;

public class View_Window_SaveGame extends View_JPanel_withBackgroundImage implements ActionListener{
	
	//MARK: - Assets
	private View_JButton_withBackgroundImage btnSaveButton1;
	private View_JButton_withBackgroundImage btnSaveButton2;
	private View_JButton_withBackgroundImage btnSaveButton3;
	private View_JButton_withBackgroundImage btnSaveButton4;
	private View_JButton_withBackgroundImage btnSaveButton5;
	private View_JButton_withBackgroundImage btnSaveButton6;
	private View_JButton_withBackgroundImage btnSaveButton7;
	private View_JButton_withBackgroundImage btnSaveButton8;
	private WWMModel model;
	private String path;

	//MARK: - Constructor
	public View_Window_SaveGame(WWMModel model, String path) {
		//this.setBackground(Color.BLACK);
		this.model = model;
		this.path = path;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 0};
		gridBagLayout.rowHeights = new int[] {0, 0, 0};
		gridBagLayout.columnWeights = new double[] {1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[] {0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblChoose = new View_JLabel_withBackgroundImage(1, "Wähle die Speicherstelle aus:");
		lblChoose.setHorizontalAlignment(SwingConstants.CENTER);
		lblChoose.setFont(lblChoose.getFont().deriveFont(22.0f));
		GridBagConstraints gbc_lblWhleDieSpeicherstelle = new GridBagConstraints();
		gbc_lblWhleDieSpeicherstelle.fill = GridBagConstraints.BOTH;
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
		gbc_panelSave.insets = new Insets(20, 20, 50, 20);
		add(panelSave, gbc_panelSave);
		panelSave.setLayout(new GridLayout(4, 2, 0, 0));
		
		btnSaveButton1 = new View_JButton_withBackgroundImage("Speicherstelle 1");
		btnSaveButton1.setActionCommand("1");
		btnSaveButton1.addActionListener(this);
		panelSave.add(btnSaveButton1);
		
		btnSaveButton2 = new View_JButton_withBackgroundImage("Speicherstelle 2");
		btnSaveButton2.setActionCommand("2");
		btnSaveButton2.addActionListener(this);
		panelSave.add(btnSaveButton2);
		
		btnSaveButton3 = new View_JButton_withBackgroundImage("Speicherstelle 3");
		btnSaveButton3.setActionCommand("3");
		btnSaveButton3.addActionListener(this);
		panelSave.add(btnSaveButton3);
		
		btnSaveButton4 = new View_JButton_withBackgroundImage("Speicherstelle 4");
		btnSaveButton4.setActionCommand("4");
		btnSaveButton4.addActionListener(this);
		panelSave.add(btnSaveButton4);
		
		btnSaveButton5 = new View_JButton_withBackgroundImage("Speicherstelle 5");
		btnSaveButton5.setActionCommand("5");
		btnSaveButton5.addActionListener(this);
		panelSave.add(btnSaveButton5);
		
		btnSaveButton6 = new View_JButton_withBackgroundImage("Speicherstelle 6");
		btnSaveButton6.setActionCommand("6");
		btnSaveButton6.addActionListener(this);
		panelSave.add(btnSaveButton6);
		
		btnSaveButton7 = new View_JButton_withBackgroundImage("Speicherstelle 7");
		btnSaveButton7.setActionCommand("7");
		btnSaveButton7.addActionListener(this);
		panelSave.add(btnSaveButton7);
		
		btnSaveButton8 = new View_JButton_withBackgroundImage("Speicherstelle 8");
		btnSaveButton8.setActionCommand("8");
		btnSaveButton8.addActionListener(this);
		panelSave.add(btnSaveButton8);
	}

	//MARK: - Methods
	@Override public void actionPerformed(ActionEvent e) {
		int saveIndex = Integer.parseInt(e.getActionCommand());
		if (saveGameExists(path, saveIndex)) {
			new View_JDialog_SaveOverride(model, path, saveIndex);
		} else {
			model.saveGameToFile(path, saveIndex);
		}
		updateSaveWindow();
	}
	private boolean saveGameExists (String parentPath, int index) {
		if (new File (parentPath + "save/game" + index + ".wwm").exists())
			return true;
		return false;
	}
	public void updateSaveWindow() {
		btnSaveButton1.changeImageIndex(2);
		btnSaveButton1.repaint();
		btnSaveButton2.changeImageIndex(2);
		btnSaveButton2.repaint();
		btnSaveButton3.changeImageIndex(2);
		btnSaveButton3.repaint();
		btnSaveButton4.changeImageIndex(2);
		btnSaveButton4.repaint();
		btnSaveButton5.changeImageIndex(2);
		btnSaveButton5.repaint();
		btnSaveButton6.changeImageIndex(2);
		btnSaveButton6.repaint();
		btnSaveButton7.changeImageIndex(2);
		btnSaveButton7.repaint();
		btnSaveButton8.changeImageIndex(2);
		btnSaveButton8.repaint();
		if(saveGameExists(path, 1)) {
			btnSaveButton1.changeImageIndex(3);
			btnSaveButton1.repaint();
		}
		if(saveGameExists(path, 2)) {
			btnSaveButton2.changeImageIndex(3);
			btnSaveButton2.repaint();
		}
		if(saveGameExists(path, 3)) {
			btnSaveButton3.changeImageIndex(3);
			btnSaveButton3.repaint();
		}
		if(saveGameExists(path, 4)) {
			btnSaveButton4.changeImageIndex(3);
			btnSaveButton4.repaint();
		}
		if(saveGameExists(path, 5)) {
			btnSaveButton5.changeImageIndex(3);
			btnSaveButton5.repaint();
		}
		if(saveGameExists(path, 6)) {
			btnSaveButton6.changeImageIndex(3);
			btnSaveButton6.repaint();
		}
		if(saveGameExists(path, 7)) {
			btnSaveButton7.changeImageIndex(3);
			btnSaveButton7.repaint();
		}
		if(saveGameExists(path, 8)) {
			btnSaveButton8.changeImageIndex(3);
			btnSaveButton8.repaint();
		}
	}	
}