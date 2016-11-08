import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a linked list, determine whether it contains a cycle
 * <p>
 * 1 -> 2 -> 3 -> 4
 * ^         |
 * |_________|
 *
 */
public class LinkedListCycleTest {
    @Test
    public void testCycleInList(){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.children.add(node2);
        node2.children.add(node3);
        node3.children.add(node1);
        node3.children.add(node4);
        Assert.assertTrue(isCycleInLinkedList(node1));
    }

    private boolean isCycleInLinkedList(Node node) {
        if(node == null || node.children.isEmpty()){
            return false;
        }


        for (Node child : node.children) {
            ArrayList<Node> visitedNodes = new ArrayList<>();
            if(traverseTree(child, visitedNodes)){
                return true;
            }
        }
        return false;
    }

    private boolean traverseTree(Node node, List<Node> visitedNodes){
        for (Node visitedNode : visitedNodes) {
            if(node.value == visitedNode.value){
                return true;
            }
            visitedNodes.add(node);
            traverseTree(visitedNode, visitedNodes);

        }

        return false;
    }



    private class Node{
        int value;

        Node(int value) {
            this.value = value;
        }

        private List<Node> children = new ArrayList<>();
    }
}
