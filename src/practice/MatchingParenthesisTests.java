package practice;

import org.junit.Test;

import java.util.Stack;

public class MatchingParenthesisTests {

    @Test
    public void testiIt() {
        String par1 = "{[()(){{{(())}}}]}";
        String par2 = "[()(){{{(()}}}]}";
        System.out.println(isParenthesisClosed(par1));
        System.out.println(isParenthesisClosed(par2));
    }

    private boolean isParenthesisClosed(String par) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < par.length(); i++) {
            char ch = par.charAt(i);
            if (ch == '{' || ch == '(' || ch == '[') {
                characterStack.push(ch);
            } else if (ch == '}' || ch == ')' || ch == ']') {
                Character topChar = characterStack.pop();
                if (ch == '}' && topChar != '{') {
                    return false;
                }
                if (ch == ')' && topChar != '(') {
                    return false;
                }
                if (ch == ']' && topChar != '[') {
                    return false;
                }
            }
        }
        if(characterStack.isEmpty()){
            return true;
        }
        return false;

    }
}
