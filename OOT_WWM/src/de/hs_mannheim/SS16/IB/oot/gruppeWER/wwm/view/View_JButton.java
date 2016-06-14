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
	
	//MARK: - Constructor
	View_JButton(String label) {
		super(label);
		setContentAreaFilled(false);
		setBorderPainted(false);
		loadImage();
		setForeground(Color.WHITE);
	}
	View_JButton() {
		super();
		setContentAreaFilled(false);
		setBorderPainted(false);
		loadImage();
		setForeground(Color.WHITE);
	}
	View_JButton(Icon icon) {
		super(icon);
		setContentAreaFilled(false);
		setBorderPainted(false);
	}
	
	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		if ( imageActivated != null && isEnabled() )
			g.drawImage(imageActivated, 0, 0, getWidth(), getHeight(), this);
		else if (imageDeactivated != null && !isEnabled() )
			g.drawImage(imageDeactivated, 0, 0, getWidth(), getHeight(), this);
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
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}