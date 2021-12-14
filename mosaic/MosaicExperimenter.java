

import java.awt.*;

public class MosaicExperimenter {

	public static void main(String[] args) {
		int rows = 4;
		int cols = 8;
		int width = 40;
		int height = 50;
		Mosaic.open(rows, cols, width, height);
		
		int currRow = 0;
		int currCol = 0;
		
		while(Mosaic.isOpen()) {
			Mosaic.delay(200);
			Mosaic.setColor(currRow, currCol, getRandColor());
			currCol++;
			if(currCol == cols) { //reset columns and move row down
				currCol = 0;
				currRow++;
			}
			if(currRow == rows) {
				currRow = 0;
			}
		}
	}//end main
	
	public static Color getRandColor() {
		int red = (int)(Math.random() * 256);
		int green = (int)(Math.random() * 256);
		int blue = (int)(Math.random() * 256);
		return new Color(red, green, blue);
	}

}//end class
