package practice.searching;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieAutocompleteTest {

    @Test
    public void testIt() {
        String[] dict = new String[]{"abc", "abd", "acde", "a"};
//        List collect = Arrays.stream(dict).filter(f -> f.contains("ab")).collect(Collectors.toList());
//        System.out.println(collect);

        Autocomplete autocomplete = new Autocomplete(dict);
        List<String> list = autocomplete.find("ab");
        for (String s : list) {
            System.out.println(s);
        }

    }

    class Node {
        String pref;
        Map<Character, Node> children = new HashMap<>();
        boolean isWord;

        Node(String pref) {
            this.pref = pref;
        }

        Node(String pref, boolean isWord) {
            this.pref = pref;
            this.isWord = isWord;
        }
    }

    class Autocomplete {

        Node trie;

        Autocomplete(String[] dict) {
            this.trie = new Node("");
            for (String s : dict) {
                add(s);
            }
        }

        private void add(String word) {
            Node curr = trie;
            for (int i = 0; i < word.length(); i++) {
                if (!curr.children.containsKey(word.charAt(i))) {
                    curr.children.put(word.charAt(i), new Node(word.substring(0, i + 1), i == word.length() - 1));
                }
                curr = curr.children.get(word.charAt(i));
            }
        }

        List<String> find(String prefix) {
            List<String> result = new ArrayList<>();
            Node curr = trie;
            //find the end of the prefix
            for (char ch : prefix.toCharArray()) {
                if (curr.children.containsKey(ch)) {
                    curr = curr.children.get(ch);
                } else {
                    return result; //nothing found, return empty
                }
            }
            //recurse to find all prefixes by key which are words
            collect(curr, result);
            return result;
        }

        private void collect(Node curr, List<String> result) {
            if (curr.isWord) {
                result.add(curr.pref);
            }
            for (Character ch : curr.children.keySet()) {
                collect(curr.children.get(ch), result);
            }
        }
    }
}
