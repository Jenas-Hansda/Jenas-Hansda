import heapq

class SmallestInfiniteSet:

    def __init__(self):
        self.current = 1
        self.added_back = []  # min-heap
        self.added_back_set = set()  # to avoid duplicates

    def popSmallest(self) -> int:
        if self.added_back:
            smallest = heapq.heappop(self.added_back)
            self.added_back_set.remove(smallest)
            return smallest
        else:
            self.current += 1
            return self.current - 1

    def addBack(self, num: int) -> None:
        if num < self.current and num not in self.added_back_set:
            heapq.heappush(self.added_back, num)
            self.added_back_set.add(num)
