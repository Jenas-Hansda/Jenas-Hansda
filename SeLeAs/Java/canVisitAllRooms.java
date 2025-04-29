

import java.util.*;

public class canVisitAllRooms {
    public boolean CanVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        while (!stack.isEmpty()) {
            int room = stack.pop();
            if (!visited.contains(room)) {
                visited.add(room);
                for (int key : rooms.get(room)) {
                    if (!visited.contains(key)) {
                        stack.push(key);
                    }
                }
            }
        }

        return visited.size() == rooms.size();
    }
}
