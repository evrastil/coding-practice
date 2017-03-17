package practice;

import org.junit.Test;

import java.util.HashMap;

public class AreWordsAnagramsTest {
    @Test
    public void testIt() {
        System.out.println(isAnagram("axy", "xay"));
        System.out.println(isAnagram("abxy", "xay"));
        System.out.println(isAnagram("abc", "cba"));
    }

    private boolean isAnagram(String a, String b) {
        int aLength = a.length();
        if (aLength != b.length()) {
            return false;
        }
        HashMap<String, Integer> letters = new HashMap<>();
        for (int i = 0; i < aLength; i++) {
            String letter = String.valueOf(a.charAt(i));
            if (letters.containsKey(letter)) {
                letters.put(letter, letters.get(letter) + 1);
            } else {
                letters.put(letter, 1);
            }
        }
        for (int i = 0; i < aLength; i++) {
            String letter = String.valueOf(a.charAt(i));
            if(!letters.containsKey(letter)){
                return false;
            }else {
                letters.put(letter, letters.get(letter)-1);
            }
        }
        for (Integer count : letters.values()) {
            if(count>0){
                return false;
            }
        }
        return true;
    }
}
