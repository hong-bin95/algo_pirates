package a20230310;

import java.io.*;

public class boj_s5_17478_재귀함수가뭔가요 {
	
	static int N;
	static StringBuilder sb;
	static String[] strings;

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		br.close();
		
		strings = new String[6];
		strings[0] = "어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.";
		strings[1] = "\"재귀함수가 뭔가요?\"";
		strings[2] = "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.";
		strings[3] = "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.";
		strings[4] = "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"";
		strings[5] = "라고 답변하였지.";
		
		sb = new StringBuilder();
		sb.append(strings[0]);
		sb.append("\n");
		recursion(0);
		System.out.println(sb.toString());
	}	
	
	public static void recursion(int depth) {
		
		for(int i=0; i<depth; i++) {
			sb.append("____");
		}
		sb.append(strings[1]);
		sb.append("\n");
		
		if(depth == N) {
			for(int i=0; i<depth; i++) {
				sb.append("____");
			}
			sb.append("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
			for(int i=0; i<depth; i++) {
				sb.append("____");
			}
			sb.append(strings[5]);
			sb.append("\n");
			return;
		}
		
		for(int j=2; j<=4; j++) {
			for(int i=0; i<depth; i++) {
				sb.append("____");
			}
			sb.append(strings[j]);
			sb.append("\n");
		}
		recursion(depth+1);
		for(int i=0; i<depth; i++) {
			sb.append("____");
		}
		sb.append(strings[5]);
		sb.append("\n");
	}
}
