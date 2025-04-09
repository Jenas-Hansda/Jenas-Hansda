from collections import defaultdict
from typing import List

class Solution:
    def equalPairs(self, grid: List[list[int]]) -> int:
        n = len(grid)
        pairs = 0
        rows = defaultdict(int)
        
        # Count occurrences of each row
        for row in grid:
            rows[tuple(row)] += 1
        
        # Check each column
        for col in range(n):
            column = tuple(grid[r][col] for r in range(n))
            if column in rows:
                pairs += rows[column]
        
        return pairs  # Move the return statement outside the column loop
