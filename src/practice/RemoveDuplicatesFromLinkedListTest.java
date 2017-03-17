package practice;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by eda on 2.3.17.
 */
public class RemoveDuplicatesFromLinkedListTest {
    class Node {
        Node next;
        int val;

        public Node(Node next, int val) {
            this.next = next;
            this.val = val;
        }
    }

    @Test
    public void testIt() {
        Node n6 = new Node(null, 4);
        Node n5 = new Node(n6, 3);
        Node n4 = new Node(n5, 3);
        Node n3 = new Node(n4, 3);
        Node n2 = new Node(n3, 2);
        Node n1 = new Node(n2, 1);
        removeDuplicates(n1);
        System.out.println(n1);

    }

    public void removeDuplicates(Node node) {
        HashSet<Integer> values = new HashSet<>();
        Node prev = null;
        while (node != null) {
            if(values.contains(node.val)){
                prev.next = node.next;
            }else{
                values.add(node.val);
                prev = node;
            }
            node = node.next;
        }
        prev.next = null;
    }

}
