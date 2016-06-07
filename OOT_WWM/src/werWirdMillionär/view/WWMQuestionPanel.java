package werWirdMillionär.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.GridLayout;

public class WWMQuestionPanel extends JLabel {

	private double widthI;
	private int step = 0;
	private Timer timer;
	private int seconds;
	
	/**
	 * Create the panel.
	 */
	public WWMQuestionPanel(int seconds) {
		this.seconds = seconds- 1;		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, (int) (step++ * widthI), (int) this.getHeight());
		super.paintComponent(g);
	}
	
	private void timeAnimtion (int seconds) {
		step = 0;
		widthI = getWidth() / (double) ((seconds * 1000) / 50);
		if (widthI <= 0)
			return;
		timer = new Timer(50, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
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
		timeAnimtion(seconds);
	}
	
	
	
	

}
