
public class ginRummyRunner {

	public static void main(String[] args) {
		ginRummyGameShell.welcome();
		if(ginRummyGameShell.gameMode()) new ginRummyGameSingle().playGame();
		else new ginRummyGameDouble().playGame();
		
	}
}
