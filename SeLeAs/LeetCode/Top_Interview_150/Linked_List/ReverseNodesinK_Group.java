package Top_Interview_150.Linked_List;

class ReverseNodesinK_Group {

    private int lengthOfLinkedList(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }

    private ListNode reverseKGroupHelper(ListNode head, int k, int length) {
        if (length < k) {
            return head;
        }

        int count = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (count < k && curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }

        if (next != null) {
            head.next = reverseKGroupHelper(next, k, length - k);
        }

        return prev;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        int length = lengthOfLinkedList(head);
        return reverseKGroupHelper(head, k, length);
    }
}