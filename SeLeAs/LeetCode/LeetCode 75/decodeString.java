import java.util.Stack;
public class decodeString {
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch != ']') {
                stack.push(String.valueOf(ch));
            } else {
                // Step 1: Get the string inside the brackets
                StringBuilder curr = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    curr.insert(0, stack.pop());
                }

                // Remove the '['
                stack.pop();

                // Step 2: Get the number before the brackets
                StringBuilder num = new StringBuilder();
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    num.insert(0, stack.pop());
                }

                // Step 3: Repeat the string and push back to the stack
                int repeat = Integer.parseInt(num.toString());
                String repeated = curr.toString().repeat(repeat);
                stack.push(repeated);
            }
        }

        // Build the final result
        StringBuilder result = new StringBuilder();
        for (String str : stack) {
            result.append(str);
        }

        return result.toString();
    }
}

}
