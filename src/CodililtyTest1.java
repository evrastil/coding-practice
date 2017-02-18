import org.junit.Test;

import java.util.LinkedList;
import java.util.Stack;

/**
 * Created by vrastil on 18.2.2017.
 */
public class CodililtyTest1 {
    @Test
    public void testìT() {
        System.out.println(getSolution2("99*9*9*9*9*9*9*9*9*9*9*9*9"));
    }


    public int getSolution2(String S) {

        if (S == null || S.length() == 0) {
            return -1;
        }

        Stack<Integer> stack = new Stack();

        for (int i = 0; i < S.length(); ++i) {
            char character = S.charAt(i);

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
