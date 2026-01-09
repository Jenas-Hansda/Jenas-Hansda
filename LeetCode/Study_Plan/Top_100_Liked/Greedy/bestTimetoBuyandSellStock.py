from typing import List

class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        buy = prices[0]
        max_profit = 0
        for price in prices[1:]:  # start from the second price
            buy = min(buy, price)
            max_profit = max(max_profit, price - buy)
        return max_profit
