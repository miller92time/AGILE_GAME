import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Team {
    
    private ArrayList<Card> hand;
    private int numPlayers;
    private int score;
    private Deck deck;
    private Dice dice;
    private boolean win = false;
    private String Name;
    
    // Takes the game deck as input to the constructor so the team can draw cards
    public Team(Deck deck, Dice dice) {
    	this.deck = deck;
        this.dice = dice;
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
    public void setName(String n)
    {
    	Name=n;
    }
    public String getName()
    {
    	return Name;
    }
    public void setNumber(int n)
    {
    	numPlayers=n;
    }
    public int getNumber()
    {
    	return numPlayers;
    }
    // Ensures that each team's hand always contains 10 cards and returns the updated hand
    public void drawCards() {
        while (hand.size() < 10) {
            hand.add(deck.draw());
        }
    }
    
    // Allows team to remove a card from the hand
    public Card removeCard(int position) {
        Card card = hand.get(position);
        hand.remove(position);
        return card;
    }
    
    // Allows team's product owner to trade in a card for a new one from the deck
    public void swap(Card card) {
        hand.add(deck.swapCard(card));
        hand.remove(card);
    }
    
    // Takes the card the player chose for their turn and completes their dice roll
    public void playerTurn(Card card) {
        int goal = card.getStoryPoints();
        int[] diceRoll = dice.rollDice();
        int result = diceRoll[0] + diceRoll[1];
        if (result >= goal) {
            hand.remove(card);
            score += card.getValue();
        } else {
            card.cardFailed();
            // TODO: Redraw card with updated value
        }
    }
    
    // Add method to display the hand
    public void Display()
    {
    	Collections.sort(hand, new Comparator<Card>(){
    		public int compare(Card c1, Card c2){
    			return c1.getValue() > c2.getValue() ? -1 :(c1.getValue() < c2.getValue() ? 1 : 0);//descending  by card value
    		}
    	});
    }
}
