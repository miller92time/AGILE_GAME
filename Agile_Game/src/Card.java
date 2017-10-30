import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Card extends JComponent{
	
	//need to add listener
	//need to add button
	
	
    private int value;
    private int storyPoints;
    private int xPos;
    private int yPos;
    private Random rand;
    private BufferedImage image;
    private InputStream str;
    private String imageStr = "BlankCard.jpg";
    private int sprint;
    private int team;
    public Card(int x , int y) {
    	this.xPos = x;
    	this.yPos = y;
        rand = new Random();
        // Value is a random number between 1 and 20
        value = rand.nextInt(20) + 1;
        // Story points is a random number between 1 and 12
        storyPoints = rand.nextInt(12) + 1;
        
        //load image
        str =ClassLoader.getSystemResourceAsStream(imageStr);
        try {
    		image = ImageIO.read(str);
    	} catch (IOException ex) {
    		ex.printStackTrace();
    	}
    }
    
    public int getValue() {
        return value;
    }
    
    public void setX(int x) {
    	this.xPos = x;
    }
    
    public void setY(int y) {
    	this.yPos = y;
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	
    	//story display strings
    	String displaySP = "Story Points: " + storyPoints;
    	String displayVal = "Value: " + value;
    	
    	//actually drawing the cards and stuff yo
    	g.setFont(new Font("TimesRoman" , Font.PLAIN,18));
    	g.drawImage(image, xPos, yPos, null);
    	g.drawString(displaySP, xPos + 15, yPos + 50);
    	g.drawString(displayVal, xPos + 15, yPos + 100);
    }
    
    public int getStoryPoints() {
        return storyPoints;
    }
    public int setSprint(){
    	return sprint;
    }
    public int getSprint()
    {
    	return sprint;
    }
    public int setTeam(){
    	return team;
    }
    public int getTeam()
    {
    	return team;
    }
    public int cardFailed() {
        storyPoints -= 1;
        return storyPoints;
    }
}
