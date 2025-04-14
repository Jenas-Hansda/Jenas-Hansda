from collections import deque
class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        dire = deque()
        radiant = deque()
        n = len(senate)
        for i in range(n):
            if senate[i] == "D":
                dire.append(i)
            else:
                radiant.append(i)
        while dire and radiant:
            d = dire.popleft()
            r = radiant.popleft()
            if r < d:
                radiant.append(r + n)
            else:
                dire.append(d + n)
        return "Radiant" if radiant else "Dire"
