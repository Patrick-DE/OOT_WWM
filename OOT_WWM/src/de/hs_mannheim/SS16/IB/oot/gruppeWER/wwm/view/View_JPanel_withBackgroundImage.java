package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;

public class View_JPanel_withBackgroundImage extends JPanel {

	//MARK: - Assets
	private static final long serialVersionUID = 5017812866844155230L;

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
	}
	View_JPanel_withBackgroundImage() {
		super();
		this.imageIndex = 0;
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		switch(this.imageIndex) {
		case 0:
			if(WWMController.imageContainer.image_background != null) {
				g.drawImage(WWMController.imageContainer.image_background, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 1: 
			if(WWMController.imageContainer.image_wwmBadge != null) {
				g.drawImage(WWMController.imageContainer.image_wwmBadge, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 2: 
			if(WWMController.imageContainer.image_buttonSquared != null) {
				g.drawImage(WWMController.imageContainer.image_buttonSquared, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		default:
			if(WWMController.imageContainer.image_background != null) {
				g.drawImage(WWMController.imageContainer.image_background, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		}
	}
}