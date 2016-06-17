package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.Timer;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;

public class View_JLabel_withBackgroundImage extends JLabel {

	//MARK: - Assets
	private int imageIndex;
	
	//MARK: - Constructor
	public View_JLabel_withBackgroundImage(int imageIndex) {
		super();
		this.imageIndex = imageIndex;
		this.setForeground(Color.WHITE);
	}
	public View_JLabel_withBackgroundImage() {
		super();
		this.imageIndex = 0;
		this.setForeground(Color.WHITE);
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		switch(this.imageIndex) {
		case 0:
			if(WWMController.imageContainer.backdrop_activated != null) {
				g.drawImage(WWMController.imageContainer.backdrop_activated, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 1: 
			if(WWMController.imageContainer.statusBackdrop != null) {
				g.drawImage(WWMController.imageContainer.statusBackdrop, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 2: 
			if(WWMController.imageContainer.backdrop != null) {
				g.drawImage(WWMController.imageContainer.backdrop, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		default:
			if(WWMController.imageContainer.backdrop_activated != null) {
				g.drawImage(WWMController.imageContainer.backdrop_activated, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		}
		super.paintComponent(g);
	}
}