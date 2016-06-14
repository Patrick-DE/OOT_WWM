package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class View_JPanel extends JPanel {
	
	//MARK: - Assets
	private static final long serialVersionUID = -6088012016107912859L;
	private BufferedImage backdrop;
	
	//MARK: - Constructor
	View_JPanel() {
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
			backdrop = ImageIO.read(new File("data/WWM_Logo_Spaced.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}