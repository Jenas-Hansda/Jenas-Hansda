import java.util.*;

public class DecodeString{
    class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(String.valueOf(ch));
            } else {
                StringBuilder curr = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    curr.insert(0, stack.pop());
                }

                stack.pop();

                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num.insert(0, stack.pop());
                }

                int repeat = Integer.parseInt(num.toString());
                String repeated = curr.toString().repeat(repeat);
                stack.push(repeated);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }

        return result.toString();
    
    }
}
}