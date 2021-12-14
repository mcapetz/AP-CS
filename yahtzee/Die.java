
public class Die {
	//Static:
	private static final int numSides = 6;
	
	//Instance:
	private int currentValue;
	
	//Constructors:
	public Die() {
		roll(); 
	}

	public Die(int initialValue) {
		currentValue = initialValue;
	}
	
	//Instance methods:
	public int roll() {
		currentValue = (int)(Math.random() * numSides + 1);
		return currentValue;
	}
	
	public String toString() {
		return "Num of sides: " + numSides + ", Value: " + currentValue;
	}
	
	public int getCurrentValue() {
		return currentValue;
	}
	
	//Getters and Setters
	
	public static int getNumSides() {
		return numSides;
	}
}