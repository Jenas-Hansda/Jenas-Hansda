from typing import List
import heapq

class Solution:
    def totalCost(self, costs: List[int], k: int, candidates: int) -> int:
        n = len(costs)
        total_cost = 0

        leftHeap = []
        rightHeap = []

        left = 0
        right = n - 1

        # Initialize both heaps
        for _ in range(candidates):
            if left <= right:
                heapq.heappush(leftHeap, (costs[left], left))
                left += 1
        for _ in range(candidates):
            if left <= right:
                heapq.heappush(rightHeap, (costs[right], right))
                right -= 1

        while k > 0:
            # Choose from the smaller-cost heap
            if leftHeap and (not rightHeap or leftHeap[0][0] <= rightHeap[0][0]):
                cost, idx = heapq.heappop(leftHeap)
                if left <= right:
                    heapq.heappush(leftHeap, (costs[left], left))
                    left += 1
            else:
                cost, idx = heapq.heappop(rightHeap)
                if left <= right:
                    heapq.heappush(rightHeap, (costs[right], right))
                    right -= 1

            total_cost += cost
            k -= 1

        return total_cost
