import sys
from collections import deque
sys.setrecursionlimit(10**9)    # RecursionError 해결


def dfs(start):
    visited[start] = True

    print(start, end=' ')
    for node in graph[start]:
        if not visited[node]:
            dfs(node)


def bfs(start):
    queue = deque([start])
    visited[start] = True
    while queue:
        now = queue.popleft()
        print(now, end=' ')
        for node in graph[now]:
            if not visited[node]:
                visited[node] = True
                queue.append(node)


n, m, v = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]

visited = [False] * (n + 1)
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

for node in graph:
    node.sort()

dfs(v)
print()
visited = [False] * (n + 1)
bfs(v)
