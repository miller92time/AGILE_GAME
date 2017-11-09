import org.junit.Test;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import org.junit.Before;

public class GameLogicTest {
    
    private Team team;
    private Deck deck;
    private Dice dice;
    private Team winTeam;
    private Team loseTeam;
    private Dice winDice;
    private Dice loseDice;
    
    @Before
    public void setUp() {
        // Team for testing deck and dice
        this.deck = new Deck();
        this.dice = new Dice();
        this.team = new Team(this.deck, this.dice);
        
        // Team with mock dice rigged to make every card attempt successful
        this.winDice = mock(Dice.class);
        int[] winner = {7,7};
        when(this.winDice.rollDice()).thenReturn(winner);
        this.winTeam = new Team(this.deck, this.winDice);
        
        // Team with mock dice rigged to make every card attempt fail
        this.loseDice = mock(Dice.class);
        int[] loser = {0,0};
        when(this.loseDice.rollDice()).thenReturn(loser);
        this.loseTeam = new Team(this.deck, this.loseDice);
    }
    
    /* User story: As a product owner game player, I want to draw 10 cards 
     * for my team at the start of the game.
     */
    @Test
    public void drawHandTest() {
        // Hand starts out empty
        assertThat(this.team.getHand().size(), equalTo(0));
        // Draw cards
        this.team.drawCards();
        // Hand should have 10 cards
        assertThat(this.team.getHand().size(), equalTo(10));
    }
    
    /* User story: As a product owner game player, I want to draw new cards
     * at the start of each turn/sprint.
     */
    @Test
    public void drawCardsTest() {
        // Start out with a full hand (10 cards)
        this.team.drawCards();
        // Remove two cards from hand
        this.team.removeCard(5);
        this.team.removeCard(7);
        // Hand should now contain 8 cards
        assertThat(this.team.getHand().size(), equalTo(8));
        // Draw cards
        this.team.drawCards();
        // Hand should contain 10 cards again
        assertThat(this.team.getHand().size(), equalTo(10));
    }
    
    /* User story: As a product owner game player, I want the option to return
     * some cards and draw new ones at the start of each turn/sprint.
     */
    @Test
    public void returnCardsTest() {
        // Draw new hand of cards
        this.team.drawCards();
        // Choose card to return
        Card card = this.team.getHand().get(0);
        // Return card to deck and draw new one to replace it
        this.team.swap(card);
        // Hand should still contain 10 cards
        assertThat(this.team.getHand().size(), equalTo(10));
        // Swapped card should be in the deck
        assertThat(this.deck.containsCard(card), is(true));
    }
    
    /* User stories: 
     * (1) As a game player, I want to roll the dice to determine whether
     * my story was successfully completed.
     * (2) As a game player, I want the value points from my successfully
     * completed story to be added to my team's total in the sprint review.
     */
    @Test
    public void successfulStoryTest() {
        // Draw new hand of cards
        this.winTeam.drawCards();
        // Score should start out at 0
        assertThat(this.winTeam.getScore(), equalTo(0));
        // Choose card from hand and take a player turn
        Card card = this.winTeam.getHand().get(0);
        this.winTeam.playerTurn(card);
        // Dice are rigged, so card should always be successful
        // Team score should equal value points from card
        assertThat(this.winTeam.getScore(), equalTo(card.getValue()));
        // Card should be removed from hand
        assertThat(this.winTeam.getHand().contains(card), is(false));
    }
    
    /* User stories:
     * (1) As a game player, I want to roll the dice to determine whether
     * my story was successfully completed.
     * (2) As a game player, I want the story point value for a card to
     * decrease by 1 if I do not successfully complete it in the current sprint.
     */
    @Test
    public void failedStoryTest() {
        // Draw new hand of cards
        this.loseTeam.drawCards();
        // Score should start out at 0
        assertThat(this.loseTeam.getScore(), equalTo(0));
        // Choose card from hand and take a player turn
        Card card = this.loseTeam.getHand().get(0);
        int storyPoints = card.getStoryPoints();
        this.loseTeam.playerTurn(card);
        // Dice are rigged, so card should always fail
        // Story points of card should be reduced by 1
        assertThat(card.getStoryPoints(), equalTo(storyPoints - 1));
        // Team score should still equal 0
        assertThat(this.loseTeam.getScore(), equalTo(0));
        // Card should still be in the hand
        assertThat(this.loseTeam.getHand().contains(card), is(true));
    }
}
