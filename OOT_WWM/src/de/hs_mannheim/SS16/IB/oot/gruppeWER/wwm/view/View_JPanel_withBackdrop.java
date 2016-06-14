package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class View_JPanel_withBackdrop extends JPanel {

	//MARK: - Assets
	private static final long serialVersionUID = 5017812866844155230L;
	private BufferedImage backdrop;

	//MARK: - Constructor
	View_JPanel_withBackdrop() {
		super();
		loadImage();
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(backdrop != null) {
			g.drawImage(backdrop, 0, 0, getWidth(), getHeight(), null);
		}
	}
	private void loadImage() {
		try {
			backdrop = ImageIO.read(new File("data/Backdrop.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}