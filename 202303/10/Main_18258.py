from sys import stdin
from collections import deque


def pop_possible(q):
    return len(q) > 0


def is_empty(q):
    return len(q) == 0


n = int(stdin.readline())
queue = deque()

for _ in range(n):
    commands = list(stdin.readline().split())

    if len(commands) == 1:
        if commands[0] == "pop":
            print(queue.popleft() if pop_possible(queue) else -1)
        elif commands[0] == "size":
            print(len(queue))
        elif commands[0] == "empty":
            print(1 if is_empty(queue) else 0)
        elif commands[0] == "front":
            print(queue[0] if not is_empty(queue) else -1)
        elif commands[0] == "back":
            print(queue[-1] if not is_empty(queue) else -1)
    else:
        queue.append(int(commands[1]))
