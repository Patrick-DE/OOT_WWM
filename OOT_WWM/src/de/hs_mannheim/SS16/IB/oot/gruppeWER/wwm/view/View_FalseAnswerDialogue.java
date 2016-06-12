package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class View_FalseAnswerDialogue extends JDialog {

	//MARK: - Assets
	private final JPanel contentPanel = new JPanel();

	//MARK: - Constructor
	public View_FalseAnswerDialogue() {
		getContentPane().setBackground(Color.BLACK);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setOpaque(false);
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(1, 0, 0, 0));
		{
			JLabel lblFalseAnswer = new JLabel("Falsche Antwort!");
			lblFalseAnswer.setForeground(Color.WHITE);
			lblFalseAnswer.setOpaque(false);
			lblFalseAnswer.setHorizontalAlignment(SwingConstants.CENTER);
			contentPanel.add(lblFalseAnswer);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setOpaque(false);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new View_JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		pack();
		this.setVisible(true);
	}
}