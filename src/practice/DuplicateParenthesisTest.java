package practice;


import org.junit.Test;

import java.util.Stack;

public class DuplicateParenthesisTest {
    @Test
    public void testIt() {
        String expression = "((x+y)+((z)))"; //true at z
        System.out.println(isDuplicate(expression));
    }

    private boolean isDuplicate(String expression) {
        Stack<Character> characterStack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                characterStack.push(ch);
            } else if (ch == ')') {
                if (characterStack.peek() == ')') {
                    int parLeftCount = 0;
                    characterStack.pop();
                    while (characterStack.pop() == '(') {
                        parLeftCount++;
                        if (parLeftCount > 1) {
                            return true;
                        }
                    }
                }
                characterStack.push(ch);
            }
        }
        return false;
    }
}
