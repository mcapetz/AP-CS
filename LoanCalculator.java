//Margaret Capetz

//last payment is different!
//return, not system out
// \n new line
//current amt + interest - 950 = remaining amt
//remaining amt = current amt
// String.format(); Concatenate, to return
public class LoanCalculator {
	
	public static void main(String[] args) {
		System.out.print(createAmortizationTable(10000, 950, 0.17));
		//System.out.print(createAmortizationTable(13854, 278.37, 0.13));
	}
	
	public static String createAmortizationTable(double initialLoanAmt, double monthlyPmt, double annualInterestRate) {
	
		//String str = "";
		String amortizationTable = "";
		amortizationTable += String.format("%-10s%-16s%-16s%s\n", "Month","Interest","Payment","Remaining");
		//str = String.format("%-10s%-16s%-16s%s\n", "Month","Interest","Payment","Remaining");
		
		double remainingAmt = initialLoanAmt;
		double currentAmt = initialLoanAmt;
		double monthlyInterestRate = annualInterestRate / 12;
		//System.out.println("initial loan amount: "+ initialLoanAmt);
		//System.out.println("monthly interest rate: "+ monthlyInterestRate);
		//System.out.println("initial x monthlyinterest: "+(monthlyInterestRate * initialLoanAmt));d
		//System.out.println("monthly payment: " + monthlyPmt);
		
		if(monthlyPmt <= (monthlyInterestRate * initialLoanAmt)) {
			return "Not possible to pay off the loan.";
		}
		int month = 1;
		double interest = 1;
		while(remainingAmt > 0) {
			currentAmt = remainingAmt;
			interest = Math.round(monthlyInterestRate * remainingAmt * 100) / 100.0;	
			remainingAmt = currentAmt + interest - monthlyPmt;
			//remainingAmt = Math.round(remainingAmt * 100) / 100.0;
			if(remainingAmt < 0) {
				monthlyPmt = monthlyPmt + remainingAmt;
				remainingAmt = 0;
				
			}
			amortizationTable += String.format("%-10s", month);
			String interestString = String.format("$%1.2f",interest);
			amortizationTable += String.format("%-16s", interestString);
			String monthlyPmtString = String.format("$%1.2f", monthlyPmt);
			amortizationTable += String.format("%-16s", monthlyPmtString);
			String remainingAmtString = String.format("$%1.2f", remainingAmt);
			amortizationTable += String.format("%s\n", remainingAmtString);
			//amortizationTable += String.format("%-10s$%-15s$%-15s$%s\n", month, interestString, monthlyPmtString, remainingAmtString);
			month++;
		}
		return amortizationTable;
	}

}
