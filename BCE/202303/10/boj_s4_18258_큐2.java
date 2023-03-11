package a20230310;

import java.io.*;
import java.util.*;

public class boj_s4_18258_큐2 {
	
	static int N;
	
	public static void main(String[] args) throws Exception {
		
		ArrayDeque<Integer> queue = new ArrayDeque<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			if(command.startsWith("push")) {
				String num = command.split(" ")[1];
				queue.offer(Integer.parseInt(num));
			} else if("pop".equals(command)) {
				if(queue.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(queue.poll()).append("\n");					
				}
			} else if ("size".equals(command)) {
				sb.append(queue.size()).append("\n");
			} else if ("empty".equals(command)) {
				if(queue.isEmpty()) {
					sb.append(1).append("\n");					
				} else {
					sb.append(0).append("\n");										
				}
			} else if("front".equals(command)) {
				if(queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.getFirst()).append("\n");					
				}
			} else {
				if(queue.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(queue.getLast()).append("\n");					
				}
			}
		}
		br.close();
		System.out.println(sb.toString());
	}

}
