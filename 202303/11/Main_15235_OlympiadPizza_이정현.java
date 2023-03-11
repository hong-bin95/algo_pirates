package algo0311;

import java.util.*;
import java.io.*;

public class Main_15235_OlympiadPizza_이정현 {

	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(in.readLine());
		
		//큐 만들어서 큐에 몇번째 사람인지, 피자 수 넣기
		ArrayDeque<int[]> q = new ArrayDeque<>();
		
		StringTokenizer st= new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			int pizza = Integer.parseInt(st.nextToken());
			q.offer(new int[] {i, pizza});
		}
		
		int time=0;
		int[] save =new int[N]; //사람마다 시간 저장할 배열
		while(!q.isEmpty()) {//큐가 다 비워질 때 까지
			time++;
			int[] tmp= q.poll();
			int pizza=tmp[1]-1;//필요한 피자-1(줬으니까 하나 빼기)
			
			if(pizza==0) {
				save[tmp[0]]=time;
			}else {
				q.offer(new int[] {tmp[0],pizza});
			}
			
		}
		
		for(int i=0;i<N;i++) {
			System.out.print(save[i]+" ");
		}
		

	}

}
