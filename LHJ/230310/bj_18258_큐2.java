import java.io.*;
import java.util.*;

class Myqueue{
	int[] queue=new int[2000000];
	int front=0, back=0; //front: 큐의 젤 앞, back: 다음에 들어갈 자리
	int size() {
		return back-front;
	}
	void push(int x) {
		queue[back++]=x;
	}
	int pop() {
		if(size()==0) return -1;
		else return queue[front++];
	}
	int empty() {
		return size()==0? 1:0;
	}
	int front() {
		if(size()==0) return -1;
		else return queue[front];
	}
	int back() {
		if(size()==0) return -1;
		else return queue[back-1];
	}
}

public class bj_18258_큐2 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb=new StringBuilder();
		StringTokenizer st=null;
		int n=Integer.parseInt(in.readLine());
		Myqueue q=new Myqueue();
		for(int i=0; i<n; i++) {
			st=new StringTokenizer(in.readLine());
			String op=st.nextToken();
			switch(op) {
			case "push":{
				int x=Integer.parseInt(st.nextToken());
				q.push(x);
				break;
			}
			case "pop":{
				sb.append(q.pop()).append('\n');
				break;
			}
			case "size":{
				sb.append(q.size()).append('\n');
				break;
			}
			case "empty":{
				sb.append(q.empty()).append('\n');
				break;
			}
			case "front":{
				sb.append(q.front()).append('\n');
				break;
			}
			case "back":{
				sb.append(q.back()).append('\n');
				break;
			}
			}
		}
		System.out.println(sb.toString());

	}

}
