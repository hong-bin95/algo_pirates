package a20230311;

import java.io.*;
import java.util.*;

public class boj_s4_2003_수들의합 {
	
	static int N, M;
	static int[] accumulation; // 누적합 배열

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		accumulation = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			accumulation[i] = accumulation[i-1] + Integer.parseInt(st.nextToken());
		}
		br.close();
		System.out.println(getCnt());
	}

	public static int getCnt() {
		int cnt = 0;
		
		int start = 0;
		int end = 1;
		
		while(end <= N) {
			if(accumulation[end]-accumulation[start] < M) {
				end++;
			} else if(accumulation[end]-accumulation[start] > M) {
				if(++start == end) {
					end++;
				}
			} else if(accumulation[end]-accumulation[start] == M) {
				cnt++;
				start++;
				end++;
			}
		}	
		return cnt;
	}
}
