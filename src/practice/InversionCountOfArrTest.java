package practice;

import org.junit.Test;

/**
 * Created by eda on 19.3.17.
 */
public class InversionCountOfArrTest {
    @Test
    public void testIt() {
        int[] A = new int[]{1, 9, 6, 4, 5};
        System.out.println(countInversions(A));
    }

    public int countInversions(int[] arr) {
        int invCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i];
            for (int j = i; j < arr.length; j++) {
                int i2 = arr[j];
                if (i < j && i1 > i2) {
                    invCount++;
                }
            }
        }
        return invCount;
    }
}
