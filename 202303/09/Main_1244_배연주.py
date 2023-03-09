from sys import stdin

n = int(stdin.readline())
switch = list(map(int, stdin.readline().split()))

student = int(stdin.readline())
for _ in range(student):
    gender, number = map(int, stdin.readline().split())

    if gender == 1:
        """
        남학생은 번호(number)의 배수 스위치의 상태 변경
        """
        for i in range(n):
            if (i + 1) % number == 0:
                switch[i] = 1 if switch[i] == 0 else 0

    else:  # 여학생일 때
        """"
        여학생은 번호(number)를 중심으로 좌우가 대칭이면서 가장 많은 스위치를 포함하는 구간을 찾아서
        구간에 속하는 스위치 상태 모두 변경
        """
        switch[number - 1] = 1 if switch[number - 1] == 0 else 0

        for i in range(1, n // 2):  # 현재 위치를 기준으로 좌우 탐색
            left = number - 1 - i
            right = number - 1 + i

            if left < 0 or right >= n:  # 범위를 벗어나지 않는지 체크
                break
            if switch[left] == switch[right]:
                switch[left] = 1 if switch[left] == 0 else 0
                switch[right] = 1 if switch[right] == 0 else 0
            else:
                break

for i in range(0, n, 20):
    print(*switch[i:i+20])