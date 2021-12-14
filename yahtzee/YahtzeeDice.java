public class YahtzeeDice {
	
	
	public static final int numDice = 5;

	Die[] dice = new Die[numDice];


	// --- Constructors ---
	public YahtzeeDice() {
		for (int i = 0; i < dice.length; i++) {
			dice[i] = new Die();
		}
	}
	
	public void setDice(int i, int value) {
		dice[i] = new Die(value);
	}
	
	
	public int roll() { 
		int roll = 0;
		for(int i = 0; i < dice.length; i ++) {
			roll += dice[i].roll();
		}
		return roll;
	}
	
	// return the array of Die objects
	public Die[] getDice() {
		return dice;
	}
	
	public void updateDice(int[] test, YahtzeeDice round) {
		//Set the dice to the new dice values
		for(int j = 0; j < test.length; j ++) {
			round.setDice(j, test[j]);
		}
	}
	
	public int getDiceValue(int i) {
		return dice[i].getCurrentValue();
	}

	
	// If the format above isn't helpful
	// this method will return the int values of each Die object
	public int[] getDiceValues() {
		return new int[] {dice[0].getCurrentValue(), 
			dice[1].getCurrentValue(), dice[2].getCurrentValue(), dice[3].getCurrentValue(), dice[4].getCurrentValue() };
	}
	
	public int[] holdDice(YahtzeeDice round) {
		System.out.println("");
		System.out.println("Hold dice? Enter (y)es or (n)o");
		Die die = new Die();
		int[] currDice = getDiceValues();
		for(int i=0; i<currDice.length; i++) {
			System.out.println("Dice " + (i+1) + "? ");
			boolean input = TextIO.getlnBoolean();
			if(!input) {
				System.out.println("You did not want to hold");
				currDice[i] = die.roll();
//				System.out.println(currDice[i]);
			} else {
				System.out.println("Okay it will stay as " + currDice[i]);
			}
		}
		
		for(int j = 0; j < dice.length; j ++) {
			round.setDice(j, dice[j].getCurrentValue());
		}
		
		return currDice;
	}
	
	public String toString() {
		return dice[0].toString() + " " + dice[1].toString() + " " + dice[2].toString() + " " + dice[3].toString() + " " + dice[4].toString();
	}
	
}