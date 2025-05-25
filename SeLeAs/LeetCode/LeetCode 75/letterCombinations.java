import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class letterCombinations{
    public class Solution {

        private List<String> combinations;
    
        public List<String> letterCombinationsRecursive(String digits) {
            if (digits == null || digits.isEmpty()) {
                return new ArrayList<>();
            }
    
            Map<Character, String> d = new HashMap<>();
            d.put('2', "abc");
            d.put('3', "def");
            d.put('4', "ghi");
            d.put('5', "jkl");
            d.put('6', "mno");
            d.put('7', "pqrs");
            d.put('8', "tuv");
            d.put('9', "wxyz");
    
            combinations = new ArrayList<>();
            comb(digits, 0, "", d);
            return combinations;
        }
    
        private void comb(String digits, int index, String current, Map<Character, String> d) {
            if (index == digits.length()) {
                combinations.add(current);
                return;
            }
    
            String letters = d.get(digits.charAt(index));
            for (int i = 0; i < letters.length(); i++) {
                comb(digits, index + 1, current + letters.charAt(i), d);
            }
        }
    }
}