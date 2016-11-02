import org.junit.Assert;
import org.junit.Test;

/**
 * https://www.interviewcake.com/question/java/single-rifle-check
 * I figured out how to get rich: online poker.
 * I suspect the online poker game I'm playing shuffles cards by doing a single " riffle."
 * <p>
 * To prove this, let's write a function to tell us if a full deck of cards shuffled_deck is a single riffle of two other halves half1 and half2.
 * <p>
 * We'll represent a stack of cards as a list of integers in the range 1..521..52 (since there are 5252 distinct cards in a deck).
 * <p>
 * Why do I care? A single riffle is not a completely random shuffle. If I'm right, I can make more informed bets and get rich and finally prove to my ex
 * that I am not a "loser with an unhealthy cake obsession" (even though it's too late now because she let me go and she's never getting me back).
 */
public class OnlinePokerTest {

    @Test
    public void testIsSingleRiffle(){

        int [] half1 = new int[]{1,3,5};
        int [] half2 = new int[]{2,4,6};
        int [] shuffled_deck = new int[]{1,2,3,4,5,6};
        Assert.assertTrue(isDeckSingleRiffle(shuffled_deck, half1, half2));

    }

    private boolean isDeckSingleRiffle(int[] shuffled_deck, int[] half1, int[] half2) {

        return true;
    }

}
