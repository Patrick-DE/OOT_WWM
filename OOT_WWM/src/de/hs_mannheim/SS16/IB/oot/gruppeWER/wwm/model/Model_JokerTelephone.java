package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

public class Model_JokerTelephone extends Model_Joker {

    //MARK: - Methods
    public String getTelephonAnswer (Model_Question question, int[] fiftyFiftyValues) {
        boolean knowsRightAnswer = false; // determines if Joker knows right answer or not
        boolean readyToGiveAnswer = false;
        String[] dataPaths = {
                "data/telephoneEasyGivesAnswer.dat", 
                "data/telephoneMiddleGivesAnswer.dat",
                "data/telephoneHardGivesAnswer.dat",
                "data/telephoneEasyDontGivesAnswer.dat",
                "data/telephoneMiddleDontGivesAnswer.dat",
                "data/telephoneHardDontGivesAnswer.dat"
                };
        String[/*Gives Answer or Not*/][/*Question difficulty*/][/*texts*/] possibleAnswers = new String[2][3][];
        int dataPathsIndex = 0;
        for (int i = 0; i < possibleAnswers.length; i++) {
            for (int j = 0; j < possibleAnswers[i].length; j++) {
                try {
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(new FileInputStream(dataPaths[dataPathsIndex]), "UTF8"));
                    int length = 0;
                    while(reader.ready()) {
                        reader.readLine();
                        length++;
                    }
                    reader.close();

                    String[] answers = new String[length];
                    reader = new BufferedReader(
                            new InputStreamReader(new FileInputStream(dataPaths[dataPathsIndex++]), "UTF8"));
                    int index = 0;
                    while(reader.ready()) {
                        answers[index++] = reader.readLine();
                    }
                    possibleAnswers[i][j] = answers;
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
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
                telephoneAnswer = possibleAnswers[0][0][(int) (Math.random() * possibleAnswers[0][0].length)];
            else
                telephoneAnswer = possibleAnswers[1][0][(int) (Math.random() * possibleAnswers[1][0].length)];

        } else if (question.getDifficultyValue() == 1) {
            if ((int) (100 * Math.random()) < 50)
                knowsRightAnswer = true;
            else
                knowsRightAnswer = false;
            
            if (readyToGiveAnswer)
                telephoneAnswer = possibleAnswers[0][1][(int) (Math.random() * possibleAnswers[0][1].length)];
            else
                telephoneAnswer = possibleAnswers[1][1][(int) (Math.random() * possibleAnswers[1][1].length)];

        } else if (question.getDifficultyValue() == 2) {
            if ((int) (100 * Math.random()) < 30)
                knowsRightAnswer = true;
            else
                knowsRightAnswer = false;
            
            if (readyToGiveAnswer)
                telephoneAnswer = possibleAnswers[0][2][(int) (Math.random() * possibleAnswers[0][2].length)];
            else
                telephoneAnswer = possibleAnswers[1][2][(int) (Math.random() * possibleAnswers[1][2].length)];
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