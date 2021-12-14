
import javax.swing.*;
import java.awt.*;


public class SubkillerMain {
	public static void main(String[] args) {
	
		JFrame window = new JFrame("Sub Killer Game");
		
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());

		ScorePanel scorePanel = new ScorePanel();
		SubkillerPanel content = new SubkillerPanel(scorePanel);
		SubkillerListener listener = new SubkillerListener(content, scorePanel);
		
		container.add(content, BorderLayout.CENTER);
		container.add(scorePanel, BorderLayout.SOUTH);

		JMenuBar menuBar = new JMenuBar();
		
		JMenu subKillerMenu = new JMenu("Sub Killer");
		JMenu optionsMenu = new JMenu("Options");
		
		JMenuItem about = new JMenuItem("About");
		JMenuItem quit = new JMenuItem("Quit");
		JMenuItem restart = new JMenuItem("Restart");
		
		//register listener: component.addXXXListener(listener);
		about.addActionListener(listener);
		quit.addActionListener(listener);
		restart.addActionListener(listener);
		
		//container.add(component);
		subKillerMenu.add(about);
		subKillerMenu.addSeparator();
		subKillerMenu.add(quit);
		optionsMenu.add(restart);
		
		menuBar.add(subKillerMenu);
		menuBar.add(optionsMenu);		
		
		window.setJMenuBar(menuBar);
		window.setContentPane(container);
		
		window.setSize(600, 480);
		window.setLocation(100, 100);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false); // User can't change the window's size.
		window.setVisible(true);
	}
}
