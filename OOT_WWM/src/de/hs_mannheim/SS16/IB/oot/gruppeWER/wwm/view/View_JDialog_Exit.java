package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class View_JDialog_Exit extends JDialog {

	//MARK: - Constructor
	public View_JDialog_Exit(WWMController controller) {
		this.setTitle("Speichern und Beenden");
		this.setResizable(false);
		this.setBounds(100, 100, 450, 100);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - this.getHeight()/2);
		this.setAlwaysOnTop(true);
		this.setModalityType(Dialog.DEFAULT_MODALITY_TYPE);
		
		getContentPane().setLayout(new BorderLayout());

		//Create a JPanel for the label
		JPanel labelPanel = new View_JPanel_withBackgroundImage(2);
		labelPanel.setOpaque(false);
		labelPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		labelPanel.setLayout(new GridLayout(1, 1, 0, 0));
		//Create and add the label
		JLabel lblBeendenOhneSpeichern = new JLabel("Beenden ohne Speichern?");
		lblBeendenOhneSpeichern.setOpaque(false);
		lblBeendenOhneSpeichern.setForeground(Color.WHITE);
		lblBeendenOhneSpeichern.setHorizontalAlignment(SwingConstants.CENTER);
		lblBeendenOhneSpeichern.setFont(lblBeendenOhneSpeichern.getFont().deriveFont(20.0f));
		labelPanel.add(lblBeendenOhneSpeichern);
		//Add the panel to the contentPane
		getContentPane().add(labelPanel, BorderLayout.CENTER);

		//Create a JPanel for the buttons
		JPanel buttonPanel = new View_JPanel_withBackgroundImage();
		buttonPanel.setOpaque(false);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
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
		//pack();
		this.setVisible(true);
	}
}