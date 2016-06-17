package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;

public class View_JButton_withBackgroundImage extends JButton {

	//MARK: - Assets
	private static final long serialVersionUID = 945286255842321281L;

	private int imageIndex;

	//MARK: - Constructor
	/**
	 * Custom Constructor that allows to set a specified background image
	 * @param label -> Set the button text
	 * @param imageIndex -> Set up a specified background image (index starts at 1, 0 will use the default image)
	 */
	View_JButton_withBackgroundImage(String label, int imageIndex) {
		super(label);
		this.imageIndex = imageIndex;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
	}
	/**
	 * Custom Constructor that allows to set a specified background image
	 * @param imageIndex -> Set up a specified background image (index starts at 1, 0 will use the default image)
	 */
	View_JButton_withBackgroundImage(int imageIndex) {
		super();
		this.imageIndex = imageIndex;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
	}
	View_JButton_withBackgroundImage(String label) {
		super(label);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
	}
	View_JButton_withBackgroundImage() {
		super();
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
	}
	View_JButton_withBackgroundImage(Icon icon) {
		super(icon);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		switch(this.imageIndex) {
		case 0:
			if(WWMController.imageContainer.backdrop_activated != null && WWMController.imageContainer.backdrop_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.backdrop_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.backdrop_deactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 1:
			if(WWMController.imageContainer.loggedAnswer != null) {
				g.drawImage(WWMController.imageContainer.loggedAnswer, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 2:
			if(WWMController.imageContainer.rightAnswer != null) {
				g.drawImage(WWMController.imageContainer.rightAnswer, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 3:
			if(WWMController.imageContainer.wrongAnswer != null) {
				g.drawImage(WWMController.imageContainer.wrongAnswer, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 4:
			if(WWMController.imageContainer.jokerTelephone_activated != null && WWMController.imageContainer.jokerTelephone_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.jokerTelephone_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.jokerTelephone_deactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 5:
			if(WWMController.imageContainer.jokerFiftyFifty_activated != null && WWMController.imageContainer.jokerFiftyFifty_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.jokerFiftyFifty_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.jokerFiftyFifty_deactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 6:
			if(WWMController.imageContainer.jokerAudience_activated != null && WWMController.imageContainer.jokerAudience_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.jokerAudience_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.jokerAudience_deactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 7:
			if(WWMController.imageContainer.imageDropout != null) {
				g.drawImage(WWMController.imageContainer.imageDropout, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		default:
			if(WWMController.imageContainer.backdrop_activated != null && WWMController.imageContainer.backdrop_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.backdrop_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.backdrop_deactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		}
		super.paintComponent(g);
	}
	@Override protected void paintBorder(Graphics g) {
		super.paintBorder(g);
	}
	@Override public boolean contains(int x, int y) {
		return super.contains(x, y);
	}
	public void changeImageIndex(int newImageIndex) {
		this.imageIndex = newImageIndex;
	}
}