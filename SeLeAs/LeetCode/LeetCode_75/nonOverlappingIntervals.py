from typing import List


class Solution:
    def eraseOverlapIntervals(self, intervals: List[List[int]]) -> int:
        if not intervals:
            return 0
        intervals.sort(key=lambda x: x[1])  # Sort by end time
        remove = 0
        end = intervals[0][1]  # Corrected: set to end of the first interval

        for i in range(1, len(intervals)):
            if intervals[i][0] < end:
                remove += 1  # Overlaps, need to remove one
            else:
                end = intervals[i][1]  # Update end to current interval's end

        return remove
