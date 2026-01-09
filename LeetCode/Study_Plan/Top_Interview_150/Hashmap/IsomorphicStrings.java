package Top_Interview_150.Hashmap;
import java.util.Arrays;

public class IsomorphicStrings {
    

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Early check for unequal lengths
        if (s.length() != t.length()) return false;

        int[] mapST = new int[256];
        int[] mapTS = new int[256];
        Arrays.fill(mapST, -1);
        Arrays.fill(mapTS, -1);

        int n = s.length();
        for (int i = 0; i < n; i++) {
            char chS = s.charAt(i);
            char chT = t.charAt(i);

            if ((mapST[chS] != -1 && mapST[chS] != chT) ||
                (mapTS[chT] != -1 && mapTS[chT] != chS)) {
                return false;
            }

            mapST[chS] = chT;
            mapTS[chT] = chS;
        }

        return true;
    }
}

}
