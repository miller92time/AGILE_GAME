import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Card extends JComponent{
    private int value;
    private int storyPoints;
    private Random rand;
    private Graphics cardG;
    private BufferedImage image;
    
    public Card() {
        rand = new Random();
        // Value is a random number between 1 and 20
        value = rand.nextInt(20) + 1;
        // Story points is a random number between 1 and 12
        storyPoints = rand.nextInt(12) + 1;
        try {
    		image = ImageIO.read(new File("src/BlankCard.jpg"));
    		int v = 0;
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}
    }
    
    public int getValue() {
        return value;
    }
    
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	g.drawImage(image, 50, 50, null);
    }
    
    public int getStoryPoints() {
        return storyPoints;
    }
    
    public int cardFailed() {
        storyPoints -= 1;
        return storyPoints;
    }
}
