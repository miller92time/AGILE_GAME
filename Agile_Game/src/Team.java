import java.util.ArrayList;

public class Team {
    
    private ArrayList<Card> hand;
    private int numPlayers;
    private int score;
    private Deck deck;
    private boolean win = false;
    
    // Takes the game deck as input to the constructor so the team can draw cards
    public Team(Deck deck) {
    	this.deck = deck;
        hand = new ArrayList<Card>();
        numPlayers = 4; // Default is 4, can add ability to change it later
        score = 0;
    }
    
    // Returns the team's score
    public int getScore() {
        return score;
    }
    
    
    // Adds given number of points to team's score and returns new score
    public int addToScore(int points) {
        score += points;
        return score;
    }
    
    // Returns the team's hand as an ArrayList of Card objects
    public ArrayList<Card> getHand() {
        return hand;
    }
    
    public void setWin() {
    	win = true;
    }
    
    public boolean getWin() {
    	return win;
    }
    
    // Ensures that each team's hand always contains 10 cards and returns the updated hand
    public void drawCards() {
        while (hand.size() < 10) {
            hand.add(deck.draw());
        }
    }
    
    // TODO: Jenny - Add method to display the hand
}
