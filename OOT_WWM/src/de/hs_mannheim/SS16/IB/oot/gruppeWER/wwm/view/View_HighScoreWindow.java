package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import javax.swing.JPanel;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.Model_HighScoreEntry;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;
import java.awt.GridBagLayout;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class View_HighScoreWindow extends JPanel {

	//MARK: - Assets
	private BufferedImage backdrop;
	private WWMModel model;
	private JLabel lblQuestioncount;
	private JLabel lblTime_1;
	private JLabel lblName_1;

	//MARK: - Constructor
	public View_HighScoreWindow(WWMModel model) {
		//this.setBackground(Color.BLACK);
		loadImage();
		this.model = model;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0, 80};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0};
		setLayout(gridBagLayout);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setOpaque(false);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 0);
		gbc_panel_1.weightx = 0;
		gbc_panel_1.weighty = 0;
		gbc_panel_1.weighty = 0.0;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new GridLayout(1, 3, 0, 0));

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(Color.WHITE);
		lblName.setOpaque(false);
		lblName.setVerticalAlignment(SwingConstants.TOP);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblName);

		JLabel lblTime = new JLabel("Zeit (s)");
		lblTime.setForeground(Color.WHITE);
		lblTime.setOpaque(false);
		lblTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblTime.setVerticalAlignment(SwingConstants.TOP);
		panel_1.add(lblTime);

		JLabel lblQuestionamount = new JLabel("Frageanzahl");
		lblQuestionamount.setForeground(Color.WHITE);
		lblQuestionamount.setOpaque(false);
		lblQuestionamount.setVerticalAlignment(SwingConstants.TOP);
		lblQuestionamount.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblQuestionamount);

		JPanel panelHighScore = new JPanel();
		panelHighScore.setOpaque(false);
		//panelHighScore.setBackground(Color.BLACK);
		GridBagConstraints gbc_panelHighScore = new GridBagConstraints();
		gbc_panelHighScore.gridwidth = 0;
		gbc_panelHighScore.weightx = 1.0;
		gbc_panelHighScore.weighty = 0.9;
		gbc_panelHighScore.fill = GridBagConstraints.BOTH;
		gbc_panelHighScore.gridx = 0;
		gbc_panelHighScore.gridy = 1;
		add(panelHighScore, gbc_panelHighScore);
		panelHighScore.setLayout(new GridLayout(1, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setOpaque(false);
		scrollPane.setBackground(Color.BLACK);
		scrollPane.setBorder(null);
		panelHighScore.add(scrollPane);

		JPanel panel = new JPanel_withBackdrop();
		//panel.setBackground(Color.BLACK);
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(0, 3, 0, 0));

		lblName_1 = new JLabel("",JLabel.CENTER);
		lblName_1.setForeground(Color.WHITE);
		lblName_1.setOpaque(false);
		lblName_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName_1.setVerticalAlignment(SwingConstants.TOP);
		lblName_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblName_1);

		lblTime_1 = new JLabel("");
		lblTime_1.setForeground(Color.WHITE);
		lblTime_1.setOpaque(false);
		lblTime_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime_1.setVerticalAlignment(SwingConstants.TOP);
		lblTime_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTime_1);

		lblQuestioncount = new JLabel("");
		lblQuestioncount.setForeground(Color.WHITE);
		lblQuestioncount.setOpaque(false);
		lblQuestioncount.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQuestioncount.setVerticalAlignment(SwingConstants.TOP);
		lblQuestioncount.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblQuestioncount);
	}

	//MARK: - Methods
	public void updateHighScoreWindow () {	
		ArrayList<Model_HighScoreEntry> highScoreList = model.getHighScoreEntries();
		String name = "", time = "", count = "";
		for (Model_HighScoreEntry entrie: highScoreList) {
			name += entrie.getName() + "<br>";
			time += entrie.getPlayTime() + "<br>";
			count += entrie.getQuestionIndex() + "<br>";
		}
		lblQuestioncount.setText("<HTML><BODY><div style='text-align: center;'><br>" + count + "</BODY></HTML>");;
		lblTime_1.setText("<HTML><BODY><div style='text-align: center;'><br>" + time + "</BODY></HTML>");;
		lblName_1.setText("<HTML><BODY><div style='text-align: center;'><br>" + name + "</BODY></HTML>");;
	}
	@Override protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(backdrop != null) {
			g.drawImage(backdrop, 0, 0, getWidth(), getHeight(), null);
		}
	}
	private void loadImage() {
		try {
			backdrop = ImageIO.read(new File("data/Status_Backdrop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//MARK: - Inner Classes
	private class JPanel_withBackdrop extends JPanel {

		//MARK: - Assets
		private static final long serialVersionUID = -2444632001588697654L;
		private BufferedImage backdrop;

		//MARK: - Constructor
		JPanel_withBackdrop() {
			super();
			loadImage();
		}

		//MARK: - Methods
		@Override protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			if(backdrop != null) {
				g.drawImage(backdrop, 0, 0, getWidth(), getHeight(), null);
			}
		}
		private void loadImage() {
			try {
				backdrop = ImageIO.read(new File("data/Backdrop.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}