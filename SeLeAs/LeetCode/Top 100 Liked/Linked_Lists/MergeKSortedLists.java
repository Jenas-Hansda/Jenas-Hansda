import java.util.PriorityQueue;



public class MergeKSortedLists{


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNodeEntry> minHeap = new PriorityQueue<>();

        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(new ListNodeEntry(lists[i].val, i, lists[i]));
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        while (!minHeap.isEmpty()) {
            ListNodeEntry entry = minHeap.poll();
            curr.next = entry.node;
            curr = curr.next;

            if (entry.node.next != null) {
                minHeap.offer(new ListNodeEntry(entry.node.next.val, entry.index, entry.node.next));
            }
        }

        return dummy.next;
    }

    // Helper class for priority queue
    private static class ListNodeEntry implements Comparable<ListNodeEntry> {
        int val;
        int index;
        ListNode node;

        ListNodeEntry(int val, int index, ListNode node) {
            this.val = val;
            this.index = index;
            this.node = node;
        }

        @Override
        public int compareTo(ListNodeEntry other) {
            if (this.val != other.val) {
                return Integer.compare(this.val, other.val);
            }
            return Integer.compare(this.index, other.index);
        }
    }
}

}