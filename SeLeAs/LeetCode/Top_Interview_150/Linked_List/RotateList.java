class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode oldTail = head;

        // Find the tail and calculate the length
        while (oldTail.next != null) {
            oldTail = oldTail.next;
            length++;
        }

        // Make the list circular
        oldTail.next = head;

        // Normalize k
        k = k % length;
        int stepsToNewTail = length - k;

        // Find the new tail
        ListNode newTail = oldTail;
        for (int i = 0; i < stepsToNewTail; i++) {
            newTail = newTail.next;
        }

        // Break the circle and set the new head
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
