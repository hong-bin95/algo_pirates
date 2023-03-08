import java.util.*;
import java.io.*;

public class Main_1010_박홍빈 {
    static int[][] dp = new int[31][31];
    public static void main(String[] args) throws Exception {
        int T;

        System.setIn(new FileInputStream("input/bj1010.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for(int t = 1; t <= T; t++){
            String str = br.readLine();
            st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            System.out.println(조합(M,N));

        }

    }   // main


    static int 조합(int n, int r){
        if(dp[n][r] > 0){
            return dp[n][r];
        }
        // n개중에 n개 뽑거나 0개거나
        else if(n == r || r == 0){
            return dp[n][r] = 1;
        }
        else{
            return dp[n][r] = 조합(n-1,r-1) + 조합(n-1, r);
        }

    }
}
