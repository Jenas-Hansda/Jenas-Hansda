import java.util.*;

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {

        class TrieNode {
            Map<Character, TrieNode> children = new HashMap<>();
            List<String> product = new ArrayList<>();
        }

        TrieNode root = new TrieNode();

        // Sort products to ensure lexicographic order
        Arrays.sort(products);

        // Inline insertion logic
        for (String word : products) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                curr.children.putIfAbsent(c, new TrieNode());
                curr = curr.children.get(c);
                if (curr.product.size() < 3) {
                    curr.product.add(word);
                }
            }
        }

        List<List<String>> output = new ArrayList<>();
        TrieNode curr = root;

        for (char c : searchWord.toCharArray()) {
            if (curr != null && curr.children.containsKey(c)) {
                curr = curr.children.get(c);
                output.add(curr.product);
            } else {
                curr = null;
                output.add(new ArrayList<>());
            }
        }

        return output;
    }
};