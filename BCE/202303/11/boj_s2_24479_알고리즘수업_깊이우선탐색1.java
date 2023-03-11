package a20230311;

import java.io.*;
import java.util.*;

public class boj_s2_24479_알고리즘수업_깊이우선탐색1 {

	static int N, M, R, depth;
	static int[] order; // 순서 배열
	static boolean[] visited; // 방문 배열
	static List<Integer>[] edgeList; // 인접 리스트
	
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
		for (int r = 0; r < M; r++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			edgeList[a].add(b);
			edgeList[b].add(a);
		}
		br.close();
		for (int i = 0; i < N; i++) { // 오름차순으로 정렬
			Collections.sort(edgeList[i], (o1, o2) -> Integer.compare(o1, o2));
		}
		dfs(R);
		for (int i = 0; i < N; i++) {
			sb.append(order[i]).append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void dfs(int start) {
		if(depth == N) {
			return;
		}		
		visited[start] = true;
		order[start] = ++depth;
		for (int i = 0; i < edgeList[start].size(); i++) {
			int next = edgeList[start].get(i);
			if(!visited[next]) {
				dfs(next);
			}
		}
	}
}
