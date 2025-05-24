from typing import List

class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        def dfs(i):
            visited.add(i)
            for j in range(n):
                if isConnected[i][j] and j not in visited:
                    dfs(j)
        
        n = len(isConnected)
        visited = set()
        province = 0
        
        for i in range(n):
            if i not in visited:
                dfs(i)
                province += 1
                
        return province
