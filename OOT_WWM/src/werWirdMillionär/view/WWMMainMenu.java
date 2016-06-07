package werWirdMillionär.view;

import javax.swing.JPanel;

import werWirdMillionär.controller.WWMController;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WWMMainMenu extends JPanel {

	/**
	 * Create the panel.
	 */
	public WWMMainMenu(WWMController controller) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {1};
		gridBagLayout.rowHeights = new int[] {0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.0, 1};
		setLayout(gridBagLayout);
		
		JPanel panelMainImage = new JPanel();
		GridBagConstraints gbc_panelMainImage = new GridBagConstraints();
		gbc_panelMainImage.fill = GridBagConstraints.BOTH;
		gbc_panelMainImage.insets = new Insets(0, 0, 5, 0);
		gbc_panelMainImage.gridx = 0;
		gbc_panelMainImage.gridy = 0;
		add(panelMainImage, gbc_panelMainImage);
		
		JPanel panelMainMenuButtons = new JPanel();
		GridBagConstraints gbc_panelMainMenuButtons = new GridBagConstraints();
		gbc_panelMainMenuButtons.anchor = GridBagConstraints.BASELINE;
		gbc_panelMainMenuButtons.fill = GridBagConstraints.BOTH;
		gbc_panelMainMenuButtons.gridx = 0;
		gbc_panelMainMenuButtons.gridy = 2;
		add(panelMainMenuButtons, gbc_panelMainMenuButtons);
		panelMainMenuButtons.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton btnNeuesSpiel = new JButton("Neues Spiel");
		btnNeuesSpiel.setContentAreaFilled(false);
		btnNeuesSpiel.setBorderPainted(false);
		btnNeuesSpiel.addActionListener(controller);
		panelMainMenuButtons.add(btnNeuesSpiel);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setBorderPainted(false);
		btnSpeichern.setContentAreaFilled(false);
		btnSpeichern.addActionListener(controller);
		panelMainMenuButtons.add(btnSpeichern);
		
		JButton btnLaden = new JButton("Laden");
		btnLaden.setContentAreaFilled(false);
		btnLaden.setBorderPainted(false);
		btnLaden.addActionListener(controller);
		panelMainMenuButtons.add(btnLaden);
		
		JButton btnBestenliste = new JButton("Bestenliste");
		btnBestenliste.setContentAreaFilled(false);
		btnBestenliste.setBorderPainted(false);
		btnBestenliste.addActionListener(controller);
		panelMainMenuButtons.add(btnBestenliste);
		
		JButton btnBeenden = new JButton("Beenden");
		btnBeenden.setContentAreaFilled(false);
		btnBeenden.setBorderPainted(false);
		btnBeenden.addActionListener(controller);
		panelMainMenuButtons.add(btnBeenden);

	}

}
