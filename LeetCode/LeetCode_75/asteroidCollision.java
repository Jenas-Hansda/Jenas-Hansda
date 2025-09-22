import java.util.*;
public class asteroidCollision {
public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int ast : asteroids) {
            boolean destroyed = false;
            
            while (!stack.isEmpty() && stack.peek() > 0 && ast < 0) {
                int last = stack.pop();
                
                if (last > -ast) {
                    stack.push(last);
                    destroyed = true;
                    break;
                } else if (last == -ast) {
                    destroyed = true;
                    break;
                }
                // if last < -ast, continue loop
            }
            
            if (!destroyed) {
                stack.push(ast);
            }
        }

        // Convert stack to array
        int[] result = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }

        return result;
    }
}

}
