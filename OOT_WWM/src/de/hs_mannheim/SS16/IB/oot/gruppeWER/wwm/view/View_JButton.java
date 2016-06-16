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

public class View_JButton extends JButton {

	//MARK: - Assets
	private static final long serialVersionUID = 945286255842321281L;
	private BufferedImage imageActivated;
	private BufferedImage imageDeactivated;
	private BufferedImage loggedAnswer;
	private BufferedImage rightAnswer;
	private BufferedImage wrongAnswer;

	private int imageIndex;

	//MARK: - Constructor
	/**
	 * Custom Constructor that allows to set a specified background image
	 * @param label -> Set the button text
	 * @param imageIndex -> Set up a specified background image (index starts at 1, 0 will use the default image)
	 */
	View_JButton(String label, int imageIndex) {
		super(label);
		this.imageIndex = imageIndex;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);

		loadImage();
	}
	View_JButton(String label) {
		super(label);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);

		loadImage();
	}
	View_JButton() {
		super();
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);

		loadImage();
	}
	View_JButton(Icon icon) {
		super(icon);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		if (isEnabled()) {
			switch(this.imageIndex) {
			case 0:
				if(imageActivated != null) {
					g.drawImage(imageActivated, 0, 0, getWidth(), getHeight(), this);
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
			default:
				if(imageActivated != null) {
					g.drawImage(imageActivated, 0, 0, getWidth(), getHeight(), this);
				}
				break;
			}
		}
		else if (imageDeactivated != null && !isEnabled()) {
			g.drawImage(imageDeactivated, 0, 0, getWidth(), getHeight(), this);
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
			imageActivated = ImageIO.read(new File("data/Question_Backdrop_Spaced.png"));
			imageDeactivated = ImageIO.read(new File("data/Question_Backdrop_Spaced_Deactivated.png"));
			loggedAnswer = ImageIO.read(new File("data/Question_Backdrop_Logged_Spaced.png"));
			rightAnswer = ImageIO.read(new File("data/Question_Backdrop_Right_Spaced.png"));
			wrongAnswer = ImageIO.read(new File("data/Question_Backdrop_Wrong_Spaced.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}