package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.BorderLayout;
import java.awt.Color;
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

public class View_JokerTelephone extends JDialog {

    //MARK: - Assets
    private static final long serialVersionUID = 1599703298634307780L;
    private final JPanel contentPanel = new View_JPanel_withBackgroundImage();

    //MARK: - Assets
    public View_JokerTelephone(String telephoneAnswer) {
        getContentPane().setBackground(Color.BLACK);
        setAlwaysOnTop(true);
        setBounds(100, 100, 500, 150);
        this.setTitle("Publikumsjoker");
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPanel.setOpaque(false);
        contentPanel.setBackground(Color.BLACK);
        getContentPane().add(contentPanel, BorderLayout.CENTER);
        GridBagLayout gbl_contentPanel = new GridBagLayout();
        gbl_contentPanel.columnWidths = new int[]{0, 0, 0, 0, 0};
        gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0};
        gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
        contentPanel.setLayout(gbl_contentPanel);
        {
            JLabel telephoneAnswerLabel = new JLabel(telephoneAnswer);
            telephoneAnswerLabel.setForeground(Color.WHITE);
            contentPanel.add(telephoneAnswerLabel);
        }
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setOpaque(false);
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new View_JButton_withBackgroundImage("OK");
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
        this.setVisible(true);
    }
}