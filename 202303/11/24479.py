import sys
sys.setrecursionlimit(10**9)    # RecursionError 해결


def dfs(start):
    global cnt
    visited[start] = cnt

    for node in graph[start]:
        if visited[node] == 0:
            cnt += 1
            dfs(node)


n, m, r = map(int, sys.stdin.readline().split())
graph = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

for _ in range(m):
    u, v = map(int, sys.stdin.readline().split())
    graph[u].append(v)
    graph[v].append(u)

for i in range(1, n + 1):
    graph[i].sort()

cnt = 1
dfs(r)
for i in range(1, n + 1):
    print(visited[i])
