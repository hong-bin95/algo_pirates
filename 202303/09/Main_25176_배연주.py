from sys import stdin

n = int(stdin.readline())
answer = 1

# Ex. N = 4
# [1, 1, 2, 2, 3, 3, 4, 4] <- 이런 식으로 같은 수끼리 묶을 때 점수가 최소가 된다
# [1, 2, 3, 4] <- 이렇게 같은 숫자를 하나로 묶는다
# 나올 수 있는 경우의 수는 4 * 3 * 2 * 1 = 12이다.
for i in range(1, n + 1):
    answer *= i

print(answer)