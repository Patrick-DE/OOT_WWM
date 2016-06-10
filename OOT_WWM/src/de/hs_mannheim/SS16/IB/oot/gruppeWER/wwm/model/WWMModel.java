package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Observable;
import java.util.Timer;
import java.util.TimerTask;

public class WWMModel extends Observable {

	//MARK: - Assets
	private ArrayList<Model_Question> questions;
	private ArrayList<Integer> prices;
	private ArrayList<Model_HighScoreEntry> highScoreEntries;
	private Model_Joker fiftyFifty = new Model_JokerFiftyFifty();
	private	Model_Joker audience = new Model_JokerAudience();
	private Model_Joker telephone = new Model_JokerTelephone();
	private int questionIndex = -1;
	private int questionAnswerTimeInSeconds = 30;
	private int gameQuestionAmount = 15;
	private Timer questionTimer;

	private long startTime, gameTimeAlreadyRunning = 0, gameEndTime;
	
	private boolean gameStart = false, gameEnd = false, gameEndFalseAnswer = false, gameEndRightAnswer = false;

	//MARK: - Constructor
	public WWMModel() {
		loadMainData();
	}

	//MARK: - Methods
	/**
	 * Loads the main data (prices and high score entry)
	 */
	public void loadMainData() {
		highScoreEntries = new ArrayList<Model_HighScoreEntry>();
		prices = new ArrayList<Integer>();
		BufferedReader bufferedIS;
		try {
			if (new File("data/highscore.dat").exists()) {
				ObjectInputStream objectIS;
				objectIS = new ObjectInputStream(new FileInputStream("data/highscore.dat"));
				highScoreEntries = (ArrayList<Model_HighScoreEntry>) objectIS.readObject();
				objectIS.close();
			}
			bufferedIS = new BufferedReader(new InputStreamReader(new FileInputStream("data/prices.dat"), "UTF8"));
			while (bufferedIS.ready())
				prices.add(new Integer(Integer.parseInt(bufferedIS.readLine())));
			bufferedIS.close();
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * loads the question from the question files
	 * @param path String the file path of the jar- (normal "")
	 */
	public void setQuestionsFromFile() {
		startTime = System.currentTimeMillis();
		questions = new ArrayList<Model_Question>();
		ArrayList<Model_Question> questionsEasy = new ArrayList<Model_Question>(), questionsMiddle = new ArrayList<Model_Question>(),
				questionsHard = new ArrayList<Model_Question>();
		BufferedReader fileReader;

		try {
			fileReader = new BufferedReader(
					new InputStreamReader(new FileInputStream("data/fragenEinfach.dat"), "UTF8"));
			while (fileReader.ready())
				questionsEasy.add(new Model_Question(fileReader.readLine(), fileReader.readLine(), fileReader.readLine(),
						fileReader.readLine(), fileReader.readLine(), Integer.parseInt(fileReader.readLine()), 0));
			fileReader.close();
			fileReader = new BufferedReader(
					new InputStreamReader(new FileInputStream("data/fragenMittel.dat"), "UTF8"));
			while (fileReader.ready())
				questionsMiddle.add(new Model_Question(fileReader.readLine(), fileReader.readLine(), fileReader.readLine(),
						fileReader.readLine(), fileReader.readLine(), Integer.parseInt(fileReader.readLine()), 1));
			fileReader.close();
			fileReader = new BufferedReader(
					new InputStreamReader(new FileInputStream("data/fragenSchwer.dat"), "UTF8"));
			while (fileReader.ready())
				questionsHard.add(new Model_Question(fileReader.readLine(), fileReader.readLine(), fileReader.readLine(),
						fileReader.readLine(), fileReader.readLine(), Integer.parseInt(fileReader.readLine()), 2));
			fileReader.close();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		Collections.shuffle(questionsEasy);
		Collections.shuffle(questionsMiddle);
		Collections.shuffle(questionsHard);
		for (int i = 0; i < 5; i++) {
			questions.add(questionsEasy.get(i));
		}
		for (int i = 0; i < 5; i++) {
			questions.add(questionsMiddle.get(i));
		}
		for (int i = 0; i < 5; i++) {
			questions.add(questionsHard.get(i));
		}
		game();
		setChanged();
		notifyObservers();
	}
	public void loadQuestionsFromSaveGame(int loadIndex) {
		if ( questionTimer != null)
			questionTimer.cancel();
		try {
			ObjectInputStream loadInput = new ObjectInputStream(
					new FileInputStream("save/game" + loadIndex + ".wwm"));
			questions = (ArrayList<Model_Question>) loadInput.readObject();
			if (questions == null)
				setQuestionsFromFile();
			questionIndex = (int) loadInput.readInt();
			questionIndex = (questionIndex == -2) ? -1 : questionIndex;
			gameTimeAlreadyRunning = (long) loadInput.readLong();
			fiftyFifty.setStatus(loadInput.readBoolean());
			audience.setStatus(loadInput.readBoolean());
			telephone.setStatus(loadInput.readBoolean());
			loadInput.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		gameStart = true;
		gameEnd = false;
		gameEndFalseAnswer = false;
		gameEndRightAnswer = false;
		game();
		setChanged();
		notifyObservers();
	}
	/**
	 * Datei: 1. Fragen 2. Frageindex 3. Zeit 4. 50/50 Status 5. Publikum Status
	 * 6. Telefon Status
	 * 
	 * @param path
	 * @param saveIndex
	 */
	public void saveToFile(String path, int saveIndex) {
		try {
			ObjectOutputStream saveOutput = new ObjectOutputStream(
					new FileOutputStream(path + "save/game" + saveIndex + ".wwm"));
			saveOutput.writeObject(questions);
			saveOutput.writeInt(questionIndex - 1);
			saveOutput.writeLong(getGameTime());
			saveOutput.writeBoolean(fiftyFifty.getStatus());
			saveOutput.writeBoolean(audience.getStatus());
			saveOutput.writeBoolean(telephone.getStatus());
			saveOutput.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Model_Question getQuestionAtIndex(int index) {
		return questions.get(index);
	}
	public int[] getAudienceJokerResults(Model_Question question) {
		if (audience.getStatus())
			return null;
		audience.setStatus(true);
		return ((Model_JokerAudience) audience).getAudienceResults(question);
	}
	public int[] getFiftyFiftyJokerResults(Model_Question question) {
		if (fiftyFifty.getStatus())
			return null;
		fiftyFifty.setStatus(true);
		return ((Model_JokerFiftyFifty) fiftyFifty).getFalseAnswerPositions(question);
	}
	public String[] getTelephoneJokerResults(Model_Question question) {
		if (telephone.getStatus())
			return null;
		telephone.setStatus(true);
		return ((Model_JokerTelephone) telephone).getTelephonAnswer(question);
	}
	public boolean getFiftyFiftyStatus () {
		return fiftyFifty.getStatus();
	}
	public boolean getTelephoneStatus () {
		return telephone.getStatus();
	}
	public boolean getAudienceStatus () {
		return audience.getStatus();
	}
	public int getQuestionIndex() {
		return questionIndex;
	}
	public void validateAnswer(int answerIndex) {
		if (questionTimer != null)
			questionTimer.cancel();
		if (answerIndex == questions.get(questionIndex).getRightAnswerIndex()) {
			game();
		} else {
			calculateGameRunningTime();
			gameEndFalseAnswer = true;
			setChanged();
			notifyObservers();
		}
	}
	public boolean gameStarted() {
		return this.gameStart;
	}
	public void game() {
		gameStart = true;
		questionIndex++;
		if (questionIndex < gameQuestionAmount) {
			questionTimer = new Timer();
			questionTimer.schedule(new TimerTask() {

				@Override
				public void run() {
					gameEndFalseAnswer = true;
					calculateGameRunningTime();
					setChanged();
					notifyObservers();
				}
			}, questionAnswerTimeInSeconds * 1000);
			setChanged();
			notifyObservers();
		} else {
			gameEndRightAnswer = true;
			calculateGameRunningTime();
			setChanged();
			notifyObservers();
		}
	}
	public boolean getGameFinishedStatus() {
		if (gameEndRightAnswer || gameEndFalseAnswer)
			return true;
		return false;
	}
	public int getAnswerTime() {
		return this.questionAnswerTimeInSeconds;
	}
	private void calculateGameRunningTime() {
		this.gameEndTime = gameTimeAlreadyRunning + ((System.currentTimeMillis() - this.startTime) / 1000);
	}
	public long getGameTime() {
		return gameEndTime;
	}

	public int getPricesAtPos(int index) {
		return prices.get(index);
	}
	public int getAmountOfQuestions() {
		return gameQuestionAmount;
	}
	public void highScoreAddEntrie(String name, int timeInSeconds) {
		gameStart = false;
		highScoreEntries.add(new Model_HighScoreEntry(name, questionIndex, timeInSeconds));
		Collections.sort(highScoreEntries);
		try {
			ObjectOutputStream objectOS = new ObjectOutputStream(new FileOutputStream("data/highscore.dat"));
			objectOS.writeObject(highScoreEntries);
			objectOS.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		setChanged();
		notifyObservers();
	}
	public ArrayList<Model_HighScoreEntry> getHighScoreEntries() {
		return highScoreEntries;
	}
	public void setGameEnd() {
		gameEndRightAnswer = true;
		calculateGameRunningTime();
		setChanged();
		notifyObservers();
	}
	public int getPrice() {
		if (questionIndex < 4)
			return 0;
		else if (questionIndex < 9)
			return 500;
		else if (questionIndex < 15)
			return 16000;
		else
			return 1000000;
	}
	public void gameRestart() {
		if ( questionTimer != null)
			questionTimer.cancel();
		resetAudienceJoker();
		resetFiftyFiftyJoker();
		resetTelephoneJoker();
		gameEndFalseAnswer = false;
		gameStart = false;
		gameEndRightAnswer = false;
		gameEnd = false;
		loadMainData();
		questionIndex = -1;
		setQuestionsFromFile();
	}
	private void resetTelephoneJoker () {
		this.telephone.setStatus(false);
	}
	private void resetAudienceJoker () {
		this.audience.setStatus(false);
	}
	private void resetFiftyFiftyJoker () {
		this.fiftyFifty.setStatus(false);
	}
	public boolean getGameEndFalseAnswer () {
		return this.gameEndFalseAnswer;
	}
}