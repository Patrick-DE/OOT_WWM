package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

/**
 * 
 * @author Anusan Ranjan
 * this class models the telephone joker
 */
public class Model_JokerTelephone extends Model_Joker {

	//MARK: - Methods
	/**
	 * this method models the telephone Joker. It can return a response with a possibly right answer or refuse to help
	 * @param question
	 *                 the current question
	 * @param fiftyFiftyValues
	 *                         the values of the fiftyFiftyJoker, if it was used. Otherwise null.
	 * @return a String containing the answer of the telephoneJoker.
	 */
	public String getTelephoneAnswer (Model_Question question, int[] fiftyFiftyValues) {
		boolean knowsRightAnswer = false; // determines if Joker knows right answer or not
		boolean readyToGiveAnswer = false; // determines, if Joker makes stupid comment or not
		String[] dataPaths = {
				"data/telephone_joker_data/telephoneEasyGivesAnswer.dat", 
				"data/telephone_joker_data/telephoneMiddleGivesAnswer.dat",
				"data/telephone_joker_data/telephoneHardGivesAnswer.dat",
				"data/telephone_joker_data/telephoneEasyDoesntGiveAnswer.dat",
				"data/telephone_joker_data/telephoneMiddleDoesntGiveAnswer.dat",
				"data/telephone_joker_data/telephoneHardDoesntGiveAnswer.dat"
		};
		String[/*Gives Answer or Not*/][/*Question difficulty*/][/*texts*/] possibleAnswers = new String[2][3][];

		// sets possibleAnswers with correct data from dataPaths
		int dataPathsIndex = 0;
		for (int i = 0; i < possibleAnswers.length; i++) {
			for (int j = 0; j < possibleAnswers[i].length; j++) {
				try {
					BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(dataPaths[dataPathsIndex]), "UTF8"));

					// find out array length
					int length = 0;
					while(reader.ready()) {
						reader.readLine();
						length++;
					}
					reader.close();

					// set answers with length and fill
					String[] answers = new String[length];
					reader = new BufferedReader(
							new InputStreamReader(new FileInputStream(dataPaths[dataPathsIndex++]), "UTF8"));
					int index = 0;
					while(reader.ready()) {
						answers[index++] = reader.readLine();
					}
					possibleAnswers[i][j] = answers;
				} 
				catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} 
				catch (FileNotFoundException e) {
					e.printStackTrace();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		String telephoneAnswer = "";

		if((int) (100 * Math.random()) < 90) {
			readyToGiveAnswer = true;
		}
		else {
			readyToGiveAnswer = false;
		}

		// sets telephoneAnswer with an answer based on difficulty value of current question
		if(question.getDifficultyValue() == 0) {
			if((int) (100 * Math.random()) < 75) {
				knowsRightAnswer = true;
			}
			else {
				knowsRightAnswer = false;
			}
			if(readyToGiveAnswer) {
				telephoneAnswer = possibleAnswers[0][0][(int) (Math.random() * possibleAnswers[0][0].length)];
			}
			else {
				telephoneAnswer = possibleAnswers[1][0][(int) (Math.random() * possibleAnswers[1][0].length)];
			}
		} 
		else if(question.getDifficultyValue() == 1) {
			if((int) (100 * Math.random()) < 50) {
				knowsRightAnswer = true;
			}
			else {
				knowsRightAnswer = false;
			}  
			if(readyToGiveAnswer) {
				telephoneAnswer = possibleAnswers[0][1][(int) (Math.random() * possibleAnswers[0][1].length)];
			}
			else {
				telephoneAnswer = possibleAnswers[1][1][(int) (Math.random() * possibleAnswers[1][1].length)];
			}
		} 
		else if (question.getDifficultyValue() == 2) {
			if ((int) (100 * Math.random()) < 30) {
				knowsRightAnswer = true;
			}
			else {
				knowsRightAnswer = false;
			}

			if (readyToGiveAnswer) {
				telephoneAnswer = possibleAnswers[0][2][(int) (Math.random() * possibleAnswers[0][2].length)];
			}
			else {
				telephoneAnswer = possibleAnswers[1][2][(int) (Math.random() * possibleAnswers[1][2].length)];
			}
		}  
		if(readyToGiveAnswer) {
			if(knowsRightAnswer) {
				telephoneAnswer = replaceMarker(telephoneAnswer, question.getAnswerAtIndex(question.getRightAnswerIndex()));
			} else {
				//Set wrong answer
				String[] answerArray = {question.getAnswerAtIndex(1), question.getAnswerAtIndex(2), question.getAnswerAtIndex(3), question.getAnswerAtIndex(4)};
				int i;
				//Handle fiftyFiftyJoker
				if(fiftyFiftyValues != null) {
					answerArray[fiftyFiftyValues[0] - 1] = null;
					answerArray[fiftyFiftyValues[1] - 1] = null;
				}
				do {
					i = (int) (Math.random() * answerArray.length);
				} while (i == question.getRightAnswerIndex() - 1 || answerArray[i] == null);

				telephoneAnswer = replaceMarker(telephoneAnswer, answerArray[i]);
			}
		}     
		return telephoneAnswer;
	}

	/**
	 * this method replaces the sub String "(ANTWORT)" with the replacement from stringWithMarker.
	 * @param stringWithMarker
	 *                         the String, which can contain the sub String "(ANTWORT)"
	 * @param replacement
	 *                    the String, which will replace  the String "(ANTWORT)"
	 * @return the String with the replacement. If String did not contain the sub String "(ANTWORT)" stringWithMarker will be returned.
	 */
    private String replaceMarker(String stringWithMarker, String replacement) {
        // marker := (ANTWORT)
        String marker = "(ANTWORT)";
        int i = findIndexOfMarker(stringWithMarker);
        if (i != -1) {
            if (i == 0)
                return replacement + stringWithMarker.substring(i + marker.length(), stringWithMarker.length());
            else
                return stringWithMarker.substring(0, i) + replacement + stringWithMarker.substring(i + marker.length() , stringWithMarker.length());
        } else {
            return stringWithMarker;
        }
    }

    /**
     * this method iterates the string and looks for the subString "(ANTWORT)" and returns the first index where the sub String was found 
     * @param stringWithMarker
     *                         String to be iterated
     * @return the first index where "ANTWORT" was found. -1, if String does not not contain this sub String
     */
    private int findIndexOfMarker(String stringWithMarker) {
        String marker = "(ANTWORT)";
        if (stringWithMarker.length() < marker.length()) {
            return -1;
        } else {
            for (int i = 0; i <= stringWithMarker.length() - marker.length(); i++) {
                if (stringWithMarker.substring(i, i + marker.length()).equals(marker))
                    return i;
            }
        return -1;
        }
    }
}