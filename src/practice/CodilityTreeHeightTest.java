package practice;

import org.junit.Test;

/**
 * Created by vrastil on 11.2.2017.
 */
public class CodilityTreeHeightTest {

    @Test
    public void testIt() {
        Tree t1 = new Tree(1, null, null);
        Tree t10 = new Tree(10, t1, null);

        Tree t20 = new Tree(20, null, null);
//        Tree t30 = new Tree(30, null, null);
        Tree t21 = new Tree(21, null, null);
        Tree t3 = new Tree(3, t20, t21);

        Tree t5 = new Tree(5, t3, t10);

        int solution = solution(t5);
        System.out.printf(String.valueOf(solution));
    }

    public int solution(Tree T) {
        if (T == null) {
            return -1;
        }
        int left = 1 + solution(T.left);
        int right = 1 + solution(T.right);
        int max = Math.max(right, left);
        return max;
    }

    class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }
}
