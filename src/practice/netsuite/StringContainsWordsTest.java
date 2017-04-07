package practice.netsuite;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StringContainsWordsTest {
    @Test
    public void testIt() {
        String[] dict = new String[]{"a", "b", "c"};
        List<String> words = new ArrayList<>();
        containsWords("ab", dict, words);
        System.out.println(words);
    }

    void containsWords(String str, String[] dict, List<String> words) {
        if (str.length() == 0) {
            return;
        }
        for (int i = 0; i <= str.length(); i++) {

            if (dict[i].equals(str)) {
                words.add(str);
            }
            containsWords(str.substring(i, str.length()), dict, words);
            containsWords(str.substring(0, str.length() - i), dict, words);
        }
    }
}
