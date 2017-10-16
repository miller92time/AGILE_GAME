import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Die extends JPanel{
    private int value;
    private Random rand;
    private BufferedImage image;
    private int xPos;
    private int yPos;
    
    public Die(int x, int y) {
    	
    	this.xPos = x;
    	this.yPos = y;
    	/* if we use an image
    	try {
    		image = ImageIO.read(new File("src/BlankCard.jpg"));
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}
    	*/
        value = 1;
        rand = new Random();
    }
    
    public int roll() {
        // Die values range from 1 to 6
        value = rand.nextInt(6) + 1;
        return value;
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	String display = "" + value;
    	g.setFont(new Font("TimesRoman" , Font.PLAIN,18));
    	g.drawString(display, xPos + 35, yPos +35);
    	g.drawRect(xPos, yPos, 75, 75);
    	//g.drawImage(image, 50, 50, null);
    }
}
