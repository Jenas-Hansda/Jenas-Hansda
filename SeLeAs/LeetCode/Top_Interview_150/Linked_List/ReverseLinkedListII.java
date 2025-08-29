class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        // Dummy node to handle edge cases like reversing from head (left = 1)
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 1: Move `prev` to node before `left`
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 2: Start reversing from `curr` node
        ListNode curr = prev.next;

        // Step 3: Reverse nodes from left to right
        for (int i = 1; i <= right - left; i++) {
            ListNode temp = prev.next;            // Node before sublist
            prev.next = curr.next;                // Move next node to front
            curr.next = curr.next.next;           // Skip over moved node
            prev.next.next = temp;                // Link moved node to sublist
        }

        return dummy.next;
    }
}
