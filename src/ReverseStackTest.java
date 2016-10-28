import org.junit.Assert;
import org.junit.Test;

import java.util.Stack;

/**
 * Given a stack, reverse the items without creating any additional data structures.
 */
public class ReverseStackTest {

    @Test
    public void testStackReversalNull(){
        Assert.assertNull(reverseStack(null));
    }

    @Test
    public void testStackReversalEmpty(){
        Assert.assertTrue(reverseStack(new Stack<>()).isEmpty());
    }
    @Test
    public void testStackReversal() {
        Stack<Integer> integerStack = new Stack<>();
        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);
        integerStack.push(5);
        integerStack.push(6);
        integerStack.push(7);
        integerStack.push(8);
        integerStack.push(9);

        Stack<Integer> reversedIntegerStack = reverseStack(integerStack);

        Assert.assertNotNull("must not be null", reversedIntegerStack);
        reversedIntegerStack.forEach(System.out::println);
        Integer previous = null;
        for (Integer integer : reversedIntegerStack) {
            Assert.assertTrue(previous == null || integer < previous);
            previous = integer;
        }
    }

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

    @Deprecated
    public Stack<Integer> reverseStack(Stack<Integer> integerStack) {
        if (integerStack.isEmpty()) return integerStack;
        int size = integerStack.size();
        for (int i = size; i >= 1; i--) {
            Integer actual = integerStack.get(i - 1);
            integerStack.push(actual);
        }
        for (int i = 0; i < size; i++) {
            Integer actual = integerStack.get(i);
            integerStack.remove(actual);
        }
        return integerStack;
    }



    public Stack<Integer> reverse(Stack<Integer> stack) {
        if (stack.isEmpty()) return stack;
        int temp = stack.pop();
        reverse(stack);
        insertAtBottom(stack, temp);
        return stack;
    }

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