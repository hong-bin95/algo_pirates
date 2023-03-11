package a20230310;

import java.io.*;
import java.util.*;

public class boj_s4_10808_스택 {
	
	static int N;

	public static void main(String[] args) throws Exception {

		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String command = br.readLine();
			if(command.startsWith("push")) {
				String num = command.split(" ")[1];
				stack.push(Integer.parseInt(num));
			} else if("pop".equals(command)) {
				if(stack.isEmpty()) {
					sb.append("-1\n");
				} else {
					sb.append(stack.pop()).append("\n");					
				}
			} else if ("size".equals(command)) {
				sb.append(stack.size()).append("\n");
			} else if ("empty".equals(command)) {
				if(stack.isEmpty()) {
					sb.append(1).append("\n");					
				} else {
					sb.append(0).append("\n");										
				}
			} else {
				if(stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.peek()).append("\n");					
				}
			}
		}
		br.close();
		System.out.println(sb.toString());
	}
}
