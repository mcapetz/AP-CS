import java.util.Arrays;

public abstract class Score {
	
	public Score() {
		// TODO Auto-generated constructor stub
	}
	
    protected abstract int calculateScore(YahtzeeDice round);
	
	protected abstract int getScore();
	
	protected abstract void setScore(int score);
	
	protected abstract boolean isUsed();
	
	protected abstract void setIsUsed(boolean b);
	
	protected abstract String getName();

}

class One extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Ones: ";
	
	public One() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		for(int i = 0; i < calculateDice.length; i ++) {
			if(dice.getDice()[i].getCurrentValue() == 1) score ++;
		}
		return score;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}

	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setScore(int score) {
		this.score = score;
	}
}

class Two extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Twos: ";
	
	public Two() {
		// TODO Auto-generated constructor stub
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		for(int i = 0; i < calculateDice.length; i ++) {
			if(calculateDice[i].getCurrentValue() == 2) score +=2;
		}
		return score;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}
	
	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setScore(int score) {
		this.score = score;
	}
}

class Three extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Threes: ";
	
	public Three() {
		// TODO Auto-generated constructor stub
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		for(int i = 0; i < calculateDice.length; i ++) {
			if(calculateDice[i].getCurrentValue() == 3) score +=3;
		}
		return score;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}
	
	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setScore(int score) {
		this.score = score;
	}
}

class Four extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Fours: ";
	
	public Four() {
		// TODO Auto-generated constructor stub
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		for(int i = 0; i < calculateDice.length; i ++) {
			if(calculateDice[i].getCurrentValue() == 4) score +=4;
		}
		return score;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}
	
	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setScore(int score) {
		this.score = score;
	}
}

class Five extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Fives: ";
	
	public Five() {
		// TODO Auto-generated constructor stub
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		for(int i = 0; i < calculateDice.length; i ++) {
			if(calculateDice[i].getCurrentValue() == 5) score += 5;
		}
		return score;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}
	
	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setScore(int score) {
		this.score = score;
	}
}

class Six extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Sixes: ";
	
	public Six() {
		// TODO Auto-generated constructor stub
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		for(int i = 0; i < calculateDice.length; i ++) {
			if(calculateDice[i].getCurrentValue() == 6) score += 6;
		}
		return score;
	}
	
	public int getScore() {
		return score;
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}
	
	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setScore(int score) {
		this.score = score;
	}
}

class ThreeKind extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Three of a kind: ";
	
	public ThreeKind() {
		
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		
		for(int i = 1; i < 7; i ++) {
			int count = 0;
			for(int j = 0; j < calculateDice.length; j ++) {
				if(calculateDice[j].getCurrentValue() == i) count++;
			}
			if(count >= 3) {
				for(int k = 0; k < calculateDice.length; k ++) {
					score += calculateDice[k].getCurrentValue();
				}
			}
		}
		return score;
	}

	

	@Override
	protected int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	protected void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = score;
		
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}

	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

class FourKind extends Score {
	
	private int score = 0;
	private String name = "Four of a kind: ";
	private boolean isUsed = false;
	
	public FourKind() {
		
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		
		for(int i = 1; i < 7; i ++) {
			int count = 0;
			for(int j = 0; j < calculateDice.length; j ++) {
				if(calculateDice[j].getCurrentValue() == i) count++;
			}
			if(count >= 4) {
				for(int k = 0; k < calculateDice.length; k ++) {
					score += calculateDice[k].getCurrentValue();
				}
			}
		}
		return score;
	}
	
	@Override
	protected int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	protected void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = score;
		
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}

	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

class FullHouse extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Full House: ";
	
	public FullHouse() {
		
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die [] calculateDice;
		calculateDice = dice.getDice();
		
		boolean dub = false;
		boolean trip = false;
		for(int i = 1; i < 7; i ++) {
			int count = 0;
			for(int j = 0; j < calculateDice.length; j ++) {
				if(calculateDice[j].getCurrentValue() == i) count++;
			}
			if(count == 2) {
				dub = true;
			}
			if(count == 3) {
				trip = true;
			}
		}
		if(dub && trip) {
			score = 25;
		}
		return score;
	}
	
	@Override
	protected int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	protected void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = score;
		
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}

	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}

class SmallStraight extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Small Straight: ";
	
	public SmallStraight() {
		
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		int checker[] = new int[5];
		for(int o = 0; o < 5; o++) {
			checker[o] = calculateDice[o].getCurrentValue();
		}
		Arrays.sort(checker);
		for(int i = 0; i < 2; i++) {
			if(checker[i] + 1 == checker[i+1] &&
			   checker[i] + 2 == checker[i+2] &&
			   checker[i] + 3 == checker[i+3]) {
				score = 25;
			}
		}
		return score;
	}
	
	@Override
	protected int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	protected void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = score;
		
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}

	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

class LargeStraight extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Large Straight: ";
	
	public LargeStraight() {
	
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		int checker[] = new int[5];
		for(int o = 0; o < 5; o++) {
			checker[o] = calculateDice[o].getCurrentValue();
		}
		Arrays.sort(checker);
		if(checker[0] + 1 == checker[1] &&
		   checker[0] + 2 == checker[2] &&
		   checker[0] + 3 == checker[3] &&
		   checker[0] + 4 == checker[4]) {
			score = 30;
		}
		return score;
	}
	
	@Override
	protected int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	protected void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = score;
		
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}

	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

class Chance extends Score {
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Chance: ";
	
	public Chance() {
		
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		for(int i = 0; i < calculateDice.length; i ++) {
			score += calculateDice[i].getCurrentValue();
		}
		return score;
	}
	
	@Override
	protected int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	protected void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = score;
		
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}

	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}

class Yahtzee extends Score{
	
	private int score = 0;
	private boolean isUsed = false;
	private String name = "Yahtzee: ";
	
	public Yahtzee() {
		
	}
	
	public int calculateScore(YahtzeeDice dice) {
		Die[] calculateDice;
		calculateDice = dice.getDice();
		
		for(int i = 0; i < 5; i ++) {
			int count = 0;
			for(int j = 0; j < calculateDice.length; j ++) {
				if(calculateDice[j].getCurrentValue() == i) count++;
			}
			if(count == 5) {
				score = 50;
			}
		}
		return score;
	}

	@Override
	protected int getScore() {
		// TODO Auto-generated method stub
		return score;
	}

	@Override
	protected void setScore(int score) {
		// TODO Auto-generated method stub
		this.score = score;
		
	}

	@Override
	protected boolean isUsed() {
		// TODO Auto-generated method stub
		return isUsed;
	}

	@Override
	protected void setIsUsed(boolean b) {
		// TODO Auto-generated method stub
		this.isUsed = b;
	}

	@Override
	protected String getName() {
		// TODO Auto-generated method stub
		return name;
	}
}