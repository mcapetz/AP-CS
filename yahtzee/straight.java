
public class straight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[] {2, 3, 4, 5, 5};
		System.out.println(calculateStraight(arr));
	}
	
	private static int calculateStraight(int[] checker) {
		int score = 0;
		if(checker[0] + 1 == checker[1] &&
				   checker[0] + 2 == checker[2] &&
				   checker[0] + 3 == checker[3] &&
				   checker[0] + 4 == checker[4]) {
					score = 25;
				}
				return score;
	}

}
