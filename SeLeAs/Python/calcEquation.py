import collections
from typing import List
from collections import deque

class Solution:
    def calcEquation(self, equations: List[List[str]], values: List[float], queries: List[List[str]]) -> List[float]:
        adj = collections.defaultdict(list)

        # Build the graph
        for i, eq in enumerate(equations):
            a, b = eq
            adj[a].append([b, values[i]])
            adj[b].append([a, 1 / values[i]])

        def bfs(src, target):
            if src not in adj or target not in adj:
                return -1.0

            q, visit = deque(), set()
            q.append((src, 1.0))
            visit.add(src)

            while q:
                node, weight = q.popleft()
                if node == target:
                    return weight
                for nei, w in adj[node]:
                    if nei not in visit:
                        visit.add(nei)
                        q.append((nei, weight * w))

            return -1.0

        return [bfs(a, b) for a, b in queries]
