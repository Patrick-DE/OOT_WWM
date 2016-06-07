package werWirdMillionär.view;

import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import werWirdMillionär.controller.WWMController;
import werWirdMillionär.model.WWMModel;

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
import java.awt.Component;
import java.awt.FlowLayout;

public class WWMSaveWindow extends JPanel implements ActionListener{
	private JButton btnSpeicherstelle1;
	private JButton btnSpeicherstelle2;
	private JButton btnSpeicherstelle3;
	private JButton btnSpeicherstelle4;
	private JButton btnSpeicherstelle5;
	private JButton btnSpeicherstelle6;
	private JButton btnSpeicherstelle7;
	private JButton btnSpeicherstelle8;
	private WWMModel model;
	private String path;

	/**
	 * Create the panel.
	 */
	public WWMSaveWindow(WWMModel model, String path) {
		this.model = model;
		this.path = path;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JLabel lblWhleDieSpeicherstelle = new JLabel("Wähle die Speicherstelle aus:");
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
		
		btnSpeicherstelle1 = new JButton("Speicherstelle 1");
		btnSpeicherstelle1.setActionCommand("1");
		if (saveGameExists(path, 1))
			btnSpeicherstelle1.setForeground(Color.BLUE);
		btnSpeicherstelle1.addActionListener(this);
		btnSpeicherstelle1.setBorderPainted(false);
		btnSpeicherstelle1.setContentAreaFilled(false);
		panelSave.add(btnSpeicherstelle1);
		
		btnSpeicherstelle2 = new JButton("Speicherstelle 2");
		btnSpeicherstelle2.setActionCommand("2");
		if (saveGameExists(path, 2))
			btnSpeicherstelle2.setForeground(Color.BLUE);
		btnSpeicherstelle2.addActionListener(this);
		btnSpeicherstelle2.setContentAreaFilled(false);
		btnSpeicherstelle2.setBorderPainted(false);
		panelSave.add(btnSpeicherstelle2);
		
		btnSpeicherstelle3 = new JButton("Speicherstelle 3");
		btnSpeicherstelle3.setActionCommand("3");
		if (saveGameExists(path, 3))
			btnSpeicherstelle3.setForeground(Color.BLUE);
		btnSpeicherstelle3.addActionListener(this);
		btnSpeicherstelle3.setContentAreaFilled(false);
		btnSpeicherstelle3.setBorderPainted(false);
		panelSave.add(btnSpeicherstelle3);
		
		btnSpeicherstelle4 = new JButton("Speicherstelle 4");
		btnSpeicherstelle4.setActionCommand("4");
		if (saveGameExists(path, 4))
			btnSpeicherstelle4.setForeground(Color.BLUE);
		btnSpeicherstelle4.addActionListener(this);
		btnSpeicherstelle4.setContentAreaFilled(false);
		btnSpeicherstelle4.setBorderPainted(false);
		panelSave.add(btnSpeicherstelle4);
		
		btnSpeicherstelle5 = new JButton("Speicherstelle 5");
		btnSpeicherstelle5.setActionCommand("5");
		if (saveGameExists(path, 5))
			btnSpeicherstelle5.setForeground(Color.BLUE);
		btnSpeicherstelle5.addActionListener(this);
		btnSpeicherstelle5.setContentAreaFilled(false);
		btnSpeicherstelle5.setBorderPainted(false);
		panelSave.add(btnSpeicherstelle5);
		
		btnSpeicherstelle6 = new JButton("Speicherstelle 6");
		btnSpeicherstelle6.setActionCommand("6");
		if (saveGameExists(path, 6))
			btnSpeicherstelle6.setForeground(Color.BLUE);
		btnSpeicherstelle6.addActionListener(this);
		btnSpeicherstelle6.setContentAreaFilled(false);
		btnSpeicherstelle6.setBorderPainted(false);
		panelSave.add(btnSpeicherstelle6);
		
		btnSpeicherstelle7 = new JButton("Speicherstelle 7");
		btnSpeicherstelle7.setActionCommand("7");
		if (saveGameExists(path, 7))
			btnSpeicherstelle7.setForeground(Color.BLUE);
		btnSpeicherstelle7.addActionListener(this);
		btnSpeicherstelle7.setContentAreaFilled(false);
		btnSpeicherstelle7.setBorderPainted(false);
		panelSave.add(btnSpeicherstelle7);
		
		btnSpeicherstelle8 = new JButton("Speicherstelle 8");
		btnSpeicherstelle8.setActionCommand("8");
		if (saveGameExists(path, 8))
			btnSpeicherstelle8.setForeground(Color.BLUE);
		btnSpeicherstelle8.addActionListener(this);
		btnSpeicherstelle8.setContentAreaFilled(false);
		btnSpeicherstelle8.setBorderPainted(false);
		panelSave.add(btnSpeicherstelle8);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int saveIndex = Integer.parseInt(e.getActionCommand());
		if (saveGameExists(path, saveIndex)) {
			new FileOverRide(model, path, saveIndex);
		} else {
			model.saveToFile(path, saveIndex);
		}
	}
	
	private boolean saveGameExists (String parentPath, int index) {
		if (new File (parentPath + "save/game" + index + ".wwm").exists())
			return true;
		return false;
	}
	
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
					JButton btnCancel = new JButton("Abbrechen");
					buttonPane.add(btnCancel);
					btnCancel.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					getRootPane().setDefaultButton(btnCancel);
				}
				{
					JButton btnOverRide = new JButton("Überschreiben");
					btnOverRide.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
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
