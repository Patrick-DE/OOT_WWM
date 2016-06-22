package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.controller.WWMController;

public class View_JButton_withBackgroundImage extends JButton implements MouseListener {

	//MARK: - Assets
	private static final long serialVersionUID = 945286255842321281L;

	private int imageIndex;

	//MARK: - Constructor
	/**
	 * Custom Constructor that allows to set a specified background image
	 * @param label -> Set the button text
	 * @param imageIndex -> Set up a specified background image (index starts at 1, 0 will use the default image)
	 */
	View_JButton_withBackgroundImage(String label, int imageIndex) {
		super(label);
		this.addMouseListener(this);
		this.imageIndex = imageIndex;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(20.0f));
	}
	/**
	 * Custom Constructor that allows to set a specified background image
	 * @param imageIndex -> Set up a specified background image (index starts at 1, 0 will use the default image)
	 */
	View_JButton_withBackgroundImage(int imageIndex) {
		super();
		this.addMouseListener(this);
		this.imageIndex = imageIndex;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(22.0f));
	}
	View_JButton_withBackgroundImage(String label) {
		super(label);
		this.addMouseListener(this);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(22.0f));
	}
	View_JButton_withBackgroundImage() {
		super();
		this.addMouseListener(this);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		setForeground(Color.WHITE);
		this.setFont(this.getFont().deriveFont(22.0f));
	}
	View_JButton_withBackgroundImage(Icon icon) {
		super(icon);
		this.addMouseListener(this);
		this.imageIndex = 0;

		setContentAreaFilled(false);
		setBorderPainted(false);
		this.setFont(this.getFont().deriveFont(22.0f));
	}

	//MARK: - Methods
	@Override protected void paintComponent(Graphics g) {
		switch(this.imageIndex) {
		case 0:
			if(WWMController.imageContainer.image_buttonActivated != null && WWMController.imageContainer.image_buttonDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_buttonActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_buttonDeactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 1:
			if(WWMController.imageContainer.image_buttonLogged != null) {
				g.drawImage(WWMController.imageContainer.image_buttonLogged, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 2:
			if(WWMController.imageContainer.image_buttonCorrect != null) {
				g.drawImage(WWMController.imageContainer.image_buttonCorrect, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 3:
			if(WWMController.imageContainer.image_buttonWrong != null) {
				g.drawImage(WWMController.imageContainer.image_buttonWrong, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 4:
			if(WWMController.imageContainer.image_jokerTelephoneActivated != null && WWMController.imageContainer.image_jokerTelephoneDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_jokerTelephoneActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_jokerTelephoneDeactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 5:
			if(WWMController.imageContainer.image_jokerFiftyFiftyActivated != null && WWMController.imageContainer.image_jokerFiftyFiftyDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_jokerFiftyFiftyActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_jokerFiftyFiftyDeactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 6:
			if(WWMController.imageContainer.image_jokerAudienceActivated != null && WWMController.imageContainer.image_jokerAudienceDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_jokerAudienceActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_jokerAudienceDeactivated, 0, 0, getWidth(), getHeight(), this);
				}
			}
			break;
		case 7:
			if(WWMController.imageContainer.image_ButtonDropout != null) {
				g.drawImage(WWMController.imageContainer.image_ButtonDropout, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 8:
			if(WWMController.imageContainer.image_background != null) {
				g.drawImage(WWMController.imageContainer.image_background, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 9:
			if(WWMController.imageContainer.image_blank != null) {
				g.drawImage(WWMController.imageContainer.image_blank, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		case 10:
			if(WWMController.imageContainer.image_buttonHover != null) {
				g.drawImage(WWMController.imageContainer.image_buttonHover, 0, 0, getWidth(), getHeight(), this);
			}
			break;
		default:
			if(WWMController.imageContainer.image_buttonActivated != null && WWMController.imageContainer.image_buttonDeactivated != null) {
				if (isEnabled()) {
					g.drawImage(WWMController.imageContainer.image_buttonActivated, 0, 0, getWidth(), getHeight(), this);
				}
				else {
					g.drawImage(WWMController.imageContainer.image_buttonDeactivated, 0, 0, getWidth(), getHeight(), this);
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
	public void changeImageIndex(int newImageIndex) {
		this.imageIndex = newImageIndex;
	}
	@Override public void mouseClicked(MouseEvent e) {		
	}
	@Override public void mousePressed(MouseEvent e) {		
	}
	@Override public void mouseReleased(MouseEvent e) {	
	}
	@Override public void mouseEntered(MouseEvent e) {
		if(((View_JButton_withBackgroundImage)e.getComponent()).isEnabled() && ((View_JButton_withBackgroundImage)e.getComponent()).imageIndex == 0) {
			((View_JButton_withBackgroundImage)e.getComponent()).changeImageIndex(10);
			((View_JButton_withBackgroundImage)e.getComponent()).repaint();
		}
	}
	@Override public void mouseExited(MouseEvent e) {
		if(((View_JButton_withBackgroundImage)e.getComponent()).isEnabled() && ((View_JButton_withBackgroundImage)e.getComponent()).imageIndex == 10) {
			((View_JButton_withBackgroundImage)e.getComponent()).changeImageIndex(0);
			((View_JButton_withBackgroundImage)e.getComponent()).repaint();
		}
	}
}