package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

public class Model_JokerTelephone extends Model_Joker {

    //MARK: - Methods
    public String getTelephonAnswer (Model_Question question, int[] fiftyFiftyValues) {
        boolean knowsRightAnswer = false; // determines if Joker knows right answer or not
        boolean readyToGiveAnswer = false;
        String[][] possibleAnswers = {
                {
                    "Das ist doch sowas von klar. Die Antwort ist ",
                    "Das ist einfach. Die Antwort ist ",
                    "Wie können Sie das nicht wissen! Diesen Gefallen tue ich Ihnen sicher nicht.",
                    "Sorry. Bin gerade beschäftigt."
                },
                {
                    "Hm. Ich denke es ist ",
                    "Ich tippe auf ",
                    "Keinen Anschluss unter dieser Nummer.",
                    "Keine Ahnung."
                },
                {
                    "Sehr schwierige Frage. Ich tippe auf, ",
                    "Ich bin mir nicht sicher. Aber wenn ich raten würde, würde ich diese Antwort nehmen: ",
                    "Puh. Tut mir Leid. Keine Ahnung.",
                    "Joa."
                }
                };
        
        String telephoneAnswer = "";
        
        if ((int) (100 * Math.random()) < 50)
            readyToGiveAnswer = true;
        else
            readyToGiveAnswer = false;
        
        if (question.getDifficultyValue() == 0) {
            if ((int) (100 * Math.random()) < 75)
                knowsRightAnswer = true;
            else
                knowsRightAnswer = false;

            if (readyToGiveAnswer)
                telephoneAnswer = possibleAnswers[0][(int) (Math.random() * possibleAnswers[0].length / 2)];
            else
                telephoneAnswer = possibleAnswers[0][possibleAnswers[0].length / 2 + (int) (Math.random() * possibleAnswers[0].length / 2)];

        } else if (question.getDifficultyValue() == 1) {
            if ((int) (100 * Math.random()) < 50)
                knowsRightAnswer = true;
            else
                knowsRightAnswer = false;
            
            if (readyToGiveAnswer)
                telephoneAnswer = possibleAnswers[1][(int) (Math.random() * possibleAnswers[1].length / 2)];
            else
                telephoneAnswer = possibleAnswers[1][possibleAnswers[1].length / 2 + (int) (Math.random() * possibleAnswers[1].length / 2)];

        } else if (question.getDifficultyValue() == 2) {
            if ((int) (100 * Math.random()) < 30)
                knowsRightAnswer = true;
            else
                knowsRightAnswer = false;
            
            if (readyToGiveAnswer)
                telephoneAnswer = possibleAnswers[2][(int) (Math.random() * possibleAnswers[0].length / 2)];
            else
                telephoneAnswer = possibleAnswers[2][possibleAnswers[2].length / 2 + (int) (Math.random() * possibleAnswers[2].length / 2)];
        }
        
        if (readyToGiveAnswer) {
            if (knowsRightAnswer)
                telephoneAnswer += question.getAnswerAtIndex(question.getRightAnswerIndex());
            else {
                String[] answerArray = {question.getAnswerAtIndex(1), question.getAnswerAtIndex(2), question.getAnswerAtIndex(3), question.getAnswerAtIndex(4)};
                int i;
                if (fiftyFiftyValues != null) {
                    answerArray[fiftyFiftyValues[0] - 1] = null;
                    answerArray[fiftyFiftyValues[1] - 1] = null;
                }
                
                do {
                    i = (int) (Math.random() * answerArray.length);
                } while (i == question.getRightAnswerIndex() - 1 && answerArray[i] == null);
                
                telephoneAnswer += answerArray[i];
            }
        }
            
        return telephoneAnswer;
    }
}