import java.io.*;
import java.util.*;

public class Main_7568_덩치 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int N = Integer.parseInt(br.readLine());
        int arr[][] = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            arr[i][1] = Integer.parseInt(st.nextToken()); // 키
        }

        for(int i = 0; i < N; i++) {
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if(arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) cnt++;
            }
            sb.append(cnt + 1).append(" ");
        }

        System.out.println(sb.toString());
    }
}
