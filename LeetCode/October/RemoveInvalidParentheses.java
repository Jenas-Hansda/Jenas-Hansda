import java.util.*;

class RemoveInvalidParentheses {
    
    private List<String> res = new ArrayList<>();
    private Map<String, Integer> mp = new HashMap<>();
    
    private int getMinInvalid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (!stack.isEmpty() && stack.peek() == '(')
                    stack.pop();
                else
                    stack.push(')');
            }
        }
        return stack.size();
    }
    
    private void solve(String s, int minInv) {
        if (mp.containsKey(s)) return;
        mp.put(s, 1);
        
        if (minInv < 0) return;
        
        if (minInv == 0) {
            if (getMinInvalid(s) == 0)
                res.add(s);
            return;
        }
        
        for (int i = 0; i < s.length(); i++) {
            String left = s.substring(0, i);
            String right = s.substring(i + 1);
            solve(left + right, minInv - 1);
        }
    }
    
    public List<String> removeInvalidParentheses(String s) {
        solve(s, getMinInvalid(s));
        return res;
    }
}
