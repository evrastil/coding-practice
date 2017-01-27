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
        restore(mess, mess.length(), dictionary, "");
    }

    public void restore(String mess, int messLength, String[] dictionary, String result) {
        for (int i = 1; i <= messLength; i++) {
            String substring = mess.substring(0, i);
            for (int j = 0; j < dictionary.length; j++) {
                String word = dictionary[j];
                if (word.equals(substring)) {
                    if (i == messLength) {
                        System.out.println(result);
                        return;
                    }
                    result = result + word + " ";
                    restore(mess.substring(i, messLength-1), messLength-1, dictionary, result);
                }
            }
        }

    }
}
