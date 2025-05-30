import java.util.HashSet;
import java.util.Set;

public class intersectionOfTwoLinkedLists {
    int val;
    intersectionOfTwoLinkedLists next;
    public intersectionOfTwoLinkedLists(int x) {
        val = x;
        next = null;
    }
}
// Length Aproach
 class LengthSolution {
    public intersectionOfTwoLinkedLists getIntersectionNode(intersectionOfTwoLinkedLists headA, intersectionOfTwoLinkedLists headB) {
        int lenA = getListLength(headA);
        int lenB = getListLength(headB);

        while (lenA > lenB) {
            headA = headA.next;
            lenA--;
        }

        while (lenB > lenA) {
            headB = headB.next;
            lenB--;
        }

        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }

        return headA; 
    }

    private int getListLength(intersectionOfTwoLinkedLists head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
}
// Address Aproach
 class AddressSolution {
    public intersectionOfTwoLinkedLists getIntersectionNode(intersectionOfTwoLinkedLists headA, intersectionOfTwoLinkedLists headB) {
        if (headA == null || headB == null) return null;

        Set<intersectionOfTwoLinkedLists> nodeAddress = new HashSet<>();

        while (headA != null) {
            nodeAddress.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (nodeAddress.contains(headB)) return headB;
            headB = headB.next;
        }

        return null;
    }
}
