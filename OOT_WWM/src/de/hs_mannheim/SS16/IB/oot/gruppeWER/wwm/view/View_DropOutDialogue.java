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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class View_DropOutDialogue extends JDialog {

	//MARK: - Assets
	private final JPanel contentPanel = new JPanel();

	//MARK: - Constructor
	public View_DropOutDialogue(WWMModel model) {
		getContentPane().setBackground(Color.BLACK);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setOpaque(false);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			JLabel lblAussteigen = new JLabel("Aussteigen?");
			lblAussteigen.setForeground(Color.WHITE);
			lblAussteigen.setOpaque(false);
			lblAussteigen.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblAussteigen);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setOpaque(false);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNo = new View_JButton("Nein");
				btnNo.addActionListener(new ActionListener() {
					
					@Override public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnNo);
				getRootPane().setDefaultButton(btnNo);
			}
			{
				JButton btnYes = new View_JButton("Ja");
				btnYes.addActionListener(new ActionListener() {
					
					@Override public void actionPerformed(ActionEvent e) {
						model.setGameEnd();
						dispose();
					}
				});
				buttonPane.add(btnYes);
			}
		}
		pack();
		this.setVisible(true);
	}
}