from sys import stdin

n, m = map(int, stdin.readline().split())
numbers = list(map(int, stdin.readline().split()))

# 투 포인터를 위한 변수
start = 0
end = 1

# 경우의 수를 저장할 변수
cnt = 0

while start <= end <= n:    # 범위를 벗어나지 않을 경우에만 다음 동작 수행
    result = sum(numbers[start:end])

    if result == m:
        cnt += 1
        start += 1
    elif result < m:    # 더 많은 수를 더해야 하므로 end 조정
        end += 1
    else:   # 더해주는 수를 줄여야 하므로 start 조정
        start += 1

print(cnt)