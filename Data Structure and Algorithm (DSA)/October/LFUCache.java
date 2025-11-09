import java.util.*;

class LFUCache {

    private static class Node {
        int key, value, freq;
        Node(int k, int v, int f) {
            key = k;
            value = v;
            freq = f;
        }
    }

    private final int capacity;
    private int size = 0;

    private final Map<Integer, Node> keyToNode;              // key -> Node
    private final Map<Integer, LinkedList<Node>> freqToList; // freq -> list of nodes
    private final TreeSet<Integer> freqLevels;               // keeps track of existing frequencies

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.keyToNode = new HashMap<>();
        this.freqToList = new HashMap<>();
        this.freqLevels = new TreeSet<>();
    }

    private void increaseFrequency(Node node) {
        int oldFreq = node.freq;
        freqToList.get(oldFreq).remove(node);
        if (freqToList.get(oldFreq).isEmpty()) {
            freqToList.remove(oldFreq);
            freqLevels.remove(oldFreq);
        }

        node.freq++;
        freqToList.computeIfAbsent(node.freq, k -> new LinkedList<>()).addFirst(node);
        freqLevels.add(node.freq);
    }

    public int get(int key) {
        if (!keyToNode.containsKey(key)) return -1;

        Node node = keyToNode.get(key);
        increaseFrequency(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (keyToNode.containsKey(key)) {
            Node node = keyToNode.get(key);
            node.value = value;
            increaseFrequency(node);
            return;
        }

        if (size == capacity) {
            // Remove least frequently used and oldest among them
            int leastFreq = freqLevels.first();
            LinkedList<Node> list = freqToList.get(leastFreq);
            Node nodeToRemove = list.removeLast();
            if (list.isEmpty()) {
                freqToList.remove(leastFreq);
                freqLevels.remove(leastFreq);
            }
            keyToNode.remove(nodeToRemove.key);
            size--;
        }

        // Insert new node with freq = 1
        Node newNode = new Node(key, value, 1);
        freqToList.computeIfAbsent(1, k -> new LinkedList<>()).addFirst(newNode);
        keyToNode.put(key, newNode);
        freqLevels.add(1);
        size++;
    }
}
