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
	public Clip answerLoggedClip = null;
	public AudioInputStream answerCorrectStream;
	public Clip answerCorrectClip = null;
	public AudioInputStream answerWrongStream;
	public Clip answerWrongClip = null;

	public AudioInputStream jokerStream;
	public Clip jokerClip = null;

	public AudioInputStream musicBackgroundStream;
	public Clip musicBackgroundClip = null;
	public AudioInputStream musicIntroStream;
	public Clip musicIntroClip = null;

	//MARK: - Constructor
	public WWMSoundContainer() {
		loadSounds();
	}

	//MARK: - Methods
	public void playSound(String name) {
		switch(name) {
		case "answerLogged":
			answerLoggedClip.start();
		case "answerWrong":
			answerWrongClip.start();

		case "answerCorrect":
			answerCorrectClip.start();
		case "joker":
			jokerClip.start();
		case "musicBackground":
			musicBackgroundClip.start();
		case "musicIntro":
			musicIntroClip.start();
		}
	}
	public void stopSound(String name) {
		switch(name) {
		case "answerLogged":
			answerLoggedClip.stop();
		case "answerWrong":
			answerWrongClip.stop();

		case "answerCorrect":
			answerCorrectClip.stop();
		case "joker":
			jokerClip.stop();
		case "musicBackground":
			musicBackgroundClip.stop();
		case "musicIntro":
			musicIntroClip.stop();
		}
	}
	private void loadSounds() {
		try {
			answerLoggedStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerLogged.wav")));
			answerCorrectStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerCorrect.wav")));
			answerWrongStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerWrong.wav")));
			

			jokerStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/joker.wav")));
			
			musicBackgroundStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/musicBackground.wav")));
			musicIntroStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/musicIntro.wav")));
			
			answerLoggedClip = AudioSystem.getClip();
			answerLoggedClip.open(answerLoggedStream);
			
			answerCorrectClip = AudioSystem.getClip();
			answerCorrectClip.open(answerCorrectStream);
			
			answerWrongClip = AudioSystem.getClip();
			answerWrongClip.open(answerWrongStream);
			
			jokerClip = AudioSystem.getClip();
			jokerClip.open(jokerStream);
			
			musicBackgroundClip = AudioSystem.getClip();
			musicBackgroundClip.open(musicBackgroundStream);
			
			musicIntroClip = AudioSystem.getClip();
			musicIntroClip.open(musicIntroStream);
			
		}
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}