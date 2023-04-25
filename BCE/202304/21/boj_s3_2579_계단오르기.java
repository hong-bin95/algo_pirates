package a20230419;

import java.io.*;

public class boj_s3_2579_계단오르기 {
	
	static int N;
	static int[] stairs;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		stairs = new int[N];
		for (int i = 0; i < N; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		System.out.println(getMax());
	}

	public static int getMax() {
		int[][] dp = new int[N+1][2];
		dp[0][0] = 0;
		dp[0][1] = 0;
		dp[1][0] = stairs[0];
		dp[1][1] = stairs[0];
		
		// 한 번 밟은 거 == 전전행에서 큰값 + 내 위치
		// 두 번 밟은 거 == 전행에서 한 번 밟은 거 + 내 위치
		for (int i = 2; i <= N; i++) {
			dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i-1];
			dp[i][1] = dp[i-1][0]+stairs[i-1];
		}
		
		return Math.max(dp[N][0], dp[N][1]);
	}
}
// 연속 2개까지 가능
// 이차원 배열로 이전에 직전 밟은 경우와 직전 안 밟은 경우의 최대값 저장
// 직전거 더한거랑 전전거 더한거 저장?
// 밟음 안밟음?
// 지금 연속으로 한 개째인지 두개째인지 세개째인지 3차원 배열로 받기?
// 직전에 안 밟음 => 이번에 무조건 밟아야 함
// 직전에 하나 밟음 => 밟아도 되고 안 밟아도 됨
// 직전에 두 개 밟음 => 이번에 무조건 안 밟아야 함


// 누적 0 1 2
// 0 : 무조건 밟아야 함
// 1 : 밟거나 안 밟거나
// 2 : 무조건 안 밟아야 함

/*
 * 6 10 20 15 25 10 20
 */
// 밟기 안 밟기
// 첫번째일때 두번째일때 세번째일때
// 밟기 		선택		안밟기
// 10 10 0
// 20 30 10
// 25 35 30
// 55 50 35
// 45 65 50
// 75 65 65
// 이전행[2]+현재 내 값 == [0]
// 이전행[0]+현재 내 값 vs 전전행[0]+현재내값  == [1]
// 이전행[1] == [2]

// 한번 밟은 거 두번 밟은 거 안 밟은거는 전행에서 큰 값
// 한 번 밟은 거 == 전전행에서 큰값 + 내 위치
// 두 번 밟은 거 == 전행에서 한 번 밟은 거 + 내 위치
// 

