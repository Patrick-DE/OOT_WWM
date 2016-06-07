package werWirdMillionär.model;

import java.io.Serializable;

public class HighScoreEntrie implements Comparable, Serializable{

	private String name;
	private int questionIndex;
	private long gameTimeInSeconds;
	
	HighScoreEntrie (String name, int index, long seconds) {
		this.name = name;
		this.questionIndex = index;
		this.gameTimeInSeconds = seconds;
	}

	@Override
	public int compareTo(Object o) {
		HighScoreEntrie otherHS = (HighScoreEntrie) o; 
		if (this.questionIndex > otherHS.getQuestionIndex())
			return -1;
		else if (this.questionIndex < otherHS.getQuestionIndex())
			return 1;
		else {
			if (this.getPlayTime() < otherHS.getQuestionIndex())
				return -1;
			else if (this.getPlayTime() > otherHS.getPlayTime())
				return 1;
		}
		return 0;
	}
	
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
