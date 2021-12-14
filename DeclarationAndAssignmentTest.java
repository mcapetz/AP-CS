public class DeclarationAndAssignmentTest {

	public static void main(String[] args) {
		// declare a variable, of type int, called x.  4 bytes are reserved in memory.
		int x;

		// assign x to store a value of 4
		x = 4;

		// print out the value of x 
		System.out.println(x);

		// reassign x to store 23
		x = 23;

		// print out the value of double x
		System.out.println(2*x);

		// print out the message: "x squared is: " + x*x  
		// The '+' is a special operator for Strings, "String concatenation"
		// Basically, combining a String and int automatically converts to a String 
		System.out.println("x squared is: " + x*x ); 


		//-------- End int test ------------ 
		
		// declare a variable, of type double, called amountLeft
		double amountLeft;
		// assign it to be whatever x is multiplied by 0.05
		amountLeft = x*0.05;
		// print it out
		System.out.println(amountLeft); 
		// re-assign amountLeft to be the old amountLeft, plus one
		amountLeft = amountLeft + 1;
		// print it out
		System.out.println(amountLeft); 
		//-------- End double test ------------ 
		
		// declare a variable, of type boolean, called isCool
		boolean isCool;

		// assign isCool to be true
		isCool = true;

		// print out the value of isCool
		System.out.println(isCool);

		// Use the boolean isCool in an if-else branch
		if(isCool == true) {  // ** change condition
			System.out.println("Way cool");
		}
		else {
			System.out.println("NOT COOL!"); 
		}
		// Go back, and assign isCool to be false
		//-------- End boolean test ------------ 

		// declare a variable, of type String, called name
		String name;
		
		// assign it to be your first name, as a String literal
		name = "Margaret";
		// Create an if-else branch.  If the current value of name has a 
		// length > 6 characters, print "Long name!" otherwise, print "Short name!"
		if(name.length() > 6) {
			System.out.println("Long name!");
		}
		else {
			System.out.println("Short name!");
		}
	
		// re-assign name to be your original first name, concatenated with 
		// your last name, converted to all uppercase
		name = name + "Capetz".toUpperCase();
		if(name.length() > 6) {
			System.out.println("Long name!");
		}
		else {
			System.out.println("Short name!");
		}
		// ** comment back in
		System.out.println(name);
		
		//-------- End String test ------------ 

		// declare and assign a char called myChar with any vowel letter
		char myChar = 'a';
		// call subroutine printWhetherVowelOrNot, passing in myChar as the parameter
		printWhetherVowelOrNot(myChar);
		// re-assign myChar to store a consonant
		myChar = 'z';
		// call subroutine printWhetherVowelOrNot, passing in myChar as the parameter
		printWhetherVowelOrNot(myChar);
		
		
		boolean sup = false;
		
		if(name.length() > 3 || sup) {  // || - OR        && - AND
			System.out.println("True!!!!!!!!");
		}
		else {
			System.out.println("False!!!!");
		}
		//-------- End char test ------------ 
	} // ------ end of main() ---- when you get here, the program ends!
	


	// this is a subroutine that can be "called" by the main method anytime
	// once it finishes, execution "returns" back to the point in main where you 
	// called it.  Note, this DOES NOT automatically run.  It could be called 1 time,
	// 2 times, 30 times, or 0 times from main and it would run that many times.
	
	// Also, Ignore "public static" for now.  "void" means no value is 
	// returned to main.  If we put "int" or "boolean", it would return that type
	public static void printWhetherVowelOrNot(char character) {
		if(character == 'a') {
			System.out.println("Vowel!");
		}
		else if(character == 'e') {
			System.out.println("Vowel!");
		}
		else if(character == 'i') {
			System.out.println("Vowel!");
		}
		else if(character == 'o') {
			System.out.println("Vowel!");
		}
		else if(character == 'u') {
			System.out.println("Vowel!");
		}
		else {
			System.out.println("NOT a vowel!!!");
		}
	}
}