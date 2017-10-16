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
        gameWidth = 1280;
        gameHeight = 1024;
        gameStatus = true;
        frame = new JFrame(gameString);
        dice = new Dice();
    }
    
    public void rollDice() {
        int[] diceRolls = dice.rollDice();
        // TODO: Display graphics for each die, getting upward facing value from diceRolls
    }
    
    public void addComponent(JComponent c) {
    	frame.add(c);
    	//frame.revalidate();
    	//frame.repaint();
    }
    
    public void drawComponent() {
    	frame.revalidate();
    	frame.repaint();
        
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
		Deck deck = new Deck();
		Card card = new Card(50,50);
		game.addComponent(card);
		game.drawComponent();
		Card card2 = deck.draw();
		card2.setY(50);
		card2.setX(500);
		game.addComponent(card2);
		game.drawComponent();
		Die die = new Die(300,300);
		
		game.addComponent(die);
		game.drawComponent();
		
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
