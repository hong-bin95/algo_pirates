package a20230417;

import java.io.*;
import java.util.*;

public class boj_s4_11047_동전0 {

	static int N, K, cnt;
	static int[] coins;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		coins = new int[N];
		for (int i = 0; i < N; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		getCnt();
		System.out.println(cnt);
	}
	
	public static void getCnt() {
		
		for (int i = N-1; i >= 0; i--) {
			if(coins[i] <= K) {
				cnt += K/coins[i];
				K %= coins[i];
			}
		}
	}
}
