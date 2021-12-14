
public class CreditTester {

	public static void main(String[] args) {
		CreditAccount c1 = new CreditAccount("Bob Jones", 10000.00, 0.12);
		
		System.out.println(c1); // calls .toString() for CreditAccount
		
		c1.makeCharge(1000.00); // should be 11000 balance
		c1.makeCharge(3000.00); // should be 14000 balance
		
		System.out.println(c1); // verify 
		// Min should be $25 or double interest of (.12/12 = 1%) * 14000, whichever greater 
		System.out.println(c1.calculateMinimumMonthlyPayment()); // verify 280 (double 1% of 14000)
		
		c1.makePayment(13000.00);	// balance should be 1000 now
		System.out.println(c1); // verify 
		
		// Min should be $25 or double the interest of (.12/12 = 1%) * 1000, whichever greater 
		System.out.println(c1.calculateMinimumMonthlyPayment()); // verify 25, since 25 > 20
		
		
		RewardsCreditAccount c2 = new RewardsCreditAccount("Special Sue", 500.00, 0.0254);
		System.out.println(c2); // calls .toString() for RewardsCreditAccount

	}

}
