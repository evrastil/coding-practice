package practice.searching;

import org.junit.Test;

import java.util.Arrays;

public class BinarySearchArrTest {
    @Test
    public void testIt() {
        //must be sorter array
        int[] ints = {-9, 14, 37, 102};
        System.out.println(binarySearchIterative(ints, 37));
        System.out.println(binarySearchRecursive(ints, 37, 0, ints.length - 1)>-1);
        //use standard jse lib
        System.out.println(Arrays.binarySearch(ints, 37) > -1);
    }

    int binarySearchRecursive(int[] ints, int k, int low, int high) {
        if (high < low) {
            return -1; // not found
        }
        int middle = low + ((high - low) / 2);
        if (ints[middle] > k) {
            return binarySearchRecursive(ints, k, low, middle - 1);
        } else if (ints[middle] < k) {
            return binarySearchRecursive(ints, k, middle + 1, high);
        } else {
            return middle; // found
        }
    }

    boolean binarySearchIterative(int[] ints, int k) {
        int low = 0;
        int high = ints.length - 1;
        int middle = (low + high) / 2;
        while (low <= high) {
            if (ints[middle] < k)
                low = middle + 1;
            else if (ints[middle] == k) {
//                System.out.println(k + " found at location " + (middle + 1) + ".");
                break;//found
            } else {
                high = middle - 1;
            }
            middle = (low + high) / 2;
        }
        if (low > high) {
            return false;
        } else {
            return true;
        }
    }

}
