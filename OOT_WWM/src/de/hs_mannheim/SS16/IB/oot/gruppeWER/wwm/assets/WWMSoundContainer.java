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
	public Clip answerLoggedClip;
	public AudioInputStream answerCorrectStream;
	public Clip answerCorrectClip;
	public AudioInputStream answerWrongStream;
	public Clip answerWrongClip;

	public AudioInputStream jokerStream;
	public Clip jokerClip;

	public AudioInputStream musicBackgroundStream;
	public Clip musicBackgroundClip;
	public AudioInputStream musicIntroStream;
	public Clip musicIntroClip;

	//MARK: - Constructor
	public WWMSoundContainer() {
		loadSounds();
	}

	//MARK: - Methods
	public void playSound(String name) {
		switch(name) {
		case "answerLogged":
			this.reloadClip("answerLogged");
			answerLoggedClip.start();
			break;
		case "answerWrong":
			this.reloadClip("answerWrong");
			answerWrongClip.start();
			break;
		case "answerCorrect":
			this.reloadClip("answerCorrect");
			answerCorrectClip.start();
			break;
		case "joker":
			this.reloadClip("joker");
			jokerClip.start();
			break;
		case "musicBackground":
			this.reloadClip("musicBackground");
			musicBackgroundClip.start();
			break;
		case "musicIntro":
			this.reloadClip("musicIntro");
			musicIntroClip.start();
			break;
		}
	}
	public void loopSound(String name) {
		switch(name) {
		case "answerLogged":
			answerLoggedClip.loop(100);
			break;
		case "answerWrong":
			answerWrongClip.loop(100);
			break;
		case "answerCorrect":
			answerCorrectClip.loop(100);
			break;
		case "joker":
			jokerClip.start();
			break;
		case "musicBackground":
			musicBackgroundClip.loop(100);
			break;
		case "musicIntro":
			musicIntroClip.loop(100);
			break;
		}
	}
	public void stopSound(String name) {
		switch(name) {
		case "answerLogged":
			answerLoggedClip.stop();
			break;
		case "answerWrong":
			answerWrongClip.stop();
			break;
		case "answerCorrect":
			answerCorrectClip.stop();
			break;
		case "joker":
			jokerClip.stop();
			break;
		case "musicBackground":
			musicBackgroundClip.stop();
			break;
		case "musicIntro":
			musicIntroClip.stop();
			break;
		}
	}
	private void reloadClip(String name) {
		try {
			switch(name) {
			case "answerLogged":
				answerLoggedStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerLogged.wav")));
				answerLoggedClip = AudioSystem.getClip();
				answerLoggedClip.open(answerLoggedStream);
				break;
			case "answerWrong":
				answerWrongStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerWrong.wav")));
				answerWrongClip = AudioSystem.getClip();
				answerWrongClip.open(answerWrongStream);
				break;
			case "answerCorrect":
				answerCorrectStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerCorrect.wav")));
				answerCorrectClip = AudioSystem.getClip();
				answerCorrectClip.open(answerCorrectStream);
				break;
			case "joker":
				jokerStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/joker.wav")));
				jokerClip = AudioSystem.getClip();
				jokerClip.open(jokerStream);
				break;
			case "musicBackground":
				musicBackgroundStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/musicBackground.wav")));
				musicBackgroundClip = AudioSystem.getClip();
				musicBackgroundClip.open(musicBackgroundStream);
				break;
			case "musicIntro":
				musicIntroStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/musicIntro.wav")));
				musicIntroClip = AudioSystem.getClip();
				musicIntroClip.open(musicIntroStream);
				break;
			}
		}
		catch (IOException | UnsupportedAudioFileException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
	private void loadSounds() {
		try {
			answerLoggedStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerLogged.wav")));
			answerWrongStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerWrong.wav")));
			answerCorrectStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/answerCorrect.wav")));
			
			jokerStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/joker.wav")));

			musicBackgroundStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/musicBackground.wav")));
			musicIntroStream = AudioSystem.getAudioInputStream(new BufferedInputStream(new FileInputStream("data/sounds/musicIntro.wav")));

			answerLoggedClip = AudioSystem.getClip();
			answerLoggedClip.open(answerLoggedStream);

			answerWrongClip = AudioSystem.getClip();
			answerWrongClip.open(answerWrongStream);

			answerCorrectClip = AudioSystem.getClip();
			answerCorrectClip.open(answerCorrectStream);

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