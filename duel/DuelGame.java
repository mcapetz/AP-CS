// Potential Giant names if you are feeling uncreative:
// Goliath, Cyclops, Titan, Paul Bunyan, Andre, The BFG, Grog, Thag
// Potential Elf names if you are feeling uncreative:
// Galadriel, Legolas, Elrond, Tauriel, Dobby, Link, Snap, Crackle, Pop
// Potential Wizard names if you are feeling uncreative:
// Harry, Ron, Dumbledore, Voldemort, Gandalf, Saruman, Tim the Enchanter, Merlin
		
public class DuelGame {
	
	public static void main(String[] args) {
		// 1) Create an array that holds 2 Giants, 2 Elfs, 2 Wizards.
		FantasyCharacter[] characters = new FantasyCharacter[6];
		characters[0] = new Giant("Paul Bunyan");
		characters[1] = new Giant("Prometheus");
		characters[2] = new Elf("Will Ferrell");
		characters[3] = new Elf("Dobby");
		characters[4] = new Wizard("George Weasley");
		characters[5] = new Wizard("Fred Weasley");
		
		// 2) Randomly select 2 DIFFERENT participants to duel, and then start the duel.
		int num1 = (int)(Math.random() * 6);
		int num2 = (int)(Math.random() * 6);
		
		
		// THIS PART IS ONLY WORTH .5 POINTS, ~2% OF CODING TEST GRADE
		// 3) Ensure that two members from the same race CAN'T duel each other 
		// (e.g Giant vs. Giant, Elf vs. Elf, Wizard vs. Wizard is not OK)
		// How to do this?? 
		// 
		// From the text: "It is even possible to test whether a given object 				 
		// belongs to a given class, using the 'instanceof' operator. Example:
		// Vehicle myVehicle = new Car();
		// if (myVehicle instanceof Car) {...} --> would evaluate to true, evaluate {}
		// if (myVehicle instanceof Truck) {...} --> would evaluate to false, skip {}
	
		do {
			num2 = (int)(Math.random() * 6);
		} while((characters[num1] instanceof Giant && characters[num2] instanceof Giant)|| (characters[num1] instanceof Elf && characters[num2] instanceof Elf)
				|| (characters[num1] instanceof Wizard && characters[num2] instanceof Wizard));
	
		
	
		//change this to select 2 different participants, from 2 different races from a group of 6
		FantasyCharacter c1 = characters[num1];
		FantasyCharacter c2 = characters[num2];
		Duel duel = new Duel(c1, c2);
		duel.startDuel();
	}

}
