package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class View_JDialog_DropOut extends JDialog {

	//MARK: - Assets
	private static final long serialVersionUID = -7123708486453711236L;

	//MARK: - Constructor
	public View_JDialog_DropOut(WWMModel model) {
		this.setTitle("Aussteigen");
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
		JLabel lblAussteigen = new JLabel("Aussteigen?");
		lblAussteigen.setForeground(Color.WHITE);
		lblAussteigen.setHorizontalAlignment(SwingConstants.CENTER);
		lblAussteigen.setFont(lblAussteigen.getFont().deriveFont(22.0f));
		labelPanel.add(lblAussteigen);
		//Add the panel to the contentPane
		getContentPane().add(labelPanel, BorderLayout.CENTER);

		//Create a JPanel for the buttons
		JPanel buttonPanel = new View_JPanel_withBackgroundImage();
		buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
		//Create and add the buttons
		//Button "NO"
		JButton btnNo = new View_JButton_withBackgroundImage("Nein");
		btnNo.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		buttonPanel.add(btnNo);
		getRootPane().setDefaultButton(btnNo);
		//Button "YES"
		JButton btnYes = new View_JButton_withBackgroundImage("Ja");
		btnYes.addActionListener(new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				model.dropOut();
				dispose();
			}
		});
		buttonPanel.add(btnYes);
		//Add the panel to the contentPane
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		//Finish creating the Dialogue
		//pack();
		this.setVisible(true);
	}
}