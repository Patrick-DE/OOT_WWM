package de.hs_mannheim.SS16.IB.oot.gruppeWER.test;
import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model.*;

public class BackEndTesting {
	WWMModel testing;

	@Before
	public void setUp(){
		testing = new WWMModel();
	}

	@Test
	public void testLoadMainData() {
		int[] prizes = { 50, 100, 200, 300, 500, 1000, 2000, 4000, 8000, 16000, 32000, 64000, 125000, 500000, 1000000};
		// The former highscore file gets deleted, so that proper testing is possible!
		if (new File("C:\\Users\\Simon.Simon-PC\\git\\OOT_WWM\\OOT_WWM\\data\\highscore.dat").exists()) {
			try {
				Runtime.getRuntime().exec("cmd cd C:\\Users\\Simon.Simon-PC\\git\\OOT_WWM\\OOT_WWM\\data\\");
				Runtime.getRuntime().exec("cmd del " + "highscore.dat" );
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// Tests whether loadMainData reads the prizes correctly from the provided file saved in the workspace
		for (int i = 0; i < 15; i++) {
			assertEquals(prizes[i], testing.getPrizesAtPos(i));
		}
		testing.highScoreAddEntry("Simon", 10);
		testing.loadMainData();
		// Tests whether the HighScoreEntries are read correctly from a file
		ArrayList<Model_HighScoreEntry> highScoreEntries = testing.getHighScoreEntries();
		Model_HighScoreEntry myHighscore = highScoreEntries.get(0);
		assertEquals("Simon", myHighscore.getName());
		assertEquals(10, myHighscore.getPlayTime());
		assertEquals(-1, myHighscore.getQuestionIndex());

	}

	@Test
	public void testLoadQuestionsFromFile() {
		testing.loadQuestionsFromFile();
		// From index 0 to 4 the questions should be classified as easy(difficulty 0), from 5 to 9 as moderate(1) and from 10 to 14 as hard(2)
		Model_Question question;
		for(int i = 0; i < 15; i++){
			question= testing.getQuestionAtIndex(i);
			if(i < 5)
				assertEquals(0,question.getDifficultyValue());
			else if(i < 10)
				assertEquals(1,question.getDifficultyValue());
			else{
				assertEquals(2,question.getDifficultyValue());
			}

		}

	}
	@Test 
	public void testSaveGameandLoadSaveGame(){
		testing.loadQuestionsFromFile();
		// fifty fifty Joker is used
		testing.generateFiftyFiftyJokerResults(testing.getQuestionAtIndex(0));
		// Folder necessary to save the game is created
		File createFolder = new File("E:\\save");
		createFolder.mkdirs();
		testing.saveGameToFile("E:\\", 0);
		File file = new File("E:\\save\\game0.wwm");
		// Testing whether the file has been created properly by method saveGameToFile
		assertTrue(file.isFile());
		if(file.exists()) {
			testing.loadQuestionsFromSaveGame(0);
			// verifying whether jokers' status is loaded correctly by method loadQuestionsFromSaveGame
			for(int i = 0; i < 3; i++){
				if(i == 0)
					assertTrue(testing.getAllJokerStatus()[i]);
				else
					assertFalse(testing.getAllJokerStatus()[i]);

			}
			// question index has to equal 0 since it was incremented once from -1 when loadQuestionsFromSaveGame was invoked
			assertEquals(0,testing.getQuestionIndex());
		}

	}
	@Test 
	public void testRunGame(){
		testing.runGame();
		// Game status should be set to started(true)
		assertTrue(testing.getGameStartedStatus());
		// The answer time should still be 30 seconds
		assertEquals(30,testing.getAnswerTime());

	}
	@Test
	public void testRestartGame(){
		testing.loadQuestionsFromFile();
		// all jokers used --> status set to used true
		testing.generateAudienceJokerResults(testing.getQuestionAtIndex(0));
		testing.generateFiftyFiftyJokerResults(testing.getQuestionAtIndex(0));
		testing.generateTelephoneJokerResults(testing.getQuestionAtIndex(0));
		testing.restartGame();
		// all jokers should be reset to the status of not being used yet
		for(int i = 0; i < 3; i++){
			assertFalse(testing.getAllJokerStatus()[i]);
		}
		// the question index should be at 0 as it is reset to -1, but then incremented since the restartGameMethod calls runGame which increments it
		assertEquals(0,testing.getQuestionIndex());
		//the game should not have ended yet
		assertFalse(testing.getGameFinishedStatus());
	}
	@Test
	public void testDropOut(){
		testing.loadQuestionsFromFile();
		testing.dropOut();
		// When the user decides to end the game, the gameFinishedStatus should be set to true
		assertTrue(testing.getGameFinishedStatus());	
	}
	@Test 
	public void testValidateAnswer(){
		testing.loadQuestionsFromFile();
		int rightAnswerIndex = testing.getCorrectAnswerIndex();
		// if correct answer is logged in, the game should continue
		// the gameFinishedStatus should be false therefore
		testing.validateAnswer(rightAnswerIndex);
		assertFalse(testing.getGameFinishedStatus());
		// correct answer index from next question
		rightAnswerIndex = testing.getCorrectAnswerIndex();
		int falseAnswerIndex;
		if(rightAnswerIndex == 0)
			falseAnswerIndex = 1;
		else
			falseAnswerIndex = rightAnswerIndex-1;
		// if the false Answer is logged in, the game has to end --> the GameFinishedStatus should be true
		testing.validateAnswer(falseAnswerIndex);
		assertTrue(testing.getGameFinishedStatus());
	}
	@Test 
	public void testGenerateAudienceJokerResults(){
		testing.loadQuestionsFromFile();
		int[] results = testing.generateAudienceJokerResults(testing.getQuestionAtIndex(0));
		int percentage = 0;
		for(int i = 0; i < results.length; i++){
			percentage += results[i];
		}
		// percentage has to equal 100 since the whole audience is to be asked
		assertEquals(100,percentage);
		// try the same thing when 50/50 Joker was used beforehand
		testing.restartGame();
		int[] resultsFiftyFifty = testing.generateFiftyFiftyJokerResults(testing.getQuestionAtIndex(1));
		results = testing.generateAudienceJokerResults(testing.getQuestionAtIndex(1));
		percentage = 0;
		for(int i = 0; i < results.length; i++){
			if(i != resultsFiftyFifty[0]-1 && i != resultsFiftyFifty[1]-1 )
				percentage += results[i];		
		}
		assertEquals(100,percentage);
		// Audience joker has been used --> status has to be set to true
		assertTrue(testing.getAudienceStatus());
	}
	@Test
	public void testGenerateFiftyFiftyJokerResults(){
		testing.loadQuestionsFromFile();
		int rightAnswerIndex;
		int[] falseAnswerPositions;
		// Verify whether generateFiftyFiftyJokerResults returns array which does not contain rightAnswerIndex
		for(int i = 0; i < 5; i++){
			rightAnswerIndex = testing.getQuestionAtIndex(i).getRightAnswerIndex();
			falseAnswerPositions = testing.generateFiftyFiftyJokerResults(testing.getQuestionAtIndex(i));
			for(int j = 0; j < falseAnswerPositions.length; j++){
				assertFalse(rightAnswerIndex == falseAnswerPositions[j]);
			}
		}

	}
	@Test
	public void testGenerateTelephoneJoker(){
		testing.loadQuestionsFromFile();
		// only tests whether the status was set to true and whether the reult of the method is not null cause the results is completely reliant on chance and therefore not testable
		assertNotNull(testing.generateTelephoneJokerResults(testing.getQuestionAtIndex(0)));
		assertTrue(testing.getTelephoneStatus());
		testing.restartGame();
		testing.loadQuestionsFromFile();
		// if 50/50 Joker was used before
		testing.generateFiftyFiftyJokerResults(testing.getQuestionAtIndex(1));
		assertNotNull(testing.generateTelephoneJokerResults(testing.getQuestionAtIndex(1)));
	}

	// Other jokers classes are equivalent and would throw NullPointerException as well
	@Test(expected = NullPointerException.class)
	public void testNullPointer(){
		testing.generateAudienceJokerResults(null);
	}


}
