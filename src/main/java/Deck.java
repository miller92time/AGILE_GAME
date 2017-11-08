import java.awt.Graphics;
import java.util.LinkedList;
import javax.swing.JComponent;

public class Deck extends JComponent {
    private LinkedList<Card> cards;
    
    public Deck() {
    	cards = new LinkedList<Card>();
        // There are 50 cards in a deck
        for (int i = 0; i < 50; i++) {
            Card card = new Card(0,0);
            cards.add(card);
        }
    }
    
    public Card draw() {
        return cards.remove();
    }
    
    public boolean isEmpty() {
        return cards.isEmpty();
    }
    
    public Card swapCard(Card card) {
        cards.add(card);
        return cards.remove();
    }
    
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    //	g.drawImage(image, 50, 50, null);
    }
    
}
