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

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.WWMModel;

public class View_GameInfoPanel extends JPanel {

	//MARK: - Assets
	private WWMModel model;
	private Timer timer;
	private int[] time = {-1,-1};
	private int timeAn;
	private BufferedImage background;
	
	//MARK: - Constructor
	public View_GameInfoPanel(WWMModel model) {
		try {
			background = ImageIO.read(new File("data/questionBar.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.model = model;
		this.setOpaque(false);
	}
	
	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        int w = getWidth();
        int h = getHeight();
//        Color color1 = Color.BLUE;
//        Color color2 = new Color(108,210,232);
//        GradientPaint gp = new GradientPaint(0, 0, color1, 0, h, color2);
//        g2d.setPaint(gp);
//        g2d.fillRect(0, 0, w, h);
        if ( background != null )
        	g2d.drawImage(background, 0, 0, getWidth(), getHeight(), this);
        g2d.setFont(new Font(g.getFont().getName(), Font.PLAIN, 50));
        FontMetrics fm = g2d.getFontMetrics();
        int x = ((getWidth() - fm.stringWidth(model.getPricesAtPos(model.getQuestionIndex()) + "€")) / 2);
        int y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2d.setColor(Color.WHITE);
        g2d.drawString(model.getPricesAtPos(model.getQuestionIndex()) + "€", x, y);
        g2d.setFont(new Font(g.getFont().getName(), Font.PLAIN, 25));
        fm = g2d.getFontMetrics();
        x = (getWidth() / 6 - fm.stringWidth(model.getQuestionIndex() + "/" + model.getAmountOfQuestions()) / 2);
        y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        g2d.drawString(model.getQuestionIndex() + "/" + model.getAmountOfQuestions(), x, y);
        x = (getWidth() - (getWidth() / 6) - fm.stringWidth(time[0] + ":" + (time[1] > 9 ? "" : "0") + time[1]) / 2);
        y = ((getHeight() - fm.getHeight()) / 2) + fm.getAscent();
        if (time[1] < 10)
        	g2d.setColor(Color.RED);
        g2d.drawString(time[0] + ":" + (time[1] > 9 ? "" : "0") + time[1], x, y);
        g2d.setColor(Color.BLACK);
        g2d.dispose();
		super.paintComponent(g);
	}
	private void questionTimerAnimation () {
		timeAn = model.getAnswerTime();
		time[0] = (timeAn / 60);
		time[1] = timeAn - time[0];
		timer = new Timer(1000, new ActionListener() {
			
			@Override public void actionPerformed(ActionEvent e) {
				if (timeAn <= 1)
					timer.stop();
				timeAn -= 1;
				time[0] = (timeAn / 60);
				time[1] = timeAn - time[0];
				repaint();
			}
		});
		timer.start();
	}
	public void animationRestart () {
		if (timer != null && timer.isRunning())
			timer.stop();
		questionTimerAnimation();
	}
}