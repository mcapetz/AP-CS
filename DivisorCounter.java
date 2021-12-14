
public class DivisorCounter {
	
	public static void main(String[] args) {
		int n;
		int count = 0;
		int maxCount = 0;
		int maxIndex = 0;
		int divisors;
		int index;	
		String divisorsTracker = "";
		
		System.out.println("********Welcome to the Divisor Counter!********");
		System.out.println("Enter a positive integer and I will scan from 1 up to that number and output which");
		System.out.println("numbers in that range have the most divisors (and how many they had). ");
        System.out.println("");
        System.out.println("Integer to check up to? ");
		n = TextIO.getlnInt();
        //n = 10;
        
        for(index=1; index<=n; index++) {
        	int current = index;
        	count = 0;
        	for(int i=1; i<=current; i++) {
        		if(current%i == 0) {
        			count++;
        		}
        	}
        	if(count>=maxCount) {
        		maxCount = count;
        		maxIndex = index;
        		
        	}
        	//if(count == maxCount) {
        	//	System.out.println("count: "+count + " maxindex: " + maxIndex);
        		//System.out.println("max index: "+ maxIndex);
        	//	divisors = divisors + " " + maxIndex;
        	//	System.out.println("divisors: "+ divisors);
        	//}
        	//else {
        	//	divisors = "" + maxIndex;
        	//}
        	
        	
        }
        
        System.out.println("The number(s) between 1 and " + n + " with the most divisors are: ");
        
        for(index = 1; index <= n; index++) {
    	   count = 0;
    	   for(divisors = 1; divisors <= index; divisors++) {
       		if(index % divisors == 0) {
       			count++;
       		}
       	if(count == maxCount) {
       		System.out.format("%d ", divisors);
       	}
        	
        		
        
	
	}
    	   
	
}
        System.out.println("");
        System.out.println("They each have " + maxCount + " divisors.");

	}
}
 
        
        
        