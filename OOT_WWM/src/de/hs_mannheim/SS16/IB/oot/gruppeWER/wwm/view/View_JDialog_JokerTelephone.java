package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class View_JDialog_JokerTelephone extends JDialog {

	//MARK: - Assets
	private static final long serialVersionUID = 6013656282755272097L;

	//MARK: - Assets
	public View_JDialog_JokerTelephone(String telephoneAnswer) {
		this.setTitle("Telefonjoker");
		this.setResizable(false);
		this.setBounds(100, 100, 500, 150);
		this.setLocation(Toolkit.getDefaultToolkit().getScreenSize().width/2 - this.getWidth()/2, Toolkit.getDefaultToolkit().getScreenSize().height/2 - this.getHeight()/2);
		this.setAlwaysOnTop(true);

		getContentPane().setLayout(new BorderLayout());

		//Create a JPanel for the label
		JPanel labelPanel = new View_JPanel_withBackgroundImage(2);
		labelPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		labelPanel.setLayout(new GridLayout(0, 1, 0, 0));
		//Create and add the label
		JLabel telephoneAnswerLabel = new JLabel("<HTML><CENTER>" + telephoneAnswer +  "</CENTER></HTML>");
		telephoneAnswerLabel.setForeground(Color.WHITE);
		telephoneAnswerLabel.setHorizontalAlignment(SwingConstants.CENTER);
		telephoneAnswerLabel.setFont(telephoneAnswerLabel.getFont().deriveFont(20.0f));
		labelPanel.add(telephoneAnswerLabel);
		//Add the panel to the contentPane
		getContentPane().add(labelPanel, BorderLayout.CENTER);

		//Create a JPanel for the buttons
		JPanel buttonPane = new View_JPanel_withBackgroundImage();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		

		//Create and add the buttons
		//Button "OK"
		JButton okButton = new View_JButton_withBackgroundImage("OK");
		okButton.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		okButton.setActionCommand("OK");
		buttonPane.add(okButton);
		getRootPane().setDefaultButton(okButton);
		
		//Add the panel to the contentPane
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		//Finish creating the Dialogue
		//pack();
		this.setVisible(true);
	}
}