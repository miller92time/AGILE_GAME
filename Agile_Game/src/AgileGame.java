import javax.swing.*;
import java.awt.*;

public class AgileGame {
	
	//game variables
	String gameString;
	int gameWidth;
	int gameHeight;
	static boolean gameStatus;
	JFrame frame;
    Dice dice;
    Deck deck;
    
    public AgileGame() {
        gameString = "Agile Game";
        gameWidth = 1000;
        gameHeight = 1000;
        gameStatus = true;
        frame = new JFrame(gameString);
        dice = new Dice();
    }
    
    public void rollDice() {
        int[] diceRolls = dice.rollDice();
        // TODO: Display graphics for each die, getting upward facing value from diceRolls
    }
    
    public void drawCard() {
        Card card = deck.draw();
        int value = card.getValue();
        int storyPoints = card.getStoryPoints();
        // TODO: Display graphics for card, using value and storyPoints to populate numbers
    }
	
	
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
             * (Use calls to drawCard and rollDice)
			 */
			
		}
		
	}

}
