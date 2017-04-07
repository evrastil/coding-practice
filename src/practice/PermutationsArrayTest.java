package practice;

import org.junit.Test;

import java.util.*;

public class PermutationsArrayTest {
    @Test
    public void testIt() {
        int[] arr = new int[]{1, 2, 3};
        Set<int[]> perms = new HashSet<>();
        getPermutations(arr, 0, perms);
        for (int[] perm : perms) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i : perm) {
                stringBuilder.append(i);
            }
            stringBuilder.append("\n");
            System.out.println(stringBuilder.toString());
        }

    }

    private void getPermutations(int[] arr, int start, Set<int[]> perms) {
        if (start >= arr.length) {
            perms.add(arr.clone());
        }else {
            for (int i = start; i < arr.length; i++) {
                int temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
                getPermutations(arr, start + 1, perms);
                temp = arr[start];
                arr[start] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
