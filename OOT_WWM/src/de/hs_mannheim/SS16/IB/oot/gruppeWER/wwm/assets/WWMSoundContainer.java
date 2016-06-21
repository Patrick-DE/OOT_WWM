package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.assets;

import java.io.BufferedInputStream;
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
	public void playSound(AudioInputStream stream) {
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
			answerLoggedStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerLogged.wav")));
			answerCorrectStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerCorrect.wav")));
			answerWrongStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerWrong.wav")));
			
			jokerStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/joker.wav")));
			
			backgroundmusicStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/backgroundmusic.wav")));
		}
		catch (IOException | UnsupportedAudioFileException e) {
			e.printStackTrace();
		}
	}
}