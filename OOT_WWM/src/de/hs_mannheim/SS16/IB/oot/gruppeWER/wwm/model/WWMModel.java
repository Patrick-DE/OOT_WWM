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
	private ArrayList<Integer> prizes;
	private ArrayList<Model_HighScoreEntry> highScoreEntries;
	private Model_Joker fiftyFifty = new Model_JokerFiftyFifty();
	private	Model_Joker audience = new Model_JokerAudience();
	private Model_Joker telephone = new Model_JokerTelephone();
	private int questionIndex = -1;
	private int questionAnswerTimeInSeconds = 30;
	private int gameQuestionAmount = 15;
	private Timer questionTimer;

	private long startTime;
	private long saveGamePlayTime = 0;
	private long gameEndTime;

	private boolean gameStart = false;
	private boolean gameEndFalseAnswer = false;
	private boolean gameEndRightAnswer = false;

	//MARK: - Constructor
	public WWMModel() {
		loadMainData();
	}

	//MARK: - Methods
	/**
	 * Loads the main data (prizes and high score entry)
	 */
	public void loadMainData() {
		highScoreEntries = new ArrayList<Model_HighScoreEntry>();
		prizes = new ArrayList<Integer>();
		BufferedReader bufferedIS;
		try {
			if (new File("data/highscore.dat").exists()) {
				ObjectInputStream objectIS;
				objectIS = new ObjectInputStream(new FileInputStream("data/highscore.dat"));
				highScoreEntries = (ArrayList<Model_HighScoreEntry>) objectIS.readObject();
				objectIS.close();
			}
			bufferedIS = new BufferedReader(new InputStreamReader(new FileInputStream("data/prizes.dat"), "UTF8"));
			while (bufferedIS.ready()) {
				prizes.add(new Integer(Integer.parseInt(bufferedIS.readLine())));
			}
			bufferedIS.close();
		} 
		catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	/**
	 * Loads the question from the question files
	 * @param path String the file path of the jar- (normal "")
	 */
	public void loadQuestionsFromFile() {
		startTime = System.currentTimeMillis();
		questions = new ArrayList<Model_Question>();
		ArrayList<Model_Question> questionsEasy = new ArrayList<Model_Question>();
		ArrayList<Model_Question> questionsMiddle = new ArrayList<Model_Question>();
		ArrayList<Model_Question> questionsHard = new ArrayList<Model_Question>();
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
		runGame();
		setChanged();
		notifyObservers();
	}
	/**
	 * Loads the questions from the save game if the user continues from a saved game
	 * @param loadIndex -> Specifies the save game that is loaded
	 */
	public void loadQuestionsFromSaveGame(int loadIndex) {
		if (questionTimer != null) {
			questionTimer.cancel();
		}
		try {
			ObjectInputStream loadInput = new ObjectInputStream(
					new FileInputStream("save/game" + loadIndex + ".wwm"));
			questions = (ArrayList<Model_Question>) loadInput.readObject();
			if (questions == null)
				loadQuestionsFromFile();
			questionIndex = (int) loadInput.readInt();
			questionIndex = (questionIndex == -2) ? -1 : questionIndex;
			saveGamePlayTime = (long) loadInput.readLong();
			fiftyFifty.setStatus(loadInput.readBoolean());
			audience.setStatus(loadInput.readBoolean());
			telephone.setStatus(loadInput.readBoolean());
			loadInput.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		startTime = System.currentTimeMillis();
		gameStart = true;
		gameEndFalseAnswer = false;
		gameEndRightAnswer = false;
		runGame();
		setChanged();
		notifyObservers();
	}
	/**
	 * Runs the game logic per Question
	 * Method will be called for each Question
	 */
	public void runGame() {
		gameStart = true;
		questionIndex++;
		if (questionIndex < gameQuestionAmount) {
			questionTimer = new Timer();
			questionTimer.schedule(new TimerTask() {
				@Override public void run() {
					gameEndFalseAnswer = true;
					calculateGameRunningTime();
					setChanged();
					notifyObservers();
				}
			}, questionAnswerTimeInSeconds * 1000);
			setChanged();
			notifyObservers();
		} 
		else {
			gameEndRightAnswer = true;
			calculateGameRunningTime();
			setChanged();
			notifyObservers();
		}
	}
	/**
	 * Performs the necessary action when the user selects "new game" from the main menu while a game is running in the background
	 */
	public void restartGame() {
		if (questionTimer != null) {
			questionTimer.cancel();
		}
		resetAudienceJoker();
		resetFiftyFiftyJoker();
		resetTelephoneJoker();
		gameStart = false;
		gameEndRightAnswer = false;
		gameEndFalseAnswer = false;
		loadMainData();
		questionIndex = -1;
		loadQuestionsFromFile();
	}
	/**
	 * Let's the user claim his prize and finish the game and go to the main menu
	 */
	public void dropOut() {
		gameEndRightAnswer = true;
		questionTimer.cancel();
		calculateGameRunningTime();
		setChanged();
		notifyObservers();
	}
	/**
	 * Let's the user save the game and go to the main menu
	 * Datei: 1. Fragen 2. Frageindex 3. Zeit 4. 50/50 Status 5. Publikum Status
	 * 6. Telefon Status
	 * 
	 * @param path
	 * @param saveIndex
	 */
	public void saveGameToFile(String path, int saveIndex) {
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

	//MARK: - Helper Methods
	public void logInAnswer(int answerIndex) {
		//Run timer to allow for the chosen answer to be logged before it is validated 
		questionTimer.cancel();
		questionTimer = new Timer();
		questionTimer.schedule(new TimerTask() {
			@Override public void run() {
				validateAnswer(answerIndex);
			}
		}, 5 * 1000);
	}
	public void validateAnswer(int answerIndex) {
		questionTimer.cancel();
		if (answerIndex == questions.get(questionIndex).getRightAnswerIndex()) {
			runGame();
		} 
		else {
			calculateGameRunningTime();
			gameEndFalseAnswer = true;
			setChanged();
			notifyObservers();
		}
	}
	public int getCorrectAnswerIndex() {
		return questions.get(questionIndex).getRightAnswerIndex();
	}
	public int[] generateAudienceJokerResults(Model_Question question) {
		if (audience.getStatus())
			return null;
		audience.setStatus(true);
		if (!fiftyFifty.getStatus())
			return ((Model_JokerAudience) audience).getAudienceResults(question, null);
		else
			return ((Model_JokerAudience) audience).getAudienceResults(question, generateFiftyFiftyJokerResults(question));
	}
	public int[] generateFiftyFiftyJokerResults(Model_Question question) {
		fiftyFifty.setStatus(true);
		return ((Model_JokerFiftyFifty) fiftyFifty).getFalseAnswerPositions(question);
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
	public String[] generateTelephoneJokerResults(Model_Question question) {
		if (telephone.getStatus())
			return null;
		telephone.setStatus(true);
		return ((Model_JokerTelephone) telephone).getTelephonAnswer(question);
	}
	private void calculateGameRunningTime() {
		this.gameEndTime = saveGamePlayTime + ((System.currentTimeMillis() - this.startTime) / 1000);
	}
	public void highScoreAddEntry(String name, int timeInSeconds) {
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
	public int generatePrize() {
		if (questionIndex < 4)
			return 0;
		else if (questionIndex < 9)
			return 500;
		else if (questionIndex < 15)
			return 16000;
		else
			return 1000000;
	}

	//MARK: - Getter and Setter Methods
	public boolean getGameStartedStatus() {
		return this.gameStart;
	}
	public boolean getGameFinishedStatus() {
		if (gameEndRightAnswer || gameEndFalseAnswer) {
			questionTimer.cancel();
			return true;
		}
		else {
			return false;
		}
	}
	public boolean getGameEndFalseAnswer () {
		return this.gameEndFalseAnswer;
	}
	public int getAnswerTime() {
		return this.questionAnswerTimeInSeconds;
	}
	public int getQuestionIndex() {
		return questionIndex;
	}
	public Model_Question getQuestionAtIndex(int index) {
		return questions.get(index);
	}
	public long getGameTime() {
		return gameEndTime;
	}
	public int getAmountOfQuestions() {
		return gameQuestionAmount;
	}
	public int getPrizesAtPos(int index) {
		return prizes.get(index);
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
}