from sys import stdin

n, x = map(int, stdin.readline().split())
visits = list(map(int, stdin.readline().split()))

if max(visits) == 0:
    print("SAD")
else:
    max_visit = sum(visits[:x])
    result = max_visit
    count = 1

    for i in range(x, n):
        result += (visits[i] - visits[i - x])

        if max_visit < result:   # 최댓값 갱신
            max_visit = result
            count = 1
        elif max_visit == result:    # count 증가
            count += 1

    print(max_visit)
    print(count)
