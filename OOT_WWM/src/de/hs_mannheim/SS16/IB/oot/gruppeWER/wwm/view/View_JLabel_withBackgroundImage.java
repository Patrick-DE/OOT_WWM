package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JLabel;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;

public class View_JLabel_withBackgroundImage extends JLabel {

	//MARK: - Assets
	private int imageIndex;
	
	//MARK: - Constructor
	public View_JLabel_withBackgroundImage(int imageIndex, String label) {
		super(label);
		this.imageIndex = imageIndex;
		this.setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(24.0f));
	}
	public View_JLabel_withBackgroundImage(int imageIndex) {
		super();
		this.imageIndex = imageIndex;
		this.setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(24.0f));
	}
	public View_JLabel_withBackgroundImage() {
		super();
		this.imageIndex = 0;
		this.setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(24.0f));
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		switch(this.imageIndex) {
		case 0:
			if(WWMController.imageContainer.image_buttonActivated != null) {
				g.drawImage(WWMController.imageContainer.image_buttonActivated, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 1: 
			if(WWMController.imageContainer.image_buttonSquared != null) {
				g.drawImage(WWMController.imageContainer.image_buttonSquared, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 2: 
			if(WWMController.imageContainer.image_background != null) {
				g.drawImage(WWMController.imageContainer.image_background, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 3: 
			if(WWMController.imageContainer.image_blank != null) {
				g.drawImage(WWMController.imageContainer.image_blank, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		default:
			if(WWMController.imageContainer.image_buttonActivated != null) {
				g.drawImage(WWMController.imageContainer.image_buttonActivated, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		}
		super.paintComponent(g);
	}
}