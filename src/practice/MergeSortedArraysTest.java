package practice;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by eda on 2.3.17.
 */
public class MergeSortedArraysTest {
    @Test
    public void testIt() {
        int[][] arr = new int[][]{
                {3, 6, 9},
                {2, 5, 8},
                {1, 4, 7}
        };
        System.out.println(Arrays.toString(sort(arr)));
    }

    public int[] sort(int[][] arr) {
        int[] sortedMerged = new int[arr.length * arr.length];
        int sorted = 0;
        for (int i = 0; i < arr.length; i++) {
            int[] sub = new int[arr.length];
            int subIndex = 0;
            for (int j = 0; j < arr.length; j++) {
                sub[subIndex++] = arr[j][i];

            }
            int srted = sub.length;
            while (srted != 0) {
                for (int j = 0; j < sub.length - 1; j++) {
                    if (sub[j] > sub[j + 1]) {
                        int temp = sub[j];
                        sub[j] = sub[j + 1];
                        sub[j + 1] = temp;
                    } else {
                        srted--;
                    }
                }
            }

            for (int j = 0; j < sub.length; j++) {
                sortedMerged[sorted++] = sub[j];
            }

        }

        return sortedMerged;
    }
}
