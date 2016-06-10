package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 0, 0));
		{
			JLabel lblAussteigen = new JLabel("Aussteigen?");
			lblAussteigen.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblAussteigen);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnNein = new JButton("Nein");
				btnNein.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				buttonPane.add(btnNein);
				getRootPane().setDefaultButton(btnNein);
			}
			{
				JButton btnJa = new JButton("Ja");
				btnJa.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						model.setGameEnd();
						dispose();
					}
				});
				buttonPane.add(btnJa);
			}
		}
		pack();
		this.setVisible(true);
	}
}