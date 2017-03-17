package practice;

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

    public boolean isSingleRiffle(int[] half1, int[] half2, int[] shuffledDeck) {
        int half1Index = 0;
        int half2Index = 0;
        int half1MaxIndex = half1.length - 1;
        int half2MaxIndex = half2.length - 1;

        for (int card : shuffledDeck) {
            // if we still have cards in half1
            // and the "top" card in half1 is the same
            // as the top card in shuffledDeck
            if (half1Index <= half1MaxIndex
                    && card == half1[half1Index]) {
                half1Index++;

                // if we still have cards in half2
                // and the "top" card in half2 is the same
                // as the top card in shuffledDeck
            } else if (half2Index <= half2MaxIndex
                    && card == half2[half2Index]) {
                half2Index++;

                // if the top card in shuffledDeck doesn't match the top
                // card in half1 or half2, this isn't a single riffle.
            } else {
                return false;
            }
        }

        // all cards in shuffledDeck have been "accounted for"
        // so this is a single riffle!
        return true;
    }

}
