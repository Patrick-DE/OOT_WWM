package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

public class View_JDialog_SaveOverride extends JDialog {

	View_JDialog_SaveOverride(WWMModel model, String path, int index) {
		this.setTitle("Warnung");
		this.setResizable(false);
		this.setBounds(100, 100, 450, 100);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - this.getHeight()/2);
		this.setForeground(Color.WHITE);
		this.setAlwaysOnTop(true);
		this.setModal(true);
		
		getContentPane().setLayout(new BorderLayout());
		
		//Create a JPanel for the label
		JPanel labelPanel = new View_JPanel_withBackgroundImage(2);
		labelPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		labelPanel.setLayout(new GridLayout(1, 1, 0, 0));
		//Create and add the label
		JLabel lblSpielstandberschreiben = new JLabel("Spielstand überschreiben?");
		lblSpielstandberschreiben.setForeground(Color.WHITE);
		lblSpielstandberschreiben.setHorizontalAlignment(SwingConstants.CENTER);
		labelPanel.add(lblSpielstandberschreiben);
		//Add the panel to the contentPane
		getContentPane().add(labelPanel, BorderLayout.CENTER);

		//Create a JPanel for the buttons
		JPanel buttonPane = new View_JPanel_withBackgroundImage();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		//Create and add the buttons
		//Button "ABBRECHEN"
		JButton btnCancel = new View_JButton_withBackgroundImage("Abbrechen");
		buttonPane.add(btnCancel);
		btnCancel.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		getRootPane().setDefaultButton(btnCancel);
		//Button "UEBERSCHREIBEN"
		JButton btnOverRide = new View_JButton_withBackgroundImage("Überschreiben");
		btnOverRide.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				model.saveGameToFile(path, index);
				dispose();
			}
		});
		buttonPane.add(btnOverRide);
		
		//Add the panel to the contentPane
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		//Finish creating the Dialogue
		//pack();
		this.setVisible(true);
	}
}