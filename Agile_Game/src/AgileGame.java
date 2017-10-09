import javax.swing.*;
import java.awt.*;

public class AgileGame {
	
	//game variables
	String gameString = "Agile Game";
	int gameWidth = 1000;
	int gameHeight = 1000;
	static boolean gameStatus = true;
	JFrame frame = new JFrame(gameString);
	
	
	private void initializeGUI() {
		//for initializing the initial gui
		frame.setSize(gameWidth, gameHeight);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		AgileGame game = new AgileGame();
		game.initializeGUI();
		
		//game loop
		while(gameStatus) {
			/*
			 * game loop
			 * 1. process input
			 * 2. update game state
			 * 3. render (update graphics)
			 */
			
		}
		
	}

}
