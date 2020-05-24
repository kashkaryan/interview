import java.util.Arrays;

/**
 * <h1>QUESTION 6: SUM OF CARDS</h1>
 * <p/>
 *
 * Class to implement the algorithm to determine which version of the "Sum of Cards" game will
 * win the most amount of money.
 * <p/>
 *
 * See description of problem and example in the write-up.
 *
 * @author bursztyn, 19sp
 */
public class Question6 {

    /**
     * Returns which version -- 1 or 2 -- performs best given a deck of cards. In case of a
     * tie, we arbitrarily choose version 2 to win.
     *
     * @param cards the deck of cards
     * @return the version that performed best -- either 1 or 2
     * 
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static int getBetterVersion(int[] cards) {
        return version1(cards) > version2(cards) ? 1 : 2;
    }
    
    /**
     * Returns the payout amount for version 1 of the game.
     *
     * @param cards the deck of cards
     * @return the sum of the deck of cards divided by two
     * 
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static int version1(int[] cards) {
        return Arrays.stream(cards).sum() / 2;
    }

    /**
     * Returns the payout amount for version 2 of the game.
     *
     * @param cards the deck of cards
     * @return sum of payout(cards[a], cards[b]) for all pairs (a, b) such that 0 <= a < b <= n - 1
     *         (see writeup for more details)
     * 
     * @implSpec you may assume that input is valid and non-null. Do not throw any exceptions.
     */
    public static int version2(int[] cards) {
        // TODO: implement (see instructions and example in writeup).
        return 0;
    }

}
