package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.assets;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class WWMImageContainer {
	
	//MARK: - Assets
	public BufferedImage image_buttonActivated;
	public BufferedImage image_buttonDeactivated;

	public BufferedImage image_jokerTelephoneHover;
	public BufferedImage image_jokerTelephoneActivated;
	public BufferedImage image_jokerTelephoneDeactivated;

	public BufferedImage image_jokerFiftyFiftyHover;
	public BufferedImage image_jokerFiftyFiftyActivated;
	public BufferedImage image_jokerFiftyFiftyDeactivated;

	public BufferedImage image_jokerAudienceHover;
	public BufferedImage image_jokerAudienceActivated;
	public BufferedImage image_jokerAudienceDeactivated;

	public BufferedImage image_buttonHover;
	public BufferedImage image_buttonLogged;
	public BufferedImage image_buttonCorrect;
	public BufferedImage image_buttonWrong;
	public BufferedImage image_ButtonDropoutHover;
	public BufferedImage image_ButtonDropout;
	
	public BufferedImage image_background;
	public BufferedImage image_QuestionWindowBackground;
	public BufferedImage image_wwmBadge;
	public BufferedImage image_buttonSquared;
	public BufferedImage image_blank;
	
	
	//MARK: - Constructor
	public WWMImageContainer() {
		loadImages();
	}
	
	//MARK: - Methods
	private void loadImages() {
		try {
			image_buttonActivated = ImageIO.read(new File("data/images/image_buttonActivated.png"));
			image_buttonDeactivated = ImageIO.read(new File("data/images/image_buttonDeactivated.png"));

			image_jokerTelephoneHover = ImageIO.read(new File("data/images/joker_telephoneHover.png"));
			image_jokerTelephoneActivated = ImageIO.read(new File("data/images/joker_telephoneActivated.png"));
			image_jokerTelephoneDeactivated = ImageIO.read(new File("data/images/joker_telephoneDeactivated.png"));

			image_jokerFiftyFiftyHover = ImageIO.read(new File("data/images/joker_fiftyFiftyHover.png"));
			image_jokerFiftyFiftyActivated = ImageIO.read(new File("data/images/joker_fiftyFiftyActivated.png"));
			image_jokerFiftyFiftyDeactivated = ImageIO.read(new File("data/images/joker_fiftyFiftyDeactivated.png"));

			image_jokerAudienceHover = ImageIO.read(new File("data/images/joker_audienceHover.png"));
			image_jokerAudienceActivated = ImageIO.read(new File("data/images/joker_audienceActivated.png"));
			image_jokerAudienceDeactivated = ImageIO.read(new File("data/images/joker_audienceDeactivated.png"));

			image_buttonHover = ImageIO.read(new File("data/images/image_buttonHover.png"));
			image_buttonLogged = ImageIO.read(new File("data/images/image_buttonLogged.png"));
			image_buttonCorrect = ImageIO.read(new File("data/images/image_buttonCorrect.png"));
			image_buttonWrong = ImageIO.read(new File("data/images/image_buttonWrong.png"));
			image_ButtonDropoutHover = ImageIO.read(new File("data/images/image_buttonDropoutHover.png"));
			image_ButtonDropout = ImageIO.read(new File("data/images/image_buttonDropout.png"));

			image_background = ImageIO.read(new File("data/images/image_background.png"));
			image_QuestionWindowBackground = ImageIO.read(new File("data/images/image_QuestionWindowBackground.png"));
			image_wwmBadge =  ImageIO.read(new File("data/images/image_wwmBadge.png"));
			image_buttonSquared =  ImageIO.read(new File("data/images/image_buttonSquared.png"));
			image_blank =  ImageIO.read(new File("data/images/image_blank.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}