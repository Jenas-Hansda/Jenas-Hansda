import java.util.*;

class SpecialBinaryString {
    public String makeLargestSpecial(String s) {
        List<String> specials = new ArrayList<>();
        
        int start = 0;
        int balance = 0;

        for (int i = 0; i < s.length(); i++) {
            balance += (s.charAt(i) == '1') ? 1 : -1;

            if (balance == 0) {
                String inner = s.substring(start + 1, i);
                specials.add("1" + makeLargestSpecial(inner) + "0");
                start = i + 1;
            }
        }

        // Sort in descending lexicographical order
        Collections.sort(specials, Collections.reverseOrder());

        StringBuilder result = new StringBuilder();
        for (String str : specials) {
            result.append(str);
        }

        return result.toString();
    }
}