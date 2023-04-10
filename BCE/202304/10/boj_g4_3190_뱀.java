package a20230410;

import java.io.*;
import java.util.*;

public class boj_g4_3190_뱀 {

	static int N, K, L;
	static int[] dr = {-1, 0, 1, 0}; // 상우하좌
	static int[] dc = {0, 1, 0, -1};
	static int[][] board;
	static int[][] turn;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		board = new int[N][N];
		K = Integer.parseInt(br.readLine());
		for(int k=0; k<K; k++) { // 사과 두기
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			board[r][c] = 1;
		}
		L = Integer.parseInt(br.readLine());
		turn = new int[L][2];
		for(int l=0; l<L; l++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			String d = st.nextToken();
			turn[l][0] = t;
			if(d.equals("D")) { // 오른쪽으로 회전
				turn[l][1] = 1;
			} else {
				turn[l][1] = -1;
			}
		}
		br.close();
		System.out.println(snake());
	}

	public static int snake() {
		ArrayDeque<int[]> q = new ArrayDeque<>(); // 뱀이 있는 칸 담는 큐
		int dir = 1; // 처음에는 오른쪽을 향한다.
		int time = 0;
		q.offer(new int[] {0, 0});
		board[0][0] = -1;
		
		int tPointer = 0;
		// 마지막에 들어간 게 뱀 머리
		while(true) {
			int[] head = q.getLast(); 
			int r = head[0];
			int c = head[1];
			time++;
			
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr < 0 || nr >= N || nc < 0 || nc >= N || board[nr][nc] == -1) { // 범위 벗어나거나 본인 몸에 부딪히면 게임 끝
				break;
			}
			q.offer(new int[] {nr, nc});
			if(board[nr][nc] == 1) { // 사과있으면 몸 길이+1
			} else {
				int[] tail = q.poll(); // 처음 값(꼬리) 삭제 
				board[tail[0]][tail[1]] = 0;				
			}
			board[nr][nc] = -1;
			// 방향 변하는 시간이면 방향 전환 : 게임 시작 시간으로부터 X초가 끝난 뒤
			if(tPointer < L && time == turn[tPointer][0]) {
				dir = (dir + turn[tPointer++][1] + 4) % 4;
			}
		}
		return time;	
	}
}