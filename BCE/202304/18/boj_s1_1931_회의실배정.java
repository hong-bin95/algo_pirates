package a20230417;

import java.io.*;
import java.util.*;

public class boj_s1_1931_회의실배정 {
	
	static int N;
	static int[][] meetings;

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		meetings = new int[N][2];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			meetings[i][0] = Integer.parseInt(st.nextToken());
			meetings[i][1] = Integer.parseInt(st.nextToken());
		}
		br.close();

		// 끝나는 시간 기준으로 정렬 + 끝나는 시간 같으면 시작 시간 빠른 순으로 정렬
//		Arrays.sort(meetings, (o1, o2) -> Integer.compare(o1[1], o2[1]));
		Arrays.sort(meetings, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1] - o2[1];
			}
		});
		System.out.println(getCnt());
	}
	
	public static int getCnt() {
		int cnt = 1;
		int end = meetings[0][1];
		for (int i = 1; i < N; i++) {
			if(meetings[i][0] >= end) {
				cnt++;
				end = meetings[i][1];
			}
		}
		return cnt;
	}
}
