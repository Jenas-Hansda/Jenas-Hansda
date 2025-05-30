public class reverseLinkedList {
    // Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { 
        this.val = val; 
        this.next = next; 
    }
}

class Solution {

    // Recursive Solution
    public ListNode reverseListRecursive(ListNode head) {
        return helper(null, head);
    }

    private ListNode helper(ListNode prev, ListNode curr) {
        if (curr == null) {
            return prev;
        }
        ListNode nextNode = curr.next;
        curr.next = prev;
        return helper(curr, nextNode);
    }

    // Iterative Solution
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
}

}
