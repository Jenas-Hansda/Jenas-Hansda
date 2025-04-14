import java.util.Stack;

class removingStars {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(ch);
            }
        }

        // Build the result from the stack
        StringBuilder result = new StringBuilder();
        for (char ch : stack) {
            result.append(ch);
        }

        return result.toString();
    }
}



// public class Main {
//     public static void main(String[] args) {
//         Solution sol = new Solution();
//         String input = "leet**cod*e";
//         String result = sol.removeStars(input);
//         System.out.println(result);  // Output: "lecoe"
//     }
// }
