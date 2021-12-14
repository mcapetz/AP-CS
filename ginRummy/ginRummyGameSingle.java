import java.util.ArrayList;

public class ginRummyGameSingle {

	
	private Scoreboard scoreboard = new Scoreboard();
	private Deck deck = new Deck();
	private ArrayList<Card> stock = new ArrayList<Card>();
	
	
	public ginRummyGameSingle() {
		
	}
	
	public void playGame() {
		System.out.println("\nYou will play the modified single player version of Gin Rummy.");
//		for(int i = 0; i < 10; i++) {//ten rounds
//			System.out.println("Round " + (i+1) + ": ");
//			newRound();
//		}
		newRound();
	}
	public void currentHand() {
		scoreboard.getHand().sortByValue();
		System.out.println("\n\nThis is your current hand: ");
		scoreboard.getHand().display();
	}
	
	public void currentStock() {
		System.out.println("\nThis is the current stock: ");
		System.out.println(stock.get(stock.size()-1));
	}
	
	public void gameStart() {
		deck.shuffle();
		for(int i = 0; i < 10; i++) {
			scoreboard.getHand().addCard(deck.dealCard());
		}
		currentHand();
		System.out.println("\n\nHere is the first card: ");
		Card firstCard = deck.dealCard();
		System.out.println(firstCard.toString());
		System.out.println("\nWould you like to keep this card? Default is to pass.");
		boolean draw = TextIO.getlnBoolean();
		if(draw) {
			scoreboard.getHand().addCard(firstCard);
			addFromStockRemoveFromHandToStock(firstCard); //can't add/remove same card
		}
		clearMD();
	}
	
	public void addFromDeckRemoveFromHandToStock(Card card) {
		scoreboard.display();
		int index = 0;
		do {
			System.out.println("\n\nPlease choose a card to remove from your hand. "
					+ "\nEnter the index: (1-11)");
			index = TextIO.getlnInt();
		} while (index > 11 || index < 1); //index must be within range, can be most recently drawn card
		Card chosenCard = scoreboard.getHand().getCard(index-1);
		scoreboard.getHand().removeCard((index-1)); //remove card from hand
		stock.add(chosenCard); //add card to stock
		currentStock();
	}
	
	public void addFromStockRemoveFromHandToStock(Card card) {
		scoreboard.display();
		int index = 0;
		do {
			System.out.println("\n\nPlease choose a card to remove from your hand, it cannot be the just added card. "
					+ "\nEnter the index: (1-11)");
			index = TextIO.getlnInt();
		} while (index > 11 || index < 1 || card == scoreboard.getHand().getCard(index-1)); //index must be within range, cannot be most recently drawn card
		Card chosenCard = scoreboard.getHand().getCard(index-1);
		scoreboard.getHand().removeCard(index-1); //remove card from hand
		stock.add(chosenCard); //add card to stock
		currentStock();
	}
	
	public void turn() {
		System.out.println("\nYour turn: ");
		System.out.println("\nWould you like to draw from the deck? No defaults to drawing from the stock.");
		boolean draw = TextIO.getlnBoolean();
		if(draw) {
			System.out.println("\n...drawing card from deck...");
			Card card =  deck.dealCard();
			System.out.println(card.toString());
			scoreboard.getHand().addCard(card);
			addFromDeckRemoveFromHandToStock(card);
		}
		if(!draw) {
			if(stock.size() == 0) {
				System.out.println("The stock is empty, so you must draw from the deck.");
				System.out.println("\n...drawing card from deck...");
				Card card =  deck.dealCard();
				System.out.println(card.toString());
				scoreboard.getHand().addCard(card);
				addFromDeckRemoveFromHandToStock(card); //can add/remove same card
			}
			else {
				System.out.println("\n...drawing card from stock...");
				Card card = stock.get(stock.size()-1);
				System.out.println(card.toString());
				scoreboard.getHand().addCard(card);
				addFromStockRemoveFromHandToStock(card); //can't add/remove same card		}
			}
		}
		clearMD();
		
	}
	
	public void clearMD() { //clear meld and deadwood
		scoreboard.getDeadwood().clear();
		scoreboard.getMeld().clear();
	}
	
	
	public void compTurn() {
		System.out.println("\nComputer's turn: ");
		System.out.println("\n...computer draws card and places it in the stock...");
		stock.add(deck.dealCard());
		currentStock();
	}
	
	public void newRound() {
		gameStart();
		boolean knock = false;
		while(!knock) {
			turn();
			scoreboard.checkForGin();
			System.out.println("Knock? ");
			knock = TextIO.getlnBoolean();
			if(!knock) compTurn();
		}
		System.out.println("...you knocked...");
		System.out.println(scoreboard.roundScore());
		System.out.println("Thanks for playing Gin Rummy!");
		System.exit(0);
	}
	
	
}
