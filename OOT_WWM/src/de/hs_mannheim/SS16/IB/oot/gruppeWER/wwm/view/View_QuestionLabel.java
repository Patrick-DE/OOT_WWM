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

public class View_QuestionLabel extends JLabel {

	//MARK: - Assets
	private double widthI;
	private int step = 0;
	private Timer timer;
	private int seconds, modus;
	private BufferedImage backGround;
	
	//MARK: - Constructor
	public View_QuestionLabel(int questionSeconds, int modus) {
		this.setOpaque(false);
		this.modus = modus;
		this.seconds = questionSeconds - 2;
		try {
			backGround = ImageIO.read(new File("data/Question_Backdrop_Spaced.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if ( modus == 1)
			this.setForeground(Color.WHITE);
		addComponentListener(new ComponentAdapter() {
			@Override public void componentResized(ComponentEvent e) {
				widthI = getWidth() / (double) ((seconds * 1000) / 50);
				super.componentResized(e);
			}
		});
	}
	
	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		if (modus == 0) {
		if (step * widthI < getWidth() / 3)
			g.setColor(Color.GREEN);
		else if (step * widthI < (getWidth() * 2) / 3)
			g.setColor(Color.YELLOW);
		else
			g.setColor(Color.RED);
		g.fillRect(0, 0, (int) (step++ * widthI), (int) this.getHeight());
		} else {
			if ( backGround != null )
				g.drawImage(backGround, 0, 0, getWidth(), getHeight(), this);
		}
		super.paintComponent(g);
	}
	private void timeAnimation (int seconds) {
		step = 0;
		widthI = getWidth() / (double) ((seconds * 1000) / 50);
		if (widthI <= 0)
			return;
		timer = new Timer(50, new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				if (step * widthI > getWidth())
					timer.stop();
				repaint();
			}
		});
		timer.start();
	}
	public void animationRestart () {
		if (timer != null && timer.isRunning())
			timer.stop();
		timeAnimation(seconds);
	}
}