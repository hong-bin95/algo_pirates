package a20230411;

import java.io.*;
import java.util.*;

public class boj_g5_16928_뱀과사다리게임 {

	static int N, M;
	static int[] map;
	static int[] dist;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[101];
		dist = new int[101];
		for(int i =1; i<=100; i++) {
			map[i] = i;
			dist[i] = -1;
		}
		for (int i = 0; i < N+M; i++) {
			st = new StringTokenizer(br.readLine());
			map[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
		}
		bfs();
		System.out.println(dist[100]);
	}

	public static void bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(1);
		dist[1] = 0;
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=1; i<=6; i++) {
				int next = now + i;
				if(next <= 100) {
					next = map[next];
					if(dist[next] == -1) {
						dist[next] = dist[now] + 1;
						q.offer(next);
					}
				}
			}
		}
	}
}
