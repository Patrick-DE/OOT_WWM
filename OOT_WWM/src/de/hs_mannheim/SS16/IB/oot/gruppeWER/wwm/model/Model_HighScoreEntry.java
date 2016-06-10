package de.hs_mannheim.SS16.IB.oot.gruppeWER.wwm.model;

import java.io.Serializable;

public class Model_HighScoreEntry implements Comparable, Serializable{

	//MARK: - Assets
	private String name;
	private int questionIndex;
	private long gameTimeInSeconds;
	
	//MARK: - Constructor
	Model_HighScoreEntry (String name, int index, long seconds) {
		this.name = name;
		this.questionIndex = index;
		this.gameTimeInSeconds = seconds;
	}
	
	//MARK: - Methods
	@Override public int compareTo(Object o) {
		Model_HighScoreEntry otherHS = (Model_HighScoreEntry) o; 
		if (this.questionIndex > otherHS.getQuestionIndex())
			return -1;
		else if (this.questionIndex < otherHS.getQuestionIndex())
			return 1;
		else {
			if (this.getPlayTime() < otherHS.getPlayTime())
				return -1;
			else if (this.getPlayTime() > otherHS.getPlayTime())
				return 1;
		}
		return 0;
	}
	
	//MARK: - Getter and Setter Methods
	public String getName() {
		return this.name;
	}
	public int getQuestionIndex() {
		return this.questionIndex;
	}	
	public long getPlayTime() {
		return this.gameTimeInSeconds;
	}	
}