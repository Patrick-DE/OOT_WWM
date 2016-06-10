package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

public class Model_JokerTelephone extends Model_Joker {

	//MARK: - Methods
	public String[] getTelephonAnswer (Model_Question question) {
		String[] telefonAnswer = new String[1];
		telefonAnswer[0] += "Mir deucht die Antwort sei \"" + question.getQuestionText() + "\" denke Ich dass die Antwort: \"";
		int rightAnswerPos = 0;
		if (question.getDifficultyValue() == 0) {
			rightAnswerPos = (int)  Math.round(0.4 + Math.random()*0.6);
		} else if (question.getDifficultyValue() == 1)
			rightAnswerPos = (int)  Math.round(0.2 + Math.random()*0.5);
		else if (question.getDifficultyValue() == 2)
			rightAnswerPos = (int) Math.round(Math.random()*0.55);
		String answer = "";
		if (rightAnswerPos == 1) {
			switch (question.getRightAnswerIndex()) {
			case 1:
				answer = question.getAnswerAtIndex(1);
				break;
			case 2:
				answer = question.getAnswerAtIndex(2);
				break;
			case 3:
				answer = question.getAnswerAtIndex(3);
				break;
			case 4:
				answer = question.getAnswerAtIndex(4);
				break;
			}
		} else {
			String[] answerArray = {question.getAnswerAtIndex(1), question.getAnswerAtIndex(2), question.getAnswerAtIndex(3), question.getAnswerAtIndex(4)};
			answer = answerArray[(int) Math.random()*4];
		}
		telefonAnswer[0] += answer;
		return telefonAnswer;
	}
}