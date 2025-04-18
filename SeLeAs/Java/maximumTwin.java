class ListNode {
    int val;
    ListNode next;
    
    ListNode() {}
    
    ListNode(int val) {
        this.val = val;
    }
    
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class maximumTwin {
    public int pairSum(ListNode head) {
        // Step 1: Find the middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // Step 2: Reverse the second half of the list
        ListNode prev = null;
        ListNode curr = slow;
        
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        
        // Step 3: Calculate max twin sum
        ListNode head2 = prev; // Reversed half head
        int maxSum = 0;
        
        while (head2 != null) {
            maxSum = Math.max(maxSum, head.val + head2.val);
            head = head.next;
            head2 = head2.next;
        }
        
        return maxSum;
    }
}
