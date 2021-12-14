
public class Player {

	private Scoreboard scoreboard;
	private String name;
	private int totalScore;
	private int wins;

	public Player() {
		this.scoreboard = new Scoreboard();		
		totalScore = 0;
		wins = 0;
	}

	public Player(String name) {
		this.scoreboard = new Scoreboard();	
		this.name = name;
		totalScore = 0;
		wins = 0;
	}
	
	public void setScoreboard(Scoreboard scoreboard) {
		this.scoreboard = scoreboard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Scoreboard getScoreboard() {
		// TODO Auto-generated method stub
		return scoreboard;
	}
	
	public int getWins() {
		return wins;
	}
	
	public void setWins(int wins) {
		this.wins = wins;
	}
	
	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
}
