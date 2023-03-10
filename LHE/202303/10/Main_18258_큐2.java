import java.io.*;
import java.util.*;

public class Main_18258_큐2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push" : dq.offer(Integer.parseInt(st.nextToken())); break;
                case "pop" : sb.append(dq.isEmpty() ? -1 : dq.poll()).append("\n"); break;
                case "size" : sb.append(dq.size()).append("\n"); break;
                case "empty" : sb.append(dq.isEmpty() ? 1 : 0).append("\n"); break;
                case "front" : sb.append(dq.isEmpty() ? -1 : dq.getFirst()).append("\n"); break;
                case "back" : sb.append(dq.isEmpty() ? -1 : dq.getLast()).append("\n"); break;
            }
        }

        System.out.println(sb.toString());
    }
}
