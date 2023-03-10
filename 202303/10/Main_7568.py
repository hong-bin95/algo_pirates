from sys import stdin

n = int(stdin.readline())
people = [list(map(int, stdin.readline().split())) for _ in range(n)]
ranks = []

for target_weight, target_height in people:
    rank = 1

    for other_weight, other_height in people:
        # 자신보다 덩치가 더 큰 사람을 발견하면 등수 + 1
        if target_weight < other_weight and target_height < other_height:
            rank += 1
    ranks.append(rank)

print(*ranks)
