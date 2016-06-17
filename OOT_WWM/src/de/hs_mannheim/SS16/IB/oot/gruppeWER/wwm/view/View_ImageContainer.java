package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.view;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class View_ImageContainer {
	
	//MARK: - Assets
	public BufferedImage backdrop_activated;
	public BufferedImage backdrop_deactivated;

	public BufferedImage jokerTelephone_activated;
	public BufferedImage jokerTelephone_deactivated;

	public BufferedImage jokerFiftyFifty_activated;
	public BufferedImage jokerFiftyFifty_deactivated;

	public BufferedImage jokerAudience_activated;
	public BufferedImage jokerAudience_deactivated;

	public BufferedImage loggedAnswer;
	public BufferedImage rightAnswer;
	public BufferedImage wrongAnswer;
	public BufferedImage imageDropout;
	
	public BufferedImage backdrop;
	public BufferedImage logo;
	public BufferedImage statusBackdrop;
	
	//MARK: - Constructor
	public View_ImageContainer() {
		loadImages();
	}
	
	//MARK: - Methods
	public void loadImages() {
		try {
			backdrop_activated = ImageIO.read(new File("data/Question_Backdrop_Spaced.png"));
			backdrop_deactivated = ImageIO.read(new File("data/Question_Backdrop_Spaced_Deactivated.png"));

			jokerTelephone_activated = ImageIO.read(new File("data/Joker_Telefon.png"));
			jokerTelephone_deactivated = ImageIO.read(new File("data/Joker_Telefon_Deactivated.png"));

			jokerFiftyFifty_activated = ImageIO.read(new File("data/Joker_50_50.png"));
			jokerFiftyFifty_deactivated = ImageIO.read(new File("data/Joker_50_50_Deactivated.png"));

			jokerAudience_activated = ImageIO.read(new File("data/Joker_Publikum.png"));
			jokerAudience_deactivated = ImageIO.read(new File("data/Joker_Publikum_Deactivated.png"));

			loggedAnswer = ImageIO.read(new File("data/Question_Backdrop_Logged_Spaced.png"));
			rightAnswer = ImageIO.read(new File("data/Question_Backdrop_Right_Spaced.png"));
			wrongAnswer = ImageIO.read(new File("data/Question_Backdrop_Wrong_Spaced.png"));
			imageDropout = ImageIO.read(new File("data/Dropout.png"));

			backdrop = ImageIO.read(new File("data/Backdrop.png"));
			logo =  ImageIO.read(new File("data/WWM_Logo_Spaced.png"));
			statusBackdrop =  ImageIO.read(new File("data/Status_Backdrop.png"));
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}