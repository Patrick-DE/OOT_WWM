package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class View_JokerAudience extends JDialog {

	//MARK: - Assets
	private static final long serialVersionUID = 1599703298634307780L;
	private final JPanel contentPanel = new JPanel();

	
	//MARK: - Constructor
	public View_JokerAudience(int[] audienceResults) {
		setAlwaysOnTop(true);
		setBounds(100, 100, 450, 300);
		this.setTitle("Publikumsjoker");
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblPer1 = new JLabel("" + audienceResults[0] + " %");
			GridBagConstraints gbc_lblPer1 = new GridBagConstraints();
			gbc_lblPer1.weighty = 0.1;
			gbc_lblPer1.weightx = 0.25;
			gbc_lblPer1.insets = new Insets(0, 0, 5, 5);
			gbc_lblPer1.gridx = 0;
			gbc_lblPer1.gridy = 0;
			contentPanel.add(lblPer1, gbc_lblPer1);
		}
		{
			JLabel lblPer2 = new JLabel("" + audienceResults[1] + " %");
			GridBagConstraints gbc_lblPer2 = new GridBagConstraints();
			gbc_lblPer2.weighty = 0.1;
			gbc_lblPer2.weightx = 0.25;
			gbc_lblPer2.insets = new Insets(0, 0, 5, 5);
			gbc_lblPer2.gridx = 1;
			gbc_lblPer2.gridy = 0;
			contentPanel.add(lblPer2, gbc_lblPer2);
		}
		{
			JLabel lblPer3 = new JLabel("" + audienceResults[2] + " %");
			GridBagConstraints gbc_lblPer3 = new GridBagConstraints();
			gbc_lblPer3.weighty = 0.1;
			gbc_lblPer3.weightx = 0.25;
			gbc_lblPer3.insets = new Insets(0, 0, 5, 5);
			gbc_lblPer3.gridx = 2;
			gbc_lblPer3.gridy = 0;
			contentPanel.add(lblPer3, gbc_lblPer3);
		}
		{
			JLabel lblPer4 = new JLabel("" + audienceResults[3] + " %");
			GridBagConstraints gbc_lblPer4 = new GridBagConstraints();
			gbc_lblPer4.weighty = 0.1;
			gbc_lblPer4.weightx = 0.25;
			gbc_lblPer4.insets = new Insets(0, 0, 5, 0);
			gbc_lblPer4.gridx = 3;
			gbc_lblPer4.gridy = 0;
			contentPanel.add(lblPer4, gbc_lblPer4);
		}
		{
			JProgressBar progressBarAnswer1 = new JProgressBar();
			progressBarAnswer1.setBorderPainted(false);
			progressBarAnswer1.setValue(audienceResults[0]);
			progressBarAnswer1.setOrientation(SwingConstants.VERTICAL);
			GridBagConstraints gbc_progressBarAnswer1 = new GridBagConstraints();
			gbc_progressBarAnswer1.fill = GridBagConstraints.VERTICAL;
			gbc_progressBarAnswer1.weighty = 0.8;
			gbc_progressBarAnswer1.weightx = 0.25;
			gbc_progressBarAnswer1.insets = new Insets(0, 0, 5, 5);
			gbc_progressBarAnswer1.gridx = 0;
			gbc_progressBarAnswer1.gridy = 1;
			contentPanel.add(progressBarAnswer1, gbc_progressBarAnswer1);
		}
		{
			JProgressBar progressBarAnswer2 = new JProgressBar();
			progressBarAnswer2.setBorderPainted(false);
			progressBarAnswer2.setValue(audienceResults[1]);
			progressBarAnswer2.setOrientation(SwingConstants.VERTICAL);
			GridBagConstraints gbc_progressBarAnswer2 = new GridBagConstraints();
			gbc_progressBarAnswer2.weighty = 0.1;
			gbc_progressBarAnswer2.weightx = 0.25;
			gbc_progressBarAnswer2.fill = GridBagConstraints.VERTICAL;
			gbc_progressBarAnswer2.insets = new Insets(0, 0, 5, 5);
			gbc_progressBarAnswer2.gridx = 1;
			gbc_progressBarAnswer2.gridy = 1;
			contentPanel.add(progressBarAnswer2, gbc_progressBarAnswer2);
		}
		{
			JProgressBar progressBarAnswer3 = new JProgressBar();
			progressBarAnswer3.setBorderPainted(false);
			progressBarAnswer3.setValue(audienceResults[2]);
			progressBarAnswer3.setOrientation(SwingConstants.VERTICAL);
			GridBagConstraints gbc_progressBarAnswer3 = new GridBagConstraints();
			gbc_progressBarAnswer3.fill = GridBagConstraints.VERTICAL;
			gbc_progressBarAnswer3.weighty = 0.1;
			gbc_progressBarAnswer3.weightx = 0.25;
			gbc_progressBarAnswer3.insets = new Insets(0, 0, 5, 5);
			gbc_progressBarAnswer3.gridx = 2;
			gbc_progressBarAnswer3.gridy = 1;
			contentPanel.add(progressBarAnswer3, gbc_progressBarAnswer3);
		}
		{
			JProgressBar progressBarAnswer4 = new JProgressBar();
			progressBarAnswer4.setBorderPainted(false);
			progressBarAnswer4.setValue(audienceResults[3]);
			progressBarAnswer4.setOrientation(SwingConstants.VERTICAL);
			GridBagConstraints gbc_progressBarAnswer4 = new GridBagConstraints();
			gbc_progressBarAnswer4.fill = GridBagConstraints.VERTICAL;
			gbc_progressBarAnswer4.weighty = 0.1;
			gbc_progressBarAnswer4.weightx = 0.25;
			gbc_progressBarAnswer4.insets = new Insets(0, 0, 5, 0);
			gbc_progressBarAnswer4.gridx = 3;
			gbc_progressBarAnswer4.gridy = 1;
			contentPanel.add(progressBarAnswer4, gbc_progressBarAnswer4);
		}
		{
			JLabel lblA = new JLabel("A");
			GridBagConstraints gbc_lblA = new GridBagConstraints();
			gbc_lblA.weighty = 0.1;
			gbc_lblA.weightx = 0.25;
			gbc_lblA.insets = new Insets(0, 0, 0, 5);
			gbc_lblA.gridx = 0;
			gbc_lblA.gridy = 2;
			contentPanel.add(lblA, gbc_lblA);
		}
		{
			JLabel lblB = new JLabel("B");
			GridBagConstraints gbc_lblB = new GridBagConstraints();
			gbc_lblB.weighty = 0.1;
			gbc_lblB.weightx = 0.25;
			gbc_lblB.insets = new Insets(0, 0, 0, 5);
			gbc_lblB.gridx = 1;
			gbc_lblB.gridy = 2;
			contentPanel.add(lblB, gbc_lblB);
		}
		{
			JLabel lblC = new JLabel("C");
			GridBagConstraints gbc_lblC = new GridBagConstraints();
			gbc_lblC.weighty = 0.1;
			gbc_lblC.weightx = 0.25;
			gbc_lblC.insets = new Insets(0, 0, 0, 5);
			gbc_lblC.gridx = 2;
			gbc_lblC.gridy = 2;
			contentPanel.add(lblC, gbc_lblC);
		}
		{
			JLabel lblD = new JLabel("D");
			GridBagConstraints gbc_lblD = new GridBagConstraints();
			gbc_lblD.weighty = 0.1;
			gbc_lblD.weightx = 0.25;
			gbc_lblD.gridx = 3;
			gbc_lblD.gridy = 2;
			contentPanel.add(lblD, gbc_lblD);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		this.setVisible(true);
	}
}