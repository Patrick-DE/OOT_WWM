package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;
import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

public class View_JPanel_GameStatus extends JPanel {

	//MARK: - Assets
	private WWMModel model;
	private Timer timer;
	private int[] time = {-1,-1};
	private int timeAn;
	private boolean standardAnimation;

	//MARK: - Constructor
	public View_JPanel_GameStatus(WWMModel model) {
		super();
		setOpaque(false);

		this.model = model;
		this.standardAnimation = true;
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		if(model.getQuestionIndex() < model.getAmountOfQuestions()) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
			int w = getWidth();
			int h = getHeight();
			//        Color color1 = Color.BLUE;
			//        Color color2 = new Color(108,210,232);
			//        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
			//        g2d.setPaint(gp);
			//        g2d.fillRect(0, 0, w, h);
			if (WWMController.imageContainer.image_buttonSquared != null) {
				g2d.drawImage(WWMController.imageContainer.image_buttonSquared, 0, 0, getWidth(), getHeight(), this);
			}

			//Draw the Prize Tier String
			g2d.setFont(new Font(g.getFont().getName(), Font.PLAIN, 45));
			FontMetrics fm = g2d.getFontMetrics();
			//Set Position
			int x = ((getWidth() - fm.stringWidth(model.getPrizesAtPos(model.getQuestionIndex()) + "€")) / 2);
			int y = ((getHeight() - fm.getHeight()) / 3) + fm.getAscent();
			//Set Font Color
			g2d.setColor(Color.WHITE);
			g2d.drawString(model.getPrizesAtPos(model.getQuestionIndex()) + "€", x, y);

			//Draw the Security Tier String
			g2d.setFont(new Font(g.getFont().getName(), Font.PLAIN, 20));
			fm = g2d.getFontMetrics();		
			//Set Position
			x = ((getWidth() - fm.stringWidth(model.generatePrizeAtSecurityTier() + "€")) / 2);
			y = ((int)((getHeight() - fm.getHeight()) / 1.15)) + fm.getAscent();
			//Set Font Color
			g2d.setColor(Color.ORANGE);
			g2d.drawString(model.generatePrizeAtSecurityTier() + "€", x, y);

			//Draw the Question Tier String
			g2d.setFont(new Font(g.getFont().getName(), Font.PLAIN, 25));
			fm = g2d.getFontMetrics();
			//Set Position
			x = (getWidth() / 6 - fm.stringWidth(model.getQuestionIndex() + "/" + model.getAmountOfQuestions()) / 2);
			y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
			//Set Font Color
			g2d.setColor(Color.WHITE);
			g2d.drawString(model.getQuestionIndex() + "/" + model.getAmountOfQuestions(), x, y);

			//Draw Countdown String
			//Set Position
			x = (getWidth() - (getWidth() / 6) - fm.stringWidth(time[0] + ":" + (time[1] > 9 ? "" : "0") + time[1]) / 2);
			y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
			//Set Font Color
			if(time[1] <= 10 && this.standardAnimation) {
				g2d.setColor(Color.RED);
			}
			else if(!this.standardAnimation) {
				g2d.setColor(Color.ORANGE);
			}
			g2d.drawString(time[0] + ":" + (time[1] > 9 ? "" : "0") + time[1], x, y);
			g2d.setColor(Color.BLACK);
			g2d.dispose();
			super.paintComponent(g);
		}
	}
	private void questionTimerAnimation(boolean standardAnimation) {
		if(standardAnimation) {
			timeAn = model.getAnswerTime();
		}
		else {
			timeAn = 2;
		}
		time[0] = (timeAn / 60);
		time[1] = timeAn - time[0];
		timer = new Timer(1000, new ActionListener() {
			@Override public void actionPerformed(ActionEvent e) {
				if (timeAn <= 1) {
					timer.stop();
				}
				timeAn -= 1;
				time[0] = (timeAn / 60);
				time[1] = timeAn - time[0];
				repaint();
			}
		});
		timer.start();
	}
	public void animationRestart(boolean standardAnimation) {
		this.standardAnimation = standardAnimation;
		if (timer != null && timer.isRunning()) {
			timer.stop();
		}
		questionTimerAnimation(standardAnimation);
	}
}