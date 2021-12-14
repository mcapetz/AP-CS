
public class ginRummyGameShell {

	public static boolean gameMode() {
		System.out.println("Would you like to play the modified single player version? No defaults to two player game. "
				+ "\nEnter (y)es or (n)o");
		return TextIO.getlnBoolean();
	}
	
	public static void welcomeAndRules() {
		System.out.println(
				  "*********************************Welcome to Gin Rummy!*********************************"
				+ "\nThe objective of the game is to organize your hand into as many melds as possible."
				+ "\nA meld is a run or set of cards. A run is made of three or more consecutive cards "
				+ "\nof the same suit, and cannot wrap around, meaning Q K A 2 is not a valid run. A set "
				+ "\nis made of three or more cards of the same value. Cards that are not organized into"
				+ "\nmelds are called deadwood, which is the sum of the values of your unmelded cards."
				+ "\nIf you organize all 10 cards of your hand into melds, then it is called GIN, worth "
				+ "\n25 points. If you organize all 11 cards (your hand + the drawn card), then it is a "
				+ "\nBIG GIN, worth 31 points. When you knock, you score the difference between your"
				+ "\nopponent's and your points. If there is no gin or big gin, an undercut can occur"
				+ "\nif your deadwood score is greater than the opponent's deadwood score. Each turn, you"
				+ "\ndraw a card from either the facedown draw pile or the face up discard pile called the"
				+ "\nstock. You must add it to your hand and remove a card and put it in the stock pile."
				+ "\n***************************************************************************************");
	}
	
	public static void welcome() {
		System.out.println("*********************************Welcome to Gin Rummy!*********************************");
	}
}
