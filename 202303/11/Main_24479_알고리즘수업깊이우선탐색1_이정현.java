package algo0311;

import java.io.*;
import java.util.*;

public class Main_24479_알고리즘수업깊이우선탐색1_이정현 {
	
	static int N;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static boolean[] v;
	static int[] output;
	static int cnt=0;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(in.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<M;i++) {
			st= new StringTokenizer(in.readLine());
			int start= Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(list.get(i));
		}
		
		v = new boolean[N+1];
		output= new int[N+1];
		
		
		DFS(R);
		
		for(int i=1;i<=N;i++) {
			System.out.println(output[i]);
		}

	}

	private static void DFS(int start) {
		if(output[start]!=0) return;
		output[start]=++cnt;
		for(int i=0;i<list.get(start).size();i++) {
			DFS(list.get(start).get(i));
			
		}
		
	}

}
