from sys import stdin
from collections import deque

n = int(stdin.readline())
students = list(map(int, stdin.readline().split()))
times = [0] * n

queue = deque()
for key, val in enumerate(students):
    queue.append([key, val])    # (인덱스, 원하는 피자 개수)

cnt = 0
while queue:
    idx, pizza = queue.popleft()
    cnt += 1
    pizza -= 1

    if pizza == 0:
        times[idx] = cnt
    else:
        queue.append([idx, pizza])

print(*times)
