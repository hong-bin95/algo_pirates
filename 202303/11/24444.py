from sys import stdin
from collections import deque


def bfs(start):
    global cnt
    visited[start] = cnt
    cnt += 1
    queue = deque([start])

    while queue:
        now = queue.popleft()

        for node in graph[now]:
            if visited[node] == 0:
                visited[node] = cnt
                cnt += 1
                queue.append(node)


n, m, r = map(int, stdin.readline().split())
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

for _ in range(m):
    u, v = map(int, stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, n + 1):
    graph[i].sort()

cnt = 1
bfs(r)
for i in range(1, n + 1):
    print(visited[i])