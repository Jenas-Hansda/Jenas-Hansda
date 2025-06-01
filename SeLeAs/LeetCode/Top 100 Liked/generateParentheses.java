import java.util.ArrayList;
import java.util.List;

public class generateParentheses {
    

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generate(n, n, "", result);
        return result;
    }

    private void generate(int open, int close, String current, List<String> result) {
        if (open == 0 && close == 0) {
            result.add(current);
            return;
        }
        if (open > 0) {
            generate(open - 1, close, current + "(", result);
        }
        if (open < close) {
            generate(open, close - 1, current + ")", result);
        }
    }
}

}
