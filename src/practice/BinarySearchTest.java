package practice;

import org.junit.Test;

import java.util.Arrays;

public class BinarySearchTest {
    @Test
    public void itestIt() {
        //must be sorter array
        int[] ints = {-9, 14, 37, 102};
        System.out.println(binarySearch(ints, 37));
        //use standard jse lib
        System.out.println(Arrays.binarySearch(ints, 36) > -1);
    }

    int binarySearchRecursive(int[] ints, int k, int low, int high) {
        if (high < low) {
            return -1; // not found
        }
        int mid = low + ((high - low) / 2);
        if (ints[mid] > k) {
            return binarySearchRecursive(ints, k, low, mid - 1);
        } else if (ints[mid] < k) {
            return binarySearchRecursive(ints, k, mid + 1, high);
        } else {
            return mid; // found
        }
    }

    boolean binarySearch(int[] ints, int k/*, int low, int high*/) {
        int low = 0;
        int high = ints.length - 1;
        int middle = (low + high) / 2;
        while (low <= high) {
            if (ints[middle] < k)
                low = middle + 1;
            else if (ints[middle] == k) {
//                System.out.println(k + " found at location " + (middle + 1) + ".");
                break;
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
