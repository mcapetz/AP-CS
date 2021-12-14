import java.util.Arrays;

public class Scoreboard {
	
	private int masterScore;
	private int upperScore;
	
	private Score[] scores = new Score[] {
			new One(),
			new Two(),
			new Three(),
			new Four(),
			new Five(),
			new Six(),
			new ThreeKind(),
			new FourKind(),
			new FullHouse(),
			new SmallStraight(),
			new LargeStraight(),
			new Chance(),
			new Yahtzee()
	};
	
	public Scoreboard() {
		// TODO Auto-generated constructor stub
		masterScore = 0;
		upperScore = 0;
	}
	
	public int getMasterScore() {
		return masterScore;
	}

	public void setMasterScore(int masterScore) {
		this.masterScore = masterScore;
	}
	
	public int getUpperScore() {
		return upperScore;
	}

	public void setUpperScore(int upperScore) {
		this.upperScore = upperScore;
	}
	
	public Score[] getScores() {
		return scores;
	}
	
	public void setScores(Score[] s) {
		this.scores = s;
	}
	
	
	public static void display(Score[] s, YahtzeeDice round) {
		System.out.println("\n");
		for(int y = 0; y<s.length; y ++) {
			System.out.println((y + 1) + ":  " + s[y].getName() + s[y].calculateScore(round));
		}
	}

}