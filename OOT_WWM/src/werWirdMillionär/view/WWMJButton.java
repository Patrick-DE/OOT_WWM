package werWirdMillionär.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import javax.swing.JButton;

public class WWMJButton extends JButton {

	private Shape shape;
	
	WWMJButton (String label) {
		super(label);
		Dimension size = getPreferredSize();
		size.width = size.height = Math.max(size.width, size.height);
		setPreferredSize(size);
		setContentAreaFilled(false);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		if (getModel().isArmed()) {
	           g.setColor(Color.BLUE);
	     } else {
	          g.setColor(getBackground());
	     }
		g.fillRect((int)getSize().getWidth() / 6, (int) (getSize().getHeight() / 4), (int) ((getSize().getWidth() * 2)/ 3), (int) (getSize().getHeight() / 2));
		g.fillArc(0, 0, getSize().width, getSize().height, -45, 90);
		g.fillArc(0, 0, getSize().width, getSize().height, 135, 90);
		super.paintComponent(g);
	}
	
	@Override
	protected void paintBorder(Graphics g) {
		g.setColor(new Color(192, 192, 192));
		g.fillRect((int)getSize().getWidth() / 6, (int) (getSize().getHeight() / 4), (int) ((getSize().getWidth() * 2)/ 3), (int) (getSize().getHeight() / 2));
		g.fillArc(0, 0, getSize().width, getSize().height, -45, 90);
		g.fillArc(0, 0, getSize().width, getSize().height, 135, 90);
		g.setColor(Color.BLACK);
		super.paintBorder(g);
	}
	
	@Override
	public boolean contains(int x, int y) {
		if (shape == null || !shape.getBounds().equals(getBounds())) {
	          shape = new Ellipse2D.Float(0, 0, getWidth(), getHeight());
	     }
	     return shape.contains(x, y);
	}
}
