from sys import stdin


def recursion(s, left, right):
    global cnt  # 호출 횟수
    cnt += 1

    if left >= right:
        return 1
    elif s[left] != s[right]:
        return 0
    else:
        return recursion(s, left + 1, right - 1)


def is_palindrome(s):
    return recursion(s, 0, len(s) - 1)


T = int(stdin.readline())
for _ in range(T):
    cnt = 0
    s = stdin.readline().rstrip()
    print(is_palindrome(s), cnt)
