import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Restore sentence from which spaces between words were removed, given dictionary of words.
 * <p>
 * Consider the following dictionary
 * { i, like, sam, sung, samsung, mobile, ice, cream, icecream, man, go, mango}
 * <p>
 * Input:  ilike
 * Output: Yes
 * The string can be segmented as "i like".
 * <p>
 * Input:  ilikesamsung
 * Output: Yes
 * The string can be segmented as "i like samsung" or "i like sam sung".
 */
public class RestoreSpacesInSentenceTest {

    @Test
    public void testRestoreSentence() {
        String[] dictionary = new String[]{"i", "hate", "sam", "sung", "samsung", "mobile", "ice", "cream", "icecream", "man", "go", "mango" };
        String mess = "manihatemobilesamsung";
        restore(mess, dictionary, "");
    }

    public void restore(String mess, String[] dictionary, String result) {
        for (int i = 1; i <= mess.length(); i++) {
            String substring = mess.substring(0, i);
            for (int j = 0; j < dictionary.length; j++) {
                String word = dictionary[j];
                if (word.equals(substring)) {
                    result = result + " " + word;
                    restore(mess.substring(i, mess.length()), dictionary, result);
                }
            }
        }
        System.out.println(result);
    }
}
