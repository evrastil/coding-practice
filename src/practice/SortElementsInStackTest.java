package practice;

import org.junit.Test;

import java.util.Stack;

/**
 * Given a stack, sort the elements in the stack using one additional stack.
 */
public class SortElementsInStackTest {

    @Test
    public void testSortStack() {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(4);
        stack.push(6);
        stack.push(5);
        stack.push(1);
        stack.push(0);

        for (int i = 0; i < stack.size(); i++) {
            System.out.println(String.valueOf(stack.get(i)));
        }
        System.out.println("##############");
        stack = sortStackDescending(stack);
        for (int i = 0; i < stack.size(); i++) {
            System.out.println(String.valueOf(stack.get(i)));
        }
    }

    public Stack<Integer> sortStackDescending(Stack<Integer> stack) {
        Stack<Integer> newStack = new Stack<>();
        Integer first = stack.pop();
        newStack.push(first);
        while (!stack.isEmpty()) {
            Integer temp = stack.pop();
            while (!newStack.isEmpty() && temp > newStack.peek()) {
                stack.push(newStack.pop());
            }
            newStack.push(temp);
        }
        return newStack;
    }
}
