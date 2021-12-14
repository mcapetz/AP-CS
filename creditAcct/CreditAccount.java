/*  The assignment for this week is to implement the missing methods
	of two classes: CreditAccount and RewardsCreditAccount. 
	If you are going to submit through Eclipse, you should 
	create a new project and have only the files for this homework assignment in
	the project.
	Comments are provided for some methods to help you figure out
	what should be done. Other methods (such as setters and getters)
	should be straight-forward.
*/

//  DO NOT REMOVE THE private DESIGNATION OF ANY OF THE MEMBER VARIABLES!!!

public class CreditAccount {
	private String accountHolder;
	private double balance;
	private double annualInterestRate; //annual rate as a decimal

	public CreditAccount(String accountHolder, double balance, 
	                                           double annualInterestRate) {
		//initialize the variables and throw an IllegalArgumentException if
		//interestRate is negative
		this.accountHolder = accountHolder;
		this.balance = balance;
		if(annualInterestRate < 0) throw new IllegalArgumentException("Interest rate cannot be negative.");
		this.annualInterestRate = annualInterestRate;
		
	}
	
	public double calculateMinimumMonthlyPayment() {
		//This method should return a value of either $25 or twice the value
		//of the interest amount for the month (whichever is greater).
		//If this amount is greater than the remaining balance, then the 
		//remaining balance should be returned.
		if((2 * calculateInterestAmountForMonth()) > 25) return 2 * calculateInterestAmountForMonth();
		if(balance < 25) return balance;
		else return 25;
	}
	
	public int howManyMonthsUsingConstantPayment(double payment) {
		//The parameter payment should be greater than the minimum monthly
		//payment. If it is not, throw an IllegalArgumentException.
		//This method should calculate how many months it will take to
		//pay off the remaining balance given a constant payment amount
		//each month. It should assume that no further charges will be made
		//and that the interest for each month is calculated before the payment
		//for that month is applied. For example, if the balance is $5634 and 
		//interest rate is 12%, then a payment of $75 would result in 
		//a balance of 5634 + 56.34 - 75 = 5615.34 for the next month.
		//(This is a simplified model of how payments are actually applied.)
		int count = 0;
		if(payment < calculateMinimumMonthlyPayment()) throw new IllegalArgumentException("Payment must be greater than minimum monthly payment.");
		while(balance > 0) {
			balance = balance + calculateInterestAmountForMonth() - payment;
			count++;
		}
		return count;
	}
	
	
	public double calculateInterestAmountForMonth() {
		return Math.round(balance * annualInterestRate / 12.0 * 100.0) / 100.0;
	}
	
	public void makeCharge(double amount) {
		//add amount to the balance
		//throw an IllegalArgumentException if the amount is negative
		if(amount < 0) throw new IllegalArgumentException("You cannot charge a negative amount.");
		balance += amount;
	}
	
	public void makePayment(double amount) {
		//subtract amount from the balance
		//throw an IllegalArgumentException if the amount is negative
		if(amount < 0) throw new IllegalArgumentException("You cannot pay a negative amount.");
		balance -= amount;
	}

	public String toString() {
		//This method should return a String with formatted versions
		//of the variables with a comma and a space separating them.
		//For example, an account with "Joe F. Pyne" as the accountHolder,
		//7384.28 as the balance, and 0.173 as the annual interest rate
		//should return the String
		// "Joe F. Pyne, $7384.28, 17.3%"
		//The balance should display two decimals places, but the
		//interest rate should show as many decimal places as necessary.
		String strBalance = String.format("%.2f", balance);
		String str = accountHolder + ", " + "$" + strBalance + ", " + (100*annualInterestRate) + "%";
		return str;
	}

	public double getBalance() {
		return balance;
	}
	
	public double getInterestRate() {
		return annualInterestRate;
	}
	
	public void setInterestRate(double interestRate) {
		//throw an IllegalArgumentException if interestRate is negative
		if(interestRate < 0) throw new IllegalArgumentException("Interest rate cannot be negative.");
		this.annualInterestRate = interestRate;
	}
	
	public String getAccountHolder() {
		return accountHolder;
	}
	
	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}
	
}

