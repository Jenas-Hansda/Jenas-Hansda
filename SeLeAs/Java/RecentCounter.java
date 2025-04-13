import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    private Queue<Integer> times;

    public RecentCounter() {
        times = new LinkedList<>();
    }

    public int ping(int t) {
        times.add(t);
        while (!times.isEmpty() && times.peek() < t - 3000) {
            times.poll();  // Removes from the front of the queue
        }
        return times.size();
    }
}
