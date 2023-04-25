package a20230418;

import java.io.*;
import java.util.*;

public class boj_g5_2470_두용액 {

	// 1,000,000,000 : 둘 다 최대값이어도 int 범위 안
	static int N, min = 2_000_000_000, alkali, acid;
	static int[] solutions;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		solutions = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			solutions[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		Arrays.sort(solutions); // 오름차순 정렬
		getMin();
		System.out.println(alkali + " " + acid);
	}

	public static void getMin() {
		int left = 0;
		int right = N-1;
		alkali = solutions[left];
		acid = solutions[right];
		while(left < right) {
			if(Math.abs(min) > Math.abs(solutions[left] + solutions[right])) {
				min = solutions[left] + solutions[right];
				alkali = solutions[left];
				acid = solutions[right];
			} 
			if(solutions[left] + solutions[right] < 0) {
				left++;
			} else if(solutions[left] + solutions[right] > 0) {
				right--;
			} else {
				break;
			}
		}
	}
}