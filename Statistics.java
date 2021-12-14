//utility class, collection of useful methods for others to use, no main method
import java.util.Arrays;

public class Statistics {
	
	public static double calculateAverage(int[] nums) {
		double sum = 0;
		for(int i = 0; i<nums.length; i++) {
			sum += nums[i];
		}
		return sum/nums.length;
	}
	
	
	
	public static double calculateAverage(double[] nums) {
		double sum = 0;
		for(int i = 0; i<nums.length; i++) {
			sum += nums[i];
		}
		return sum/nums.length;
	}
	
	public static double calculateAverage(String[] nums) {
		double sum = 0;
		for(int i = 0; i<nums.length; i++) {
			sum += Double.parseDouble(nums[i]);
		}
		return sum/nums.length;
	}
	
	/**
	 * calculates the arithmetic mean of 2 numbers
	 * @param x The first input
	 * @param y The second input
	 * @return The average of the 2 numbers
	 */
	
	public static double calculateAverage(int x, int y) {
		return (double)(x+y/2); //cast or set x and y as doubles
	}
	
	public static double calculateAverage(String x, String y) {
		return (double)(Double.parseDouble(x) + Double.parseDouble(y) /2); 
	}
	
	public static int calculateMedian(int[] nums) {
		Arrays.sort(nums);
		int x = nums.length/2;
		if(nums.length % 2 == 0) {
			return (nums[x-1] + nums[x]) / 2;
		}
		return nums[x];
	}
	
	public static double calculateMedian(double[] nums) {
		Arrays.sort(nums);
		int x = (int)nums.length/2;
		if(nums.length % 2 == 0) {
			return (nums[x-1] + nums[x]) / 2;
		}
		return nums[x];
	}
	
	public static String calculateMedian(String[] nums) {
		Arrays.sort(nums);
		int x = nums.length/2;
		if(nums.length % 2 == 0) {
			return "" + (Integer.parseInt(nums[x-1]) + Integer.parseInt(nums[x]))/2;
		}
		return nums[x];
	}
	
	public static int calculateStdDev(int[] nums) {
		double avg = calculateAverage(nums);
		double squaredSum = 0;
		for(int i = 0; i<nums.length; i++) {
			squaredSum += Math.pow(avg - nums[i], 2);
		}
		return (int)Math.pow(squaredSum/(nums.length),0.5);		
	}
	
	public static double calculateStdDev(double[] nums) {
		double avg = calculateAverage(nums);
		double squaredSum = 0;
		for(int i = 0; i<nums.length; i++) {
			squaredSum += Math.pow(avg - nums[i], 2);
		}
		return Math.pow(squaredSum/(nums.length),0.5);		
	}
	
	public static String calculateStdDev(String[] nums) {
		double avg = calculateAverage(nums);
		double squaredSum = 0;
		for(int i = 0; i<nums.length; i++) {
			squaredSum += Math.pow(avg - Integer.parseInt(nums[i]), 2);
		}
		return "" + (int)Math.pow(squaredSum/(nums.length),0.5);		
	}
}