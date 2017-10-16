import javax.swing.*;
import java.awt.*;

public class AgileGame {

	//game variables
	final String gameString = "Agile Game";
	final int gameWidth = 1280;
	final int gameHeight = 1024;
	static boolean gameStatus;
	JFrame frame;
	Dice dice;
	Deck deck;

	public AgileGame() {
		
		gameStatus = true;
		frame = new JFrame(gameString);
		dice = new Dice();
	}


	public void addComponent(JComponent c) {
		//used for adding a component to the frame
		
		frame.add(c);
	}

	public void drawComponents() {
		//Refreshes and draws all current components in the game to the screen
		
		frame.revalidate();
		frame.repaint();
		
	}


	private void initializeGUI() {
		//for initializing the initial gui
		frame.setSize(gameWidth, gameHeight);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void main(String[] args) {

		//initial dispay stuff
		AgileGame game = new AgileGame();
		game.initializeGUI();
		Deck deck = new Deck();
		Card card = new Card(50,50);
		game.addComponent(card);
		game.drawComponents();
		Card card2 = deck.draw();
		card2.setY(50);
		card2.setX(500);
		game.addComponent(card2);
		game.drawComponents();
		Die die = new Die(300,300);


		//need to add button for rolls


		game.addComponent(die);
		game.drawComponents();

		//game loop
		while(gameStatus) {
			/*
			 * game loop
			 * 1. process input
			 * 2. update game state
			 * 3. render (update graphics)
			 * game.drawComponent();
			 * (Use calls to drawCard and rollDice)
			 */

		}

	}

}
