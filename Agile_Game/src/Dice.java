public class Dice {
    private Die die1;
    private Die die2;
    
    public Dice() {
        die1 = new Die();
        die2 = new Die();
    }
    
    public int[] rollDice() {
        int[] dieRolls = new int[2];
        dieRolls[0] = die1.roll();
        dieRolls[1] = die2.roll();
        return dieRolls;
    }
}
