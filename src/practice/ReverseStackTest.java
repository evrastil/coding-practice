package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Given a stack, reverse the items without creating any additional data structures.
 */
public class ReverseStackTest {

    @Test
    public void testStackReversalRecursion() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);

        Stack<Integer> reversedIntegerStack = reverse(integerStack);

        Assert.assertNotNull("must not be null", reversedIntegerStack);
        Integer previous = null;
        for (Integer integer : reversedIntegerStack) {
            Assert.assertTrue(previous == null || integer < previous);
            previous = integer;
        }
        reversedIntegerStack.forEach(System.out::println);
    }

    /**
     * User recursion to emty stack and store temp to recursive stack, then call insert at bottom.
     */
    public Stack<Integer> reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return stack;
        int temp = stack.pop();
        reverse(stack);
        insertAtBottom(stack, temp);
        return stack;
    }

    /**
     * Recurse to empty stack and store tam to call stack then push temp to the bottom
     */
    private void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        int temp = stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
    }
}