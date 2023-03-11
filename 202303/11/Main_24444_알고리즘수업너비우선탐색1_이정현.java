package algo0311;

import java.util.*;
import java.io.*;

public class Main_24444_알고리즘수업너비우선탐색1_이정현 {
	static boolean[] v;
	static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
	static int N;
	static int[] output;
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st= new StringTokenizer(in.readLine()," ");
		N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int R=Integer.parseInt(st.nextToken());
		
		//0은 안씀
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(in.readLine());
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			
			//양방향으로 그래프 연결
			list.get(start).add(end);
			list.get(end).add(start);
		}
		
		v= new boolean[N+1];
		output= new int[N+1];
		//인접 정점 오름차순 방문
		for(int i=1;i<=N;i++) {
			Collections.sort(list.get(i));
		}
		//시작 정점 파라미터로
		BFS(R);
		
		for(int i=1;i<=N;i++) {
			System.out.println(output[i]);
		}
		
		
	}
	
	static void BFS(int start) {
		ArrayDeque<Integer> q= new ArrayDeque<>();
		int cnt=0;
		output[start]=++cnt;
		v[start]=true;
		q.offer(start);
		
		while(!q.isEmpty()) {
			int tmp= q.poll();
			
			for(int i=0;i<list.get(tmp).size();i++) {
				if(!v[list.get(tmp).get(i)]) {
					q.offer(list.get(tmp).get(i));
					output[list.get(tmp).get(i)]=++cnt;
					v[list.get(tmp).get(i)]=true;
				}
			}
		}
		
	}

}
