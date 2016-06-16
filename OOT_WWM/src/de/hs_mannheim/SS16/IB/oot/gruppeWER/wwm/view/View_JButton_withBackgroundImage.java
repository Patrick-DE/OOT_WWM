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
	private BufferedImage backdrop_activated;
	private BufferedImage backdrop_deactivated;
	
	private BufferedImage jokerTelephone_activated;
	private BufferedImage jokerTelephone_deactivated;
	
	private BufferedImage jokerFiftyFifty_activated;
	private BufferedImage jokerFiftyFifty_deactivated;
	
	private BufferedImage jokerAudience_activated;
	private BufferedImage jokerAudience_deactivated;
	
	private BufferedImage loggedAnswer;
	private BufferedImage rightAnswer;
	private BufferedImage wrongAnswer;
	
	private BufferedImage imageDropout;

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

		loadImage();
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

		loadImage();
	}
	View_JButton_withBackgroundImage(String label) {
		super(label);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);

		loadImage();
	}
	View_JButton_withBackgroundImage() {
		super();
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);

		loadImage();
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
			if(backdrop_activated != null && backdrop_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(backdrop_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(backdrop_deactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 1:
			if(loggedAnswer != null) {
				g.drawImage(loggedAnswer, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 2:
			if(rightAnswer != null) {
				g.drawImage(rightAnswer, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 3:
			if(wrongAnswer != null) {
				g.drawImage(wrongAnswer, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 4:
			if(jokerTelephone_activated != null && jokerTelephone_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(jokerTelephone_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(jokerTelephone_deactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 5:
			if(jokerFiftyFifty_activated != null && jokerFiftyFifty_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(jokerFiftyFifty_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(jokerFiftyFifty_deactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 6:
			if(jokerAudience_activated != null && jokerAudience_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(jokerAudience_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(jokerAudience_deactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 7:
			if(imageDropout != null) {
				g.drawImage(imageDropout, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		default:
			if(backdrop_activated != null && backdrop_deactivated != null) {
				if (isEnabled()) {
					g.drawImage(backdrop_activated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(backdrop_deactivated, 0, 0, getWidth(), getHeight(), this);
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
	private void loadImage() {
		try {
			backdrop_activated = ImageIO.read(new File("data/Question_Backdrop_Spaced.png"));
			backdrop_deactivated = ImageIO.read(new File("data/Question_Backdrop_Spaced_Deactivated.png"));
			
			jokerTelephone_activated = ImageIO.read(new File("data/Joker_Telefon.png"));
			jokerTelephone_deactivated = ImageIO.read(new File("data/Joker_Telefon_Deactivated.png"));
			
			jokerFiftyFifty_activated = ImageIO.read(new File("data/Joker_50_50.png"));
			jokerFiftyFifty_deactivated = ImageIO.read(new File("data/Joker_50_50_Deactivated.png"));
			
			jokerAudience_activated = ImageIO.read(new File("data/Joker_Publikum.png"));
			jokerAudience_deactivated = ImageIO.read(new File("data/Joker_Publikum_Deactivated.png"));
			
			loggedAnswer = ImageIO.read(new File("data/Question_Backdrop_Logged_Spaced.png"));
			rightAnswer = ImageIO.read(new File("data/Question_Backdrop_Right_Spaced.png"));
			wrongAnswer = ImageIO.read(new File("data/Question_Backdrop_Wrong_Spaced.png"));
			imageDropout = ImageIO.read(new File("data/Dropout.png"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void changeImageIndex(int newImageIndex) {
		this.imageIndex = newImageIndex;
	}
}