
class SortList{
class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        int length = getLength(head);
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        for (int size = 1; size < length; size *= 2) {
            ListNode curr = dummy.next;
            ListNode tail = dummy;

            while (curr != null) {
                ListNode left = curr;
                ListNode right = split(left, size);
                curr = split(right, size);
                tail = merge(left, right, tail);
            }
        }

        return dummy.next;
    }

    // Get total length of list
    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    // Split the list into two parts, first part has 'size' nodes
    private ListNode split(ListNode head, int size) {
        if (head == null) return null;
        for (int i = 1; head.next != null && i < size; i++) {
            head = head.next;
        }
        ListNode second = head.next;
        head.next = null; // cut
        return second;
    }

    // Merge two sorted lists and connect to tail
    private ListNode merge(ListNode l1, ListNode l2, ListNode tail) {
        ListNode curr = tail;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        curr.next = (l1 != null) ? l1 : l2;

        // Move to the end of the merged part
        while (curr.next != null) {
            curr = curr.next;
        }

        return curr; // Return new tail
    }
}
}