import org.junit.Test;

import java.util.Random;

/**
 * Write a function for doing an in-place ↴ shuffle of a list.
 The shuffle must be "uniform," meaning each item in the original list must have the same probability of ending up in each spot in the final list.

 Assume that you have a function get_random(floor, ceiling) for getting a random integer that is >= floor and <= ceiling.
 */
public class InPlaceShuffleOfListTests {

    @Test
    public void testInPlaceShuffle(){
        int[] list = new int[]{1,5,7,8};
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        shuffle(list);
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
    }

    public void shuffle(int[] list) {
        int length = list.length;
        for (int i = 0; i < list.length; i++) {
            int random = getRandom(i, length-1);
            int numTemp = list[i];
            int numAtRnd = list[random];
            list[i] = numAtRnd;
            list[random] = numTemp;
        }
    }

    private int getRandom(int floor, int ceiling) {
        Random random = new Random();
        return random.nextInt((ceiling - floor) + 1) + floor;
    }


}
