class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;

        ListNode prev = head;
        ListNode temp = head.next;

        while (temp != null) {
            if (temp.val == prev.val) {
                temp = temp.next; // Skip the duplicate
            } else {
                prev.next = temp; // Link to the next distinct node
                prev = temp;
                temp = temp.next;
            }
        }

        prev.next = null; // End the list cleanly
        return head;
    }
}
