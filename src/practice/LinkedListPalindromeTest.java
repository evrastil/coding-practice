package practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a linked list, write a function to determine whether the list is a palindrome.
 */
public class LinkedListPalindromeTest {


    @Test
    public void testIsLinkedListPalindrome() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node32 = new Node(2);
        Node node31 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node32;
        node32.next = node31;

        //1->2->3->2->1 is palindrome
//              *
//                    *
        //1->2->3->3->2->1 is palindrome
        Assert.assertTrue(isPalindrome(node1)); //to return true
        Assert.assertTrue(isPalindromeV2(node1)); //to return true

        node2.value = 5;
        node1.value = 6;
        Assert.assertFalse(isPalindrome(node1)); //to return false
        Assert.assertFalse(isPalindromeV2(node1)); //to return false

        Node node21 = new Node(1);
        Node node22 = new Node(2);
        Node node232 = new Node(2);
        Node node231 = new Node(1);
        node21.next = node22;
        node22.next = node232;
        node232.next = node231;

        Assert.assertTrue(isPalindrome(node21)); //to return true
        Assert.assertTrue(isPalindromeV2(node21)); //to return true
        node22.value = 5;
        Assert.assertFalse(isPalindromeV2(node21)); //to return false
        Assert.assertFalse(isPalindrome(node21)); //to return false

    }

    public boolean isPalindromeV2(Node node) {
        Node curr = node;
        Node runner = node;

        Stack<Node> stack = new Stack<>();
        while (runner != null && runner.next != null) {
            stack.push(curr);
            curr = curr.next;
            runner = runner.next.next;
        }
        if(runner != null) {
            curr = curr.next;
        }
        while (curr != null) {
            if(curr.value != stack.pop().value){
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public boolean isPalindrome(Node node) {
        List<Node> nodeList = new ArrayList<>();
        createNodeList(nodeList, node);

        int size = nodeList.size();
        int index = size - 1;
        double mid = Math.floor(size / 2);

        for (int i = 0, j = index; i <= mid && j >= mid; i++, j--) {
            if (nodeList.get(i).value != nodeList.get(j).value) {
                return false;
            }
        }
        return true;
    }

    private void createNodeList(List<Node> nodeList, Node node) {
        if (node == null) {
            return;
        }
        nodeList.add(node);
        createNodeList(nodeList, node.next);
    }

    private class Node {
        private Node next;
        private int value;

        Node(int value) {
            this.value = value;
        }
    }
}
