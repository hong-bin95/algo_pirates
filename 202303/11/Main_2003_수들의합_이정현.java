package algo0311;

import java.util.*;
import java.io.*;

public class Main_2003_수들의합_이정현 {

	public static void main(String[] args) throws Exception {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(in.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		
		int[] acc = new int[N+1];
		
		
		//배열에 입력값 누적해가면서 저장
		st= new StringTokenizer(in.readLine());
		for(int i=0;i<N;i++) {
			int num= Integer.parseInt(st.nextToken());
			acc[i+1]=acc[i]+num;
		}
		
		int cnt=0; //경우의 수
		//배열이 채워져있는 1부터 N까지
		for(int i=0;i<=N;i++) {
			for(int j=i;j<=N;j++) {
				if((acc[j]-acc[i])==M) {
//					System.out.println(Arrays.toString(acc));
//					System.out.println(i+" "+j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		in.close();

	}

}
