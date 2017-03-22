package practice;

import org.junit.Test;

import java.util.*;

/*

Given a set S, generate all subsets of it i.e., find power set of set S. A power set of any set S is the set of all subsets of S, including the empty set and S itself.


For example, if S is the set {x, y, z}, then the subsets of S are:

{} (also known as the empty set or the null set)
{x}
{y}
{z}
{x, y}
{x, z}
{y, z}
{x, y, z}
 */
public class GenerateSubsetsTest {
    @Test
    public void testIt() {
        String exp = "xyz";

        List<String> subsets = new ArrayList<>();
        generate(exp, exp.length(), subsets);
        for (String subset : subsets) {
            System.out.println(subset);
        }
    }

    public void generate(String expr, int length, List<String> subsets) {

        if (length == 0) {
            return;
        }



    }
}
