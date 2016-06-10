package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

public class Model_JokerAudience extends Model_Joker {

	//MARK: - Methods
	public int[] getAudienceResults(Model_Question question) {
		int[] audienceResults = new int[4];
		if (question.getDifficultyValue() == 0)
			audienceResults[question.getRightAnswerIndex() - 1] = 65 + (int) (Math.random() * 20);
		else if (question.getDifficultyValue() == 1)
			audienceResults[question.getRightAnswerIndex() - 1] = 45 + (int) (Math.random() * 20);
		else
			audienceResults[question.getRightAnswerIndex() - 1] = 25 + (int) (Math.random() * 20);
		int perLess = 100 - audienceResults[question.getRightAnswerIndex() - 1];
		int perAll = 0;
		for (int i = 0; i < audienceResults.length; i++) {
			if (i != (question.getRightAnswerIndex() - 1) && (i != audienceResults.length - 1)) {
				audienceResults[i] = (int) (Math.random() * (perLess));
				perLess -= audienceResults[i];
			} else if (i == audienceResults.length - 1 && i != (question.getRightAnswerIndex() - 1)) {
				audienceResults[i] = perLess;
				perLess -= audienceResults[i];
			} else if ((question.getRightAnswerIndex() - 1) == 3 && i == 2) {
				audienceResults[i] = perLess;
				perLess -= audienceResults[i];
			}
			perAll += audienceResults[i];
		}
		if (perAll < 100) {
			for (int i = audienceResults.length - 1; i >= 0; i--) {
				if (i != question.getRightAnswerIndex() - 1) {
					audienceResults[i] += 100 - perAll;
					break;
				}
			}
		}
		return audienceResults;
	}
}