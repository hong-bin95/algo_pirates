from sys import stdin
from math import factorial

n, m = map(int, stdin.readline().split())
print(factorial(n) // (factorial(m) * factorial(n - m)))
