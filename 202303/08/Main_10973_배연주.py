from sys import stdin

n = int(stdin.readline())
numbers = list(map(int, stdin.readline().split()))
idx = -1    # 바꿀 위치

for i in range(n - 1, 0, -1):   # 뒤부터 탐색
    if numbers[i - 1] > numbers[i]:
        idx = i - 1
        break

if idx == -1:
    print(-1)
else:   # 다음 순열을 찾았다면
    for i in range(n - 1, 0, -1):   # 다시 뒤부터 탐색
        if numbers[idx] > numbers[i]:
            numbers[idx], numbers[i] = numbers[i], numbers[idx]
            answer = numbers[:idx + 1] + sorted(numbers[idx + 1:], reverse=True)
            break
    print(*answer)
