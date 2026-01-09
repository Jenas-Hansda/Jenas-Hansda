import java.util.*;

class IPO {
    public int findMaximizedCapital(int k, int W, int[] profits, int[] capital) {
        int n = profits.length;

        // Store projects as (capital, profit)
        List<int[]> projects = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            projects.add(new int[]{capital[i], profits[i]});
        }

        // Sort projects by required capital in ascending order
        projects.sort(Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> maxProfit = new PriorityQueue<>(Collections.reverseOrder());
        int i = 0;

        while (k-- > 0) {
            // Push all affordable projects into max heap
            while (i < n && projects.get(i)[0] <= W) {
                maxProfit.offer(projects.get(i)[1]);
                i++;
            }

            if (maxProfit.isEmpty()) {
                break; // No projects we can afford
            }

            // Do the most profitable one
            W += maxProfit.poll();
        }

        return W;
    }
}
