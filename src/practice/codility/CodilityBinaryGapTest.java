package practice.codility;

import org.junit.Test;


public class CodilityBinaryGapTest {

    @Test
    public void testIt() {
        System.out.println(" longest gap is:" + solution(1041));
    }

    public int solution(int N) {
        String binaryString = Integer.toBinaryString(N);
        char[] charArray = binaryString.toCharArray();
        int longestGapSoFar = 0;
        int tempGap = 0;
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (ch == '0') {
                tempGap++;
            }
            if (ch == '1') {
                if (tempGap > longestGapSoFar) {
                    longestGapSoFar = tempGap;
                }
                tempGap = 0;
            }

        }
        return longestGapSoFar;
    }
}
