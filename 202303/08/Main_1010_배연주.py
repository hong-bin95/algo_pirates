from sys import stdin
from math import factorial

T = int(stdin.readline())

for tc in range(T):
    n, m = map(int, stdin.readline().split())
    print(factorial(m) // (factorial(n) * factorial(m - n)))
