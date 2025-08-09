

public class ReverseNodesinKGroup{
class Solution {

    // Helper to compute length
    private int lengthOfLinkedList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    // Private recursive helper that takes `length` as input
    private ListNode reverseKGroupHelper(ListNode head, int k, int length) {
        if (length < k) {
            return head;
        }

        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        // Reverse k nodes
        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Recurse for the remaining nodes
        if (next != null) {
            head.next = reverseKGroupHelper(next, k, length - k);
        }

        return prev;
    }

    // Public method
    public ListNode reverseKGroup(ListNode head, int k) {
        int length = lengthOfLinkedList(head);
        return reverseKGroupHelper(head, k, length);
    }
}
}