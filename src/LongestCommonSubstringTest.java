import org.junit.Assert;
import org.junit.Test;


public class
LongestCommonSubstringTest {

    @Test
    public void testLongestCommonSubstring(){
        String a = "abcaaa";
        String b = "bcdaaa";


        Assert.assertNotNull(getLongestCommSubstring(a, b));
        Assert.assertEquals("aaa", getLongestCommSubstring(a, b));
    }

    public String getLongestCommSubstring(String left, String right) {
        String result = "";
        int[][] lengthGrid = new int[left.length()][right.length()];
        int length = 0;
        for (int i = 0; i < left.length(); i++) {
            char leftChar = left.charAt(i);
            for (int j = 0; j < right.length(); j++) {
                char rightChar = right.charAt(j);
                if (leftChar == rightChar) {
                    if (i == 0 || j == 0) {
                        lengthGrid[0][0] = 1;
                    } else {
                        lengthGrid[i][j] = lengthGrid[i - 1][j - 1] + 1;
                    }
                    if (length < lengthGrid[i][j]) {
                        length = lengthGrid[i][j];
                        result = left.substring(i - length + 1, i + 1);
                    }
                }

            }

        }
        return result;
    }

}