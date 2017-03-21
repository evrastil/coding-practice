package practice;

import org.junit.Test;

public class PermutationOfStringTest {
    @Test
    public void testIt(){
        String s = "abc";
        permutations("", s);
    }

    private void permutations(String prefix, String s) {
        int length  = s.length();
        if(s.length() == 0){
            System.out.println(prefix);
        }
        for (int i = 0; i < s.length(); i++) {
            permutations(prefix + s.charAt(i), s.substring(0,i)+s.substring(i+1, length));
        }
    }
}
