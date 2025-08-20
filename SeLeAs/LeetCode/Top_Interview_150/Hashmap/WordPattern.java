package Top_Interview_150.Hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, Integer> charToIndex = new HashMap<>();
        Map<String, Integer> wordToIndex = new HashMap<>();

        String[] words = s.split(" ");
        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char ch = pattern.charAt(i);
            String word = words[i];

            if (!charToIndex.getOrDefault(ch, 0).equals(wordToIndex.getOrDefault(word, 0)))
                return false;

            charToIndex.put(ch, i + 1);
            wordToIndex.put(word, i + 1);
        }
        return true;
    }
}

}
