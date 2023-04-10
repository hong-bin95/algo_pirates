package a20230410;

import java.io.*;
import java.util.*;

public class boj_s2_1012_유기농배추 {
	
	static int T, N, M, K;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] farm;
	static boolean[][] visited;

	public static void main(String[] args) throws Exception {
		
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			farm = new int[N][M];
			visited = new boolean[N][M];
			for(int k=0; k<K; k++) { // 배추 심기
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				farm[r][c] = 1;
			}
			int cnt = 0; // 배추흰지렁이 수
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					if(farm[r][c] == 1 && !visited[r][c]) { // 배추가 있고, 방문하지 않은 곳
						bfs(r, c);
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		br.close();
		System.out.println(sb.toString());
	}
	
	public static void bfs(int i, int j) {
		Queue<int[]> q = new ArrayDeque<>(); 
		q.offer(new int[] {i, j});
		
		while(!q.isEmpty()) {
			int[] rc = q.poll();
			int r = rc[0];
			int c = rc[1];
			visited[r][c] = true;
			for(int d=0; d<4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];
				if(0 <= nr && nr < N && 0 <= nc && nc < M && farm[nr][nc] == 1 && !visited[nr][nc]) {
					visited[nr][nc] = true;
					q.offer(new int[] {nr, nc});
				}
			}
		}
	}
}

// 이중 for문 안에서 1이면서 방문한 적 없으면 bfs 호출 && cnt++;
// bfs 안에서 상하좌우 탐색하면서 1이면 큐에 넣고 방문처리
// 테스트케이스 만큼 반복
