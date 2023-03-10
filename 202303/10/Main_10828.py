from sys import stdin


def pop_possible(s):
    return len(s) > 0


def is_empty(s):
    return len(s) == 0


n = int(stdin.readline())
stack = []

for _ in range(n):
    commands = list(stdin.readline().split())

    if len(commands) == 1:
        if commands[0] == "pop":
            print(stack.pop() if pop_possible(stack) else -1)
        elif commands[0] == "size":
            print(len(stack))
        elif commands[0] == "empty":
            print(1 if is_empty(stack) else 0)
        elif commands[0] == "top":
            print(-1 if is_empty(stack) else stack[-1])
    else:
        stack.append(int(commands[1]))
