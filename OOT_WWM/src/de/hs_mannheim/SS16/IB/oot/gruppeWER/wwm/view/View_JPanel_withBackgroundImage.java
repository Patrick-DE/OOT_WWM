package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class View_JPanel_withBackgroundImage extends JPanel {

	//MARK: - Assets
	private static final long serialVersionUID = 5017812866844155230L;
	private BufferedImage backdrop;
	private BufferedImage logo;

	private int imageIndex;

	//MARK: - Constructor
	/**
	 * Custom Constructor that allows to set a specified background image
	 * @param label -> Set the button text
	 * @param imageIndex -> Set up a specified background image (index starts at 1, 0 will use the default image)
	 */
	View_JPanel_withBackgroundImage(int imageIndex) {
		super();
		this.imageIndex = imageIndex;

		loadImage();
	}
	View_JPanel_withBackgroundImage() {
		super();
		this.imageIndex = 0;

		loadImage();
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch(this.imageIndex) {
		case 0:
			if(backdrop != null) {
				g.drawImage(backdrop, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 1: 
			if(logo != null) {
				g.drawImage(logo, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		default:
			if(backdrop != null) {
				g.drawImage(backdrop, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		}
	}
	private void loadImage() {
		try {
			backdrop = ImageIO.read(new File("data/Backdrop.png"));
			logo =  ImageIO.read(new File("data/WWM_Logo_Spaced.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}