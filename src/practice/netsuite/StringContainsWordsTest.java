package practice.netsuite;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StringContainsWordsTest {
    @Test
    public void testIt() {
        String[] dict = new String[]{"a", "b", "c", "d", "e"};
        Set<String> words = new HashSet<>();
        containsWords("abc", dict, words);
        System.out.println(words);
        System.out.println(canBeSeparatedIntoWords("abcd", dict));
    }

    void containsWords(String str, String[] dict, Set<String> words) {
        int length = str.length();
        if (length == 0) {
            return;
        }
        for (int i = 0; i < dict.length; i++) {
            if (dict[i].equals(str)) {
                words.add(str);
            }
        }
        for (int i = 1; i < str.length(); i++) {
            containsWords(str.substring(0, length - i), dict, words);
            containsWords(str.substring(i, length), dict, words);
        }
    }

    boolean canBeSeparatedIntoWords(String str, String[] dict) {
        int length = str.length();
        if (length == 0) {
            return true;
        }
        for (int i = 0; i < dict.length; i++) {
            if (dict[i].equals(str)) {
                return true;
            }
        }
        for (int i = 1; i < str.length(); i++) {
            return canBeSeparatedIntoWords(str.substring(0, length - i), dict) && canBeSeparatedIntoWords(str.substring(i, length), dict);
        }
        return false;
    }
}
