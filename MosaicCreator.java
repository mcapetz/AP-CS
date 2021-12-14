import java.awt.Color;

public class MosaicCreator {
	public static void main(String[] args) {
		welcome();
		
		System.out.println("Enter the number of rows: ");
		int rows = TextIO.getlnInt();
		System.out.println("Enter the number of columns: ");
		int cols = TextIO.getlnInt();
		Mosaic.open(rows, cols, 40, 40);
		
		colorDescription();
		
		int currRow = 0;
		int currCol = 0;
		int indexArr = 0;
		char[] arr = new char[rows*cols];
		
		while(Mosaic.isOpen()) {
			System.out.println("Enter the colors for row #"+ (currRow+1));
			String colorString = TextIO.getlnString();
			colorString = colorString.toLowerCase();
			for(int i =0; i<cols && i<colorString.length();i++) {
				Mosaic.setColor(currRow, currCol, charToColor(colorString.charAt(i)));
				arr[indexArr] = colorString.charAt(i);
				indexArr++;
				currCol++;
			}
			if(colorString.length()<cols) {
				for(int j = currCol;j<cols;j++) {
					Mosaic.setColor(currRow, currCol, Color.BLACK);
					arr[indexArr] = ' ';
					indexArr++;
					currCol++;
				}
			}
			
			if(currCol == cols) { //reset columns and move row down
				currCol = 0;
				currRow++;
			}
			if(currRow == rows) {
				break;
			}
		}
		
		currRow = 0;
		currCol = 0;
		int countArr = 0;
		Mosaic.delay(1000);
		while(Mosaic.isOpen()) {
			Mosaic.setColor(currRow, currCol, newColor(arr[countArr]));
			arr[countArr] = newChar(arr[countArr]);
			countArr++;
			currCol++;
			if(currCol == cols) { //reset columns and move row down
				currCol = 0;
				currRow++;
			}
			if(currRow == rows) {
				Mosaic.delay(1000);
				currRow = 0;
			}
			if(countArr == arr.length) {
				countArr = 0;
			}
		}

	}
	
	private static void welcome() {
		System.out.println("Welcome to the Mosaic Creator!");
	}
	
	private static void colorDescription() {
		System.out.println("The following color codes are: ");
		System.out.printf("%-15s%-15s%-15s","r for red","g for green","b for blue");
		System.out.println("");
		System.out.printf("%-15s%-15s%-15s","y for yellow","c for cyan","m for magenta");
		System.out.println("");
		System.out.printf("%-15s%s","w for white","any character (including spaces) for black");
		System.out.println("");
	}
	
	private static Color charToColor(char c) {
		switch (c) {
		case ('r'):
			return Color.RED;
		case ('g'):
			return Color.GREEN;
		case('b'):
			return Color.BLUE;
		case('y'):
			return Color.YELLOW;
		case('c'):
			return Color.CYAN;
		case('m'):
			return Color.MAGENTA;
		case('w'):
			return Color.WHITE;
		default:
			return Color.BLACK;
	}
	}
	
	private static Color newColor(char c) {
		switch (c) {
		case ('r'):
			return Color.CYAN;
		case ('g'):
			return Color.BLUE;
		case('b'):
			return Color.MAGENTA;
		case('y'):
			return Color.WHITE;
		case('c'):
			return Color.YELLOW;
		case('m'):
			return Color.BLACK;
		case('w'):
			return Color.GREEN;
		default:
			return Color.RED;
	}
	}
	
	private static char newChar(char c) {
		switch (c) {
		case ('r'):
			return 'c';
		case ('g'):
			return 'b';
		case('b'):
			return 'm';
		case('y'):
			return 'w';
		case('c'):
			return 'y';
		case('m'):
			return ' ';
		case('w'):
			return 'g';
		default:
			return 'r';
	}
	}
	
}
