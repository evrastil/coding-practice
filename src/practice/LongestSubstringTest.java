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
        String a = "abcdcaa";
        String b = "kabcjha";
        int count = countLongestSubstring(a, b);
        System.out.println(count);

        String str = substringRecursive(a, b);
        System.out.println(str);
    }

    private int countLongestSubstring(String a, String b) {
        int[][] cache = new int[a.length()][b.length()];
        int max = 0;
//        String string = "";
        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {
                char charAtA = a.charAt(i);
                char charAtB = b.charAt(j);
                if (charAtA == charAtB) {
                    if (i == 0 || j == 0) {
                        cache[i][j] = 1;
//                        string = String.valueOf(charAtA);
                    } else {
                        int localMax = cache[i - 1][j - 1] + 1;
                        cache[i][j] = localMax;
                        if (localMax > max) {
                            max = localMax;
//                            string = string + charAtA;
                        }
                    }
                }
            }
        }
        return max;
    }

    private String substringRecursive(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return "";
        } else if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
            return substringRecursive(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1)) + a.charAt(a.length() - 1);
        } else {
            String x = substringRecursive(a, b.substring(0, b.length() - 1));
            String y = substringRecursive(a.substring(0, a.length() - 1), b);
            return x.length() > y.length() ? x : y;
        }
    }
}
