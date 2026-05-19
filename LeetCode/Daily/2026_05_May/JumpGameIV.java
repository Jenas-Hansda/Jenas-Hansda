import java.util.*;

class Solution {

    public int minJumps(int[] arr) {

        int n = arr.length;

        if (n == 1)
            return 0;

        // value -> all indices having that value
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];

        queue.offer(0);
        visited[0] = true;

        int steps = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            while (size-- > 0) {

                int curr = queue.poll();

                // reached destination
                if (curr == n - 1) {
                    return steps;
                }

                // move left
                int left = curr - 1;

                if (left >= 0 && !visited[left]) {
                    visited[left] = true;
                    queue.offer(left);
                }

                // move right
                int right = curr + 1;

                if (right < n && !visited[right]) {
                    visited[right] = true;
                    queue.offer(right);
                }

                // jump to same value indices
                if (map.containsKey(arr[curr])) {

                    for (int idx : map.get(arr[curr])) {

                        if (!visited[idx]) {
                            visited[idx] = true;
                            queue.offer(idx);
                        }
                    }

                    // IMPORTANT:
                    // avoid processing same value again
                    map.remove(arr[curr]);
                }
            }

            steps++;
        }

        return -1;
    }
}