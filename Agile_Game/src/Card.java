import java.util.Random;

public class Card {
    private int value;
    private int storyPoints;
    private Random rand;
    
    public Card() {
        rand = new Random();
        // Value is a random number between 1 and 20
        value = rand.nextInt(20) + 1;
        // Story points is a random number between 1 and 12
        storyPoints = rand.nextInt(12) + 1;
    }
    
    public int getValue() {
        return value;
    }
    
    public int getStoryPoints() {
        return storyPoints;
    }
    
    public int cardFailed() {
        storyPoints -= 1;
        return storyPoints;
    }
}
