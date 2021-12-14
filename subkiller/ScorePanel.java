import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
	int score = 0;
	JSlider slider;
	JLabel scoreLabel;

	public ScorePanel() {
		this.setLayout(new GridLayout(1,2));
		
		JPanel difficultyPanel = new JPanel();
		
		JLabel difficultyLabel = new JLabel("Difficulty: ");
		slider = new JSlider(1,5,1);
		slider.setMajorTickSpacing(2);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.setSnapToTicks(true);
		
		difficultyPanel.add(difficultyLabel);
		difficultyPanel.add(slider);
		
		scoreLabel = new JLabel("Score: "+score);
		
		this.add(difficultyPanel);
		this.add(scoreLabel);
		
	}

	public JSlider getSlider() {
		return slider;
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public JLabel getScoreLabel() {
		return scoreLabel;
	}
}
