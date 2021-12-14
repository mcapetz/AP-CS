import java.util.ArrayList;

public class ginRummyGameDouble {

	private Player player1 = new Player("Player 1");
	private Player player2 = new Player("Player 2");
	
	private Scoreboard scoreboard = new Scoreboard();
	private Deck deck = new Deck();
	private ArrayList<Card> stock = new ArrayList<Card>();
	
	private boolean round;
	
	public ginRummyGameDouble() {
		
	}
	
	public void playGame() {
		System.out.println("\nYou will play the two player version of Gin Rummy.");
		round = true;
		//ten rounds
		for(int i = 0; i < 10; i ++) {
			System.out.println("Round " + (i+1) + ": ");
			newRound();
		}
		gameEnd();
	}
	
	public void currentHand(Player player) {
		System.out.println(player.getName() + ": ");
		player.getScoreboard().getHand().sortByValue();
		System.out.println("\n\nThis is your current hand: ");
		player.getScoreboard().getHand().display();
	}
	
	public void currentStock() {
		if(stock.size() == 0) System.out.println("The stock is empty.");
		else {
			System.out.println("\nThis is the current stock: ");
			System.out.println(stock.get(stock.size()-1));
		}
	}
	
	public void dealCards(Player player1, Player player2) {
		deck.shuffle();
		for(int i = 0; i < 10; i++) {
			player1.getScoreboard().getHand().addCard(deck.dealCard());
			player2.getScoreboard().getHand().addCard(deck.dealCard());
		}
	}
	
	public Card drawACard() {
		Card firstCard = deck.dealCard();
		System.out.println("\n\nHere is the drawn card: " + firstCard.toString());
		return firstCard;
	}
	
	public boolean gameStart(Player player, Card firstCard) {
		currentHand(player);
		System.out.println("\nWould you like to keep this card? Default is to pass.");
		boolean draw = TextIO.getlnBoolean();
		if(draw) {
			player.getScoreboard().getHand().addCard(firstCard);
			addFromStockRemoveFromHandToStock(player, firstCard); //can't add/remove same card
		}
		clearMD(player);
		if(draw) return true;
		return false;
	}
	
	public void addFromDeckRemoveFromHandToStock(Player player, Card card) {
		System.out.println(player.getName()+": ");
		player.getScoreboard().display();
		int index = 0;
		do {
			System.out.println("\n\nPlease choose a card to remove from your hand. "
					+ "\nEnter the index: (1-11)");
			index = TextIO.getlnInt();
		} while (index > 11 || index < 1); //index must be within range, can be most recently drawn card
		Card chosenCard = player.getScoreboard().getHand().getCard(index-1);
		player.getScoreboard().getHand().removeCard((index-1)); //remove card from hand
		stock.add(chosenCard); //add card to stock
		currentStock();
	}
	
	public void addFromStockRemoveFromHandToStock(Player player, Card card) {
		System.out.println(player.getName()+": ");
		player.getScoreboard().display();
		int index = 0;
		do {
			System.out.println("\n\nPlease choose a card to remove from your hand, it cannot be the just added card. "
					+ "\nEnter the index: (1-11)");
			index = TextIO.getlnInt();
		} while (index > 11 || index < 1 || card == player.getScoreboard().getHand().getCard(index-1)); //index must be within range, cannot be most recently drawn card
		Card chosenCard = player.getScoreboard().getHand().getCard(index-1);
		player.getScoreboard().getHand().removeCard(index-1); //remove card from hand
		stock.add(chosenCard); //add card to stock
		currentStock();
	}
	
	public void turn(Player player) {
		System.out.println("\n" + player.getName() +"'s turn: ");
		System.out.println("\nWould you like to draw from the deck? No defaults to drawing from the stock.");
		currentStock();
		currentHand(player);
		space();
		boolean draw = TextIO.getlnBoolean();
		if(draw) {
			System.out.println("\n...drawing card from deck...");
			Card card =  deck.dealCard();
			System.out.println(card.toString());
			player.getScoreboard().getHand().addCard(card);
			addFromDeckRemoveFromHandToStock(player, card); //can add/remove same card
		}
		if(!draw) {
			if(stock.size() == 0) {
				System.out.println("The stock is empty, so you must draw from the deck.");
				System.out.println("\n...drawing card from deck...");
				Card card =  deck.dealCard();
				System.out.println(card.toString());
				player.getScoreboard().getHand().addCard(card);
				addFromDeckRemoveFromHandToStock(player, card);
			}
			else {
				System.out.println("\n...drawing card from stock...");
				Card card = stock.get(stock.size()-1);
				System.out.println(card.toString());
				player.getScoreboard().getHand().addCard(card);
				addFromStockRemoveFromHandToStock(player, card); //can't add/remove same card		}
			}
		}
		clearMD(player);
		//System.out.println("end of turn()");
	}
	
	public void clearMD(Player player) { //clear meld and deadwood
		player.getScoreboard().getDeadwood().clear();
		player.getScoreboard().getMeld().clear();
	}
	
	public boolean knock(Player player) {
		System.out.println("Knock? ");
		return TextIO.getlnBoolean();
	}
	
	public void knockPlay(Player knocker, Player player) {
		System.out.println("you knocked...");
		player1.getScoreboard().roundScore(knocker, player);
		round = false;
	}
	
	public void newRound() {
		reset(player1, player2);
		dealCards(player1, player2);
		Card firstCard = drawACard();
		//game start: picking up the first card
		if(gameStart(player1, firstCard)) {
			System.out.println("Since the first player picked up the first card, so may the second player.");
			space();
			Card secondCard = drawACard();
			gameStart(player2, secondCard);
			space();
		}
		else {
			System.out.println("Since the first player did not pick up the first card, neither may the second player.");
		}
		
		//turns
		boolean first = false;
		while(round) {
			turn(player1);
			//System.out.println("Player 1 turn is over");
			if(first) if(knock(player1)) knockPlay(player1, player2);
			
			if(!round) break;
			
			space();
			turn(player2);
			//System.out.println("Player 2 turn is over");
			if(knock(player2)) knockPlay(player2, player1);
			space();
			first = true;
		}
	}
	
	public void space() {
		for(int i = 0; i < 10; i ++) {
			System.out.println("");
		}
	}
	
	public void reset(Player player1, Player player2) {
		deck.setCardsUsed(0);
		round = true;
		player1.getScoreboard().getHand().clear();
		player2.getScoreboard().getHand().clear();
		
	}
	
	
	public void gameEnd() {
		//calculate game bonus: 100 points if more than 100 points already
		if(player1.getTotalScore() >= 100) {
			System.out.println(player1.getName() + " earns a game bonus of 100 points!");
		}
		if(player2.getTotalScore() >= 100) {
			System.out.println(player2.getName() + " earns a game bonus of 100 points!");
		}
		//calculate line/box bonus: 25 points for each hand won
		for(int i = 0; i < player1.getWins(); i++) {
			player1.setTotalScore(player1.getTotalScore() + 25);
		}
		for(int i = 0; i < player2.getWins(); i++) {
			player2.setTotalScore(player2.getTotalScore() + 25);
		}
		System.out.println("Thanks for playing Gin Rummy!");
		System.exit(0);
	}
	
}
