
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.*;


public class SubkillerPanel extends JPanel{
    //------------------------------------------------------------------------

    // *** Don't forget to comment out "width, height" in your refactoring!!  
    // (Explained at 41:00 in 6.4 notes day 2 video)
    // This is because a JPanel object already knows its width/height, and you can call this.getWidth()
    // The problem is if you override this with your own "getWidth()" getter method, it'll grab that value
    // (probably 0) instead of the actual panel width! ***)
   // private int width, height;  // The size of the panel -- the values are set
                                //    the first time the paintComponent() method
                                //    is called.  This class is not designed to
                                //    handle changes in size; once the width and
                                //    height have been set, they are not changed.
                                //    Note that width and height cannot be set
                                //    in the constructor because the width and
                                //    height of the panel have not been set at
                                //    the time that the constructor is called.

   

	private Boat boat;          // The boat, bomb, and sub objects are defined
    private Bomb bomb;          //    by nested classes Boat, Bomb, and Submarine,
    private Submarine sub;      //    which are defined later in this class.
                                //    Note that the objects are created in the
                                //    paintComponent() method, after the width
                                //    and height of the panel are known.
    
    private int subSpeed = 1;
    private ScorePanel scorePanel; //reference to increment score
    
    public SubkillerPanel(ScorePanel s) {
    	scorePanel = s;
        setBackground( new Color(0,200,0) ); 

    }
    
    public void restart() {
    	boat = null;
    	sub = null;
    	bomb = null;
    	subSpeed = 1;
    	scorePanel.setScore(0);
    	scorePanel.getScoreLabel().setText("Score: 0");
    	scorePanel.getSlider().setValue(1);
    }
    
    @Override
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);  // Fill panel with background color, green.
        
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        //*** Initialize if it's the first time
        // The reason we don't do it in the constructor is because we don't know the 
        // panel's getHeight() and getWidth() at that time, and the sub would be drawn off the screen
        if (boat == null) {
                // The first time that paintComponent is called, it assigns
                // values to the instance variables.
         
            boat = new Boat(this);
            sub = new Submarine(this);
            bomb = new Bomb(this, boat, sub);
        }

        if (hasFocus())
            g.setColor(Color.CYAN);
        else {
            g.setColor(Color.BLACK);
            g.drawString("CLICK TO ACTIVATE", 20, 30);
            g.setColor(Color.GRAY);
        }
        g.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);  // Draw a 3-pixel border.
        g.drawRect(1,1,this.getWidth()-3,this.getHeight()-3);
        g.drawRect(2,2,this.getWidth()-5,this.getHeight()-5);

        boat.draw(g); //**Like a Rectangle, a Boat object knows how to draw itself
        sub.draw(g);
        
        for(int i = 1; i < subSpeed; i++) {
        	sub.updateForNewFrame();
        	sub.draw(g);
        }
        
        bomb.draw(g); 
    }
    
    public Boat getBoat() {
		return boat;
	}

	public void setBoat(Boat boat) {
		this.boat = boat;
	}

	public Bomb getBomb() {
		return bomb;
	}

	public void setBomb(Bomb bomb) {
		this.bomb = bomb;
	}

	public Submarine getSub() {
		return sub;
	}

	public void setSub(Submarine sub) {
		this.sub = sub;
	}
	
	public void setSubSpeed(int speed) {
		this.subSpeed = speed;
	}
	
	public void incrementScore() {
		scorePanel.setScore(scorePanel.getScore() + 1);
		scorePanel.getScoreLabel().setText("Score: "+scorePanel.getScore());
	}
	
	
	
}
