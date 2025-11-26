import java.util.*;

public class AllOoneDataStructure {
    // Doubly Linked List node to store count and a set of strings with that count
    private class Node {
        int count;
        LinkedHashSet<String> keys;
        Node prev, next;

        Node(int c) {
            count = c;
            keys = new LinkedHashSet<>();
        }
    }

    // Hash map: key -> node containing that key
    private final Map<String, Node> keyCountMap;

    // Dummy head and tail to simplify edge handling
    private final Node head, tail;

    public AllOoneDataStructure() {
        keyCountMap = new HashMap<>();
        head = new Node(Integer.MIN_VALUE);  // clearly mark as dummy
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }

    // Helper: Add a new node with count = `count` after node `prevNode`
    private Node addNodeAfter(Node prevNode, int count) {
        Node newNode = new Node(count);
        newNode.next = prevNode.next;
        newNode.prev = prevNode;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        return newNode;
    }

    // Helper: Remove a node from the linked list
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        // optional cleanup for GC clarity
        node.prev = null;
        node.next = null;
    }

    /** Increment the count of key */
    public void inc(String key) {
        if (!keyCountMap.containsKey(key)) {
            // Key doesn’t exist → insert at count = 1
            if (head.next == tail || head.next.count != 1) {
                addNodeAfter(head, 1);
            }
            head.next.keys.add(key);
            keyCountMap.put(key, head.next);
        } else {
            Node curNode = keyCountMap.get(key);
            int curCount = curNode.count;

            // Ensure next node exists with count+1
            if (curNode.next == tail || curNode.next.count != curCount + 1) {
                addNodeAfter(curNode, curCount + 1);
            }
            curNode.next.keys.add(key);
            keyCountMap.put(key, curNode.next);

            // Remove from current node
            curNode.keys.remove(key);
            if (curNode.keys.isEmpty()) {
                removeNode(curNode);
            }
        }
    }

    /** Decrement the count of key */
    public void dec(String key) {
        if (!keyCountMap.containsKey(key)) return;

        Node curNode = keyCountMap.get(key);
        int curCount = curNode.count;

        // Remove the key from current node
        curNode.keys.remove(key);

        if (curCount == 1) {
            // Key disappears completely
            keyCountMap.remove(key);
        } else {
            // Move to previous count node (create if necessary)
            if (curNode.prev == head || curNode.prev.count != curCount - 1) {
                addNodeAfter(curNode.prev, curCount - 1);
            }
            curNode.prev.keys.add(key);
            keyCountMap.put(key, curNode.prev);
        }

        // Remove node if empty
        if (curNode.keys.isEmpty()) {
            removeNode(curNode);
        }
    }

    /** Return one of the keys with maximal count */
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }

    /** Return one of the keys with minimal count */
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }

    // ------------------------------------------------------------
    // Simple demonstration of the data structure
    // ------------------------------------------------------------
    public static void main(String[] args) {
        AllOne allOne = new AllOne();

        allOne.inc("hello");
        allOne.inc("hello");
        allOne.inc("leet");
        allOne.inc("code");
        allOne.inc("code");
        allOne.inc("code");
        allOne.dec("leet");

        System.out.println("Max Key: " + allOne.getMaxKey()); // Expect "code"
        System.out.println("Min Key: " + allOne.getMinKey()); // Expect "hello" (count 2)

        allOne.dec("hello");
        allOne.dec("hello");
        System.out.println("After removing 'hello':");
        System.out.println("Max Key: " + allOne.getMaxKey()); // Expect "code"
        System.out.println("Min Key: " + allOne.getMinKey()); // Expect "code"
    }
}
