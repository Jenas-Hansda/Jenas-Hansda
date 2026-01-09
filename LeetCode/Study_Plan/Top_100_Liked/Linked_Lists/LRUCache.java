import java.util.LinkedHashMap;


class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // accessOrder = true → maintains order by access
        this.cache = new LinkedHashMap<>(capacity, 0.75f, true);
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        return cache.get(key);
    }

    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            cache.put(key, value); // Will update and move to most recent due to accessOrder=true
        } else {
            if (cache.size() == capacity) {
                // Remove the least recently used (first entry)
                int lruKey = cache.keySet().iterator().next();
                cache.remove(lruKey);
            }
            cache.put(key, value);
        }
    }
}
