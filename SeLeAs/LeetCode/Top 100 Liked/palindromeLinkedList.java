public class palindromeLinkedList {
    class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find the middle of the list
        ListNode mid = findMid(head);

        // Step 2: Reverse the second half
        ListNode secondHalf = reverseList(mid);

        // Step 3: Compare the two halves
        ListNode p1 = head;
        ListNode p2 = secondHalf;
        boolean result = true;

        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // Optional: Restore the original list if needed
        // reverseList(secondHalf);

        return result;
    }

    private ListNode findMid(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head, next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

}
