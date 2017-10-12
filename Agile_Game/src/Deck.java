import java.util.LinkedList;

public class Deck {
    private LinkedList<Card> cards;
    
    public Deck() {
        // There are 50 cards in a deck
        for (int i = 0; i < 50; i++) {
            Card card = new Card();
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
}
