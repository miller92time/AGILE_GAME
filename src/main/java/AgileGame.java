import javax.swing.*;

import java.awt.*;

public class AgileGame implements Runnable {

	//game variables
	final String gameString = "Agile Game";
	final int gameWidth = 1280;
	final int gameHeight = 1024;
	static boolean gameStatus;
	JFrame frame;
	Dice dice;
	Deck deck;
	static Team team1;
	static Team team2;

	public AgileGame() {
		
		gameStatus = true;
		frame = new JFrame(gameString);
		dice = new Dice();
        deck = new Deck();
		team1 = new Team(deck, dice);
		team2 = new Team(deck, dice);
		team1.setName(AgileGameDemo.team1name);
		team1.setNumber(AgileGameDemo.team1player);
		team2.setName(AgileGameDemo.team2name);
		team2.setNumber(AgileGameDemo.team2player);
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
		frame.setLayout(null);
		//
		///
		
	}
	
	

	//
	private final static JLabel t1lab = new JLabel("<html>Total<br>Value Points</html>");
	public static void main(String[] args) {

		//initial dispay stuff
		AgileGame game = new AgileGame();
		game.initializeGUI();
		/**
		 * Initialize the contents of the frame.
		 */
		JPanel Team1Panel = new JPanel();
		Team1Panel.setBackground(Color.LIGHT_GRAY);
		Team1Panel.setBounds(0, 0, 430, 100);
		game.addComponent(Team1Panel);
		Team1Panel.setLayout(null);
		t1lab.setFont(new Font("Tahoma", Font.BOLD, 24));
		t1lab.setBounds(0, 42, 284, 58);
		Team1Panel.add(t1lab);
		
		JLabel t1pointslab = new JLabel(String.valueOf(team1.getScore()));
		t1pointslab.setHorizontalAlignment(SwingConstants.CENTER);
		t1pointslab.setFont(new Font("Tahoma", Font.BOLD, 24));
		t1pointslab.setBounds(260, 0, 170, 100);
		Team1Panel.add(t1pointslab);
		
		JLabel t1namelab = new JLabel(team1.getName());
		t1namelab.setFont(new Font("Tahoma", Font.BOLD, 16));
		t1namelab.setBounds(0, 0, 170, 36);
		Team1Panel.add(t1namelab);
		
		JPanel Team2Panel = new JPanel();
		Team2Panel.setBackground(Color.LIGHT_GRAY);
		Team2Panel.setBounds(828, 0, 430, 100);
		game.addComponent(Team2Panel);
		Team2Panel.setLayout(null);
		
		JLabel t2lab = new JLabel("<html>Total<br>Value Points</html>");
		t2lab.setBounds(0, 42, 284, 58);
		Team2Panel.add(t2lab);
		t2lab.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		//
		JLabel t2pointslab = new JLabel(String.valueOf(team2.getScore()));
		t2pointslab.setHorizontalAlignment(SwingConstants.CENTER);
		t2pointslab.setFont(new Font("Tahoma", Font.BOLD, 24));
		t2pointslab.setBounds(260, 0, 170, 100);
		Team2Panel.add(t2pointslab);
		
		JLabel t2namelab = new JLabel(team2.getName());
		t2namelab.setFont(new Font("Tahoma", Font.BOLD, 16));
		t2namelab.setBounds(0, 0, 170, 36);
		Team2Panel.add(t2namelab);
		
		JPanel SprintPanel = new JPanel();
		SprintPanel.setBackground(Color.WHITE);
		SprintPanel.setBounds(430, 0, 396, 100);
		game.addComponent(SprintPanel);
		SprintPanel.setLayout(null);
		
		JLabel SprintNumlab = new JLabel("Sprint 3");
		SprintNumlab.setFont(new Font("Tahoma", Font.BOLD, 24));
		SprintNumlab.setHorizontalAlignment(SwingConstants.CENTER);
		SprintNumlab.setBounds(0, 0, 396, 58);
		SprintPanel.add(SprintNumlab);
		
		JLabel TeamInfolab = new JLabel("Current playing: "+team1.getName());
		TeamInfolab.setFont(new Font("Tahoma", Font.BOLD, 16));
		TeamInfolab.setHorizontalAlignment(SwingConstants.CENTER);
		TeamInfolab.setBounds(0, 63, 396, 37);
		SprintPanel.add(TeamInfolab);
		//
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
			
			try {Thread.sleep(10);
			
			} catch (InterruptedException ex)
			{
				ex.printStackTrace();
			}
		}
		

	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		main(null);
	}

}
