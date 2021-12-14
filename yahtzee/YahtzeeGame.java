public class YahtzeeGame {
	
	private YahtzeeDice round;
	private Scoreboard scoreboard = new Scoreboard();
	
	public YahtzeeGame() {
		// TODO Auto-generated constructor stub
		this.round = new YahtzeeDice();
	}
	
	public YahtzeeGame(YahtzeeDice r) {
		this.round = r;
	}
	
	public void playGame() {
				
		while(!allUsed(scoreboard.getScores())) {
			reset(scoreboard.getScores());
			newRound();				
		}
		
	}
	
	public void newRound() {
		
		reset(scoreboard.getScores());
		
		
			
			rollDisplay(round);
			
			//asks user if they want to hold, and then updates
			int rollsLeft = 2;
			
			for(int i = 0; i < 2; i ++) {
				
				Scoreboard.display(scoreboard.getScores(), round);
				
				System.out.println("You have " + rollsLeft + " roll(s) left");
				
				String ask = "";
				do {
					ask = askPlay(scoreboard.getScores(), scoreboard, "Enter your play or enter 0 to continue to hold dice");
					System.out.println(ask);
				} while (ask.equals("Sorry, you already used this play") || ask.contentEquals("Incorrect input"));
				
				int[] newValues = round.holdDice(round);
				
				for(int z = 0; z < newValues.length; z ++) {
					round.setDice(z, newValues[z]);
				}
				
				displayDice(round);
				
				rollsLeft--;
				
				System.out.println("");
				
				reset(scoreboard.getScores());
			}
			
			Scoreboard.display(scoreboard.getScores(), round);
			
			String ask = "";
			do {
				ask = askPlay(scoreboard.getScores(), scoreboard, "You cannot hold anymore! Choose your score... ");
				System.out.println(ask);
			} while (ask.equals("Sorry, you already used this play") || ask.equals("Incorrect input") || ask.equals(""));
			
			
			if(!allUsed(scoreboard.getScores())) {
				
				System.out.println("New round: \n");
			}
			
	}
	
	public void finalScore() {
		System.out.println("***Game End***");
		if(scoreboard.getUpperScore() >= 63) {
			scoreboard.setMasterScore(scoreboard.getMasterScore() + 35);
			System.out.println("You received a bonus score of 35");
		}
		System.out.println("Your final score is: " + scoreboard.getMasterScore());
	}
	
	public void displayDice(YahtzeeDice dice) {
		for(int i = 0; i < YahtzeeDice.numDice; i ++) {
			if(i == YahtzeeDice.numDice - 1) {
				System.out.print(dice.getDiceValue(i));
			}
			else System.out.print(dice.getDiceValue(i) + ",");
		}
	}
		
	public void reset(Score[] s) {
		for(int i = 0; i < s.length; i ++) {
			s[i].setScore(0);
		}
	}
	
	public void rollDisplay(YahtzeeDice round) {
		round.roll();
		displayDice(round);
	}
	
	public void endGame() {
		System.out.println("Play again? (y/n)");
		boolean input = TextIO.getlnBoolean();
		if(input) new YahtzeeGame(new YahtzeeDice());
		else System.exit(0);
	}
	
	public static void welcome() {
		System.out.print("***Welcome to Yahtzee Game!*** \n");
		System.out.println("\nYour first roll is: ");
	}

	public String askPlay(Score[] s, Scoreboard v, String message){
		if(allUsed(s)) {
			finalScore();
			endGame();
					}
		int playInput;
		System.out.println(message);
		playInput = TextIO.getlnInt();
		if(playInput == 0) {
			//System.out.println("Continue");
			return "";
			//break;
		}
		if(playInput < 0 || playInput > 13) {
			return "Incorrect input";
		}
		if(!(s[playInput - 1]).isUsed()) {
			if(1 <= playInput && playInput <= 6) {
				v.setUpperScore(v.getUpperScore() + s[playInput-1].getScore());
			}
			v.setMasterScore(v.getMasterScore() + s[playInput-1].getScore());
			(s[playInput - 1]).setIsUsed(true);
			System.out.println("You played " + s[playInput-1].getName() + "score of " + s[playInput-1].getScore() + "\n");
			

			if(!(allUsed(s))) System.out.println("New round: ");
			newRound();
			return "You played " + s[playInput-1].getName() + "score of " + s[playInput-1].getScore();
		}
		else {
			//System.out.println("Sorry, you already used this play");
			return "Sorry, you already used this play";
		}
	}
	
	public boolean allUsed(Score[] s) {
		for(int i = 0; i < 13; i ++) {
			if(!s[i].isUsed()) return false;
		}
		finalScore();
		endGame();
		return true;
	}
	
	public static void printInstructions() {
		System.out.println("In each turn a player may throw the dice up to three times. "
				+ "\nA player doesn't have to roll all five dice on the second and third throw of a roun"
				+ "d, \nhe may put as many dice as he wants to the side and only throw the ones \nt"
				+ "hat don't have the numbers he's trying to get.\nFor example, a player thro"
				+ "ws and gets 1,3,3,4,6. \nHe decides he want to try for the large straight, 1,2,3,4,"
				+ "5. \nSo, he puts 1,3,4 to the side and only throws 3 and 6 again, hoping to get 2 and 5.\n");
	}
}