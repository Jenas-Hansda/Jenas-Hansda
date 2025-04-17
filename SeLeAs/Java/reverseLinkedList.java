class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        
        while (curr != null){
            next = curr.next;   // Store the next node
            curr.next = prev;   // Reverse the current node's pointer
            prev = curr;        // Move prev and curr one step forward
            curr = next;
        }

        return prev;  // prev is the new head of the reversed list
    }
}
