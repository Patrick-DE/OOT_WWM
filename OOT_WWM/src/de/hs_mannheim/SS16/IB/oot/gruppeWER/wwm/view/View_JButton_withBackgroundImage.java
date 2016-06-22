package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
		this.setFont(this.getFont().deriveFont(20.0f));
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
		this.setFont(this.getFont().deriveFont(22.0f));
	}
	View_JButton_withBackgroundImage(String label) {
		super(label);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(22.0f));
	}
	View_JButton_withBackgroundImage() {
		super();
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(22.0f));
	}
	View_JButton_withBackgroundImage(Icon icon) {
		super(icon);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		this.setFont(this.getFont().deriveFont(22.0f));
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		switch(this.imageIndex) {
		case 0:
			if(WWMController.imageContainer.image_buttonActivated != null && WWMController.imageContainer.image_buttonDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_buttonActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_buttonDeactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 1:
			if(WWMController.imageContainer.image_buttonLogged != null) {
				g.drawImage(WWMController.imageContainer.image_buttonLogged, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 2:
			if(WWMController.imageContainer.image_buttonCorrect != null) {
				g.drawImage(WWMController.imageContainer.image_buttonCorrect, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 3:
			if(WWMController.imageContainer.image_buttonWrong != null) {
				g.drawImage(WWMController.imageContainer.image_buttonWrong, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 4:
			if(WWMController.imageContainer.image_jokerTelephoneActivated != null && WWMController.imageContainer.image_jokerTelephoneDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_jokerTelephoneActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_jokerTelephoneDeactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 5:
			if(WWMController.imageContainer.image_jokerFiftyFiftyActivated != null && WWMController.imageContainer.image_jokerFiftyFiftyDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_jokerFiftyFiftyActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_jokerFiftyFiftyDeactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 6:
			if(WWMController.imageContainer.image_jokerAudienceActivated != null && WWMController.imageContainer.image_jokerAudienceDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_jokerAudienceActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_jokerAudienceDeactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 7:
			if(WWMController.imageContainer.image_ButtonDropout != null) {
				g.drawImage(WWMController.imageContainer.image_ButtonDropout, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 8:
			if(WWMController.imageContainer.image_background != null) {
				g.drawImage(WWMController.imageContainer.image_background, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 9:
			if(WWMController.imageContainer.image_blank != null) {
				g.drawImage(WWMController.imageContainer.image_blank, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		default:
			if(WWMController.imageContainer.image_buttonActivated != null && WWMController.imageContainer.image_buttonDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_buttonActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_buttonDeactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		}
		Graphics2D g2D = (Graphics2D) g;
		g2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		super.paintComponent(g2D);
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