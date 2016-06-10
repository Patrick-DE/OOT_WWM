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

public class View_JButton extends JButton {

	//MARK: - Assets
	private BufferedImage image, imageDe;
	
	//MARK: - Constructor
	View_JButton (String label) {
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
		if ( image != null && isEnabled() )
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
		else if (imageDe != null && !isEnabled() )
			g.drawImage(imageDe, 0, 0, getWidth(), getHeight(), this);
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
			image = ImageIO.read(new File("data/questionBar.png"));
			imageDe = ImageIO.read(new File("data/questionBarDe.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}