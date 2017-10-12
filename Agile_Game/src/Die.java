import java.util.Random;

public class Die {
    private int value;
    private Random rand;
    
    public Die() {
        value = 1;
        rand = new Random();
    }
    
    public int roll() {
        // Die values range from 1 to 6
        value = rand.nextInt(6) + 1;
        return value;
    }
}
