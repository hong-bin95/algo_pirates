import java.io.*;
import java.util.*;

public class Main_1010_다리놓기 {

    static int N;
    static int M;
    static int[][] dp;

    public static void main(String[]args) throws Exception {
        // 풀이 전략
        // M 개중 N 개를 뽑는 조합
        // DP 사용

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            dp = new int[M + 1][M + 1];

            sb.append(comb(M, N) + "\n");
        }

        System.out.println(sb.toString());
        br.close();
    }

    static int comb(int n, int r) {
        if(n < 0 || r < 0) return 0;
        if(dp[n][r] > 0) return dp[n][r];
        if(n == r || r == 0) return dp[n][r] = 1;
        return dp[n][r] = comb(n - 1, r - 1) + comb(n - 1, r);
    }
}
