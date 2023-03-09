from sys import stdin


def permutation(depth):
    if depth == n:
        print(*arr)
        return

    for i in range(n):
        if not visited[i]:
            visited[i] = True
            arr[depth] = numbers[i]
            permutation(depth + 1)
            visited[i] = False


n = int(stdin.readline())
visited = [False] * (n + 1)
arr = [0] * n
numbers = list(range(1, n + 1))
permutation(0)