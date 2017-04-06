package practice;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AutocompleteTest {

    @Test
    public void testIt(){
        String[] dict = new String[]{"abc", "abd", "acde", "a"};
        List collect = Arrays.stream(dict).filter(f -> f.contains("ab")).collect(Collectors.toList());
        System.out.println(collect);
    }
}
