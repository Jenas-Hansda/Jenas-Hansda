import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianfromDataStream{
public class MedianFinder {
    private PriorityQueue<Integer> leftMaxHeap; // max heap for the smaller half
    private PriorityQueue<Integer> rightMinHeap; // min heap for the larger half

    public MedianFinder() {
        leftMaxHeap = new PriorityQueue<>(Collections.reverseOrder());
        rightMinHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (leftMaxHeap.isEmpty() || num <= leftMaxHeap.peek()) {
            leftMaxHeap.add(num);
        } else {
            rightMinHeap.add(num);
        }

        // Rebalance: ensure leftMaxHeap has equal or one more element than rightMinHeap
        if (leftMaxHeap.size() > rightMinHeap.size() + 1) {
            rightMinHeap.add(leftMaxHeap.poll());
        } else if (rightMinHeap.size() > leftMaxHeap.size()) {
            leftMaxHeap.add(rightMinHeap.poll());
        }
    }

    public double findMedian() {
        if (leftMaxHeap.size() == rightMinHeap.size()) {
            return (leftMaxHeap.peek() + rightMinHeap.peek()) / 2.0;
        } else {
            return leftMaxHeap.peek();
        }
    }
}
}