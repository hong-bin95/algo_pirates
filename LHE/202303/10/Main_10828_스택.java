import java.io.*;
import java.util.*;

public class Main_10828_스택 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            switch (command) {
                case "push": dq.push(Integer.parseInt(st.nextToken())); break;
                case "pop": sb.append(dq.isEmpty() ? -1 : dq.pop()).append("\n"); break;
                case "size": sb.append(dq.size()).append("\n"); break;
                case "empty": sb.append(dq.isEmpty() ? 1 : 0).append("\n"); break;
                case "top": sb.append(dq.isEmpty() ? -1 : dq.peek()).append("\n"); break;
            }
        }

        System.out.println(sb.toString());
    }
}
