package 구간합;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_bj11659 {
    public static void main(String[] args) throws Exception {
//        System.setIn(new FileInputStream("/src/main/res/bj11659.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N, M;

        String str = br.readLine();

        StringTokenizer st = new StringTokenizer(str);

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        int[] sum = new int[N+1];

        str = br.readLine();
        st = new StringTokenizer(str);

        arr[0] = 0;
        sum[0] = 0;

        arr[1] = Integer.parseInt(st.nextToken());
        sum[1] = arr[1];

        for(int i = 2 ; i <= N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            sum[i] = sum[i-1] + arr[i];
        }

        for(int k = 0; k < M; k++){
            str = br.readLine();
            st = new StringTokenizer(str);

            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());

            System.out.println(sum[j] - sum[i-1]);
        }


    }
}
