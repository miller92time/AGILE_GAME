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
	Team team1;
	Team team2;

	public AgileGame() {
		
		gameStatus = true;
		frame = new JFrame(gameString);
		dice = new Dice();
        deck = new Deck();
		team1 = new Team(deck, dice);
		team2 = new Team(deck, dice);
	}


	public void addComponent(JComponent c) {
		//used for adding a component to the frame
		
		frame.add(c);
	}

	public void drawComponents() {
		//Refreshes and draws all current components in the game to the screen
		
		frame.revalidate();
		frame.setBackground(Color.WHITE);
		frame.repaint();
		
	}
	
	
	public void checkGameStatus() {
		//game logic here
		
		//on click events
		
		
		checkGameOver();
		
		
		
	}
	
	public void checkGameOver() {
		//Checks for game over and exits game loop
		
		//game over logic
		
		//if - exit button then exit
		
		if(team1.getScore() >= 100) team1.setWin();
		else if (team2.getScore() >= 100) team2.setWin();
		
		if(team1.getWin() || team2.getWin()) {
			frame.removeAll();
			//Graphics g = frame.getGraphics();
			//frame.add(g);
			gameStatus = false;
		}
			
		
		
		
		
	}


	private void initializeGUI() {
		//for initializing the initial gui
		frame.setSize(gameWidth, gameHeight);
		frame.setBackground(Color.WHITE);
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
		
		
		game.team1.drawCards();
		


		//need to add button for rolls


		game.addComponent(die);
		game.drawComponents();

		//game loop
		while(gameStatus) {
			
			//long currentTime = System.nanoTime();
			/*
			 * game loop
			 * 1. process input
			 * 2. update game state
			 * 3. render (update graphics)
			 * game.drawComponent();
			 * (Use calls to drawCard and rollDice)
			 */
			
			
			game.checkGameStatus();
			game.drawComponents();
			game.team1.addToScore(101);
			game.frame.removeAll();

		}
		

	}

}
