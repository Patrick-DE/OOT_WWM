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
import java.io.File;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

public class View_SaveWindow extends JPanel implements ActionListener{
	
	//MARK: - Assets
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
		this.model = model;
		this.path = path;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblChoose = new JLabel("Wähle die Speicherstelle aus:");
		GridBagConstraints gbc_lblWhleDieSpeicherstelle = new GridBagConstraints();
		gbc_lblWhleDieSpeicherstelle.weighty = 0.1;
		gbc_lblWhleDieSpeicherstelle.insets = new Insets(0, 0, 5, 0);
		gbc_lblWhleDieSpeicherstelle.gridx = 0;
		gbc_lblWhleDieSpeicherstelle.gridy = 0;
		add(lblChoose, gbc_lblWhleDieSpeicherstelle);
		
		JPanel panelSave = new JPanel();
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
			new FileOverRide(model, path, saveIndex);
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
	
	//MARK: - Inner Classes
	class FileOverRide extends JDialog {
		
		private final JPanel contentPanel = new JPanel();
		
		FileOverRide (WWMModel model, String path, int index) {
			this.setTitle("Warnung");
			setBounds(100, 100, 450, 300);
			getContentPane().setLayout(new BorderLayout());
			contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
			getContentPane().add(contentPanel, BorderLayout.CENTER);
			contentPanel.setLayout(new GridLayout(1, 1, 0, 0));
			{
				JLabel lblSpielstandberschreiben = new JLabel("Spielstand überschreiben?");
				lblSpielstandberschreiben.setHorizontalAlignment(SwingConstants.CENTER);
				contentPanel.add(lblSpielstandberschreiben);
			}
			{
				JPanel buttonPane = new JPanel();
				buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
				getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
					JButton btnCancel = new View_JButton("Abbrechen");
					buttonPane.add(btnCancel);
					btnCancel.addActionListener(new ActionListener() {
						
						@Override public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					getRootPane().setDefaultButton(btnCancel);
				}
				{
					JButton btnOverRide = new View_JButton("Überschreiben");
					btnOverRide.addActionListener(new ActionListener() {
						
						@Override public void actionPerformed(ActionEvent e) {
							model.saveToFile(path, index);
							dispose();
						}
					});
					buttonPane.add(btnOverRide);
				}
			}
			pack();
			this.setVisible(true);
		}
	}
}