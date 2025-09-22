package Top_Interview_150.Array_String;
import java.util.*;


public class TextJustification {
    

class Solution {
    int MAX_WIDTH;

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int n = words.length;
        MAX_WIDTH = maxWidth;
        int i = 0;

        while (i < n) {
            int lettersCount = words[i].length();
            int j = i + 1;

            // Calculate how many words can fit in the current line
            while (j < n && lettersCount + (j - i) + words[j].length() <= maxWidth) {
                lettersCount += words[j].length();
                j++;
            }

            int spaceSlots = j - i - 1;
            int remainingSlots = maxWidth - lettersCount;

            int eachWordSpace = spaceSlots == 0 ? 0 : remainingSlots / spaceSlots;
            int extraSpace = spaceSlots == 0 ? 0 : remainingSlots % spaceSlots;

            boolean isLastLine = (j == n);

            result.add(getFinalWord(i, j, eachWordSpace, extraSpace, words, isLastLine));
            i = j;
        }

        return result;
    }

    private String getFinalWord(int i, int j, int eachWordSpace, int extraSpace, String[] words, boolean isLastLine) {
        StringBuilder s = new StringBuilder();

        for (int k = i; k < j; k++) {
            s.append(words[k]);

            if (k == j - 1) break;

            if (isLastLine) {
                s.append(" ");
            } else {
                for (int space = 0; space < eachWordSpace; space++) {
                    s.append(" ");
                }
                if (extraSpace > 0) {
                    s.append(" ");
                    extraSpace--;
                }
            }
        }

        while (s.length() < MAX_WIDTH) {
            s.append(" ");
        }

        return s.toString();
    }
}

}
