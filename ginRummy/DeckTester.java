public class DeckTester {

	public static void main(String[] args) {
		
		Scoreboard scoreboard = new Scoreboard();
		
		scoreboard.getHand().addCard(new Card(3, 2));
		scoreboard.getHand().addCard(new Card(5, 2));
		scoreboard.getHand().addCard(new Card(6, 2));
		scoreboard.getHand().addCard(new Card(4, 2));
		scoreboard.getHand().addCard(new Card(10, 3));
		scoreboard.getHand().addCard(new Card(2, 3));
		scoreboard.getHand().addCard(new Card(8, 3));
		scoreboard.getHand().addCard(new Card(8, 0));
		scoreboard.getHand().addCard(new Card(8, 2));
		
		
		scoreboard.getHand().display();
		
		System.out.println("");
		scoreboard.calculateMeld();
		
		scoreboard.display();;
	}
}