package a20230310;

import java.io.*;
import java.util.*;

public class boj_s5_7568_덩치 {

	static int N;
	static int[][] heightAndWeight;
	
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		heightAndWeight = new int[N][2];
		for(int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			heightAndWeight[r][0] = Integer.parseInt(st.nextToken());
			heightAndWeight[r][1] = Integer.parseInt(st.nextToken());
		}
		br.close();

		int[] ranking = getRank();
		StringBuilder sb = new StringBuilder();
		sb.append(ranking[0]+1);
		for(int i=1; i<N; i++) {
			sb.append(" ").append(ranking[i]+1);
		}
		System.out.println(sb.toString());
	}
	
	public static int[] getRank() {
		int[] ranking = new int[N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(heightAndWeight[i][0] < heightAndWeight[j][0] && heightAndWeight[i][1] < heightAndWeight[j][1]) {
					ranking[i]++;
				}
			}
		}
		return ranking;
	}
}
