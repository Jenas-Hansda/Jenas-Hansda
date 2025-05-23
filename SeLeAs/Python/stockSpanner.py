class StockSpanner:

    def __init__(self):
        self.prices = []
        

    def next(self, price: int) -> int:
        span = 1
        while self.prices and self.prices[-1][0] <= price:
            p, s = self.prices.pop()
            span += s
        self.prices.append((price, span))
        return span
