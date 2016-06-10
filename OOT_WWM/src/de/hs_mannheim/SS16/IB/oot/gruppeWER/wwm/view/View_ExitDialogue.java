package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

public class View_ExitDialogue extends JDialog {

	//MARK: - Assets
	private final JPanel contentPanel = new JPanel();

	//MARK: - Constructor
	public View_ExitDialogue(WWMController controller) {
		setTitle("Speichern und Beenden");
		setModal(true);
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 1, 0, 0));
		{
			JLabel lblBeendenOhneSpeichern = new JLabel("Beenden ohne Speichern?");
			lblBeendenOhneSpeichern.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblBeendenOhneSpeichern);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnAbbrechen = new JButton("Abrechen");
				btnAbbrechen.addActionListener(new ActionListener() {
					
					@Override public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnAbbrechen);
				getRootPane().setDefaultButton(btnAbbrechen);
			}
			{
				JButton btnSpeichern = new JButton("Speichern");
				btnSpeichern.addActionListener(new ActionListener() {
					
					@Override public void actionPerformed(ActionEvent e) {
						controller.actionPerformed(new ActionEvent(this, 123456, "Speichern"));
						dispose();
					}
				});
				buttonPane.add(btnSpeichern);
			}
			{
				JButton btnBeenden = new JButton("Beenden");
				btnBeenden.addActionListener(new ActionListener() {
					
					@Override public void actionPerformed(ActionEvent e) {
						System.exit(0);
					}
				});
				buttonPane.add(btnBeenden);
			}
		}
		pack();
		this.setVisible(true);
	}
}