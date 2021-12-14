public class YahtzeeRunner {
	
	public static void main(String[] args) {
		YahtzeeGame.printInstructions();
		YahtzeeGame.welcome();
		new YahtzeeGame(new YahtzeeDice()).playGame();
	}
	
}