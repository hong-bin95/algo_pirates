package a20230311;

import java.io.*;
import java.util.*;

public class boj_s5_15235_OlympiadPizza {

	static int N;
	static int[] contestants; // 참가자마다 필요한 피자 조각 수 배열
	
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		contestants = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			contestants[i] = Integer.parseInt(st.nextToken());
		}
		br.close();
		int[] times = getTime();
		for (int i = 0; i < N; i++) {
			sb.append(times[i]).append(" ");
		}
		System.out.println(sb.toString());
	}
	
	public static int[] getTime() {
		
		int[] times = new int[N]; // 피자 받는 데 필요한 시간 배열
		ArrayDeque<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			q.offer(new int[] {i, contestants[i]});
		}
		
		int time = 0;
		while(!q.isEmpty() ) {
			time++;
			int[] now = q.poll();
			int contestant = now[0];
			int need = now[1]-1;
			if(need == 0) {
				times[contestant] = time;
			} else {
				q.offer(new int[] {contestant, need});
			}
		}
		return times;
	}
}
