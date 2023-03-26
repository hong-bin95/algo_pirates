import java.util.*;
import java.io.*;

class MyStack{
	int[] stack=new int[10000];
	int size=0; //size이기도 하고 다음에 들어갈 숫자의 자리이기도 함
	void push(int x) {
		stack[size++]=x;
	}
	int pop() {
		if(size==0) return -1;
		return stack[--size];
	}
	int size() {
		return size;
	}
	int empty() {
		if(size==0) return 1;
		else return 0;
	}
	int top() {
		if(size==0) return -1;
		else return stack[size-1];
	}
}
public class bj_10828_스택 {

	public static void main(String[] args) throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=null;
		
		int n=Integer.parseInt(in.readLine());
		MyStack s=new MyStack();
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(in.readLine());
			String op=st.nextToken();
			switch(op) {
			case "push":{
				int x=Integer.parseInt(st.nextToken());
				s.push(x);
				break;
			}
			case "pop":{
				sb.append(s.pop()).append('\n');
				break;
			}
			case "size":{
				sb.append(s.size()).append('\n');
				break;
			}
			case "empty":{
				sb.append(s.empty()).append('\n');
				break;
			}
			case "top":{
				sb.append(s.top()).append('\n');
				break;
			}
			}
		}
		System.out.println(sb.toString());
	}

}
