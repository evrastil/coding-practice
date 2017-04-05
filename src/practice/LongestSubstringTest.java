package practice;

import org.junit.Test;

/**
 * Created by eda on 5.4.2017.
 */
public class LongestSubstringTest {
    @Test
    public void testIt() {
        /*
        abcdc
        kabcjh

           a b c d c a
        k  0 0 0 0 0 0
        a  1 0 0 0 0 1
        b  0 2 0 0 0 0
        c  0 0 3 0 1 0
        j  0 0 0 0 0 0
        h  0 0 0 0 0 0

         */
        String a = "abcdca";
        String b = "kabcjh";
        int count = countLongestSubstring(a, b);
        System.out.println(count);
    }

    private int countLongestSubstring(String a, String b) {
        int[][] cache = new int[a.length()][b.length()];
        int max = 0;
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                char charAtA = a.charAt(i);
                char charAtB = b.charAt(j);
                if (charAtA == charAtB) {
                    if (i == 0 || j == 0) {
                        cache[i][j] = 1;
                    } else {
                        int localMax = cache[i - 1][j - 1] + 1;
                        cache[i][j] = localMax;
                        if (localMax > max) {
                            max = localMax;
                        }
                    }
                }
            }
        }
        return max;
    }
}
