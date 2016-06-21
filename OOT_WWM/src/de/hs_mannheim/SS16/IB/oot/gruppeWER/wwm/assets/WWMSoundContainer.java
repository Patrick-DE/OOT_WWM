package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.assets;

import java.io.FileInputStream;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class WWMSoundContainer {
	
	//MARK: - Assets
	public AudioInputStream answerLoggedStream;
	public AudioInputStream answerCorrectStream;
	public AudioInputStream answerWrongStream;

	public AudioInputStream jokerStream;
	
	public AudioInputStream backgroundmusicStream;
	
	//MARK: - Constructor
	public WWMSoundContainer() {
		loadSounds();
	}
	
	//MARK: - Methods
	public static void playSound(AudioInputStream stream) {
	        try {
	        	Clip clip = AudioSystem.getClip();
				clip.open(stream);
				clip.start();
			} 
	        catch (LineUnavailableException | IOException e) {
				e.printStackTrace(); 
		}
	}
	private void loadSounds() {
		try {
			answerLoggedStream = AudioSystem.getAudioInputStream(new FileInputStream("data/sounds/answerLogged.mp3"));
			answerCorrectStream = AudioSystem.getAudioInputStream(new FileInputStream("data/sounds/answerCorrect.mp3"));
			answerWrongStream = AudioSystem.getAudioInputStream(new FileInputStream("data/sounds/answerWrong.mp3"));
			
			jokerStream = AudioSystem.getAudioInputStream(new FileInputStream("data/sounds/jokerAudience.mp3"));
			
			backgroundmusicStream = AudioSystem.getAudioInputStream(new FileInputStream("data/sounds/backgroundmusic.mp3"));
		}
		catch (IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
}