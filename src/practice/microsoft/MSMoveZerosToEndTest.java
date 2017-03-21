package practice.microsoft;

import org.junit.Test;

/**
 * Created by vrastil on 22.2.2017.
 */
public class MSMoveZerosToEndTest {
    @Test
    public void testIt() {
        int[] arr = new int[]{0, 1, 2, 0, 0, 3, 0, 4, 5, 0};
        shuffle(arr);
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            System.out.println(val);
        }
    }

    public void shuffle(int[] a) {
        int zeroCount = 0;
        for (int i = 0; i < a.length; i++) {
            int val = a[i];
            if (val != 0) {
                a[i - zeroCount] = val;
            } else {
                zeroCount++;
            }
        }
        for (int i = a.length - zeroCount; i < a.length; i++) {
            a[i] = 0;
        }
    }
}
