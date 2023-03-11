package a20230311;

import java.io.*;
import java.util.*;

public class boj_s2_24444_알고리즘수업_너비우선탐색1 {

	static int N, M, R, turn;
	static int[] order;
	static boolean[] visited;
	static List<Integer>[] edgeList;
	
	public static void main(String[] args) throws Exception {

		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken())-1;
		order = new int[N];
		visited = new boolean[N];
		edgeList = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			edgeList[i] = new ArrayList<>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			edgeList[a].add(b);
			edgeList[b].add(a);
		}
		br.close();
		for (int i = 0; i < N; i++) {
			Collections.sort(edgeList[i], (o1, o2) -> Integer.compare(o1, o2));
		}
		bfs();
		for (int i = 0; i < N; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void bfs() {
		
		ArrayDeque<Integer> q = new ArrayDeque<>();
		visited[R] = true;
		q.offer(R);
		order[R] = ++turn;
		
		while(!q.isEmpty() ) {
			int now = q.poll();
			for (int i = 0; i < edgeList[now].size(); i++) {
				int next = edgeList[now].get(i);
				if(!visited[next]) {
					visited[next] = true;
					order[next] = ++turn;
					q.offer(next);
				}
			}
		}
	}
}
