import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeTraversalTest {

    class Node {
        Node left;
        Node right;
        int val;

        public Node(Node left, Node right, int val) {
            this.left = left;
            this.right = right;
            this.val = val;
        }
    }

    /*
              7
         5          9
       3   6     8    11
      1 4 2         10  12
    */
    @Test
    public void testIt() {
        Node node1 = new Node(null, null, 1);
        Node node4 = new Node(null, null, 4);
        Node node3 = new Node(node1, node4, 3);
        Node node2 = new Node(null, null, 2);
        Node node6 = new Node(node2, null, 6);
        Node node5 = new Node(node3, node6, 5);
        Node node8 = new Node(null, null, 8);
        Node node10 = new Node(null, null, 10);
        Node node12 = new Node(null, null, 12);
        Node node11 = new Node(node10, node12, 11);
        Node node9 = new Node(node8, node11, 9);
        Node node7 = new Node(node5, node9, 7);

        depth(node7);
        System.out.println("\n");
        breadth(node7);
    }

    public void depth(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            if (temp.right != null) {
                stack.push(temp.right);
            }
            if (temp.left != null) {
                stack.push(temp.left);
            }
            System.out.printf(" d " + String.valueOf(temp.val));
        }
    }

    public void breadth(Node node) {
        Queue<Node> stack = new LinkedList<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            Node temp = stack.poll();
            if (temp.left != null) {
                stack.add(temp.left);
            }
            if (temp.right != null) {
                stack.add(temp.right);
            }
            System.out.printf(" b " +String.valueOf(temp.val));
        }
    }

}
