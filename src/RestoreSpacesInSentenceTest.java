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
        String[] dictionary = new String[]{"to", "je", "co", "auto", "ma", "automat", "tojota", "au"};
        String mess = "tojotajetoautocomaautomat";
        restore(mess, dictionary, "");
    }

    public void restore(String stringWithoutSpaces, String[] dictionary, String result) {
        for (int i = 1; i <= stringWithoutSpaces.length(); i++) {
            String substring = stringWithoutSpaces.substring(0, i);
            for (String word : dictionary) {
                if (word.equals(substring)) {
                    result = result + word + " ";
                    if (i == stringWithoutSpaces.length()) {
                        System.out.println(result);
                        return;
                    }
                    restore(stringWithoutSpaces.substring(i, stringWithoutSpaces.length()), dictionary, result);
                }
            }
        }

    }
}
