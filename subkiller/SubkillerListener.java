

import java.awt.event.*;

import javax.swing.JSlider;
import javax.swing.event.*;
import javax.swing.*;

public class SubkillerListener implements KeyListener, FocusListener, MouseListener, ActionListener, ChangeListener{
	
	
	SubkillerPanel gamePanel; //reference
	Timer timer; 
	
	public SubkillerListener(SubkillerPanel panel, ScorePanel scorePanel) {
		gamePanel = panel;
		//register listener
		gamePanel.addMouseListener(this);
		gamePanel.addKeyListener(this);
		gamePanel.addFocusListener(this);
		//no action listener added, generated by timers instead
		timer = new Timer(30, this); //registration
		timer.start();
		
		//score panel is jpanel, doesn't generate change events
		//add accessor method to scorepanel
		scorePanel.getSlider().addChangeListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String s = e.getActionCommand(); //"About", "Quit", "Restart", null for timer
	
		//timer ticks
		// TODO Auto-generated method stub
		if(s == null) {
			if (gamePanel.getBoat() != null) {
	            gamePanel.getBoat().updateForNewFrame();
	            gamePanel.getBomb().updateForNewFrame();
	            gamePanel.getSub().updateForNewFrame();
	        }
			gamePanel.repaint();
		}
		else if(s.equals("About")){
			JOptionPane.showMessageDialog(gamePanel, "This game rocks!");
		}
		else if(s.equals("Quit")){
			System.exit(0);
		}
		else if(s.equals("Restart")){
			gamePanel.restart();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
        gamePanel.requestFocusInWindow();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		timer.start();
		gamePanel.repaint();
	}

	@Override
	public void focusLost(FocusEvent e) {
		// TODO Auto-generated method stub
		timer.stop();
		gamePanel.repaint(); //use hasFocus() in Subkiller panel to check what color to draw
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c = e.getKeyChar(); //char
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int code = e.getKeyCode(); //code (num)
		if (code == KeyEvent.VK_LEFT) {
            // Move the boat left.  (If this moves the boat out of the frame, its
            // position will be adjusted in the boat.updateForNewFrame() method.)
			gamePanel.getBoat().setCenterX(gamePanel.getBoat().getCenterX() - 15);
		}
		else if (code == KeyEvent.VK_RIGHT) {  
            // Move the boat right.  (If this moves boat out of the frame, its
            // position will be adjusted in the boat.updateForNewFrame() method.)
			gamePanel.getBoat().setCenterX(gamePanel.getBoat().getCenterX() + 15);
		}
		else if (code == KeyEvent.VK_DOWN) {
			// Start the bomb falling, if it is not already falling.
		if ( gamePanel.getBomb().isFalling() == false )
            gamePanel.getBomb().setFalling(true);
    }
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		// TODO Auto-generated method stub
		JSlider source = (JSlider)e.getSource();
		if(!source.getValueIsAdjusting()) { //only once they have stopped adjusting the slider
			int difficultyLevel = source.getValue();
			gamePanel.setSubSpeed(difficultyLevel);
			gamePanel.requestFocusInWindow();
		}
	}

}
