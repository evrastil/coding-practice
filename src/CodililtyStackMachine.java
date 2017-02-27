import org.junit.Test;

import java.util.Stack;

/**
 * Created by vrastil on 18.2.2017.
 */
public class CodililtyStackMachine {
    @Test
    public void testìT() {
        System.out.println(solution("13+62*7+*"));
    }


    public int solution(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); ++i) {
            char character = s.charAt(i);

            if (character >= '0' && character <= '9') {
                stack.push(character - '0');
            } else if (stack.size() >= 2) {
                if (character == '+') {
                    int intVal = stack.pop() + stack.pop();
                    if (intVal >= 4096) {
                        return -1;
                    }
                    stack.push(intVal);
                } else if (character == '*') {
                    int intVal = stack.pop() * stack.pop();
                    if (intVal >= 4096) {
                        return -1;
                    }
                    stack.push(intVal);
                } else {
                    return -1;
                }
            } else {
                return -1;
            }
        }

        return stack.peek();


    }

}
