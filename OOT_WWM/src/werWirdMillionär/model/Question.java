package werWirdMillionär.model;

import java.io.Serializable;

public class Question implements Serializable{

	private String question, answer1, answer2, answer3, answer4;
	private int difficultyValue, rightAnswerIndex;
	
	/**
	 * Creates the question
	 * @param question String, the question text
	 * @param answer1 String, first answer
	 * @param answer2 String, second answer
	 * @param answer3 String, third answer
	 * @param answer4 String, fourth answer
	 * @param answerIndex int, index of the right answer (1 to 4)
	 * @param difficultyValue int, difficulty of the question (0 to 2)
	 */
	Question (String question, String answer1, String answer2, String answer3, String answer4, int answerIndex, int difficultyValue) {
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.rightAnswerIndex = answerIndex;
		this.difficultyValue = difficultyValue;
	}
	
	/**
	 * returns the question text
	 * @return
	 */
	public String getQuestionText () {
		return this.question;
	}
	
	/**
	 * return the answer at index
	 * @param index int value, from 1 to 4
	 * @return if index valid the answer or an empty String
	 */
	public String getAnswerAtIndex (int index) {
		switch (index) {
			case 1: return answer1;
			case 2: return answer2;
			case 3: return answer3;
			case 4: return answer4;
			default: return "";
		}
	}
	
	/**
	 * 
	 * @return
	 */
	public int getRightAnswerIndex () {
		return this.rightAnswerIndex;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getDifficultyValue () {
		return this.difficultyValue;
	}
}
