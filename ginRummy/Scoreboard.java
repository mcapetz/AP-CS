import java.util.ArrayList;

public class Scoreboard {
	
	private Hand deadwood;
	private Hand meld;
	private Hand hand;
	
	private int deadwoodScore;

	public Hand getDeadwood() {
		return deadwood;
	}


	public int getDeadwoodScore() {
		return deadwoodScore;
	}


	public void setDeadwoodScore(int deadwoodScore) {
		this.deadwoodScore = deadwoodScore;
	}


	public void setDeadwood(Hand deadwood) {
		this.deadwood = deadwood;
	}

	public Hand getMeld() {
		return meld;
	}

	public void setMeld(Hand meld) {
		this.meld = meld;
	}

	public Hand getHand() {
		return hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}

	public Scoreboard() {
		deadwood = new Hand();
		meld = new Hand();
		hand = new Hand();
    }
	
	public int deadwoodScore() {
		int score = 0;
		for(int i = 0; i < deadwood.getCardCount(); i++) {
			if(deadwood.getCard(i).getValue() == 1
				|| deadwood.getCard(i).getValue() == 11
				|| deadwood.getCard(i).getValue() == 12 //face cards value as 10
				|| deadwood.getCard(i).getValue() == 13) score += 10;
			else score += deadwood.getCard(i).getValue(); // other cards have reg values
		}
		setDeadwoodScore(score);
		return score;
	}
	
	public String roundScore() { //calculates final scores with bonuses
		int score = 0;
		//System.out.println("Deadwood score: " + getDeadwoodScore());
		//System.out.println("meld card count: "+ meld.getCardCount());
		if(getDeadwoodScore() == 0
			&& meld.getCardCount() == 10) {
			score += 25; //gin bonus
			System.out.println("\nGin bonus: 25");
		}
		if(getDeadwoodScore() == 0
			&& meld.getCardCount() == 11) {
			score += 31;// big gin bonus
			System.out.println("\nBig gin bonus: 31");
		}
		return "Round Score: " + score;
	}
	
	public void roundScore(Player knocker, Player player) { //calculates final scores with bonuses
		int knockerScore = 0;
		int playerScore = 0;
		int knockBonus = 0;
		
		System.out.println(knocker.getName() + " deadwood score is "+ knocker.getScoreboard().getDeadwoodScore());
		System.out.println(player.getName() + " deadwood score is "+ player.getScoreboard().getDeadwoodScore());
		
		int knockerDeadwood = knocker.getScoreboard().getDeadwoodScore();
		int playerDeadwood = player.getScoreboard().getDeadwoodScore();
		
		if(knocker.getScoreboard().getDeadwoodScore() == 0
			&& knocker.getScoreboard().getMeld().getCardCount() == 10) {
			knockerScore += 25; //gin bonus
			System.out.println("Gin bonus: 25");
		}
		if(knocker.getScoreboard().getDeadwoodScore() == 0
			&& knocker.getScoreboard().getMeld().getCardCount() == 11) {
			knockerScore += 31;// big gin bonus
			System.out.println("Big gin bonus: 31");
		}
		//UNDERCUT
		if(knockerDeadwood != 0 && (knockerDeadwood >= playerDeadwood)) {
			System.out.println("Undercut! The opponent has less or equal deadwood points than the knocker.");
			System.out.println("The knocker scores 0 points, opponent scores 25 points plus the deadwood difference");
			System.out.println("the difference in points is: " + (knockerDeadwood - playerDeadwood));
			playerScore = playerScore + 25 + (knockerDeadwood - playerDeadwood);
		}
		//KNOCKER POINTS
		if(knockerDeadwood < playerDeadwood) {
			knockBonus = playerDeadwood - knockerDeadwood;
			knockerScore += knockBonus;
		}
		
		System.out.println("Knock bonus: " + knockBonus);
		
		//winner
		if(knockerScore > playerScore) {
			knocker.setWins(knocker.getWins() + 1);
			System.out.println(knocker.getName() + " (knocker) wins this round!");
		}
		else {
			player.setWins(player.getWins() + 1);
			System.out.println(player.getName() + " (opponent) wins this round!");
		}
		
		//set total scores
		knocker.setTotalScore(knocker.getTotalScore() + knockerScore);
		player.setTotalScore(player.getTotalScore() + playerScore);
		
		//print out round scores
		System.out.println(knocker.getName() + " Round Score: " + knockerScore);
		System.out.println(player.getName() + " Round Score: " + playerScore);
		
		//print out final scores
		System.out.println(knocker.getName() + " Total Score: " + knocker.getTotalScore());
		System.out.println(player.getName() + " Total Score: " + player.getTotalScore());
		
		System.out.println("***************************************************************************************");
				
	}
	
	public void display() { //asks how to sort, calculates melds, then displays deadwood, deadwood score, meld, in toString() format
//		Hand sortedHand = new Hand();
//		sortedHand.clone(hand, sortedHand);
//		sortHand(sortedHand);
		sortHand();
		calculateMeld();
		System.out.println("\nHand: ");
		for(int i = 0; i < hand.getCardCount(); i++) {
			if(i == hand.getCardCount()-1) System.out.print(hand.getCard(i).toString());
			else System.out.print(hand.getCard(i).toString() + ", ");
		}
		
		System.out.println("\n\nDeadwood: ");
		for(int i = 0; i < deadwood.getCardCount(); i++) {
			if(i == deadwood.getCardCount()-1) System.out.print(deadwood.getCard(i).toString());
			else System.out.print(deadwood.getCard(i).toString() + ", ");
		}
		System.out.println("\nDeadwood score: " + deadwoodScore());
		
		System.out.println("\nMeld: ");
		for(int i = 0; i < meld.getCardCount(); i++) {
			if(i == meld.getCardCount()-1) System.out.print(meld.getCard(i).toString());
			else System.out.print(meld.getCard(i).toString() + ", ");
		}
	}
	
	public void checkForGin() {
		if(deadwood.getCardCount() == 0 && meld.getCardCount() == 10) {
			System.out.println("Gin! choose to knock when prompted");
		}
		if(deadwood.getCardCount() == 0 && meld.getCardCount() == 11) {
			System.out.println("Big Gin! choose to knock when prompted");
		}
	}
	
	public void sortHand(Hand hand) {
		System.out.println("Sort by value? If not, it will sort by suit. (y)es or (n)o");
		boolean input = TextIO.getlnBoolean();
		if(input) {
			System.out.println("...sorting by value...");
			hand.sortByValue();
		}
		else {
			System.out.println("...sorting by suit...");
			hand.sortBySuit();	
		}
	}
	
	public void sortHand() {
		System.out.println("Sort by value? If not, it will sort by suit. (y)es or (n)o");
		boolean input = TextIO.getlnBoolean();
		if(input) hand.sortByValue();
		else hand.sortBySuit();	
	}
	
	public void addAndRemove(Hand changedHand, ArrayList<Card> holder) {
		for(int d = 0; d < holder.size(); d++) {
			changedHand.removeCard(holder.get(d));
			meld.addCard(holder.get(d));				
		}
	}
	
	public boolean checkForRun(ArrayList<Card> holder) {
		int count = 0;
		if(holder.size() < 3) {
			return false;
		}
		if(holder.size() == 3) {
			if(holder.get(0).getValue() + 1 == holder.get(1).getValue() && holder.get(0).getValue() + 2 == holder.get(2).getValue()) return true;
			else return false;
		}
		for(int w = 3; w < holder.size(); w++) { //checks holder sizes 4+
			for(int y = 1; y < w+1; y++) {
				if(holder.get(0).getValue() + y == holder.get(y).getValue()) {
					count++;
				}
			}
			if(count < w) {
				return false;
			}
			for(int i = 0; i < holder.size(); i++) {
				if(i > count) holder.remove(i);
			}
			count=0;
		
		}
		return true;
	}
	
	public void calculateMeld() {
		Hand changedHand = new Hand();
		changedHand.clone(hand, changedHand);
		ArrayList<Card> holder = new ArrayList<Card>(); //holder as a tool
		int count = 0;
		for(int i = 1; i < 14; i++) { //check for sets first
			count = 0;
			for(int j = 0; j < changedHand.getCardCount(); j++) {
				if(changedHand.getCard(j).getValue() == i) {
					holder.add(changedHand.getCard(j));
					count++;
				}
			}
			if(count >= 3) { //change changedHand, meld
				addAndRemove(changedHand, holder);
			}
			holder.clear();
		}
		
		changedHand.sortBySuit();
		for(int a = 0; a < 4; a++) { //check for runs
			holder.clear();
			for(int b = 0; b < changedHand.getCardCount(); b++) { 
				if(changedHand.getCard(b).getSuit() == a) {
					holder.add(changedHand.getCard(b));
				}
			}
//			
			if(checkForRun(holder)) {
				addAndRemove(changedHand, holder);
			}
			holder.clear();
		}
		deadwood.clone(changedHand, deadwood); 
	}
}
