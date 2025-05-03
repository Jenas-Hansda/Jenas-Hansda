import java.util.PriorityQueue;
import java.util.HashSet;
public class SmallestInfiniteSet {




    private int current;
    private PriorityQueue<Integer> addedBack;
    private HashSet<Integer> addedBackSet;

    public SmallestInfiniteSet() {
        current = 1;
        addedBack = new PriorityQueue<>();
        addedBackSet = new HashSet<>();
    }

    public int popSmallest() {
        if (!addedBack.isEmpty()) {
            int smallest = addedBack.poll();
            addedBackSet.remove(smallest);
            return smallest;
        } else {
            return current++;
        }
    }

    public void addBack(int num) {
        if (num < current && !addedBackSet.contains(num)) {
            addedBack.add(num);
            addedBackSet.add(num);
        }
    }
}

