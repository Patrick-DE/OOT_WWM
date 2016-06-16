package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class View_Dialogue_Exit extends JDialog {

	//MARK: - Constructor
	public View_Dialogue_Exit(WWMController controller) {
		getContentPane().setBackground(Color.BLACK);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Speichern und Beenden");
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);

		//Create a JPanel for the label
		JPanel labelPanel = new JPanel();
		labelPanel.setOpaque(false);
		labelPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		labelPanel.setLayout(new GridLayout(1, 1, 0, 0));
		//Create and add the label
		JLabel lblBeendenOhneSpeichern = new JLabel("Beenden ohne Speichern?");
		lblBeendenOhneSpeichern.setOpaque(false);
		lblBeendenOhneSpeichern.setForeground(Color.WHITE);
		lblBeendenOhneSpeichern.setHorizontalAlignment(SwingConstants.CENTER);
		labelPanel.add(lblBeendenOhneSpeichern);
		//Add the panel to the contentPane
		getContentPane().add(labelPanel, BorderLayout.CENTER);

		//Create a JPanel for the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
		//Create and add the buttons
		//Button "ABBRECHEN"
		JButton btnCancel = new View_JButton_withBackgroundImage("Abbrechen");
		btnCancel.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPanel.add(btnCancel);
		getRootPane().setDefaultButton(btnCancel);
		//Button "SPEICHERN"
		JButton btnSave = new View_JButton_withBackgroundImage("Speichern");
		btnSave.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				controller.actionPerformed(new ActionEvent(this, 123456, "Speichern"));
				dispose();
			}
		});
		buttonPanel.add(btnSave);
		//Button "BEENDEN"
		JButton btnExit = new View_JButton_withBackgroundImage("Beenden");
		btnExit.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		buttonPanel.add(btnExit);
		//Add the panel to the contentPane
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		//Finish creating the Dialogue
		pack();
		this.setVisible(true);
	}
}