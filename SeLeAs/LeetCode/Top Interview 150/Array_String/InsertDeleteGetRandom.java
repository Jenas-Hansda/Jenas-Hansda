package Array_String;
import java.util.*;

public class InsertDeleteGetRandom {
    

public class RandomizedSet {
    private final ArrayList<Integer> list;
    private final HashMap<Integer, Integer> map;
    private final Random random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int idxToRemove = map.get(val);
        int lastElement = list.get(list.size() - 1);

        // Swap the element to remove with the last one
        list.set(idxToRemove, lastElement);
        map.put(lastElement, idxToRemove);

        // Remove the last element
        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    /** Get a random element from the set, wrapped in Optional. */
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}

}
