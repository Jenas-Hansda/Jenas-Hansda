

public class SwapNodesinPairs {

  public ListNode swapPairs(ListNode head) {
    // Early return for 0 or 1 node
    if (head == null || head.next == null) return head;

    // Create a dummy node to ease swapping at the head
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode point = dummy;

    // Swap nodes in pairs
    while (point.next != null && point.next.next != null) {
        ListNode swap1 = point.next;
        ListNode swap2 = point.next.next;

        // Perform the swap
        point.next = swap2;
        swap1.next = swap2.next;
        swap2.next = swap1;

        // Move to the next pair
        point = swap1;
    }

    return dummy.next;
}



}