package practice;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationOfStringTest {
    @Test
    public void testIt() {
        String s = "abc";
        List<String> result = new ArrayList<>();
        permutations("", s, result);
        for (String r : result) {
            System.out.println(r);
        }

    }

    private void permutations(String prefix, String s, List<String> result) {
        int length = s.length();
        if (length == 0) {
//            System.out.println(prefix);
            result.add(prefix);
        }
        for (int i = 0; i < length; i++) {
            permutations(prefix + s.charAt(i), s.substring(0, i) + s.substring(i + 1, length), result);
        }
    }
}
